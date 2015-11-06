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

package org.jetbrains.kotlin.android.synthetic.descriptors

import org.jetbrains.kotlin.android.synthetic.res.*
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.descriptors.impl.PackageFragmentDescriptorImpl
import org.jetbrains.kotlin.incremental.components.LookupLocation
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.resolve.descriptorUtil.module
import org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter
import org.jetbrains.kotlin.resolve.scopes.KtScope
import org.jetbrains.kotlin.resolve.scopes.KtScopeImpl
import org.jetbrains.kotlin.storage.StorageManager
import org.jetbrains.kotlin.utils.Printer
import java.util.*

class AndroidSyntheticPackageData(
        val moduleData: AndroidModuleData,
        val forView: Boolean,
        val isDeprecated: Boolean,
        val resources: List<AndroidResource>)

class AndroidSyntheticPackageFragmentDescriptor(
        module: ModuleDescriptor,
        fqName: FqName,
        val packageData: AndroidSyntheticPackageData,
        private val lazyContext: LazySyntheticElementResolveContext,
        private val storageManager: StorageManager
) : PackageFragmentDescriptorImpl(module, fqName) {
    private val scope = AndroidExtensionPropertiesScope()
    override fun getMemberScope(): KtScope = scope

    private inner class AndroidExtensionPropertiesScope : KtScopeImpl() {
        private val properties = storageManager.createLazyValue {
            val packageFragmentDescriptor = this@AndroidSyntheticPackageFragmentDescriptor

            val context = lazyContext()
            val widgetReceivers = context.getWidgetReceivers(packageData.forView)
            val fragmentTypes = context.fragmentTypes

            val properties = ArrayList<PropertyDescriptor>(0)
            for (resource in packageData.resources) {
                when (resource) {
                    is AndroidResource.Widget -> {
                        val resolvedWidget = resource.resolve(module)
                        for (receiver in widgetReceivers) {
                            val descriptor = genPropertyForWidget(packageFragmentDescriptor, receiver, resolvedWidget, context)
                            properties += descriptor
                        }
                    }
                    is AndroidResource.Fragment -> if (!packageData.forView) {
                        for ((receiverType, type) in fragmentTypes) {
                            properties += genPropertyForFragment(packageFragmentDescriptor, receiverType, type, resource)
                        }
                    }
                }
            }

            properties
        }

        override fun getDescriptors(kindFilter: DescriptorKindFilter, nameFilter: (Name) -> Boolean) = properties()
        override fun getProperties(name: Name, location: LookupLocation) = properties().filter { it.name == name }

        override fun printScopeStructure(p: Printer) {
            p.println(javaClass.simpleName)
        }

        override fun getContainingDeclaration() = throw UnsupportedOperationException()
    }
}
