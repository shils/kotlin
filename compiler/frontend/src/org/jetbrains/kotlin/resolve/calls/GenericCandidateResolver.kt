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

package org.jetbrains.kotlin.resolve.calls

import org.jetbrains.kotlin.builtins.KotlinBuiltIns
import org.jetbrains.kotlin.builtins.ReflectionTypes
import org.jetbrains.kotlin.descriptors.CallableDescriptor
import org.jetbrains.kotlin.descriptors.TypeParameterDescriptor
import org.jetbrains.kotlin.descriptors.ValueParameterDescriptor
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.FunctionDescriptorUtil
import org.jetbrains.kotlin.resolve.calls.callResolverUtil.*
import org.jetbrains.kotlin.resolve.calls.callResolverUtil.ResolveArgumentsMode.RESOLVE_FUNCTION_ARGUMENTS
import org.jetbrains.kotlin.resolve.calls.callResolverUtil.ResolveArgumentsMode.SHAPE_FUNCTION_ARGUMENTS
import org.jetbrains.kotlin.resolve.calls.callUtil.getCall
import org.jetbrains.kotlin.resolve.calls.context.CallCandidateResolutionContext
import org.jetbrains.kotlin.resolve.calls.context.ContextDependency.INDEPENDENT
import org.jetbrains.kotlin.resolve.calls.context.ResolutionContext
import org.jetbrains.kotlin.resolve.calls.context.ResolutionResultsCache
import org.jetbrains.kotlin.resolve.calls.context.TemporaryTraceAndCache
import org.jetbrains.kotlin.resolve.calls.inference.ConstraintSystem
import org.jetbrains.kotlin.resolve.calls.inference.ConstraintSystemBuilderImpl
import org.jetbrains.kotlin.resolve.calls.inference.constraintPosition.ConstraintPosition
import org.jetbrains.kotlin.resolve.calls.inference.constraintPosition.ConstraintPositionKind.RECEIVER_POSITION
import org.jetbrains.kotlin.resolve.calls.inference.constraintPosition.ConstraintPositionKind.VALUE_PARAMETER_POSITION
import org.jetbrains.kotlin.resolve.calls.inference.getNestedTypeParameters
import org.jetbrains.kotlin.resolve.calls.inference.getNestedTypeVariables
import org.jetbrains.kotlin.resolve.calls.results.ResolutionStatus
import org.jetbrains.kotlin.resolve.calls.results.ResolutionStatus.INCOMPLETE_TYPE_INFERENCE
import org.jetbrains.kotlin.resolve.calls.results.ResolutionStatus.OTHER_ERROR
import org.jetbrains.kotlin.resolve.calls.smartcasts.DataFlowValueFactory
import org.jetbrains.kotlin.resolve.scopes.receivers.ExpressionReceiver
import org.jetbrains.kotlin.types.*
import org.jetbrains.kotlin.types.TypeUtils.DONT_CARE
import org.jetbrains.kotlin.types.checker.KotlinTypeChecker
import org.jetbrains.kotlin.types.expressions.ExpressionTypingUtils

class GenericCandidateResolver(private val argumentTypeResolver: ArgumentTypeResolver) {
    fun <D : CallableDescriptor> inferTypeArguments(context: CallCandidateResolutionContext<D>): ResolutionStatus {
        val candidateCall = context.candidateCall
        val candidate = candidateCall.candidateDescriptor

        val builder = ConstraintSystemBuilderImpl()
        builder.registerTypeVariables(candidate.typeParameters)

        val substituteDontCare = makeConstantSubstitutor(candidate.typeParameters, DONT_CARE)

        // Value parameters
        for ((candidateParameter, resolvedValueArgument) in candidateCall.valueArguments) {
            val valueParameterDescriptor = candidate.valueParameters[candidateParameter.index]

            for (valueArgument in resolvedValueArgument.arguments) {
                // TODO : more attempts, with different expected types

                // Here we type check expecting an error type (DONT_CARE, substitution with substituteDontCare)
                // and throw the results away
                // We'll type check the arguments later, with the inferred types expected
                addConstraintForValueArgument(
                        valueArgument, valueParameterDescriptor, substituteDontCare, builder, context, SHAPE_FUNCTION_ARGUMENTS
                )
            }
        }

        // Receiver
        // Error is already reported if something is missing
        val receiverArgument = candidateCall.extensionReceiver
        val receiverParameter = candidate.extensionReceiverParameter
        if (receiverArgument.exists() && receiverParameter != null) {
            var receiverType: KotlinType? = if (context.candidateCall.isSafeCall)
                TypeUtils.makeNotNullable(receiverArgument.type)
            else
                receiverArgument.type
            if (receiverArgument is ExpressionReceiver) {
                receiverType = updateResultTypeForSmartCasts(receiverType, receiverArgument.expression, context)
            }
            builder.addSubtypeConstraint(receiverType, receiverParameter.type, RECEIVER_POSITION.position())
        }

        val constraintSystem = builder.build()
        candidateCall.setConstraintSystem(constraintSystem)

        // Solution
        val hasContradiction = constraintSystem.status.hasContradiction()
        if (!hasContradiction) {
            return INCOMPLETE_TYPE_INFERENCE
        }
        return OTHER_ERROR
    }

