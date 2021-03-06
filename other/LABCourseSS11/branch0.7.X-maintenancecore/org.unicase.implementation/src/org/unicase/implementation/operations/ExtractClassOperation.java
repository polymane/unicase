/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Extract Class Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.implementation.operations.ExtractClassOperation#getContextClass <em>Context Class</em>}</li>
 * <li>{@link org.unicase.implementation.operations.ExtractClassOperation#getAttributes <em>Attributes</em>}</li>
 * <li>{@link org.unicase.implementation.operations.ExtractClassOperation#getOutgoingAssociations <em>Outgoing
 * Associations</em>}</li>
 * <li>{@link org.unicase.implementation.operations.ExtractClassOperation#getIncomingAssociations <em>Incoming
 * Associations</em>}</li>
 * <li>{@link org.unicase.implementation.operations.ExtractClassOperation#getCompositionName <em>Composition Name</em>}</li>
 * <li>{@link org.unicase.implementation.operations.ExtractClassOperation#getClassName <em>Class Name</em>}</li>
 * <li>{@link org.unicase.implementation.operations.ExtractClassOperation#getTargetPackage <em>Target Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.implementation.operations.OperationsPackage#getExtractClassOperation()
 * @model annotation="http://unicase.org/operations description='A set of attributes and associations are extracted to a new class which is reachable trough a composition.' label='Extract Class'"
 * @generated
 */
public interface ExtractClassOperation extends SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Context Class</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Class</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Context Class</em>' containment reference.
	 * @see #setContextClass(ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractClassOperation_ContextClass()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelElementId getContextClass();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.ExtractClassOperation#getContextClass
	 * <em>Context Class</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Context Class</em>' containment reference.
	 * @see #getContextClass()
	 * @generated
	 */
	void setContextClass(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.metamodel.ModelElementId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractClassOperation_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementId> getAttributes();

	/**
	 * Returns the value of the '<em><b>Outgoing Associations</b></em>' containment reference list. The list contents
	 * are of type {@link org.unicase.metamodel.ModelElementId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Associations</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Outgoing Associations</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractClassOperation_OutgoingAssociations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementId> getOutgoingAssociations();

	/**
	 * Returns the value of the '<em><b>Incoming Associations</b></em>' containment reference list. The list contents
	 * are of type {@link org.unicase.metamodel.ModelElementId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Associations</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Incoming Associations</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractClassOperation_IncomingAssociations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementId> getIncomingAssociations();

	/**
	 * Returns the value of the '<em><b>Composition Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Composition Name</em>' attribute.
	 * @see #setCompositionName(String)
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractClassOperation_CompositionName()
	 * @model required="true"
	 * @generated
	 */
	String getCompositionName();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.ExtractClassOperation#getCompositionName
	 * <em>Composition Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Composition Name</em>' attribute.
	 * @see #getCompositionName()
	 * @generated
	 */
	void setCompositionName(String value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractClassOperation_ClassName()
	 * @model required="true"
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.ExtractClassOperation#getClassName
	 * <em>Class Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Target Package</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Package</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target Package</em>' containment reference.
	 * @see #setTargetPackage(ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getExtractClassOperation_TargetPackage()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelElementId getTargetPackage();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.ExtractClassOperation#getTargetPackage
	 * <em>Target Package</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target Package</em>' containment reference.
	 * @see #getTargetPackage()
	 * @generated
	 */
	void setTargetPackage(ModelElementId value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model required="true" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getContextClass());'"
	 * @generated
	 */
	org.unicase.model.classes.Class getContextClass(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getAttributes());'"
	 * @generated
	 */
	EList<Attribute> getAttributes(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	EList<Attribute> getPossibleAttributes(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getOutgoingAssociations());'"
	 * @generated
	 */
	EList<Association> getOutgoingAssociations(Project project);

	/**
	 * <!-- begin-user-doc --> 
	 * Get all possible outgoing associations suitable for extraction.
	 * @param project the project to apply the operation on
	 * @return the list of associations
	 * <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	EList<Association> getPossibleOutgoingAssociations(Project project);

	/**
	 * <!-- begin-user-doc --> 
	 * Get all incoming associations that are to be extracted.
	 * <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getIncomingAssociations());'"
	 * @generated
	 */
	EList<Association> getIncomingAssociations(Project project);

	/**
	 * <!-- begin-user-doc --> 
	 * Get all possible incoming associations for extraction.
	 * <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	EList<Association> getPossibleIncomingAssociations(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model required="true" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getTargetPackage());'"
	 * @generated
	 */
	org.unicase.model.classes.Package getTargetPackage(Project project);

	/**
	 * <!-- begin-user-doc --> 
	 * Validate the new class name to avoid name collisions.
	 * <!-- end-user-doc -->
	 * 
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='A class or enumeration with that name already exists.'"
	 * @generated
	 */
	boolean validateClassName(Project project);

	/**
	 * <!-- begin-user-doc --> 
	 * Validate name of the composition to check for name collisions.
	 * <!-- end-user-doc -->
	 * 
	 * @model required="true" annotation=
	 *        "http://unicase.org/operations description='An attribute or association with that name already exists.'"
	 * @generated
	 */
	boolean validateCompositionName(Project project);

} // ExtractClassOperation
