/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.esmodel.SessionId;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.ProjectId;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.workspace.Workspace#getProjectSpaces <em>Project Spaces</em>}</li>
 *   <li>{@link org.unicase.workspace.Workspace#getServerInfos <em>Server Infos</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.workspace.WorkspacePackage#getWorkspace()
 * @model
 * @generated
 */
public interface Workspace extends EObject {
	/**
	 * Returns the value of the '<em><b>Project Spaces</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.workspace.ProjectSpace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Spaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Spaces</em>' reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspace_ProjectSpaces()
	 * @model
	 * @generated
	 */
	EList<ProjectSpace> getProjectSpaces();

	/**
	 * Returns the value of the '<em><b>Server Infos</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.workspace.ServerInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Infos</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Infos</em>' reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspace_ServerInfos()
	 * @model
	 * @generated
	 */
	EList<ServerInfo> getServerInfos();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ConnectionException 
	 * @model
	 * @generated NOT
	 */
	ProjectSpace checkout(Usersession usersession, ProjectId projectId, VersionSpec version) throws ConnectionException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void save();
	
	/**
	 * @param connectionManager
	 *
	 * @generated NOT
	 */
	public void setConnectionManager(ConnectionManager connectionManager);

	/**
	 * @param resource
	 *
	 * @generated NOT
	 */
	public void setResource(Resource resource);
	
} // Workspace
