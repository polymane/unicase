/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Radio Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.RadioGroup#getSelectedIndex <em>Selected Index</em>}</li>
 *   <li>{@link org.unicase.uiModeling.RadioGroup#getButtons <em>Buttons</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.uiModeling.UiModelingPackage#getRadioGroup()
 * @model
 * @generated
 */
public interface RadioGroup extends Widget {
	/**
	 * Returns the value of the '<em><b>Selected Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected Index</em>' attribute.
	 * @see #setSelectedIndex(int)
	 * @see org.unicase.uiModeling.UiModelingPackage#getRadioGroup_SelectedIndex()
	 * @model default="-1"
	 * @generated
	 */
	int getSelectedIndex();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.RadioGroup#getSelectedIndex <em>Selected Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected Index</em>' attribute.
	 * @see #getSelectedIndex()
	 * @generated
	 */
	void setSelectedIndex(int value);

	/**
	 * Returns the value of the '<em><b>Buttons</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.uiModeling.RadioButton}.
	 * It is bidirectional and its opposite is '{@link org.unicase.uiModeling.RadioButton#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buttons</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buttons</em>' containment reference list.
	 * @see org.unicase.uiModeling.UiModelingPackage#getRadioGroup_Buttons()
	 * @see org.unicase.uiModeling.RadioButton#getGroup
	 * @model opposite="group" containment="true"
	 * @generated
	 */
	EList<RadioButton> getButtons();

} // RadioGroup
