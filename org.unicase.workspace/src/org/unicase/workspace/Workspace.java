/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.esmodel.ProjectInfo;
import org.eclipse.emf.ecore.resource.Resource;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.esmodel.ProjectId;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.workspace.connectionmanager.ConnectionException;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace</b></em>'.
 * @implements IAdaptable
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
public interface Workspace extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Project Spaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.workspace.ProjectSpace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Spaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Spaces</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspace_ProjectSpaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProjectSpace> getProjectSpaces();

	/**
	 * Returns the value of the '<em><b>Server Infos</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.workspace.ServerInfo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Infos</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Infos</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getWorkspace_ServerInfos()
	 * @model containment="true"
	 * @generated
	 */
	EList<ServerInfo> getServerInfos();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ConnectionException 
	 * @throws EmfStoreException 
	 * @model
	 * @generated NOT
	 */
	ProjectSpace checkout(Usersession usersession, ProjectInfo projectInfo) throws EmfStoreException;

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
