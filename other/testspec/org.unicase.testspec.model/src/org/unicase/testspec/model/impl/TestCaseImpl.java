/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.unicase.model.impl.ModelElementImpl;

import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;

import org.unicase.testspec.model.EnumType;
import org.unicase.testspec.model.ModelPackage;
import org.unicase.testspec.model.TestCase;
import org.unicase.testspec.model.TestStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.testspec.model.impl.TestCaseImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestCaseImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestCaseImpl#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestCaseImpl#getInfrastructure <em>Infrastructure</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestCaseImpl#getNonFunctionalRequirement <em>Non Functional Requirement</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestCaseImpl#getFunctionalRequirement <em>Functional Requirement</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestCaseImpl#getStep <em>Step</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestCaseImpl extends ModelElementImpl implements TestCase {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EnumType TYPE_EDEFAULT = EnumType.UNIT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EnumType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrecondition() <em>Precondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected static final String PRECONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected String precondition = PRECONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPostcondition() <em>Postcondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostcondition()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTCONDITION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPostcondition() <em>Postcondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostcondition()
	 * @generated
	 * @ordered
	 */
	protected String postcondition = POSTCONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInfrastructure() <em>Infrastructure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructure()
	 * @generated
	 * @ordered
	 */
	protected static final String INFRASTRUCTURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInfrastructure() <em>Infrastructure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructure()
	 * @generated
	 * @ordered
	 */
	protected String infrastructure = INFRASTRUCTURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNonFunctionalRequirement() <em>Non Functional Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonFunctionalRequirement()
	 * @generated
	 * @ordered
	 */
	protected NonFunctionalRequirement nonFunctionalRequirement;

	/**
	 * The cached value of the '{@link #getFunctionalRequirement() <em>Functional Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalRequirement()
	 * @generated
	 * @ordered
	 */
	protected FunctionalRequirement functionalRequirement;

	/**
	 * The cached value of the '{@link #getStep() <em>Step</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected EList<TestStep> step;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TEST_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EnumType newType) {
		EnumType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_CASE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrecondition() {
		return precondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecondition(String newPrecondition) {
		String oldPrecondition = precondition;
		precondition = newPrecondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_CASE__PRECONDITION, oldPrecondition, precondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostcondition() {
		return postcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostcondition(String newPostcondition) {
		String oldPostcondition = postcondition;
		postcondition = newPostcondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_CASE__POSTCONDITION, oldPostcondition, postcondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInfrastructure() {
		return infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfrastructure(String newInfrastructure) {
		String oldInfrastructure = infrastructure;
		infrastructure = newInfrastructure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_CASE__INFRASTRUCTURE, oldInfrastructure, infrastructure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonFunctionalRequirement getNonFunctionalRequirement() {
		if (nonFunctionalRequirement != null && nonFunctionalRequirement.eIsProxy()) {
			InternalEObject oldNonFunctionalRequirement = (InternalEObject)nonFunctionalRequirement;
			nonFunctionalRequirement = (NonFunctionalRequirement)eResolveProxy(oldNonFunctionalRequirement);
			if (nonFunctionalRequirement != oldNonFunctionalRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.TEST_CASE__NON_FUNCTIONAL_REQUIREMENT, oldNonFunctionalRequirement, nonFunctionalRequirement));
			}
		}
		return nonFunctionalRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonFunctionalRequirement basicGetNonFunctionalRequirement() {
		return nonFunctionalRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonFunctionalRequirement(NonFunctionalRequirement newNonFunctionalRequirement) {
		NonFunctionalRequirement oldNonFunctionalRequirement = nonFunctionalRequirement;
		nonFunctionalRequirement = newNonFunctionalRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_CASE__NON_FUNCTIONAL_REQUIREMENT, oldNonFunctionalRequirement, nonFunctionalRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement getFunctionalRequirement() {
		if (functionalRequirement != null && functionalRequirement.eIsProxy()) {
			InternalEObject oldFunctionalRequirement = (InternalEObject)functionalRequirement;
			functionalRequirement = (FunctionalRequirement)eResolveProxy(oldFunctionalRequirement);
			if (functionalRequirement != oldFunctionalRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.TEST_CASE__FUNCTIONAL_REQUIREMENT, oldFunctionalRequirement, functionalRequirement));
			}
		}
		return functionalRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement basicGetFunctionalRequirement() {
		return functionalRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionalRequirement(FunctionalRequirement newFunctionalRequirement) {
		FunctionalRequirement oldFunctionalRequirement = functionalRequirement;
		functionalRequirement = newFunctionalRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_CASE__FUNCTIONAL_REQUIREMENT, oldFunctionalRequirement, functionalRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestStep> getStep() {
		if (step == null) {
			step = new EObjectResolvingEList<TestStep>(TestStep.class, this, ModelPackage.TEST_CASE__STEP);
		}
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.TEST_CASE__TYPE:
				return getType();
			case ModelPackage.TEST_CASE__PRECONDITION:
				return getPrecondition();
			case ModelPackage.TEST_CASE__POSTCONDITION:
				return getPostcondition();
			case ModelPackage.TEST_CASE__INFRASTRUCTURE:
				return getInfrastructure();
			case ModelPackage.TEST_CASE__NON_FUNCTIONAL_REQUIREMENT:
				if (resolve) return getNonFunctionalRequirement();
				return basicGetNonFunctionalRequirement();
			case ModelPackage.TEST_CASE__FUNCTIONAL_REQUIREMENT:
				if (resolve) return getFunctionalRequirement();
				return basicGetFunctionalRequirement();
			case ModelPackage.TEST_CASE__STEP:
				return getStep();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.TEST_CASE__TYPE:
				setType((EnumType)newValue);
				return;
			case ModelPackage.TEST_CASE__PRECONDITION:
				setPrecondition((String)newValue);
				return;
			case ModelPackage.TEST_CASE__POSTCONDITION:
				setPostcondition((String)newValue);
				return;
			case ModelPackage.TEST_CASE__INFRASTRUCTURE:
				setInfrastructure((String)newValue);
				return;
			case ModelPackage.TEST_CASE__NON_FUNCTIONAL_REQUIREMENT:
				setNonFunctionalRequirement((NonFunctionalRequirement)newValue);
				return;
			case ModelPackage.TEST_CASE__FUNCTIONAL_REQUIREMENT:
				setFunctionalRequirement((FunctionalRequirement)newValue);
				return;
			case ModelPackage.TEST_CASE__STEP:
				getStep().clear();
				getStep().addAll((Collection<? extends TestStep>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.TEST_CASE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.TEST_CASE__PRECONDITION:
				setPrecondition(PRECONDITION_EDEFAULT);
				return;
			case ModelPackage.TEST_CASE__POSTCONDITION:
				setPostcondition(POSTCONDITION_EDEFAULT);
				return;
			case ModelPackage.TEST_CASE__INFRASTRUCTURE:
				setInfrastructure(INFRASTRUCTURE_EDEFAULT);
				return;
			case ModelPackage.TEST_CASE__NON_FUNCTIONAL_REQUIREMENT:
				setNonFunctionalRequirement((NonFunctionalRequirement)null);
				return;
			case ModelPackage.TEST_CASE__FUNCTIONAL_REQUIREMENT:
				setFunctionalRequirement((FunctionalRequirement)null);
				return;
			case ModelPackage.TEST_CASE__STEP:
				getStep().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.TEST_CASE__TYPE:
				return type != TYPE_EDEFAULT;
			case ModelPackage.TEST_CASE__PRECONDITION:
				return PRECONDITION_EDEFAULT == null ? precondition != null : !PRECONDITION_EDEFAULT.equals(precondition);
			case ModelPackage.TEST_CASE__POSTCONDITION:
				return POSTCONDITION_EDEFAULT == null ? postcondition != null : !POSTCONDITION_EDEFAULT.equals(postcondition);
			case ModelPackage.TEST_CASE__INFRASTRUCTURE:
				return INFRASTRUCTURE_EDEFAULT == null ? infrastructure != null : !INFRASTRUCTURE_EDEFAULT.equals(infrastructure);
			case ModelPackage.TEST_CASE__NON_FUNCTIONAL_REQUIREMENT:
				return nonFunctionalRequirement != null;
			case ModelPackage.TEST_CASE__FUNCTIONAL_REQUIREMENT:
				return functionalRequirement != null;
			case ModelPackage.TEST_CASE__STEP:
				return step != null && !step.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(", precondition: ");
		result.append(precondition);
		result.append(", postcondition: ");
		result.append(postcondition);
		result.append(", infrastructure: ");
		result.append(infrastructure);
		result.append(')');
		return result.toString();
	}

} //TestCaseImpl