    fun addConstraintForValueArgument(
            valueArgument: ValueArgument,
            valueParameterDescriptor: ValueParameterDescriptor,
            substitutor: TypeSubstitutor,
            builder: ConstraintSystem.Builder,
            context: CallCandidateResolutionContext<*>,
            resolveFunctionArgumentBodies: ResolveArgumentsMode
    ) {

        val effectiveExpectedType = getEffectiveExpectedType(valueParameterDescriptor, valueArgument)
        val argumentExpression = valueArgument.getArgumentExpression()

        val expectedType = substitutor.substitute(effectiveExpectedType, Variance.INVARIANT)
        val dataFlowInfoForArgument = context.candidateCall.dataFlowInfoForArguments.getInfo(valueArgument)
        val newContext = context.replaceExpectedType(expectedType).replaceDataFlowInfo(dataFlowInfoForArgument)

        val typeInfoForCall = argumentTypeResolver.getArgumentTypeInfo(argumentExpression, newContext, resolveFunctionArgumentBodies)
        context.candidateCall.dataFlowInfoForArguments.updateInfo(valueArgument, typeInfoForCall.dataFlowInfo)

        val constraintPosition = VALUE_PARAMETER_POSITION.position(valueParameterDescriptor.index)

        if (addConstraintForNestedCall(argumentExpression, constraintPosition, builder, newContext, effectiveExpectedType)) return

        val type = updateResultTypeForSmartCasts(typeInfoForCall.type, argumentExpression, context.replaceDataFlowInfo(dataFlowInfoForArgument))
        builder.addSubtypeConstraint(type, effectiveExpectedType, constraintPosition)
    }

    private fun addConstraintForNestedCall(
            argumentExpression: KtExpression?,
            constraintPosition: ConstraintPosition,
            builder: ConstraintSystem.Builder,
            context: CallCandidateResolutionContext<*>,
            effectiveExpectedType: KotlinType
    ): Boolean {
        val resolutionResults = getResolutionResultsCachedData(argumentExpression, context)?.resolutionResults
        if (resolutionResults == null || !resolutionResults.isSingleResult) return false

        val resultingCall = resolutionResults.resultingCall
        if (resultingCall.isCompleted) return false

        val argumentConstraintSystem = resultingCall.constraintSystem ?: return false

        val candidateDescriptor = resultingCall.candidateDescriptor
        val returnType = candidateDescriptor.returnType ?: return false

        val nestedTypeVariables = argumentConstraintSystem.getNestedTypeVariables(returnType)

        // we add an additional type variable only if no information is inferred for it.
        // otherwise we add currently inferred return type as before
        if (nestedTypeVariables.any { argumentConstraintSystem.getTypeBounds(it).bounds.isNotEmpty() }) return false

        val candidateWithFreshVariables = FunctionDescriptorUtil.alphaConvertTypeParameters(candidateDescriptor)
        val conversion = candidateDescriptor.typeParameters.zip(candidateWithFreshVariables.typeParameters).toMap()

        val freshVariables = returnType.getNestedTypeParameters().map { conversion[it] }.filterNotNull()
        builder.registerTypeVariables(freshVariables, external = true)

        builder.addSubtypeConstraint(candidateWithFreshVariables.returnType, effectiveExpectedType, constraintPosition)
        return true
    }

