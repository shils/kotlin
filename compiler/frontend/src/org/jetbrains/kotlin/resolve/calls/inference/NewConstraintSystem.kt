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

package org.jetbrains.kotlin.resolve.calls.inference

import org.jetbrains.kotlin.descriptors.TypeParameterDescriptor
import org.jetbrains.kotlin.psi.Call
import org.jetbrains.kotlin.resolve.calls.inference.constraintPosition.ConstraintPosition
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.TypeConstructor
import org.jetbrains.kotlin.types.TypeSubstitutor

interface NewTypeVariable {
    val call: Call
    val descriptor: TypeParameterDescriptor
    val type: KotlinType
}

abstract class TypeVariableConstructor(val variable: NewTypeVariable) : TypeConstructor

val KotlinType.typeVariable: NewTypeVariable? get() = (constructor as? TypeVariableConstructor)?.variable

interface NewConstraintSystem {
    val variables: Collection<NewTypeVariable>
    val result: ConstraintSystemStatus
    val fastHasContradiction: Boolean

    // fun descriptorToVariable(descriptor: TypeParameterDescriptor, call: Call): NewTypeVariable

    fun toBuilder(): Builder

    interface Builder {
        fun register(call: Call, descriptor: TypeParameterDescriptor): NewTypeVariable

        fun addConstraint(subtype: KotlinType, supertype: KotlinType, position: ConstraintPosition)

        fun add(other: Builder)

        fun build(): NewConstraintSystem
    }
}
