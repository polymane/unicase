/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.events.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.emfstore.common.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.emfstore.server.model.versioning.events.MergeChoiceEvent} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class MergeChoiceEventItemProvider extends EventItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MergeChoiceEventItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSelectionPropertyDescriptor(object);
			addContextFeaturePropertyDescriptor(object);
			addCreatedIssueNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Selection feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSelectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MergeChoiceEvent_selection_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MergeChoiceEvent_selection_feature", "_UI_MergeChoiceEvent_type"),
				 EventsPackage.Literals.MERGE_CHOICE_EVENT__SELECTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Context Feature feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContextFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MergeChoiceEvent_contextFeature_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MergeChoiceEvent_contextFeature_feature", "_UI_MergeChoiceEvent_type"),
				 EventsPackage.Literals.MERGE_CHOICE_EVENT__CONTEXT_FEATURE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Created Issue Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreatedIssueNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MergeChoiceEvent_createdIssueName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MergeChoiceEvent_createdIssueName_feature", "_UI_MergeChoiceEvent_type"),
				 EventsPackage.Literals.MERGE_CHOICE_EVENT__CREATED_ISSUE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EventsPackage.Literals.MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES);
			childrenFeatures.add(EventsPackage.Literals.MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES);
			childrenFeatures.add(EventsPackage.Literals.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MergeChoiceEvent.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MergeChoiceEvent"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MergeChoiceEvent)object).getCreatedIssueName();
		return label == null || label.length() == 0 ?
			getString("_UI_MergeChoiceEvent_type") :
			getString("_UI_MergeChoiceEvent_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MergeChoiceEvent.class)) {
			case EventsPackage.MERGE_CHOICE_EVENT__SELECTION:
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_FEATURE:
			case EventsPackage.MERGE_CHOICE_EVENT__CREATED_ISSUE_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EventsPackage.MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES:
			case EventsPackage.MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES:
			case EventsPackage.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES,
				 OperationsFactory.eINSTANCE.createOperationId()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES,
				 OperationsFactory.eINSTANCE.createOperationId()));

		newChildDescriptors.add
			(createChildParameter
				(EventsPackage.Literals.MERGE_CHOICE_EVENT__CONTEXT_MODEL_ELEMENT,
				 ModelFactory.eINSTANCE.createModelElementId()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == EventsPackage.Literals.MERGE_CHOICE_EVENT__MY_ACCEPTED_CHANGES ||
			childFeature == EventsPackage.Literals.MERGE_CHOICE_EVENT__THEIR_REJECTED_CHANGES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}