    private fun updateResultTypeForSmartCasts(
            type: KotlinType?,
            argumentExpression: KtExpression?,
            context: ResolutionContext<*>
    ): KotlinType? {
        val deparenthesizedArgument = KtPsiUtil.getLastElementDeparenthesized(argumentExpression, context.statementFilter)
        if (deparenthesizedArgument == null || type == null) return type

        val dataFlowValue = DataFlowValueFactory.createDataFlowValue(deparenthesizedArgument, type, context)
        if (!dataFlowValue.isPredictable) return type

        val possibleTypes = context.dataFlowInfo.getPossibleTypes(dataFlowValue)
        if (possibleTypes.isEmpty()) return type

        return TypeIntersector.intersectTypes(KotlinTypeChecker.DEFAULT, possibleTypes)
    }

    fun <D : CallableDescriptor> completeTypeInferenceDependentOnFunctionArgumentsForCall(context: CallCandidateResolutionContext<D>) {
        val resolvedCall = context.candidateCall
        val constraintSystem = resolvedCall.constraintSystem?.toBuilder() ?: return

        // constraints for function literals
        // Value parameters
        for ((valueParameterDescriptor, resolvedValueArgument) in resolvedCall.valueArguments) {
            for (valueArgument in resolvedValueArgument.arguments) {
                valueArgument.getArgumentExpression()?.let { argumentExpression ->
                    ArgumentTypeResolver.getFunctionLiteralArgumentIfAny(argumentExpression, context)?.let { functionLiteral ->
                        addConstraintForFunctionLiteral(functionLiteral, valueArgument, valueParameterDescriptor, constraintSystem, context)
                    }
                    ArgumentTypeResolver.getCallableReferenceExpressionIfAny(argumentExpression, context)?.let { callableReference ->
                        addConstraintForCallableReference(callableReference, valueArgument, valueParameterDescriptor, constraintSystem, context)
                    }
                }
            }
        }
        val resultingSystem = constraintSystem.build()
        resolvedCall.setConstraintSystem(resultingSystem)
        resolvedCall.setResultingSubstitutor(resultingSystem.resultingSubstitutor)
    }

    private fun <D : CallableDescriptor> addConstraintForFunctionLiteral(
            functionLiteral: KtFunction,
            valueArgument: ValueArgument,
            valueParameterDescriptor: ValueParameterDescriptor,
            constraintSystem: ConstraintSystem.Builder,
            context: CallCandidateResolutionContext<D>
    ) {
        val argumentExpression = valueArgument.getArgumentExpression() ?: return

        val effectiveExpectedType = getEffectiveExpectedType(valueParameterDescriptor, valueArgument)
        var expectedType = constraintSystem.build().currentSubstitutor.substitute(effectiveExpectedType, Variance.INVARIANT)
        if (expectedType == null || TypeUtils.isDontCarePlaceholder(expectedType)) {
            expectedType = argumentTypeResolver.getShapeTypeOfFunctionLiteral(functionLiteral, context.scope, context.trace, false)
        }
        if (expectedType == null || !KotlinBuiltIns.isFunctionOrExtensionFunctionType(expectedType) ||
            hasUnknownFunctionParameter(expectedType)) {
            return
        }
        val dataFlowInfoForArguments = context.candidateCall.dataFlowInfoForArguments
        val dataFlowInfoForArgument = dataFlowInfoForArguments.getInfo(valueArgument)

        //todo analyze function literal body once in 'dependent' mode, then complete it with respect to expected type
        val hasExpectedReturnType = !hasUnknownReturnType(expectedType)
        val position = VALUE_PARAMETER_POSITION.position(valueParameterDescriptor.index)
        if (hasExpectedReturnType) {
            val temporaryToResolveFunctionLiteral = TemporaryTraceAndCache.create(
                    context, "trace to resolve function literal with expected return type", argumentExpression)

            val statementExpression = KtPsiUtil.getExpressionOrLastStatementInBlock(functionLiteral.bodyExpression) ?: return
            val mismatch = BooleanArray(1)
            val errorInterceptingTrace = ExpressionTypingUtils.makeTraceInterceptingTypeMismatch(
                    temporaryToResolveFunctionLiteral.trace, statementExpression, mismatch)
            val newContext = context.replaceBindingTrace(errorInterceptingTrace).replaceExpectedType(expectedType)
                    .replaceDataFlowInfo(dataFlowInfoForArgument).replaceResolutionResultsCache(temporaryToResolveFunctionLiteral.cache)
                    .replaceContextDependency(INDEPENDENT)
            val type = argumentTypeResolver.getFunctionLiteralTypeInfo(
                    argumentExpression, functionLiteral, newContext, RESOLVE_FUNCTION_ARGUMENTS).type
            if (!mismatch[0]) {
                constraintSystem.addSubtypeConstraint(type, effectiveExpectedType, position)
                temporaryToResolveFunctionLiteral.commit()
                return
            }
        }
        val expectedTypeWithoutReturnType = replaceReturnTypeByUnknown(expectedType)
        val newContext = context.replaceExpectedType(expectedTypeWithoutReturnType).replaceDataFlowInfo(dataFlowInfoForArgument)
                .replaceContextDependency(INDEPENDENT)
        val type = argumentTypeResolver.getFunctionLiteralTypeInfo(argumentExpression, functionLiteral, newContext, RESOLVE_FUNCTION_ARGUMENTS).type
        constraintSystem.addSubtypeConstraint(type, effectiveExpectedType, position)
    }

