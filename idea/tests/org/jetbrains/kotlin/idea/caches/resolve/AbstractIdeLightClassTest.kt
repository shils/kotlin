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

package org.jetbrains.kotlin.idea.caches.resolve

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootModificationUtil
import com.intellij.openapi.util.io.FileUtilRt
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.search.GlobalSearchScope
import org.jetbrains.kotlin.asJava.LightClassTestCommon
import org.jetbrains.kotlin.idea.KotlinDaemonAnalyzerTestCase
import org.jetbrains.kotlin.idea.test.ConfigLibraryUtil
import org.jetbrains.kotlin.idea.test.KotlinLightCodeInsightFixtureTestCase
import org.jetbrains.kotlin.idea.test.KotlinWithJdkAndRuntimeLightProjectDescriptor
import org.jetbrains.kotlin.test.KotlinTestUtils
import org.jetbrains.kotlin.test.MockLibraryUtil
import org.junit.Assert
import java.io.File

abstract class AbstractIdeLightClassTest : KotlinLightCodeInsightFixtureTestCase() {
    fun doTest(testDataPath: String) {
        myFixture.configureByFile(testDataPath)
        testLightClass(project, testDataPath, false)
    }

    override fun getProjectDescriptor() = KotlinWithJdkAndRuntimeLightProjectDescriptor.INSTANCE
}

public abstract class AbstractIdeCompiledLightClassTest : KotlinDaemonAnalyzerTestCase() {
    override fun setUp() {
        super.setUp()

        val testName = getTestName(false)
        if (testName.startsWith("AllFilesPresentIn")) return

        val filePath = "${KotlinTestUtils.getTestsRoot(this)}/${getTestName(false)}.kt"

        Assert.assertTrue("File doesn't exist $filePath", File(filePath).exists())

        val libraryJar = MockLibraryUtil.compileLibraryToJar(filePath, libName(), false, false
        )
        val jarUrl = "jar://" + FileUtilRt.toSystemIndependentName(libraryJar.absolutePath) + "!/"
        ModuleRootModificationUtil.addModuleLibrary(module, jarUrl)
    }

    override fun tearDown() {
        ConfigLibraryUtil.removeLibrary(module, libName())

        super.tearDown()
    }

    private fun libName() = "libFor" + getTestName(false)

    fun doTest(testDataPath: String) {
        testLightClass(project, testDataPath, true)
    }
}

private fun testLightClass(project: Project, testDataPath: String, ignoreInterfaceDefault: Boolean ) {
    LightClassTestCommon.testLightClass(
            File(testDataPath),
            findLightClass = {
                val clazz = JavaPsiFacade.getInstance(project).findClass(it, GlobalSearchScope.allScope(project))
                if (clazz != null) {
                    PsiElementChecker.checkPsiElementStructure(clazz)
                }
                clazz

            },
            normalizeText = { clazz, text ->
                //NOTE: ide and compiler differ in names generated for parameters with unspecified names
                text
                        .replace("java.lang.String s,", "java.lang.String p,")
                        .replace("java.lang.String s)", "java.lang.String p)")
                        .replace("java.lang.String s1", "java.lang.String p1")
                        .replace("java.lang.String s2", "java.lang.String p2")
                        .removeLinesStartingWith("@kotlin.jvm.internal.KotlinClass")
                        .removeLinesStartingWith("@kotlin.jvm.internal.KotlinFileFacade")
                        .run { 
                            // It's rather tricky to understand from PSI only will DefaultImpls be generated or not. So it's 
                            // a known issue that light classes in IDE and from compiled code can differ here.
                            if (ignoreInterfaceDefault && clazz.isInterface && !clazz.isAnnotationType && 
                                    !this.contains("final class DefaultImpls")) {
                                this.substring(0, lastIndexOf('}')) + 
                                    """|
                                       |    final class DefaultImpls {
                                       |    }
                                       |}""".trimMargin()
                            }
                            else {
                                this
                            }
                        }
            }
    )
}

private fun String.removeLinesStartingWith(prefix: String) : String {
    return lines().filterNot { it.trimStart().startsWith(prefix) }.joinToString(separator = "\n")
}

