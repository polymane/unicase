/**
 * Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html $Id$
 */
package org.unicase.model.emailnotificationgroup;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.model.emailnotificationgroup.EmailnotificationgroupPackage
 * @generated
 */
public interface EmailnotificationgroupFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. \nThis program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this \ndistribution, and is available at http://www.eclipse.org/legal/epl-v10.html";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmailnotificationgroupFactory eINSTANCE = org.unicase.model.emailnotificationgroup.impl.EmailnotificationgroupFactoryImpl
		.init();

	/**
	 * Returns a new object of class '<em>Notification Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Group</em>'.
	 * @generated
	 */
	NotificationGroup createNotificationGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EmailnotificationgroupPackage getEmailnotificationgroupPackage();

} //EmailnotificationgroupFactory