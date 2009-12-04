/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.provider;

import java.util.Collection;
import java.util.Date;
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
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.MergeChoice;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.metamodel.MetamodelFactory;

/**
 * This is the item provider adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoice} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class MergeChoiceItemProvider extends EventItemProvider implements IEditingDomainItemProvider,
	IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MergeChoiceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSelectionPropertyDescriptor(object);
			addContextFeaturePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Selection feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSelectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_MergeChoice_selection_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_MergeChoice_selection_feature", "_UI_MergeChoice_type"),
			EventsPackage.Literals.MERGE_CHOICE__SELECTION, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Context Feature feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addContextFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_MergeChoice_contextFeature_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_MergeChoice_contextFeature_feature",
				"_UI_MergeChoice_type"), EventsPackage.Literals.MERGE_CHOICE__CONTEXT_FEATURE, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EventsPackage.Literals.MERGE_CHOICE__MY_CHANGES);
			childrenFeatures.add(EventsPackage.Literals.MERGE_CHOICE__THEIR_CHANGES);
			childrenFeatures.add(EventsPackage.Literals.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT);
			childrenFeatures.add(EventsPackage.Literals.MERGE_CHOICE__CREATED_ISSUE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MergeChoice.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MergeChoice"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Date labelValue = ((MergeChoice) object).getTimestamp();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ? getString("_UI_MergeChoice_type")
			: getString("_UI_MergeChoice_type") + " " + label;
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

		switch (notification.getFeatureID(MergeChoice.class)) {
		case EventsPackage.MERGE_CHOICE__SELECTION:
		case EventsPackage.MERGE_CHOICE__CONTEXT_FEATURE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case EventsPackage.MERGE_CHOICE__MY_CHANGES:
		case EventsPackage.MERGE_CHOICE__THEIR_CHANGES:
		case EventsPackage.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT:
		case EventsPackage.MERGE_CHOICE__CREATED_ISSUE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__MY_CHANGES,
			OperationsFactory.eINSTANCE.createCompositeOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__MY_CHANGES,
			OperationsFactory.eINSTANCE.createCreateDeleteOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__MY_CHANGES,
			OperationsFactory.eINSTANCE.createAttributeOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__MY_CHANGES,
			OperationsFactory.eINSTANCE.createSingleReferenceOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__MY_CHANGES,
			OperationsFactory.eINSTANCE.createMultiReferenceOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__MY_CHANGES,
			OperationsFactory.eINSTANCE.createMultiReferenceMoveOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__MY_CHANGES,
			OperationsFactory.eINSTANCE.createDiagramLayoutOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__THEIR_CHANGES,
			OperationsFactory.eINSTANCE.createCompositeOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__THEIR_CHANGES,
			OperationsFactory.eINSTANCE.createCreateDeleteOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__THEIR_CHANGES,
			OperationsFactory.eINSTANCE.createAttributeOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__THEIR_CHANGES,
			OperationsFactory.eINSTANCE.createSingleReferenceOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__THEIR_CHANGES,
			OperationsFactory.eINSTANCE.createMultiReferenceOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__THEIR_CHANGES,
			OperationsFactory.eINSTANCE.createMultiReferenceMoveOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__THEIR_CHANGES,
			OperationsFactory.eINSTANCE.createDiagramLayoutOperation()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT,
			MetamodelFactory.eINSTANCE.createModelElementId()));

		newChildDescriptors.add(createChildParameter(EventsPackage.Literals.MERGE_CHOICE__CREATED_ISSUE,
			MetamodelFactory.eINSTANCE.createModelElementId()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == EventsPackage.Literals.MERGE_CHOICE__MY_CHANGES
			|| childFeature == EventsPackage.Literals.MERGE_CHOICE__THEIR_CHANGES
			|| childFeature == EventsPackage.Literals.MERGE_CHOICE__CONTEXT_MODEL_ELEMENT
			|| childFeature == EventsPackage.Literals.MERGE_CHOICE__CREATED_ISSUE;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject),
				getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
