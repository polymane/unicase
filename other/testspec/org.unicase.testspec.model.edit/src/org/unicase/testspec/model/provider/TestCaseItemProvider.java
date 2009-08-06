/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model.provider;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelElementItemProvider;

import org.unicase.testspec.model.ModelPackage;
import org.unicase.testspec.model.TestCase;
import org.unicase.testspec.model.TestStep;
import org.unicase.testspec.model.impl.TestCaseImpl;
import org.unicase.testspec.model.impl.TestProtocolImpl;
import org.unicase.testspec.model.impl.TestStepImpl;

/**
 * This is the item provider adapter for a {@link org.unicase.testspec.model.TestCase} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TestCaseItemProvider
	extends ModelElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCaseItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
			addPreconditionPropertyDescriptor(object);
			addPostconditionPropertyDescriptor(object);
			addInfrastructurePropertyDescriptor(object);
			addNonFunctionalRequirementPropertyDescriptor(object);
			addFunctionalRequirementPropertyDescriptor(object);
			addStepPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TestCase_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TestCase_type_feature", "_UI_TestCase_type"),
				 ModelPackage.Literals.TEST_CASE__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Precondition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPreconditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TestCase_precondition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TestCase_precondition_feature", "_UI_TestCase_type"),
				 ModelPackage.Literals.TEST_CASE__PRECONDITION,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Postcondition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPostconditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TestCase_postcondition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TestCase_postcondition_feature", "_UI_TestCase_type"),
				 ModelPackage.Literals.TEST_CASE__POSTCONDITION,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Infrastructure feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addInfrastructurePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TestCase_infrastructure_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TestCase_infrastructure_feature", "_UI_TestCase_type"),
				 ModelPackage.Literals.TEST_CASE__INFRASTRUCTURE,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Non Functional Requirement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNonFunctionalRequirementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TestCase_nonFunctionalRequirement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TestCase_nonFunctionalRequirement_feature", "_UI_TestCase_type"),
				 ModelPackage.Literals.TEST_CASE__NON_FUNCTIONAL_REQUIREMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Functional Requirement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFunctionalRequirementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TestCase_functionalRequirement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TestCase_functionalRequirement_feature", "_UI_TestCase_type"),
				 ModelPackage.Literals.TEST_CASE__FUNCTIONAL_REQUIREMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Step feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStepPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TestCase_step_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TestCase_step_feature", "_UI_TestCase_type"),
				 ModelPackage.Literals.TEST_CASE__STEP,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns TestCase.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TestCase"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
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

		switch (notification.getFeatureID(TestCase.class)) {
			case ModelPackage.TEST_CASE__TYPE:
			case ModelPackage.TEST_CASE__PRECONDITION:
			case ModelPackage.TEST_CASE__POSTCONDITION:
			case ModelPackage.TEST_CASE__INFRASTRUCTURE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ModelPackage.TEST_CASE__STEP:
				TestCaseImpl tcase = (TestCaseImpl)notification.getNotifier();
				Set<ModelElement> s = tcase.getContainerModelElement().getAllContainedModelElements();

				for (Iterator<ModelElement> i = s.iterator(); i.hasNext();) {
					Object object = i.next();
					if (object instanceof TestProtocolImpl) {
						TestProtocolImpl tp = (TestProtocolImpl) object;
						TestCaseImpl tc = (TestCaseImpl)tp.getTestCase();
						if(tc != null) {
							
							tp.clearParams();
							for (Iterator<TestStep> iterator = tc.getStep().iterator(); iterator.hasNext();) {
								TestStepImpl ts = (TestStepImpl) iterator.next();
								tp.addTestStepInputOutput(ts.getName(), ts.getInputParams(), ts.getOutputParams());
							}
							tp.finishedTestSteps();
						}
						else {
							tp.emptyTestSteps();
						}
					}
				}
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
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
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
		return ModelEditPlugin.INSTANCE;
	}

}
