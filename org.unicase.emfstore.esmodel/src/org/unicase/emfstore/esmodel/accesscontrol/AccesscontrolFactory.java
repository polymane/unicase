/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.accesscontrol;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage
 * @generated
 */
public interface AccesscontrolFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	AccesscontrolFactory eINSTANCE = org.unicase.emfstore.esmodel.accesscontrol.impl.AccesscontrolFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>AC User</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>AC User</em>'.
	 * @generated
	 */
	ACUser createACUser();

	/**
	 * Returns a new object of class '<em>AC Org Unit</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>AC Org Unit</em>'.
	 * @generated
	 */
	ACOrgUnit createACOrgUnit();

	/**
	 * Returns a new object of class '<em>AC Group</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>AC Group</em>'.
	 * @generated
	 */
	ACGroup createACGroup();

	/**
	 * Returns a new object of class '<em>AC Org Unit Id</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>AC Org Unit Id</em>'.
	 * @generated
	 */
	ACOrgUnitId createACOrgUnitId();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	AccesscontrolPackage getAccesscontrolPackage();

} // AccesscontrolFactory
