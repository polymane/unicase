/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.accesscontrol;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.esmodel.accesscontrol.AccesscontrolPackage
 * @generated
 */
public interface AccesscontrolFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AccesscontrolFactory eINSTANCE = org.unicase.esmodel.accesscontrol.impl.AccesscontrolFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>AC User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AC User</em>'.
	 * @generated
	 */
	ACUser createACUser();

	/**
	 * Returns a new object of class '<em>AC Org Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AC Org Unit</em>'.
	 * @generated
	 */
	ACOrgUnit createACOrgUnit();

	/**
	 * Returns a new object of class '<em>AC Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AC Group</em>'.
	 * @generated
	 */
	ACGroup createACGroup();

	/**
	 * Returns a new object of class '<em>AC Org Unit Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AC Org Unit Id</em>'.
	 * @generated
	 */
	ACOrgUnitId createACOrgUnitId();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AccesscontrolPackage getAccesscontrolPackage();

} //AccesscontrolFactory