    private fun <D : CallableDescriptor> addConstraintForCallableReference(
            callableReference: KtCallableReferenceExpression,
            valueArgument: ValueArgument,
            valueParameterDescriptor: ValueParameterDescriptor,
            constraintSystem: ConstraintSystem.Builder,
            context: CallCandidateResolutionContext<D>
    ) {
        val effectiveExpectedType = getEffectiveExpectedType(valueParameterDescriptor, valueArgument)
        val expectedType = getExpectedTypeForCallableReference(callableReference, constraintSystem, context, effectiveExpectedType)
                           ?: return
        if (!ReflectionTypes.isCallableType(expectedType)) return
        val resolvedType = getResolvedTypeForCallableReference(callableReference, context, expectedType, valueArgument)
        val position = VALUE_PARAMETER_POSITION.position(valueParameterDescriptor.index)
        constraintSystem.addSubtypeConstraint(resolvedType, effectiveExpectedType, position)
    }

    private fun <D : CallableDescriptor> getExpectedTypeForCallableReference(
            callableReference: KtCallableReferenceExpression,
            constraintSystem: ConstraintSystem.Builder,
            context: CallCandidateResolutionContext<D>,
            effectiveExpectedType: KotlinType
    ): KotlinType? {
        val substitutedType = constraintSystem.build().currentSubstitutor.substitute(effectiveExpectedType, Variance.INVARIANT)
        if (substitutedType != null && !TypeUtils.isDontCarePlaceholder(substitutedType))
            return substitutedType

        val shapeType = argumentTypeResolver.getShapeTypeOfCallableReference(callableReference, context, false)
        if (shapeType != null && KotlinBuiltIns.isFunctionOrExtensionFunctionType(shapeType) && !hasUnknownFunctionParameter(shapeType))
            return shapeType

        return null
    }

    private fun <D : CallableDescriptor> getResolvedTypeForCallableReference(
            callableReference: KtCallableReferenceExpression,
            context: CallCandidateResolutionContext<D>,
            expectedType: KotlinType,
            valueArgument: ValueArgument
    ): KotlinType? {
        val dataFlowInfoForArgument = context.candidateCall.dataFlowInfoForArguments.getInfo(valueArgument)
        val expectedTypeWithoutReturnType = if (!hasUnknownReturnType(expectedType)) replaceReturnTypeByUnknown(expectedType) else expectedType
        val newContext = context
                .replaceExpectedType(expectedTypeWithoutReturnType)
                .replaceDataFlowInfo(dataFlowInfoForArgument)
                .replaceContextDependency(INDEPENDENT)
        val argumentExpression = valueArgument.getArgumentExpression()!!
        val type = argumentTypeResolver.getCallableReferenceTypeInfo(
                argumentExpression, callableReference, newContext, RESOLVE_FUNCTION_ARGUMENTS).type
        return type
    }
}

fun getResolutionResultsCachedData(expression: KtExpression?, context: ResolutionContext<*>): ResolutionResultsCache.CachedData? {
    if (!ExpressionTypingUtils.dependsOnExpectedType(expression)) return null
    val argumentCall = expression?.getCall(context.trace.bindingContext) ?: return null

    return context.resolutionResultsCache[argumentCall]
}

fun makeConstantSubstitutor(typeParameterDescriptors: Collection<TypeParameterDescriptor>, type: KotlinType): TypeSubstitutor {
    val constructors = typeParameterDescriptors.map { it.typeConstructor }.toSet()
    val projection = TypeProjectionImpl(type)

    return TypeSubstitutor.create(object : TypeConstructorSubstitution() {
        override operator fun get(key: TypeConstructor) =
                if (key in constructors) projection else null

        override fun isEmpty() = false
    })
}
