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

package org.jetbrains.kotlin.checkers;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@RunWith(JUnit3RunnerWithInners.class)
public class PsiCheckerTestGenerated extends AbstractPsiCheckerTest {
    @TestMetadata("idea/testData/checker")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Checker extends AbstractPsiCheckerTest {
        @TestMetadata("Abstract.kt")
        public void testAbstract() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Abstract.kt");
            doTest(fileName);
        }

        public void testAllFilesPresentInChecker() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/checker"), Pattern.compile("^(.+)\\.kt$"), false);
        }

        @TestMetadata("AnnotationOnFile.kt")
        public void testAnnotationOnFile() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/AnnotationOnFile.kt");
            doTest(fileName);
        }

        @TestMetadata("AnonymousInitializers.kt")
        public void testAnonymousInitializers() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/AnonymousInitializers.kt");
            doTest(fileName);
        }

        @TestMetadata("BinaryCallsOnNullableValues.kt")
        public void testBinaryCallsOnNullableValues() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/BinaryCallsOnNullableValues.kt");
            doTest(fileName);
        }

        @TestMetadata("Bounds.kt")
        public void testBounds() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Bounds.kt");
            doTest(fileName);
        }

        @TestMetadata("Bounds2.kt")
        public void testBounds2() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Bounds2.kt");
            doTest(fileName);
        }

        @TestMetadata("BoundsWithSubstitutors.kt")
        public void testBoundsWithSubstitutors() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/BoundsWithSubstitutors.kt");
            doTest(fileName);
        }

        @TestMetadata("BreakContinue.kt")
        public void testBreakContinue() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/BreakContinue.kt");
            doTest(fileName);
        }

        @TestMetadata("Builders.kt")
        public void testBuilders() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Builders.kt");
            doTest(fileName);
        }

        @TestMetadata("Casts.kt")
        public void testCasts() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Casts.kt");
            doTest(fileName);
        }

        @TestMetadata("ClassObjectInEnum.kt")
        public void testClassObjectInEnum() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/ClassObjectInEnum.kt");
            doTest(fileName);
        }

        @TestMetadata("ClassObjects.kt")
        public void testClassObjects() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/ClassObjects.kt");
            doTest(fileName);
        }

        @TestMetadata("Constants.kt")
        public void testConstants() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Constants.kt");
            doTest(fileName);
        }

        @TestMetadata("Constructors.kt")
        public void testConstructors() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Constructors.kt");
            doTest(fileName);
        }

        @TestMetadata("CyclicHierarchy.kt")
        public void testCyclicHierarchy() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/CyclicHierarchy.kt");
            doTest(fileName);
        }

        @TestMetadata("ExtensionFunctions.kt")
        public void testExtensionFunctions() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/ExtensionFunctions.kt");
            doTest(fileName);
        }

        @TestMetadata("ForRangeConventions.kt")
        public void testForRangeConventions() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/ForRangeConventions.kt");
            doTest(fileName);
        }

        @TestMetadata("FunctionReturnTypes.kt")
        public void testFunctionReturnTypes() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/FunctionReturnTypes.kt");
            doTest(fileName);
        }

        @TestMetadata("GenericArgumentConsistency.kt")
        public void testGenericArgumentConsistency() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/GenericArgumentConsistency.kt");
            doTest(fileName);
        }

        @TestMetadata("IncDec.kt")
        public void testIncDec() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/IncDec.kt");
            doTest(fileName);
        }

        @TestMetadata("IsExpressions.kt")
        public void testIsExpressions() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/IsExpressions.kt");
            doTest(fileName);
        }

        @TestMetadata("LocalObjects.kt")
        public void testLocalObjects() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/LocalObjects.kt");
            doTest(fileName);
        }

        @TestMetadata("MultipleBounds.kt")
        public void testMultipleBounds() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/MultipleBounds.kt");
            doTest(fileName);
        }

        @TestMetadata("NestedObjects.kt")
        public void testNestedObjects() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/NestedObjects.kt");
            doTest(fileName);
        }

        @TestMetadata("NotFinishedGenericDeclaration.kt")
        public void testNotFinishedGenericDeclaration() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/NotFinishedGenericDeclaration.kt");
            doTest(fileName);
        }

        @TestMetadata("NullAsAnnotationArgument.kt")
        public void testNullAsAnnotationArgument() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/NullAsAnnotationArgument.kt");
            doTest(fileName);
        }

        @TestMetadata("Nullability.kt")
        public void testNullability() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Nullability.kt");
            doTest(fileName);
        }

        @TestMetadata("Objects.kt")
        public void testObjects() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Objects.kt");
            doTest(fileName);
        }

        @TestMetadata("Override.kt")
        public void testOverride() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Override.kt");
            doTest(fileName);
        }

        @TestMetadata("OverridesAndGenerics.kt")
        public void testOverridesAndGenerics() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/OverridesAndGenerics.kt");
            doTest(fileName);
        }

        @TestMetadata("PackageAsExpression.kt")
        public void testPackageAsExpression() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/PackageAsExpression.kt");
            doTest(fileName);
        }

        @TestMetadata("PackageQualified.kt")
        public void testPackageQualified() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/PackageQualified.kt");
            doTest(fileName);
        }

        @TestMetadata("PlatformStaticUsagesRuntime.kt")
        public void testPlatformStaticUsagesRuntime() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/PlatformStaticUsagesRuntime.kt");
            doTest(fileName);
        }

        @TestMetadata("PrimaryConstructors.kt")
        public void testPrimaryConstructors() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/PrimaryConstructors.kt");
            doTest(fileName);
        }

        @TestMetadata("ProjectionsInSupertypes.kt")
        public void testProjectionsInSupertypes() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/ProjectionsInSupertypes.kt");
            doTest(fileName);
        }

        @TestMetadata("Properties.kt")
        public void testProperties() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Properties.kt");
            doTest(fileName);
        }

        @TestMetadata("QualifiedExpressions.kt")
        public void testQualifiedExpressions() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/QualifiedExpressions.kt");
            doTest(fileName);
        }

        @TestMetadata("QualifiedThis.kt")
        public void testQualifiedThis() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/QualifiedThis.kt");
            doTest(fileName);
        }

        @TestMetadata("QualifiedThisInClosures.kt")
        public void testQualifiedThisInClosures() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/QualifiedThisInClosures.kt");
            doTest(fileName);
        }

        @TestMetadata("Redeclaration.kt")
        public void testRedeclaration() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Redeclaration.kt");
            doTest(fileName);
        }

        @TestMetadata("Redeclarations.kt")
        public void testRedeclarations() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Redeclarations.kt");
            doTest(fileName);
        }

        @TestMetadata("ResolveToJava.kt")
        public void testResolveToJava() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/ResolveToJava.kt");
            doTest(fileName);
        }

        @TestMetadata("ResolveTypeInAnnotationArgumentRuntime.kt")
        public void testResolveTypeInAnnotationArgumentRuntime() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/ResolveTypeInAnnotationArgumentRuntime.kt");
            doTest(fileName);
        }

        @TestMetadata("ReturnTypeMismatchOnOverride.kt")
        public void testReturnTypeMismatchOnOverride() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/ReturnTypeMismatchOnOverride.kt");
            doTest(fileName);
        }

        @TestMetadata("Shadowing.kt")
        public void testShadowing() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Shadowing.kt");
            doTest(fileName);
        }

        @TestMetadata("StringTemplates.kt")
        public void testStringTemplates() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/StringTemplates.kt");
            doTest(fileName);
        }

        @TestMetadata("SupertypeListChecks.kt")
        public void testSupertypeListChecks() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/SupertypeListChecks.kt");
            doTest(fileName);
        }

        @TestMetadata("TraitSupertypeList.kt")
        public void testTraitSupertypeList() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/TraitSupertypeList.kt");
            doTest(fileName);
        }

        @TestMetadata("trivialHierarchyLoop.kt")
        public void testTrivialHierarchyLoop() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/trivialHierarchyLoop.kt");
            doTest(fileName);
        }

        @TestMetadata("TypeParameterBounds.kt")
        public void testTypeParameterBounds() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/TypeParameterBounds.kt");
            doTest(fileName);
        }

        @TestMetadata("UnreachableCode.kt")
        public void testUnreachableCode() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/UnreachableCode.kt");
            doTest(fileName);
        }

        @TestMetadata("Unresolved.kt")
        public void testUnresolved() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Unresolved.kt");
            doTest(fileName);
        }

        @TestMetadata("Unused.kt")
        public void testUnused() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Unused.kt");
            doTest(fileName);
        }

        @TestMetadata("Variance.kt")
        public void testVariance() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/Variance.kt");
            doTest(fileName);
        }

        @TestMetadata("When.kt")
        public void testWhen() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/When.kt");
            doTest(fileName);
        }

        @TestMetadata("WhenInEnumInExtensionProperty.kt")
        public void testWhenInEnumInExtensionProperty() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/WhenInEnumInExtensionProperty.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("idea/testData/checker/regression")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Regression extends AbstractPsiCheckerTest {
        public void testAllFilesPresentInRegression() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/checker/regression"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("AmbiguityOnLazyTypeComputation.kt")
        public void testAmbiguityOnLazyTypeComputation() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/AmbiguityOnLazyTypeComputation.kt");
            doTest(fileName);
        }

        @TestMetadata("AssignmentsUnderOperators.kt")
        public void testAssignmentsUnderOperators() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/AssignmentsUnderOperators.kt");
            doTest(fileName);
        }

        @TestMetadata("BadParseForClass.kt")
        public void testBadParseForClass() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/BadParseForClass.kt");
            doTest(fileName);
        }

        @TestMetadata("CoercionToUnit.kt")
        public void testCoercionToUnit() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/CoercionToUnit.kt");
            doTest(fileName);
        }

        @TestMetadata("createInnerInstance.kt")
        public void testCreateInnerInstance() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/createInnerInstance.kt");
            doTest(fileName);
        }

        @TestMetadata("DoubleDefine.kt")
        public void testDoubleDefine() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/DoubleDefine.kt");
            doTest(fileName);
        }

        @TestMetadata("extensionMemberInClassObject.kt")
        public void testExtensionMemberInClassObject() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/extensionMemberInClassObject.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet11.kt")
        public void testJet11() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet11.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet121.kt")
        public void testJet121() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet121.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet124.kt")
        public void testJet124() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet124.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet169.kt")
        public void testJet169() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet169.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet183.kt")
        public void testJet183() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet183.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet183-1.kt")
        public void testJet183_1() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet183-1.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet53.kt")
        public void testJet53() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet53.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet67.kt")
        public void testJet67() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet67.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet68.kt")
        public void testJet68() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet68.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet69.kt")
        public void testJet69() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet69.kt");
            doTest(fileName);
        }

        @TestMetadata("Jet72.kt")
        public void testJet72() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/Jet72.kt");
            doTest(fileName);
        }

        @TestMetadata("kt251.kt")
        public void testKt251() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/kt251.kt");
            doTest(fileName);
        }

        @TestMetadata("kt303.kt")
        public void testKt303() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/kt303.kt");
            doTest(fileName);
        }

        @TestMetadata("OverrideResolution.kt")
        public void testOverrideResolution() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/OverrideResolution.kt");
            doTest(fileName);
        }

        @TestMetadata("ScopeForSecondaryConstructors.kt")
        public void testScopeForSecondaryConstructors() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/ScopeForSecondaryConstructors.kt");
            doTest(fileName);
        }

        @TestMetadata("SpecififcityByReceiver.kt")
        public void testSpecififcityByReceiver() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/SpecififcityByReceiver.kt");
            doTest(fileName);
        }

        @TestMetadata("WrongTraceInCallResolver.kt")
        public void testWrongTraceInCallResolver() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/regression/WrongTraceInCallResolver.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("idea/testData/checker/recovery")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Recovery extends AbstractPsiCheckerTest {
        public void testAllFilesPresentInRecovery() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/checker/recovery"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("namelessMembers.kt")
        public void testNamelessMembers() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/recovery/namelessMembers.kt");
            doTest(fileName);
        }

        @TestMetadata("namelessToplevelDeclarations.kt")
        public void testNamelessToplevelDeclarations() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/recovery/namelessToplevelDeclarations.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("idea/testData/checker/rendering")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Rendering extends AbstractPsiCheckerTest {
        public void testAllFilesPresentInRendering() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/checker/rendering"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("TypeInferenceError.kt")
        public void testTypeInferenceError() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/rendering/TypeInferenceError.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("idea/testData/checker/scripts")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Scripts extends AbstractPsiCheckerTest {
        public void testAllFilesPresentInScripts() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/checker/scripts"), Pattern.compile("^(.+)\\.kts$"), true);
        }

        @TestMetadata("simple.kts")
        public void testSimple() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/scripts/simple.kts");
            doTest(fileName);
        }
    }

    @TestMetadata("idea/testData/checker/duplicateJvmSignature")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class DuplicateJvmSignature extends AbstractPsiCheckerTest {
        public void testAllFilesPresentInDuplicateJvmSignature() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/checker/duplicateJvmSignature"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("idea/testData/checker/duplicateJvmSignature/fields")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Fields extends AbstractPsiCheckerTest {
            public void testAllFilesPresentInFields() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/checker/duplicateJvmSignature/fields"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("classObjectCopiedFieldObject.kt")
            public void testClassObjectCopiedFieldObject() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/fields/classObjectCopiedFieldObject.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("idea/testData/checker/duplicateJvmSignature/functionAndProperty")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class FunctionAndProperty extends AbstractPsiCheckerTest {
            public void testAllFilesPresentInFunctionAndProperty() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/checker/duplicateJvmSignature/functionAndProperty"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("class.kt")
            public void testClass() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/functionAndProperty/class.kt");
                doTest(fileName);
            }

            @TestMetadata("classObject.kt")
            public void testClassObject() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/functionAndProperty/classObject.kt");
                doTest(fileName);
            }

            @TestMetadata("localClass.kt")
            public void testLocalClass() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/functionAndProperty/localClass.kt");
                doTest(fileName);
            }

            @TestMetadata("nestedClass.kt")
            public void testNestedClass() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/functionAndProperty/nestedClass.kt");
                doTest(fileName);
            }

            @TestMetadata("object.kt")
            public void testObject() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/functionAndProperty/object.kt");
                doTest(fileName);
            }

            @TestMetadata("objectExpression.kt")
            public void testObjectExpression() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/functionAndProperty/objectExpression.kt");
                doTest(fileName);
            }

            @TestMetadata("topLevel.kt")
            public void testTopLevel() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/functionAndProperty/topLevel.kt");
                doTest(fileName);
            }

            @TestMetadata("topLevelMultifileRuntime.kt")
            public void testTopLevelMultifileRuntime() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/functionAndProperty/topLevelMultifileRuntime.kt");
                doTest(fileName);
            }

            @TestMetadata("trait.kt")
            public void testTrait() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/functionAndProperty/trait.kt");
                doTest(fileName);
            }
        }

        @TestMetadata("idea/testData/checker/duplicateJvmSignature/traitImpl")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class TraitImpl extends AbstractPsiCheckerTest {
            public void testAllFilesPresentInTraitImpl() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/checker/duplicateJvmSignature/traitImpl"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("twoTraits.kt")
            public void testTwoTraits() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/duplicateJvmSignature/traitImpl/twoTraits.kt");
                doTest(fileName);
            }
        }
    }

    @TestMetadata("idea/testData/checker/infos")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Infos extends AbstractPsiCheckerTest {
        public void testAllFilesPresentInInfos() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/checker/infos"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("CapturedConstructorParameter.kt")
        public void testCapturedConstructorParameter() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/infos/CapturedConstructorParameter.kt");
            doTestWithInfos(fileName);
        }

        @TestMetadata("CapturedInInlinedClosure.kt")
        public void testCapturedInInlinedClosure() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/infos/CapturedInInlinedClosure.kt");
            doTestWithInfos(fileName);
        }

        @TestMetadata("PropertiesWithBackingFields.kt")
        public void testPropertiesWithBackingFields() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/infos/PropertiesWithBackingFields.kt");
            doTestWithInfos(fileName);
        }

        @TestMetadata("SmartCasts.kt")
        public void testSmartCasts() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/infos/SmartCasts.kt");
            doTestWithInfos(fileName);
        }

        @TestMetadata("SmartCastsWithSafeAccess.kt")
        public void testSmartCastsWithSafeAccess() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/infos/SmartCastsWithSafeAccess.kt");
            doTestWithInfos(fileName);
        }

        @TestMetadata("Typos.kt")
        public void testTypos() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/infos/Typos.kt");
            doTestWithInfos(fileName);
        }

        @TestMetadata("WrapIntoRef.kt")
        public void testWrapIntoRef() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("idea/testData/checker/infos/WrapIntoRef.kt");
            doTestWithInfos(fileName);
        }
    }
}
