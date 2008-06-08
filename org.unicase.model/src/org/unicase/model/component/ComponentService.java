/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.component;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.component.ComponentService#getOfferingComponent <em>Offering Component</em>}</li>
 *   <li>{@link org.unicase.model.component.ComponentService#getConsumingComponents <em>Consuming Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.component.ComponentPackage#getComponentService()
 * @model
 * @generated
 */
public interface ComponentService extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Offering Component</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.component.Component#getOfferedServices <em>Offered Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offering Component</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offering Component</em>' container reference.
	 * @see #setOfferingComponent(Component)
	 * @see org.unicase.model.component.ComponentPackage#getComponentService_OfferingComponent()
	 * @see org.unicase.model.component.Component#getOfferedServices
	 * @model opposite="offeredServices" transient="false"
	 * @generated
	 */
	Component getOfferingComponent();

	/**
	 * Sets the value of the '{@link org.unicase.model.component.ComponentService#getOfferingComponent <em>Offering Component</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offering Component</em>' container reference.
	 * @see #getOfferingComponent()
	 * @generated
	 */
	void setOfferingComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Consuming Components</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.component.Component}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.component.Component#getConsumedServices <em>Consumed Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consuming Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consuming Components</em>' reference list.
	 * @see org.unicase.model.component.ComponentPackage#getComponentService_ConsumingComponents()
	 * @see org.unicase.model.component.Component#getConsumedServices
	 * @model opposite="consumedServices"
	 * @generated
	 */
	EList<Component> getConsumingComponents();

} // ComponentService
