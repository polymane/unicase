/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.state;

import org.unicase.model.ModelElement;

/*
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Transition</b></em>'. <!-- end-user-doc --> <p>
 * The following features are supported: <ul> <li>{@link org.unicase.model.state.Transition#getCondition
 * <em>Condition</em>}</li> <li>{@link org.unicase.model.state.Transition#getSource <em>Source</em>}</li> <li>{@link
 * org.unicase.model.state.Transition#getTarget <em>Target</em>}</li> </ul> </p>
 * @see org.unicase.model.state.StatePackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute. The default value is <code>""</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.unicase.model.state.StatePackage#getTransition_Condition()
	 * @model default=""
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.unicase.model.state.Transition#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.state.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(State)
	 * @see org.unicase.model.state.StatePackage#getTransition_Source()
	 * @see org.unicase.model.state.State#getOutgoingTransitions
	 * @model opposite="outgoingTransitions" keys="identifier"
	 * @generated
	 */
	State getSource();

	/**
	 * Sets the value of the '{@link org.unicase.model.state.Transition#getSource <em>Source</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(State value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.state.State#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(State)
	 * @see org.unicase.model.state.StatePackage#getTransition_Target()
	 * @see org.unicase.model.state.State#getIncomingTransitions
	 * @model opposite="incomingTransitions" keys="identifier"
	 * @generated
	 */
	State getTarget();

	/**
	 * Sets the value of the '{@link org.unicase.model.state.Transition#getTarget <em>Target</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(State value);

} // Transition
