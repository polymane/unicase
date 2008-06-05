/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;

import org.unicase.model.organization.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.task.ActionItem#getAssignedTo <em>Assigned To</em>}</li>
 *   <li>{@link org.unicase.model.task.ActionItem#getDueDate <em>Due Date</em>}</li>
 *   <li>{@link org.unicase.model.task.ActionItem#isDone <em>Done</em>}</li>
 *   <li>{@link org.unicase.model.task.ActionItem#getEstimate <em>Estimate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.task.TaskPackage#getActionItem()
 * @model
 * @generated
 */
public interface ActionItem extends WorkItem {
	/**
	 * Returns the value of the '<em><b>Assigned To</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.organization.User}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned To</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned To</em>' reference list.
	 * @see org.unicase.model.task.TaskPackage#getActionItem_AssignedTo()
	 * @model required="true"
	 * @generated
	 */
	EList<User> getAssignedTo();

	/**
	 * Returns the value of the '<em><b>Due Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Due Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Due Date</em>' attribute.
	 * @see #setDueDate(Date)
	 * @see org.unicase.model.task.TaskPackage#getActionItem_DueDate()
	 * @model
	 * @generated
	 */
	Date getDueDate();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.ActionItem#getDueDate <em>Due Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Due Date</em>' attribute.
	 * @see #getDueDate()
	 * @generated
	 */
	void setDueDate(Date value);

	/**
	 * Returns the value of the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Done</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Done</em>' attribute.
	 * @see #setDone(boolean)
	 * @see org.unicase.model.task.TaskPackage#getActionItem_Done()
	 * @model
	 * @generated
	 */
	boolean isDone();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.ActionItem#isDone <em>Done</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Done</em>' attribute.
	 * @see #isDone()
	 * @generated
	 */
	void setDone(boolean value);

	/**
	 * Returns the value of the '<em><b>Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Estimate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Estimate</em>' attribute.
	 * @see #setEstimate(int)
	 * @see org.unicase.model.task.TaskPackage#getActionItem_Estimate()
	 * @model
	 * @generated
	 */
	int getEstimate();

	/**
	 * Sets the value of the '{@link org.unicase.model.task.ActionItem#getEstimate <em>Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Estimate</em>' attribute.
	 * @see #getEstimate()
	 * @generated
	 */
	void setEstimate(int value);

} // ActionItem
