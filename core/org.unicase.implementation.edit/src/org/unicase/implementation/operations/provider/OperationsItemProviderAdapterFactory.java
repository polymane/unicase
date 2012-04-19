/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.provider;

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
import org.unicase.implementation.operations.util.OperationsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class OperationsItemProviderAdapterFactory extends OperationsAdapterFactory implements
	ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	 * This constructs an instance.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.implementation.operations.ExtractSuperClassOperation} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected ExtractSuperClassOperationItemProvider extractSuperClassOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.implementation.operations.ExtractSuperClassOperation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createExtractSuperClassOperationAdapter() {
		if (extractSuperClassOperationItemProvider == null) {
			extractSuperClassOperationItemProvider = new ExtractSuperClassOperationItemProvider(this);
		}

		return extractSuperClassOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.implementation.operations.InlineSuperClassOperation} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected InlineSuperClassOperationItemProvider inlineSuperClassOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.implementation.operations.InlineSuperClassOperation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createInlineSuperClassOperationAdapter() {
		if (inlineSuperClassOperationItemProvider == null) {
			inlineSuperClassOperationItemProvider = new InlineSuperClassOperationItemProvider(this);
		}

		return inlineSuperClassOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.implementation.operations.InlineClassOperation} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected InlineClassOperationItemProvider inlineClassOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.implementation.operations.InlineClassOperation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createInlineClassOperationAdapter() {
		if (inlineClassOperationItemProvider == null) {
			inlineClassOperationItemProvider = new InlineClassOperationItemProvider(this);
		}

		return inlineClassOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.implementation.operations.ExtractClassOperation} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected ExtractClassOperationItemProvider extractClassOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.implementation.operations.ExtractClassOperation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createExtractClassOperationAdapter() {
		if (extractClassOperationItemProvider == null) {
			extractClassOperationItemProvider = new ExtractClassOperationItemProvider(this);
		}

		return extractClassOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.implementation.operations.PartitionAssociationOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartitionAssociationOperationItemProvider partitionAssociationOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.implementation.operations.PartitionAssociationOperation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPartitionAssociationOperationAdapter() {
		if (partitionAssociationOperationItemProvider == null) {
			partitionAssociationOperationItemProvider = new PartitionAssociationOperationItemProvider(this);
		}

		return partitionAssociationOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.implementation.operations.PushDownOperation} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PushDownOperationItemProvider pushDownOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.implementation.operations.PushDownOperation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPushDownOperationAdapter() {
		if (pushDownOperationItemProvider == null) {
			pushDownOperationItemProvider = new PushDownOperationItemProvider(this);
		}

		return pushDownOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.implementation.operations.PullUpOperation} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PullUpOperationItemProvider pullUpOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.implementation.operations.PullUpOperation}.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPullUpOperationAdapter() {
		if (pullUpOperationItemProvider == null) {
			pullUpOperationItemProvider = new PullUpOperationItemProvider(this);
		}

		return pullUpOperationItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (extractSuperClassOperationItemProvider != null) extractSuperClassOperationItemProvider.dispose();
		if (inlineSuperClassOperationItemProvider != null) inlineSuperClassOperationItemProvider.dispose();
		if (extractClassOperationItemProvider != null) extractClassOperationItemProvider.dispose();
		if (inlineClassOperationItemProvider != null) inlineClassOperationItemProvider.dispose();
		if (partitionAssociationOperationItemProvider != null) partitionAssociationOperationItemProvider.dispose();
		if (pushDownOperationItemProvider != null) pushDownOperationItemProvider.dispose();
		if (pullUpOperationItemProvider != null) pullUpOperationItemProvider.dispose();
	}

}
