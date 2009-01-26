/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.accesscontrol.roles;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Role</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.accesscontrol.roles.Role#getProjects <em>Projects</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage#getRole()
 * @model abstract="true"
 * @generated
 */
public interface Role extends EObject {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.emfstore.esmodel.ProjectId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage#getRole_Projects()
	 * @model containment="true" resolveProxies="true" keys="id"
	 * @generated
	 */
	EList<ProjectId> getProjects();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	boolean canAdministrate(ProjectId projectId);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	boolean canCreate(ProjectId projectId, ModelElement modelElement);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	boolean canDelete(ProjectId projectId, ModelElement modelElement);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	boolean canModify(ProjectId projectId, ModelElement modelElement);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	boolean canRead(ProjectId projectId, ModelElement modelElement);

} // Role
