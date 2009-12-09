/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.unicase.emfstore.esmodel.provider.EsmodelEditPlugin;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.provider.IdentifiableElementItemProvider;

/**
 * This is the item provider adapter for a {@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class AbstractOperationItemProvider extends IdentifiableElementItemProvider implements
	IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
	IItemPropertySource {
	/**
	 * Constant for name and class tag separator.
	 */
	public static final String NAME_CLASS_TAG_SEPARATOR = "&";
	/**
	 * Constant for name tag separator.
	 */
	public static final String NAME_TAG__SEPARATOR = "%";

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractOperationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getChildren(java.lang.Object)
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		if (object instanceof AbstractOperation) {
			AbstractOperation operation = (AbstractOperation) object;
			ArrayList<ModelElementId> result = new ArrayList<ModelElementId>();
			ModelElementId modelElementId = operation.getModelElementId();
			if (modelElementId != null) {
				result.add(modelElementId);
			}
			result.addAll(operation.getOtherInvolvedModelElements());
			return result;
		}
		return super.getChildren(object);
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

			addNamePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addModelElementIdPropertyDescriptor(object);
			addAcceptedPropertyDescriptor(object);
			addClientDatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractOperation_name_feature"), getString(
			"_UI_PropertyDescriptor_description", "_UI_AbstractOperation_name_feature", "_UI_AbstractOperation_type"),
			OperationsPackage.Literals.ABSTRACT_OPERATION__NAME, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Description feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractOperation_description_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_AbstractOperation_description_feature",
				"_UI_AbstractOperation_type"), OperationsPackage.Literals.ABSTRACT_OPERATION__DESCRIPTION, true, false,
			false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Model Element Id feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addModelElementIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractOperation_modelElementId_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_AbstractOperation_modelElementId_feature",
				"_UI_AbstractOperation_type"), OperationsPackage.Literals.ABSTRACT_OPERATION__MODEL_ELEMENT_ID, true,
			false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Accepted feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAcceptedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractOperation_accepted_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_AbstractOperation_accepted_feature",
				"_UI_AbstractOperation_type"), OperationsPackage.Literals.ABSTRACT_OPERATION__ACCEPTED, true, false,
			false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Client Date feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addClientDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory)
			.getRootAdapterFactory(), getResourceLocator(), getString("_UI_AbstractOperation_clientDate_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_AbstractOperation_clientDate_feature",
				"_UI_AbstractOperation_type"), OperationsPackage.Literals.ABSTRACT_OPERATION__CLIENT_DATE, true, false,
			false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns AbstractOperation.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AbstractOperation"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AbstractOperation) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_AbstractOperation_type")
			: getString("_UI_AbstractOperation_type") + " " + label;
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

		switch (notification.getFeatureID(AbstractOperation.class)) {
		case OperationsPackage.ABSTRACT_OPERATION__NAME:
		case OperationsPackage.ABSTRACT_OPERATION__DESCRIPTION:
		case OperationsPackage.ABSTRACT_OPERATION__ACCEPTED:
		case OperationsPackage.ABSTRACT_OPERATION__CLIENT_DATE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EsmodelEditPlugin.INSTANCE;
	}

	public String getModelElementName(ModelElementId modelElementId) {
		return NAME_TAG__SEPARATOR + modelElementId.getId() + NAME_TAG__SEPARATOR;
	}

	public String getModelElementNames(List<ModelElementId> modelElementIds) {
		StringBuilder builder = new StringBuilder();
		for (ModelElementId modelElementId : modelElementIds) {
			builder.append(NAME_TAG__SEPARATOR);
			builder.append(modelElementId.getId());
			builder.append(NAME_TAG__SEPARATOR);
			builder.append(", ");
		}
		builder.replace(builder.lastIndexOf(NAME_TAG__SEPARATOR + ", "), builder.length(), "NAME_TAG__SEPARATOR.");
		builder.replace(builder.lastIndexOf(NAME_TAG__SEPARATOR + ", "), builder
			.lastIndexOf(NAME_TAG__SEPARATOR + ", ") + 3, NAME_TAG__SEPARATOR + " and ");
		return builder.toString();
	}

	public String getModelElementClassAndName(ModelElementId modelElementId) {
		return NAME_CLASS_TAG_SEPARATOR + modelElementId.getId() + NAME_CLASS_TAG_SEPARATOR;
	}

	private static final int MAX_NAME_SIZE = 30;

	public String trim(Object object) {
		return trim(object, false);
	}

	public String trim(Object object, boolean isName) {
		if (object == null) {
			return isName ? "(no name)" : "(null)";
		}
		String string = object.toString();
		String result = string.trim();
		if (result.length() > MAX_NAME_SIZE) {
			return result.substring(0, MAX_NAME_SIZE) + "...";
		}
		if (result.length() == 0) {
			return "(empty)";
		}
		return result;
	}

}
