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

package org.jetbrains.kotlin.idea.liveTemplates.macro

import com.intellij.openapi.project.Project
import org.jetbrains.kotlin.descriptors.VariableDescriptor
import org.jetbrains.kotlin.idea.KotlinBundle
import org.jetbrains.kotlin.idea.core.IterableTypesDetector

class IterableVariableMacro : BaseKotlinVariableMacro() {

    override fun getName(): String {
        return "kotlinIterableVariable"
    }

    override fun getPresentableName(): String {
        return KotlinBundle.message("macro.iterable.variable")
    }

    override fun isSuitable(
            variableDescriptor: VariableDescriptor,
            project: Project,
            iterableTypesDetector: IterableTypesDetector): Boolean {
        //TODO: smart-casts
        return iterableTypesDetector.isIterable(variableDescriptor.type, null)
    }
}
