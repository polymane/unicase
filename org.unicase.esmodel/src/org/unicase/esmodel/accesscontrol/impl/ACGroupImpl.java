/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.accesscontrol.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.unicase.esmodel.accesscontrol.ACGroup;
import org.unicase.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.esmodel.accesscontrol.AccesscontrolPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AC Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.esmodel.accesscontrol.impl.ACGroupImpl#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ACGroupImpl extends ACOrgUnitImpl implements ACGroup {
	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<ACOrgUnit> members;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ACGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccesscontrolPackage.Literals.AC_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ACOrgUnit> getMembers() {
		if (members == null) {
			members = new EObjectResolvingEList<ACOrgUnit>(ACOrgUnit.class, this, AccesscontrolPackage.AC_GROUP__MEMBERS);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AccesscontrolPackage.AC_GROUP__MEMBERS:
				return getMembers();
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
			case AccesscontrolPackage.AC_GROUP__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends ACOrgUnit>)newValue);
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
			case AccesscontrolPackage.AC_GROUP__MEMBERS:
				getMembers().clear();
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
			case AccesscontrolPackage.AC_GROUP__MEMBERS:
				return members != null && !members.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ACGroupImpl
