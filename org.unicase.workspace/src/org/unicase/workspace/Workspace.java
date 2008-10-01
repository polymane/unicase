/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import java.io.IOException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Workspace</b></em>'.
 * 
 * @implements IAdaptable <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.workspace.Workspace#getProjectSpaces <em>Project Spaces</em>}</li>
 *   <li>{@link org.unicase.workspace.Workspace#getServerInfos <em>Server Infos</em>}</li>
 *   <li>{@link org.unicase.workspace.Workspace#getUsersessions <em>Usersessions</em>}</li>
 *   <li>{@link org.unicase.workspace.Workspace#getActiveProjectSpace <em>Active Project Space</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.workspace.WorkspacePackage#getWorkspace()
 * @model
 * @generated
 */
public interface Workspace extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Project Spaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.workspace.ProjectSpace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Spaces</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Spaces</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspace_ProjectSpaces()
	 * @model containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<ProjectSpace> getProjectSpaces();

	/**
	 * Returns the value of the '<em><b>Server Infos</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.workspace.ServerInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Infos</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Infos</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspace_ServerInfos()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ServerInfo> getServerInfos();

	/**
	 * Returns the value of the '<em><b>Usersessions</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.workspace.Usersession}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usersessions</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usersessions</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspace_Usersessions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Usersession> getUsersessions();

	/**
	 * Returns the value of the '<em><b>Active Project Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Project Space</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Project Space</em>' reference.
	 * @see #setActiveProjectSpace(ProjectSpace)
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspace_ActiveProjectSpace()
	 * @model keys="identifier" transient="true"
	 * @generated
	 */
	ProjectSpace getActiveProjectSpace();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.Workspace#getActiveProjectSpace <em>Active Project Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Project Space</em>' reference.
	 * @see #getActiveProjectSpace()
	 * @generated
	 */
	void setActiveProjectSpace(ProjectSpace value);

	/**
	 * Checkout a project to the workspace.
	 * 
	 * @param usersession
	 *            the usersession
	 * @param projectInfo
	 *            the project info describing the project and version
	 * @throws EmfStoreException
	 *             if checkout fails
	 * @return the project space containing the project
	 * @model
	 * @generated NOT
	 */
	ProjectSpace checkout(Usersession usersession, ProjectInfo projectInfo)
			throws EmfStoreException;

	/**
	 * <!-- begin-user-doc --> Save the workspace to the resource. <!--
	 * end-user-doc -->
	 * @model
	 * @generated
	 */
	void save();

	/**
	 * Set the workspace connection manager.
	 * 
	 * @param connectionManager
	 *            the connection manager
	 * 
	 * @generated NOT
	 */
	void setConnectionManager(ConnectionManager connectionManager);

	/**
	 * Set the workspace resource set.
	 * 
	 * @param resourceSet
	 *            the resource set
	 * 
	 * @generated NOT
	 */
	void setWorkspaceResourceSet(ResourceSet resourceSet);

	/**
	 * Init the workspace and its projectspaces.
	 * 
	 * @param editingDomain
	 *            the editing domain of the workspace
	 * 
	 * @generated NOT
	 */
	void init(TransactionalEditingDomain editingDomain);

	/**
	 * Return this workspace�s transactional editing domain.
	 * 
	 * @return the editing domain
	 * 
	 * @generated NOT
	 */
	TransactionalEditingDomain getEditingDomain();

	/**
	 * Import a project from file.
	 * @param absoluteFileName the file name to import from
	 * @return a project space containing the imported project
	 * @throws IOException if file access fails
	 */
	ProjectSpace importProject(String absoluteFileName) throws IOException;

	/**
	 * Export a project to a file.
	 * @param projectSpace the project space
	 * @param absoluteFileName the file name
	 * @throws IOException if file access fails
	 */
	void exportProject(ProjectSpace projectSpace, String absoluteFileName)
			throws IOException;

} // Workspace
