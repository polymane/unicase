/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.implementation.operations;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Push Down Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.PushDownOperation#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.PushDownOperation#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.PushDownOperation#getOutgoingAssociations <em>Outgoing Associations</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.PushDownOperation#getIncomingAssociations <em>Incoming Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.implementation.operations.OperationsPackage#getPushDownOperation()
 * @model annotation="http://unicase.org/operations description='Attributes and associations are pushed down to sub classes.' label='Push Down Attributes and Associations'"
 * @generated
 */
public interface PushDownOperation extends SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' containment reference.
	 * @see #setSuperClass(ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getPushDownOperation_SuperClass()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelElementId getSuperClass();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.PushDownOperation#getSuperClass <em>Super Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' containment reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.metamodel.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getPushDownOperation_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementId> getAttributes();

	/**
	 * Returns the value of the '<em><b>Outgoing Associations</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.metamodel.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Associations</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getPushDownOperation_OutgoingAssociations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementId> getOutgoingAssociations();

	/**
	 * Returns the value of the '<em><b>Incoming Associations</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.metamodel.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Associations</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getPushDownOperation_IncomingAssociations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementId> getIncomingAssociations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getAttributes());'"
	 * @generated
	 */
	EList<Attribute> getAttributes(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Attribute> getPossibleAttributes(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getOutgoingAssociations());'"
	 * @generated
	 */
	EList<Association> getOutgoingAssociations(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Association> getPossibleOutgoingAssociations(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getIncomingAssociations());'"
	 * @generated
	 */
	EList<Association> getIncomingAssociations(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Association> getPossibleIncomingAssociations(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getSuperClass());'"
	 * @generated
	 */
	org.unicase.model.classes.Class getSuperClass(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='The attribute\'s defining class must have sub classes.'"
	 * @generated
	 */
	boolean validateSuperClassSubClasses(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='At least one attribute or association must be pushed down.'"
	 * @generated
	 */
	boolean validateAttributesAssociations(Project project);

} // PushDownOperation
