/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.provider;

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
import org.unicase.docExport.exportModel.renderers.specialRenderers.util.SpecialRenderersAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SpecialRenderersItemProviderAdapterFactory extends SpecialRenderersAdapterFactory implements
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
	public SpecialRenderersItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MeetingRendererItemProvider meetingRendererItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMeetingRendererAdapter() {
		if (meetingRendererItemProvider == null) {
			meetingRendererItemProvider = new MeetingRendererItemProvider(this);
		}

		return meetingRendererItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MilestoneRendererItemProvider milestoneRendererItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMilestoneRendererAdapter() {
		if (milestoneRendererItemProvider == null) {
			milestoneRendererItemProvider = new MilestoneRendererItemProvider(this);
		}

		return milestoneRendererItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StepsAttributeRendererItemProvider stepsAttributeRendererItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer}.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStepsAttributeRendererAdapter() {
		if (stepsAttributeRendererItemProvider == null) {
			stepsAttributeRendererItemProvider = new StepsAttributeRendererItemProvider(this);
		}

		return stepsAttributeRendererItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MethodRendererItemProvider methodRendererItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMethodRendererAdapter() {
		if (methodRendererItemProvider == null) {
			methodRendererItemProvider = new MethodRendererItemProvider(this);
		}

		return methodRendererItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer} instances. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PackageFlatRendererItemProvider packageFlatRendererItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPackageFlatRendererAdapter() {
		if (packageFlatRendererItemProvider == null) {
			packageFlatRendererItemProvider = new PackageFlatRendererItemProvider(this);
		}

		return packageFlatRendererItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassRendererItemProvider classRendererItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createClassRendererAdapter() {
		if (classRendererItemProvider == null) {
			classRendererItemProvider = new ClassRendererItemProvider(this);
		}

		return classRendererItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.docExport.exportModel.renderers.specialRenderers.ClassAttributesRenderer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassAttributesRendererItemProvider classAttributesRendererItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.docExport.exportModel.renderers.specialRenderers.ClassAttributesRenderer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createClassAttributesRendererAdapter() {
		if (classAttributesRendererItemProvider == null) {
			classAttributesRendererItemProvider = new ClassAttributesRendererItemProvider(this);
		}

		return classAttributesRendererItemProvider;
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
			if (!(type instanceof Class) || (((Class<?>)type).isInstance(adapter))) {
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
		if (meetingRendererItemProvider != null) meetingRendererItemProvider.dispose();
		if (milestoneRendererItemProvider != null) milestoneRendererItemProvider.dispose();
		if (stepsAttributeRendererItemProvider != null) stepsAttributeRendererItemProvider.dispose();
		if (methodRendererItemProvider != null) methodRendererItemProvider.dispose();
		if (packageFlatRendererItemProvider != null) packageFlatRendererItemProvider.dispose();
		if (classRendererItemProvider != null) classRendererItemProvider.dispose();
		if (classAttributesRendererItemProvider != null) classAttributesRendererItemProvider.dispose();
	}

}
