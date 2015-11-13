/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.quickfix

import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.openapi.command.impl.FinishMarkAction
import com.intellij.openapi.command.impl.StartMarkAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.search.searches.MethodReferencesSearch
import org.jetbrains.kotlin.asJava.toLightMethods
import org.jetbrains.kotlin.descriptors.ClassDescriptorWithResolutionScopes
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.diagnostics.Diagnostic
import org.jetbrains.kotlin.idea.caches.resolve.resolveToDescriptorIfAny
import org.jetbrains.kotlin.idea.codeInsight.CodeInsightUtils
import org.jetbrains.kotlin.idea.refactoring.changeSignature.*
import org.jetbrains.kotlin.idea.util.application.runWriteAction
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.psiUtil.containingClassOrObject
import org.jetbrains.kotlin.psi.psiUtil.endOffset
import org.jetbrains.kotlin.psi.psiUtil.startOffset
import java.util.*

object InitializePropertyQuickFixFactory : KotlinIntentionActionsFactory() {
    class AddInitializerFix(property: KtProperty) : KotlinQuickFixAction<KtProperty>(property) {
        override fun getText() = "Add initializer"
        override fun getFamilyName() = text

        override fun invoke(project: Project, editor: Editor?, file: KtFile) {
            val descriptor = element.resolveToDescriptorIfAny() as? PropertyDescriptor ?: return
            val initializerText = CodeInsightUtils.defaultInitializer(descriptor.type) ?: "null"
            val initializer = element.setInitializer(KtPsiFactory(project).createExpression(initializerText))!!
            if (editor != null) {
                PsiDocumentManager.getInstance(project).commitDocument(editor.document)
                editor.selectionModel.setSelection(initializer.startOffset, initializer.endOffset)
            }
        }
    }

    class MoveToConstructorParameters(property: KtProperty) : KotlinQuickFixAction<KtProperty>(property) {
        override fun getText() = "Move to constructor parameters"
        override fun getFamilyName() = text

        private fun configureChangeSignature(propertyDescriptor: PropertyDescriptor): KotlinChangeSignatureConfiguration {
            return object : KotlinChangeSignatureConfiguration {
                override fun configure(originalDescriptor: KotlinMethodDescriptor): KotlinMethodDescriptor {
                    return originalDescriptor.modify {
                        val initializerText = CodeInsightUtils.defaultInitializer(propertyDescriptor.type) ?: "null"
                        val newParam = KotlinParameterInfo(
                                callableDescriptor = originalDescriptor.baseDescriptor,
                                name = propertyDescriptor.name.asString(),
                                type = propertyDescriptor.type,
                                valOrVar = element.valOrVarKeyword.toValVar(),
                                modifierList = element.modifierList,
                                defaultValueForCall = KtPsiFactory(element.project).createExpression(initializerText)
                        )
                        it.addParameter(newParam)
                    }
                }

                override fun performSilently(affectedFunctions: Collection<PsiElement>): Boolean {
                    return affectedFunctions.flatMap { it.toLightMethods() }.all { MethodReferencesSearch.search(it).findFirst() == null }
                }
            }
        }

        override fun invoke(project: Project, editor: Editor?, file: KtFile) {
            val klass = element.containingClassOrObject ?: return
            val propertyDescriptor = element.resolveToDescriptorIfAny() as? PropertyDescriptor ?: return

            StartMarkAction.canStart(project)?.let { return }
            val startMarkAction = StartMarkAction.start(editor, project, text)

            try {
                val parameterToInsert = KtPsiFactory(project).createParameter(element.text)
                runWriteAction { element.delete() }

                val classDescriptor = klass.resolveToDescriptorIfAny() as? ClassDescriptorWithResolutionScopes ?: return
                val constructorDescriptor = classDescriptor.unsubstitutedPrimaryConstructor ?: return
                val constructorSource = constructorDescriptor.source.getPsi()
                val config = configureChangeSignature(propertyDescriptor)
                val changeSignature = { runChangeSignature(project, constructorDescriptor, config, element, text) }
                changeSignature.runRefactoringWithPostprocessing(project, "refactoring.changeSignature") {
                    val constructor = constructorSource as? KtConstructor<*> ?: (constructorSource as? KtClass)?.getPrimaryConstructor()
                    constructor?.getValueParameters()?.lastOrNull()?.replace(parameterToInsert)
                }
            }
            finally {
                FinishMarkAction.finish(project, editor, startMarkAction)
            }
        }
    }

    override fun doCreateActions(diagnostic: Diagnostic): List<IntentionAction> {
        val property = diagnostic.psiElement as? KtProperty ?: return emptyList()
        if (property.receiverTypeReference != null) return emptyList()

        val actions = ArrayList<IntentionAction>(2)

        actions.add(AddInitializerFix(property))

        (property.containingClassOrObject as? KtClass)?.let { klass ->
            if (klass.isAnnotation() || klass.isInterface()) return@let
            if (property.accessors.isNotEmpty()) return@let
            if (klass.getSecondaryConstructors().any { !it.getDelegationCall().isCallToThis }) return@let

            actions.add(MoveToConstructorParameters(property))
        }

        return actions
    }
}
