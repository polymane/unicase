/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.papyrus.PapyrusPackage
 * @generated
 */
public interface PapyrusFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	PapyrusFactory eINSTANCE = org.unicase.papyrus.impl.PapyrusFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>UML Model</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>UML Model</em>'.
	 * @generated
	 */
	UMLModel createUMLModel();

	/**
	 * Returns a new object of class '<em>Sys ML Model</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Sys ML Model</em>'.
	 * @generated
	 */
	SysMLModel createSysMLModel();

	/**
	 * Returns a new object of class '<em>Sys ML Class</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Sys ML Class</em>'.
	 * @generated
	 */
	SysMLClass createSysMLClass();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	PapyrusPackage getPapyrusPackage();

} // PapyrusFactory
