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

package org.jetbrains.kotlin.codegen.generated;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/boxWithJava")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class BlackBoxWithJavaCodegenTestGenerated extends AbstractBlackBoxCodegenTest {
    public void testAllFilesPresentInBoxWithJava() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava"), Pattern.compile("^([^\\.]+)$"), true);
    }

    @TestMetadata("annotatedSamFunExpression")
    public void testAnnotatedSamFunExpression() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/annotatedSamFunExpression/");
        doTestWithJava(fileName);
    }

    @TestMetadata("annotatedSamLambda")
    public void testAnnotatedSamLambda() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/annotatedSamLambda/");
        doTestWithJava(fileName);
    }

    @TestMetadata("classCompanion")
    public void testClassCompanion() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/classCompanion/");
        doTestWithJava(fileName);
    }

    @TestMetadata("classObjectAccessor")
    public void testClassObjectAccessor() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/classObjectAccessor/");
        doTestWithJava(fileName);
    }

    @TestMetadata("deprecatedFieldForObject")
    public void testDeprecatedFieldForObject() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/deprecatedFieldForObject/");
        doTestWithJava(fileName);
    }

    @TestMetadata("inline")
    public void testInline() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/inline/");
        doTestWithJava(fileName);
    }

    @TestMetadata("innerClass")
    public void testInnerClass() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/innerClass/");
        doTestWithJava(fileName);
    }

    @TestMetadata("interfaceCompanion")
    public void testInterfaceCompanion() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/interfaceCompanion/");
        doTestWithJava(fileName);
    }

    @TestMetadata("interfaceDefaultImpls")
    public void testInterfaceDefaultImpls() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/interfaceDefaultImpls/");
        doTestWithJava(fileName);
    }

    @TestMetadata("jvmName")
    public void testJvmName() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/jvmName/");
        doTestWithJava(fileName);
    }

    @TestMetadata("mangling")
    public void testMangling() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/mangling/");
        doTestWithJava(fileName);
    }

    @TestMetadata("number")
    public void testNumber() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/number/");
        doTestWithJava(fileName);
    }

    @TestMetadata("protectedInInline")
    public void testProtectedInInline() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/protectedInInline/");
        doTestWithJava(fileName);
    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/annotatedFileClasses")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class AnnotatedFileClasses extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInAnnotatedFileClasses() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/annotatedFileClasses"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("javaAnnotationOnFileFacade")
        public void testJavaAnnotationOnFileFacade() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/annotatedFileClasses/javaAnnotationOnFileFacade/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/annotationsWithKClass")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class AnnotationsWithKClass extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInAnnotationsWithKClass() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/annotationsWithKClass"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("array")
        public void testArray() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/annotationsWithKClass/array/");
            doTestWithJava(fileName);
        }

        @TestMetadata("basic")
        public void testBasic() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/annotationsWithKClass/basic/");
            doTestWithJava(fileName);
        }

        @TestMetadata("vararg")
        public void testVararg() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/annotationsWithKClass/vararg/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/builtinStubMethods")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class BuiltinStubMethods extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInBuiltinStubMethods() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/builtinStubMethods"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("extendJavaCollections")
        public void testExtendJavaCollections() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/builtinStubMethods/extendJavaCollections/");
            doTestWithJava(fileName);
        }

        @TestMetadata("substitutedIterable")
        public void testSubstitutedIterable() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/builtinStubMethods/substitutedIterable/");
            doTestWithJava(fileName);
        }

        @TestMetadata("substitutedList")
        public void testSubstitutedList() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/builtinStubMethods/substitutedList/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/casts")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Casts extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInCasts() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/casts"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("javaTypeIsFunK")
        public void testJavaTypeIsFunK() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/casts/javaTypeIsFunK/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/collections")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Collections extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInCollections() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/collections"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("charSequence")
        public void testCharSequence() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/charSequence/");
            doTestWithJava(fileName);
        }

        @TestMetadata("implementCollectionThroughKotlin")
        public void testImplementCollectionThroughKotlin() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/implementCollectionThroughKotlin/");
            doTestWithJava(fileName);
        }

        @TestMetadata("irrelevantImplCharSequence")
        public void testIrrelevantImplCharSequence() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/irrelevantImplCharSequence/");
            doTestWithJava(fileName);
        }

        @TestMetadata("irrelevantImplCharSequenceKotlin")
        public void testIrrelevantImplCharSequenceKotlin() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/irrelevantImplCharSequenceKotlin/");
            doTestWithJava(fileName);
        }

        @TestMetadata("irrelevantImplMutableList")
        public void testIrrelevantImplMutableList() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/irrelevantImplMutableList/");
            doTestWithJava(fileName);
        }

        @TestMetadata("irrelevantImplMutableListKotlin")
        public void testIrrelevantImplMutableListKotlin() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/irrelevantImplMutableListKotlin/");
            doTestWithJava(fileName);
        }

        @TestMetadata("irrelevantImplMutableListSubstitution")
        public void testIrrelevantImplMutableListSubstitution() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/irrelevantImplMutableListSubstitution/");
            doTestWithJava(fileName);
        }

        @TestMetadata("irrelevantRemoveAtOverrideInJava")
        public void testIrrelevantRemoveAtOverrideInJava() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/irrelevantRemoveAtOverrideInJava/");
            doTestWithJava(fileName);
        }

        @TestMetadata("irrelevantSizeOverrideInJava")
        public void testIrrelevantSizeOverrideInJava() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/irrelevantSizeOverrideInJava/");
            doTestWithJava(fileName);
        }

        @TestMetadata("mutableList")
        public void testMutableList() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/mutableList/");
            doTestWithJava(fileName);
        }

        @TestMetadata("platformValueContains")
        public void testPlatformValueContains() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/platformValueContains/");
            doTestWithJava(fileName);
        }

        @TestMetadata("removeAtInt")
        public void testRemoveAtInt() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/removeAtInt/");
            doTestWithJava(fileName);
        }

        @TestMetadata("strList")
        public void testStrList() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/collections/strList/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/fileClasses")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class FileClasses extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInFileClasses() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/fileClasses"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("differentFiles")
        public void testDifferentFiles() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/fileClasses/differentFiles/");
            doTestWithJava(fileName);
        }

        @TestMetadata("multifileClassWith2Files")
        public void testMultifileClassWith2Files() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/fileClasses/multifileClassWith2Files/");
            doTestWithJava(fileName);
        }

        @TestMetadata("multifileClassWithCrossCall")
        public void testMultifileClassWithCrossCall() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/fileClasses/multifileClassWithCrossCall/");
            doTestWithJava(fileName);
        }

        @TestMetadata("multifileClassWithPrivate")
        public void testMultifileClassWithPrivate() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/fileClasses/multifileClassWithPrivate/");
            doTestWithJava(fileName);
        }

        @TestMetadata("simple")
        public void testSimple() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/fileClasses/simple/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/interfaces")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Interfaces extends AbstractBlackBoxCodegenTest {
        @TestMetadata("abstractClassInheritsFromInterface")
        public void testAbstractClassInheritsFromInterface() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/interfaces/abstractClassInheritsFromInterface/");
            doTestWithJava(fileName);
        }

        public void testAllFilesPresentInInterfaces() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/interfaces"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("inheritJavaInterface")
        public void testInheritJavaInterface() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/interfaces/inheritJavaInterface/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/jvmField")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class JvmField extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInJvmField() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/jvmField"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("simple")
        public void testSimple() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/jvmField/simple/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/jvmOverloads")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class JvmOverloads extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInJvmOverloads() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/jvmOverloads"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("generics")
        public void testGenerics() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/jvmOverloads/generics/");
            doTestWithJava(fileName);
        }

        @TestMetadata("simple")
        public void testSimple() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/jvmOverloads/simple/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/jvmStatic")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class JvmStatic extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInJvmStatic() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/jvmStatic"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("annotations")
        public void testAnnotations() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/jvmStatic/annotations/");
            doTestWithJava(fileName);
        }

        @TestMetadata("classObject")
        public void testClassObject() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/jvmStatic/classObject/");
            doTestWithJava(fileName);
        }

        @TestMetadata("enumCompanion")
        public void testEnumCompanion() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/jvmStatic/enumCompanion/");
            doTestWithJava(fileName);
        }

        @TestMetadata("object")
        public void testObject() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/jvmStatic/object/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/notNullAssertions")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class NotNullAssertions extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInNotNullAssertions() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/notNullAssertions"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("extensionReceiverParameter")
        public void testExtensionReceiverParameter() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/notNullAssertions/extensionReceiverParameter/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/properties")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Properties extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInProperties() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/properties"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("annotationWithKotlinProperty")
        public void testAnnotationWithKotlinProperty() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/properties/annotationWithKotlinProperty/");
            doTestWithJava(fileName);
        }

        @TestMetadata("annotationWithKotlinPropertyFromInterfaceCompanion")
        public void testAnnotationWithKotlinPropertyFromInterfaceCompanion() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/properties/annotationWithKotlinPropertyFromInterfaceCompanion/");
            doTestWithJava(fileName);
        }

        @TestMetadata("classObjectProperties")
        public void testClassObjectProperties() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/properties/classObjectProperties/");
            doTestWithJava(fileName);
        }

        @TestMetadata("collectionSize")
        public void testCollectionSize() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/properties/collectionSize/");
            doTestWithJava(fileName);
        }

        @TestMetadata("commonProperties")
        public void testCommonProperties() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/properties/commonProperties/");
            doTestWithJava(fileName);
        }

        @TestMetadata("substituteJavaSuperField")
        public void testSubstituteJavaSuperField() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/properties/substituteJavaSuperField/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/reflection")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Reflection extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInReflection() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/reflection"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("callInstanceJavaMethod")
        public void testCallInstanceJavaMethod() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/callInstanceJavaMethod/");
            doTestWithJava(fileName);
        }

        @TestMetadata("callPrivateJavaMethod")
        public void testCallPrivateJavaMethod() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/callPrivateJavaMethod/");
            doTestWithJava(fileName);
        }

        @TestMetadata("callStaticJavaMethod")
        public void testCallStaticJavaMethod() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/callStaticJavaMethod/");
            doTestWithJava(fileName);
        }

        @TestMetadata("declaredVsInheritedFunctions")
        public void testDeclaredVsInheritedFunctions() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/declaredVsInheritedFunctions/");
            doTestWithJava(fileName);
        }

        @TestMetadata("declaredVsInheritedProperties")
        public void testDeclaredVsInheritedProperties() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/declaredVsInheritedProperties/");
            doTestWithJava(fileName);
        }

        @TestMetadata("functionReferenceErasedToKFunction")
        public void testFunctionReferenceErasedToKFunction() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/functionReferenceErasedToKFunction/");
            doTestWithJava(fileName);
        }

        @TestMetadata("javaClassGetFunctions")
        public void testJavaClassGetFunctions() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/javaClassGetFunctions/");
            doTestWithJava(fileName);
        }

        @TestMetadata("javaMethodsSmokeTest")
        public void testJavaMethodsSmokeTest() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/javaMethodsSmokeTest/");
            doTestWithJava(fileName);
        }

        @TestMetadata("javaPropertyInheritedInKotlin")
        public void testJavaPropertyInheritedInKotlin() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/javaPropertyInheritedInKotlin/");
            doTestWithJava(fileName);
        }

        @TestMetadata("javaStaticField")
        public void testJavaStaticField() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/javaStaticField/");
            doTestWithJava(fileName);
        }

        @TestMetadata("kotlinPropertyInheritedInJava")
        public void testKotlinPropertyInheritedInJava() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/kotlinPropertyInheritedInJava/");
            doTestWithJava(fileName);
        }

        @TestMetadata("mutatePrivateJavaInstanceField")
        public void testMutatePrivateJavaInstanceField() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/mutatePrivateJavaInstanceField/");
            doTestWithJava(fileName);
        }

        @TestMetadata("mutatePrivateJavaStaticField")
        public void testMutatePrivateJavaStaticField() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/mutatePrivateJavaStaticField/");
            doTestWithJava(fileName);
        }

        @TestMetadata("nestedClasses")
        public void testNestedClasses() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/nestedClasses/");
            doTestWithJava(fileName);
        }

        @TestMetadata("noConflictOnKotlinGetterAndJavaField")
        public void testNoConflictOnKotlinGetterAndJavaField() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/noConflictOnKotlinGetterAndJavaField/");
            doTestWithJava(fileName);
        }

        @TestMetadata("parametersHaveNoNames")
        public void testParametersHaveNoNames() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/parametersHaveNoNames/");
            doTestWithJava(fileName);
        }

        @TestMetadata("platformTypeNotEqualToKotlinType")
        public void testPlatformTypeNotEqualToKotlinType() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/platformTypeNotEqualToKotlinType/");
            doTestWithJava(fileName);
        }

        @TestMetadata("platformTypeToString")
        public void testPlatformTypeToString() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/platformTypeToString/");
            doTestWithJava(fileName);
        }

        @TestMetadata("referenceToJavaFieldOfKotlinSubclass")
        public void testReferenceToJavaFieldOfKotlinSubclass() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/reflection/referenceToJavaFieldOfKotlinSubclass/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/secondaryConstructors")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class SecondaryConstructors extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInSecondaryConstructors() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/secondaryConstructors"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("withGenerics")
        public void testWithGenerics() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/secondaryConstructors/withGenerics/");
            doTestWithJava(fileName);
        }

        @TestMetadata("withPrimary")
        public void testWithPrimary() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/secondaryConstructors/withPrimary/");
            doTestWithJava(fileName);
        }

        @TestMetadata("withVarargs")
        public void testWithVarargs() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/secondaryConstructors/withVarargs/");
            doTestWithJava(fileName);
        }

        @TestMetadata("withoutPrimary")
        public void testWithoutPrimary() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/secondaryConstructors/withoutPrimary/");
            doTestWithJava(fileName);
        }

    }

    @TestMetadata("compiler/testData/codegen/boxWithJava/statics")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Statics extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInStatics() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/boxWithJava/statics"), Pattern.compile("^([^\\.]+)$"), true);
        }

        @TestMetadata("fields")
        public void testFields() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/statics/fields/");
            doTestWithJava(fileName);
        }

        @TestMetadata("functions")
        public void testFunctions() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/statics/functions/");
            doTestWithJava(fileName);
        }

        @TestMetadata("hidePrivateByPublic")
        public void testHidePrivateByPublic() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/statics/hidePrivateByPublic/");
            doTestWithJava(fileName);
        }

        @TestMetadata("protectedSamConstructor")
        public void testProtectedSamConstructor() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/statics/protectedSamConstructor/");
            doTestWithJava(fileName);
        }

        @TestMetadata("protectedStatic")
        public void testProtectedStatic() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/statics/protectedStatic/");
            doTestWithJava(fileName);
        }

        @TestMetadata("protectedStatic2")
        public void testProtectedStatic2() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/boxWithJava/statics/protectedStatic2/");
            doTestWithJava(fileName);
        }

    }
}
