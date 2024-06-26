/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.descriptors.components

import org.jetbrains.kotlin.analysis.api.components.KaSymbolInfoProvider
import org.jetbrains.kotlin.analysis.api.descriptors.KaFe10Session
import org.jetbrains.kotlin.analysis.api.descriptors.components.base.KaFe10SessionComponent
import org.jetbrains.kotlin.analysis.api.descriptors.symbols.descriptorBased.base.getSymbolDescriptor
import org.jetbrains.kotlin.analysis.api.symbols.KaPropertyAccessorSymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaPropertySymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaSymbol
import org.jetbrains.kotlin.analysis.api.lifetime.KaLifetimeToken
import org.jetbrains.kotlin.analysis.api.symbols.KaClassOrObjectSymbol
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.annotations.AnnotationUseSiteTarget
import org.jetbrains.kotlin.descriptors.annotations.KotlinTarget
import org.jetbrains.kotlin.load.java.JvmAbi
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.name.SpecialNames
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.resolve.AnnotationChecker
import org.jetbrains.kotlin.resolve.DescriptorUtils
import org.jetbrains.kotlin.resolve.deprecation.DeprecationInfo
import org.jetbrains.kotlin.resolve.deprecation.DeprecationLevelValue
import org.jetbrains.kotlin.resolve.deprecation.DeprecationResolver
import org.jetbrains.kotlin.resolve.deprecation.SimpleDeprecationInfo
import org.jetbrains.kotlin.resolve.jvm.annotations.hasJvmFieldAnnotation
import org.jetbrains.kotlin.resolve.lazy.ForceResolveUtil
import org.jetbrains.kotlin.synthetic.SyntheticJavaPropertyDescriptor

internal class KaFe10SymbolInfoProvider(
    override val analysisSession: KaFe10Session
) : KaSymbolInfoProvider(), KaFe10SessionComponent {
    override val token: KaLifetimeToken
        get() = analysisSession.token

    override fun getDeprecation(symbol: KaSymbol): DeprecationInfo? {
        val descriptor = getSymbolDescriptor(symbol) ?: return null
        ForceResolveUtil.forceResolveAllContents(descriptor)
        return getDeprecation(descriptor)
    }

    override fun getDeprecation(symbol: KaSymbol, annotationUseSiteTarget: AnnotationUseSiteTarget?): DeprecationInfo? {
        when (annotationUseSiteTarget) {
            AnnotationUseSiteTarget.PROPERTY_GETTER -> {
                if (symbol is KaPropertySymbol) {
                    return getDeprecation(symbol.getter ?: symbol)
                }
            }
            AnnotationUseSiteTarget.PROPERTY_SETTER -> {
                if (symbol is KaPropertySymbol) {
                    return getDeprecation(symbol.setter ?: symbol)
                }
            }
            AnnotationUseSiteTarget.SETTER_PARAMETER -> {
                if (symbol is KaPropertySymbol) {
                    return getDeprecation(symbol.setter?.parameter ?: symbol)
                }
            }
            else -> {
            }
        }
        return getDeprecation(symbol) // TODO
    }

    private fun getDeprecation(descriptor: DeclarationDescriptor): DeprecationInfo? {
        if (descriptor is PropertyDescriptor) {
            val fieldDescriptor = descriptor.backingField
            if (fieldDescriptor != null && fieldDescriptor.annotations.hasAnnotation(DeprecationResolver.JAVA_DEPRECATED)) {
                return SimpleDeprecationInfo(DeprecationLevelValue.WARNING, propagatesToOverrides = false, message = null)
            }
        }

        return analysisContext.deprecationResolver.getDeprecations(descriptor).firstOrNull()
    }

    private fun getAccessorDeprecation(
        property: KaPropertySymbol,
        accessor: KaPropertyAccessorSymbol?,
        accessorDescriptorProvider: (PropertyDescriptor) -> PropertyAccessorDescriptor?
    ): DeprecationInfo? {
        val propertyDescriptor = getSymbolDescriptor(property) as? PropertyDescriptor ?: return null
        ForceResolveUtil.forceResolveAllContents(propertyDescriptor)

        if (accessor != null) {
            val accessorDescriptor = getSymbolDescriptor(accessor) as? PropertyAccessorDescriptor
            if (accessorDescriptor != null) {
                ForceResolveUtil.forceResolveAllContents(accessorDescriptor.correspondingProperty)
                val deprecation = analysisContext.deprecationResolver.getDeprecations(accessorDescriptor).firstOrNull()
                if (deprecation != null) {
                    return deprecation
                }
            }
        }

        val accessorDescriptor = accessorDescriptorProvider(propertyDescriptor)
        if (accessorDescriptor != null) {
            val deprecation = analysisContext.deprecationResolver.getDeprecations(accessorDescriptor).firstOrNull()
            if (deprecation != null) {
                return deprecation
            }
        }

        return getDeprecation(propertyDescriptor)
    }

    override fun getGetterDeprecation(symbol: KaPropertySymbol): DeprecationInfo? {
        return getAccessorDeprecation(symbol, symbol.getter) { it.getter }
    }

    override fun getSetterDeprecation(symbol: KaPropertySymbol): DeprecationInfo? {
        return getAccessorDeprecation(symbol, symbol.setter) { it.setter }
    }

    override fun getJavaGetterName(symbol: KaPropertySymbol): Name {
        val descriptor = getSymbolDescriptor(symbol) as? PropertyDescriptor
        if (descriptor is SyntheticJavaPropertyDescriptor) {
            return descriptor.getMethod.name
        }

        if (descriptor != null) {
            if (descriptor.hasJvmFieldAnnotation()) return descriptor.name

            val getter = descriptor.getter ?: return SpecialNames.NO_NAME_PROVIDED
            return Name.identifier(DescriptorUtils.getJvmName(getter) ?: JvmAbi.getterName(descriptor.name.asString()))
        }

        val ktPropertyName = (symbol.psi as? KtProperty)?.name ?: return SpecialNames.NO_NAME_PROVIDED
        return Name.identifier(JvmAbi.getterName(ktPropertyName))
    }

    override fun getJavaSetterName(symbol: KaPropertySymbol): Name? {
        val descriptor = getSymbolDescriptor(symbol) as? PropertyDescriptor
        if (descriptor is SyntheticJavaPropertyDescriptor) {
            return descriptor.setMethod?.name
        }

        if (descriptor != null) {
            if (!descriptor.isVar) {
                return null
            }

            if (descriptor.hasJvmFieldAnnotation()) return descriptor.name

            val setter = descriptor.setter ?: return SpecialNames.NO_NAME_PROVIDED
            return Name.identifier(DescriptorUtils.getJvmName(setter) ?: JvmAbi.setterName(descriptor.name.asString()))
        }

        val ktPropertyName = (symbol.psi as? KtProperty)?.takeIf { it.isVar }?.name ?: return SpecialNames.NO_NAME_PROVIDED
        return Name.identifier(JvmAbi.setterName(ktPropertyName))
    }

    override fun getAnnotationApplicableTargets(symbol: KaClassOrObjectSymbol): Set<KotlinTarget>? {
        val descriptor = getSymbolDescriptor(symbol) as? ClassDescriptor ?: return null
        if (descriptor.kind != ClassKind.ANNOTATION_CLASS) return null

        return AnnotationChecker.applicableTargetSet(descriptor)
    }
}