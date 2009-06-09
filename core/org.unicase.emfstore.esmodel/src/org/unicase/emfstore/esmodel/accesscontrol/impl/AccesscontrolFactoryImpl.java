/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.accesscontrol.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperties;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class AccesscontrolFactoryImpl extends EFactoryImpl implements AccesscontrolFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static AccesscontrolFactory init() {
		try {
			AccesscontrolFactory theAccesscontrolFactory = (AccesscontrolFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/esmodel/accesscontrol");
			if (theAccesscontrolFactory != null) {
				return theAccesscontrolFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AccesscontrolFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AccesscontrolFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case AccesscontrolPackage.AC_USER:
			return createACUser();
		case AccesscontrolPackage.AC_ORG_UNIT:
			return createACOrgUnit();
		case AccesscontrolPackage.AC_GROUP:
			return createACGroup();
		case AccesscontrolPackage.AC_ORG_UNIT_ID:
			return createACOrgUnitId();
		case AccesscontrolPackage.ORG_UNIT_PROPERTIES:
			return createOrgUnitProperties();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ACUser createACUser() {
		ACUserImpl acUser = new ACUserImpl();
		return acUser;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ACOrgUnit createACOrgUnit() {
		ACOrgUnitImpl acOrgUnit = new ACOrgUnitImpl();
		return acOrgUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ACGroup createACGroup() {
		ACGroupImpl acGroup = new ACGroupImpl();
		return acGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ACOrgUnitId createACOrgUnitId() {
		ACOrgUnitIdImpl acOrgUnitId = new ACOrgUnitIdImpl();
		return acOrgUnitId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OrgUnitProperties createOrgUnitProperties() {
		OrgUnitPropertiesImpl orgUnitProperties = new OrgUnitPropertiesImpl();
		return orgUnitProperties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AccesscontrolPackage getAccesscontrolPackage() {
		return (AccesscontrolPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AccesscontrolPackage getPackage() {
		return AccesscontrolPackage.eINSTANCE;
	}

} // AccesscontrolFactoryImpl
