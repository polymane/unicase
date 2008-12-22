/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.classes;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.classes.Dependency#getSource <em>Source</em>}</li>
 * <li>{@link org.unicase.model.classes.Dependency#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.classes.ClassesPackage#getDependency()
 * @model
 * @generated
 */
public interface Dependency extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.PackageElement#getOutgoingDependencies <em>Outgoing Dependencies</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(PackageElement)
	 * @see org.unicase.model.classes.ClassesPackage#getDependency_Source()
	 * @see org.unicase.model.classes.PackageElement#getOutgoingDependencies
	 * @model opposite="outgoingDependencies" annotation="org.unicase.ui.meeditor priority='10.0' position='left'"
	 * @generated
	 */
	PackageElement getSource();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Dependency#getSource <em>Source</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(PackageElement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.classes.PackageElement#getIncomingDependencies <em>Incoming Dependencies</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(PackageElement)
	 * @see org.unicase.model.classes.ClassesPackage#getDependency_Target()
	 * @see org.unicase.model.classes.PackageElement#getIncomingDependencies
	 * @model opposite="incomingDependencies" annotation="org.unicase.ui.meeditor priority='11.0' position='left'"
	 * @generated
	 */
	PackageElement getTarget();

	/**
	 * Sets the value of the '{@link org.unicase.model.classes.Dependency#getTarget <em>Target</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(PackageElement value);

} // Dependency
