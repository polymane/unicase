/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.profile;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stereotype Instance</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.profile.StereotypeInstance#getStereotype <em>Stereotype</em>}</li>
 * <li>{@link org.unicase.model.profile.StereotypeInstance#getModelElement <em>Model Element</em>}</li>
 * <li>{@link org.unicase.model.profile.StereotypeInstance#getStereotypeAttributeInstances <em>Stereotype Attribute
 * Instances</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.profile.ProfilePackage#getStereotypeInstance()
 * @model
 * @generated
 */
public interface StereotypeInstance extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.profile.Stereotype#getStereotypeInstances <em>Stereotype Instances</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Stereotype</em>' reference.
	 * @see #setStereotype(Stereotype)
	 * @see org.unicase.model.profile.ProfilePackage#getStereotypeInstance_Stereotype()
	 * @see org.unicase.model.profile.Stereotype#getStereotypeInstances
	 * @model opposite="stereotypeInstances" keys="identifier"
	 * @generated
	 */
	Stereotype getStereotype();

	/**
	 * Sets the value of the '{@link org.unicase.model.profile.StereotypeInstance#getStereotype <em>Stereotype</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Stereotype</em>' reference.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Stereotype value);

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.ModelElement#getAppliedStereotypeInstances
	 * <em>Applied Stereotype Instances</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Element</em>' container reference.
	 * @see #setModelElement(ModelElement)
	 * @see org.unicase.model.profile.ProfilePackage#getStereotypeInstance_ModelElement()
	 * @see org.unicase.model.ModelElement#getAppliedStereotypeInstances
	 * @model opposite="appliedStereotypeInstances" keys="identifier" transient="false"
	 * @generated
	 */
	ModelElement getModelElement();

	/**
	 * Sets the value of the '{@link org.unicase.model.profile.StereotypeInstance#getModelElement
	 * <em>Model Element</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Element</em>' container reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(ModelElement value);

	/**
	 * Returns the value of the '<em><b>Stereotype Attribute Instances</b></em>' containment reference list. The list
	 * contents are of type {@link org.unicase.model.profile.StereotypeAttributeInstance}. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.profile.StereotypeAttributeInstance#getStereotypeInstance
	 * <em>Stereotype Instance</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Attribute Instances</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Stereotype Attribute Instances</em>' containment reference list.
	 * @see org.unicase.model.profile.ProfilePackage#getStereotypeInstance_StereotypeAttributeInstances()
	 * @see org.unicase.model.profile.StereotypeAttributeInstance#getStereotypeInstance
	 * @model opposite="stereotypeInstance" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<StereotypeAttributeInstance> getStereotypeAttributeInstances();

} // StereotypeInstance
