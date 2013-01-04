/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.diagram.MEDiagram;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Panel</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.wireframe.Panel#getStoryboard <em>Storyboard</em>}</li>
 *   <li>{@link org.unicase.wireframe.Panel#getX <em>X</em>}</li>
 *   <li>{@link org.unicase.wireframe.Panel#getY <em>Y</em>}</li>
 *   <li>{@link org.unicase.wireframe.Panel#getWidgets <em>Widgets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.wireframe.WireframePackage#getPanel()
 * @model
 * @generated
 */
public interface Panel extends MEDiagram {
	/**
	 * Returns the value of the '<em><b>Storyboard</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.wireframe.Storyboard#getPanels <em>Panels</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storyboard</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storyboard</em>' container reference.
	 * @see #setStoryboard(Storyboard)
	 * @see org.unicase.wireframe.WireframePackage#getPanel_Storyboard()
	 * @see org.unicase.wireframe.Storyboard#getPanels
	 * @model opposite="panels" transient="false"
	 * @generated
	 */
	Storyboard getStoryboard();

	/**
	 * Sets the value of the '{@link org.unicase.wireframe.Panel#getStoryboard <em>Storyboard</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storyboard</em>' container reference.
	 * @see #getStoryboard()
	 * @generated
	 */
	void setStoryboard(Storyboard value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see org.unicase.wireframe.WireframePackage#getPanel_X()
	 * @model
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.unicase.wireframe.Panel#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see org.unicase.wireframe.WireframePackage#getPanel_Y()
	 * @model
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.unicase.wireframe.Panel#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Widgets</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.wireframe.Widget}.
	 * It is bidirectional and its opposite is '{@link org.unicase.wireframe.Widget#getPanel <em>Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widgets</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widgets</em>' containment reference list.
	 * @see org.unicase.wireframe.WireframePackage#getPanel_Widgets()
	 * @see org.unicase.wireframe.Widget#getPanel
	 * @model opposite="panel" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Widget> getWidgets();

} // Panel
