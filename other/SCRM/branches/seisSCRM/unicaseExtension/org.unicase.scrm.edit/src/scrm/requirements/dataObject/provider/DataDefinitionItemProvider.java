/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataObject.provider;

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

import scrm.provider.SCRMModelElementItemProvider;
import scrm.provider.ScrmEditPlugin;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataObject.DataDefinition;
import scrm.requirements.dataObject.DataObjectPackage;

/**
 * This is the item provider adapter for a {@link scrm.requirements.dataObject.DataDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataDefinitionItemProvider extends SCRMModelElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataDefinitionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDefinedRequirementPropertyDescriptor(object);
			addAccuracyPropertyDescriptor(object);
			addRangePropertyDescriptor(object);
			addFormatPropertyDescriptor(object);
			addProvidedInterfacePropertyDescriptor(object);
			addRequiredInterfacePropertyDescriptor(object);
			addDescribedModelPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Defined Requirement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefinedRequirementPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_DataDefinition_definedRequirement_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_DataDefinition_definedRequirement_feature",
								"_UI_DataDefinition_type"),
						DataObjectPackage.Literals.DATA_DEFINITION__DEFINED_REQUIREMENT,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Accuracy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAccuracyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DataDefinition_accuracy_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_DataDefinition_accuracy_feature",
						"_UI_DataDefinition_type"),
				DataObjectPackage.Literals.DATA_DEFINITION__ACCURACY, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Range feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRangePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DataDefinition_range_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_DataDefinition_range_feature",
						"_UI_DataDefinition_type"),
				DataObjectPackage.Literals.DATA_DEFINITION__RANGE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DataDefinition_format_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_DataDefinition_format_feature",
						"_UI_DataDefinition_type"),
				DataObjectPackage.Literals.DATA_DEFINITION__FORMAT, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Provided Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidedInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DataDefinition_providedInterface_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_DataDefinition_providedInterface_feature",
						"_UI_DataDefinition_type"),
				DataObjectPackage.Literals.DATA_DEFINITION__PROVIDED_INTERFACE,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Required Interface feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredInterfacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DataDefinition_requiredInterface_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_DataDefinition_requiredInterface_feature",
						"_UI_DataDefinition_type"),
				DataObjectPackage.Literals.DATA_DEFINITION__REQUIRED_INTERFACE,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Described Model feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescribedModelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DataDefinition_describedModel_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_DataDefinition_describedModel_feature",
						"_UI_DataDefinition_type"),
				DataObjectPackage.Literals.DATA_DEFINITION__DESCRIBED_MODEL,
				true, false, true, null, null, null));
	}

	/**
	 * This returns DataDefinition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/DataDefinition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT: return name attribute without EClass-name
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DataDefinition.class)) {
		case DataObjectPackage.DATA_DEFINITION__ACCURACY:
		case DataObjectPackage.DATA_DEFINITION__RANGE:
		case DataObjectPackage.DATA_DEFINITION__FORMAT:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ScrmEditPlugin.INSTANCE;
	}

}
