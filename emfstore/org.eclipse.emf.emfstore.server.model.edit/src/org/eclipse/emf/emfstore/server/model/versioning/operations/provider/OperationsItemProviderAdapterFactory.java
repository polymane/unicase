/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations.provider;

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
import org.eclipse.emf.emfstore.server.model.versioning.operations.util.OperationsAdapterFactory;

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
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeOperationItemProvider compositeOperationItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createCompositeOperationAdapter() {
		if (compositeOperationItemProvider == null) {
			compositeOperationItemProvider = new CompositeOperationItemProvider(this);
		}

		return compositeOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateDeleteOperationItemProvider createDeleteOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCreateDeleteOperationAdapter() {
		if (createDeleteOperationItemProvider == null) {
			createDeleteOperationItemProvider = new CreateDeleteOperationItemProvider(this);
		}

		return createDeleteOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeOperationItemProvider attributeOperationItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.AttributeOperation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createAttributeOperationAdapter() {
		if (attributeOperationItemProvider == null) {
			attributeOperationItemProvider = new AttributeOperationItemProvider(this);
		}

		return attributeOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiAttributeOperationItemProvider multiAttributeOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeOperation}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMultiAttributeOperationAdapter() {
		if (multiAttributeOperationItemProvider == null) {
			multiAttributeOperationItemProvider = new MultiAttributeOperationItemProvider(this);
		}

		return multiAttributeOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiAttributeSetOperationItemProvider multiAttributeSetOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeSetOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMultiAttributeSetOperationAdapter() {
		if (multiAttributeSetOperationItemProvider == null) {
			multiAttributeSetOperationItemProvider = new MultiAttributeSetOperationItemProvider(this);
		}

		return multiAttributeSetOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiAttributeMoveOperationItemProvider multiAttributeMoveOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiAttributeMoveOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMultiAttributeMoveOperationAdapter() {
		if (multiAttributeMoveOperationItemProvider == null) {
			multiAttributeMoveOperationItemProvider = new MultiAttributeMoveOperationItemProvider(this);
		}

		return multiAttributeMoveOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SingleReferenceOperationItemProvider singleReferenceOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.SingleReferenceOperation}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSingleReferenceOperationAdapter() {
		if (singleReferenceOperationItemProvider == null) {
			singleReferenceOperationItemProvider = new SingleReferenceOperationItemProvider(this);
		}

		return singleReferenceOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiReferenceSetOperationItemProvider multiReferenceSetOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceSetOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMultiReferenceSetOperationAdapter() {
		if (multiReferenceSetOperationItemProvider == null) {
			multiReferenceSetOperationItemProvider = new MultiReferenceSetOperationItemProvider(this);
		}

		return multiReferenceSetOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiReferenceOperationItemProvider multiReferenceOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceOperation}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMultiReferenceOperationAdapter() {
		if (multiReferenceOperationItemProvider == null) {
			multiReferenceOperationItemProvider = new MultiReferenceOperationItemProvider(this);
		}

		return multiReferenceOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiReferenceMoveOperationItemProvider multiReferenceMoveOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMultiReferenceMoveOperationAdapter() {
		if (multiReferenceMoveOperationItemProvider == null) {
			multiReferenceMoveOperationItemProvider = new MultiReferenceMoveOperationItemProvider(this);
		}

		return multiReferenceMoveOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.versioning.operations.DiagramLayoutOperation} instances.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramLayoutOperationItemProvider diagramLayoutOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.DiagramLayoutOperation}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramLayoutOperationAdapter() {
		if (diagramLayoutOperationItemProvider == null) {
			diagramLayoutOperationItemProvider = new DiagramLayoutOperationItemProvider(this);
		}

		return diagramLayoutOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected OperationIdItemProvider operationIdItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationId}.
	 * <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createOperationIdAdapter() {
		if (operationIdItemProvider == null) {
			operationIdItemProvider = new OperationIdItemProvider(this);
		}

		return operationIdItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup} instances.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected OperationGroupItemProvider operationGroupItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.operations.OperationGroup}.
	 * <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createOperationGroupAdapter() {
		if (operationGroupItemProvider == null) {
			operationGroupItemProvider = new OperationGroupItemProvider(this);
		}

		return operationGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementGroupItemProvider modelElementGroupItemProvider;

	/**
	 * This creates an adapter for a
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ModelElementGroup}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createModelElementGroupAdapter() {
		if (modelElementGroupItemProvider == null) {
			modelElementGroupItemProvider = new ModelElementGroupItemProvider(this);
		}

		return modelElementGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObjectToModelElementIdMapItemProvider eObjectToModelElementIdMapItemProvider;

	/**
	 * This creates an adapter for a {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEObjectToModelElementIdMapAdapter() {
		if (eObjectToModelElementIdMapItemProvider == null) {
			eObjectToModelElementIdMapItemProvider = new EObjectToModelElementIdMapItemProvider(this);
		}

		return eObjectToModelElementIdMapItemProvider;
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
		if (compositeOperationItemProvider != null) compositeOperationItemProvider.dispose();
		if (createDeleteOperationItemProvider != null) createDeleteOperationItemProvider.dispose();
		if (attributeOperationItemProvider != null) attributeOperationItemProvider.dispose();
		if (multiAttributeOperationItemProvider != null) multiAttributeOperationItemProvider.dispose();
		if (multiAttributeSetOperationItemProvider != null) multiAttributeSetOperationItemProvider.dispose();
		if (multiAttributeMoveOperationItemProvider != null) multiAttributeMoveOperationItemProvider.dispose();
		if (singleReferenceOperationItemProvider != null) singleReferenceOperationItemProvider.dispose();
		if (multiReferenceSetOperationItemProvider != null) multiReferenceSetOperationItemProvider.dispose();
		if (multiReferenceOperationItemProvider != null) multiReferenceOperationItemProvider.dispose();
		if (multiReferenceMoveOperationItemProvider != null) multiReferenceMoveOperationItemProvider.dispose();
		if (diagramLayoutOperationItemProvider != null) diagramLayoutOperationItemProvider.dispose();
		if (operationIdItemProvider != null) operationIdItemProvider.dispose();
		if (operationGroupItemProvider != null) operationGroupItemProvider.dispose();
		if (modelElementGroupItemProvider != null) modelElementGroupItemProvider.dispose();
		if (eObjectToModelElementIdMapItemProvider != null) eObjectToModelElementIdMapItemProvider.dispose();
	}

}
