/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.connection.rmi;

// BEGIN IGNORE UNNECCESSARY IMPORT
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.eclipse.emf.emfstore.server.EmfStore;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.server.filetransfer.FileTransferInformation;

// END IGNORE UNNECCESSARY IMPORT
/**
 * Facade for the RMIConnectionManager. Part of the RMI transport layer.
 * 
 * @author wesendonk
 */
public interface RMIEmfStoreFacade extends Remote {

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.EmfStore#getProjectList(org.eclipse.emf.emfstore.server.model.SessionId)
	 * @param sessionId session id
	 * @return list of projects
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	List<String> getProjectList(String sessionId) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.EmfStore#getProject(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.versioning.VersionSpec).
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param versionSpec the version spec
	 * @return the project
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	String getProject(String sessionId, String projectId, String versionSpec) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.EmfStore#createVersion(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec,
	 *      org.eclipse.emf.emfstore.server.model.versioning.ChangePackage,
	 *      org.eclipse.emf.emfstore.server.model.versioning.LogMessage)
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param baseVersionSpec the base version
	 * @param changePackage the change package
	 * @param logMessage the log message
	 * @return the new primary version spec
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	String createVersion(String sessionId, String projectId, String baseVersionSpec, String changePackage,
		String logMessage) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.model.EmfStore#resolveVersionSpec(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.versioning.VersionSpec))
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param versionSpec the version spec
	 * @return the primary spec
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	String resolveVersionSpec(String sessionId, String projectId, String versionSpec) throws RemoteException,
		EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.EmfStore#getChanges(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.versioning.VersionSpec,
	 *      org.eclipse.emf.emfstore.server.model.versioning.VersionSpec)
	 * @param sessionId the session
	 * @param projectId the project id
	 * @param source the source version
	 * @param target the target version
	 * @return a list of change packages
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	List<String> getChanges(String sessionId, String projectId, String source, String target) throws RemoteException,
		EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.EmfStore#getHistoryInfo(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery);
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param query the history query
	 * @return a list of history infos
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	List<String> getHistoryInfo(String sessionId, String projectId, String query) throws RemoteException,
		EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.EmfStore#addTag(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec,
	 *      org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec);
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param versionSpec the version spec
	 * @param tag the tag
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	void addTag(String sessionId, String projectId, String versionSpec, String tag) throws RemoteException,
		EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.EmfStore#removeTag(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId,
	 *      org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec,
	 *      org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec)
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param versionSpec the version spec
	 * @param tag the tag
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	void removeTag(String sessionId, String projectId, String versionSpec, String tag) throws RemoteException,
		EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.EmfStore#createEmptyProject(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      String, String, org.eclipse.emf.emfstore.server.model.versioning.LogMessage)
	 * @param sessionId the session id
	 * @param name the name
	 * @param description the description
	 * @param logMessage the log message
	 * @return the project id
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	String createProject(String sessionId, String name, String description, String logMessage) throws RemoteException,
		EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @param sessionId the session id
	 * @param name the name
	 * @param description the description
	 * @param logMessage the log message
	 * @param project the initial project state
	 * @return the project id
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	String createProject(String sessionId, String name, String description, String logMessage, String project)
		throws EmfStoreException, RemoteException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @param sessionId sessionid
	 * @param projectId projectid
	 * @param deleteFiles delete files too
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	void deleteProject(String sessionId, String projectId, boolean deleteFiles) throws EmfStoreException,
		RemoteException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @param sessionId sessionid
	 * @param projectHistory projectHistory
	 * @return projectId projectId
	 * @throws EmfStoreException in case of failure
	 * @throws RemoteException if rmi fails
	 */
	String importProjectHistoryToServer(String sessionId, String projectHistory) throws EmfStoreException,
		RemoteException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @param sessionId sessionid
	 * @param projectId projectid
	 * @return projectHistory
	 * @throws EmfStoreException in case of failure
	 * @throws RemoteException if rmi fails
	 */
	String exportProjectHistoryFromServer(String sessionId, String projectId) throws EmfStoreException, RemoteException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * 
	 * @see org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl#logIn(String, String)
	 * @param username the user name
	 * @param password the password
	 * @param serverInfo the server info
	 * @param clientVersionInfo the client's version
	 * @return the session id
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws AccessControlException if access was denied
	 */
	String login(String username, String password, String serverInfo, String clientVersionInfo) throws RemoteException,
		AccessControlException;

	/**
	 * Deletes a session on the server.
	 * 
	 * @param sessionId id to be delted
	 * @throws RemoteException in case of a rmi related failure
	 * @throws AccessControlException in case of failure on server
	 */
	void logout(String sessionId) throws RemoteException, AccessControlException;

	/**
	 * Resolves the user's rights.
	 * 
	 * @param sessionId the sessionid
	 * @param orgUnitId the user's id
	 * @return an ACUser
	 * @throws EmfStoreException server related exception
	 * @throws RemoteException rmi related exception
	 */
	String resolveUser(String sessionId, String orgUnitId) throws EmfStoreException, RemoteException;

	/**
	 * @param sessionId session id
	 * @param projectId project id
	 * @param fileChunk file chunk
	 * @return FileVersion denoting the current file version to be written to
	 * @throws EmfStoreException if any error occurs in the EmfStore
	 * @throws RemoteException if any remote error occurs
	 */
	FileTransferInformation uploadFileChunk(String sessionId, String projectId, FileChunk fileChunk)
		throws EmfStoreException, RemoteException;

	/**
	 * @param sessionId session id
	 * @param projectId project id
	 * @param fileInformation file information
	 * @return FileChunk
	 * @throws EmfStoreException if any error occurs in the EmfStore
	 * @throws RemoteException if any remote error occurs
	 */
	FileChunk downloadFileChunk(String sessionId, String projectId, FileTransferInformation fileInformation)
		throws EmfStoreException, RemoteException;

	/**
	 * @param sessionId session id
	 * @param projectId project id
	 * @param changedProperty the property that has been changed
	 * @param user the ACUser
	 * @throws EmfStoreException if any error occurs in the EmfStore
	 * @throws RemoteException if any remote error occurs
	 */
	void transmitProperty(String sessionId, String changedProperty, String user, String projectId)
		throws EmfStoreException, RemoteException;
}