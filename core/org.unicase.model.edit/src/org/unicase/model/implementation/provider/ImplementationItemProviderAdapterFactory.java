/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.unicase.model.implementation.util.ImplementationAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ImplementationItemProviderAdapterFactory extends ImplementationAdapterFactory implements
	ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImplementationItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.model.implementation.IPackage} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IPackageItemProvider iPackageItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.model.implementation.IPackage}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createIPackageAdapter() {
		if (iPackageItemProvider == null) {
			iPackageItemProvider = new IPackageItemProvider(this);
		}

		return iPackageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.model.implementation.IClass} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IClassItemProvider iClassItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.model.implementation.IClass}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createIClassAdapter() {
		if (iClassItemProvider == null) {
			iClassItemProvider = new IClassItemProvider(this);
		}

		return iClassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.model.implementation.IAttribute} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IAttributeItemProvider iAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.model.implementation.IAttribute}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createIAttributeAdapter() {
		if (iAttributeItemProvider == null) {
			iAttributeItemProvider = new IAttributeItemProvider(this);
		}

		return iAttributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.model.implementation.IReference} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IReferenceItemProvider iReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.model.implementation.IReference}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createIReferenceAdapter() {
		if (iReferenceItemProvider == null) {
			iReferenceItemProvider = new IReferenceItemProvider(this);
		}

		return iReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.model.implementation.IEnumeration} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IEnumerationItemProvider iEnumerationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.model.implementation.IEnumeration}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createIEnumerationAdapter() {
		if (iEnumerationItemProvider == null) {
			iEnumerationItemProvider = new IEnumerationItemProvider(this);
		}

		return iEnumerationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.model.implementation.ILiteral} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ILiteralItemProvider iLiteralItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.model.implementation.ILiteral}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createILiteralAdapter() {
		if (iLiteralItemProvider == null) {
			iLiteralItemProvider = new ILiteralItemProvider(this);
		}

		return iLiteralItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void dispose() {
		if (iPackageItemProvider != null)
			iPackageItemProvider.dispose();
		if (iClassItemProvider != null)
			iClassItemProvider.dispose();
		if (iAttributeItemProvider != null)
			iAttributeItemProvider.dispose();
		if (iReferenceItemProvider != null)
			iReferenceItemProvider.dispose();
		if (iEnumerationItemProvider != null)
			iEnumerationItemProvider.dispose();
		if (iLiteralItemProvider != null)
			iLiteralItemProvider.dispose();
	}

}
