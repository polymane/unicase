/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.Project;


/**
 * Implementation of a RMIEmfStoreFacade.
 * 
 * @author koegel
 * @author Wesendonk
 */
public class RMIEmfStoreFacadeImpl extends AbstractUnicaseRMIFacade implements RMIEmfStoreFacade {

	private static final long serialVersionUID = -3245554287505036114L;

	private EmfStore emfStore;

	private AuthenticationControl accessControl;

	private static final Log LOGGER = LogFactory.getLog(RMIEmfStoreFacade.class);

	private static final String SERIALEX = "An exception occured while serializing the objects.";

	/**
	 * Default constructor.
	 * 
	 * @param emfStore the emf store
	 * @param authenticationControl the authentication controler
	 * @throws RemoteException if an RMI problem occurs
	 * @throws FatalEmfStoreException exception within the server
	 */
	public RMIEmfStoreFacadeImpl(EmfStore emfStore, AuthenticationControl authenticationControl)
		throws RemoteException, FatalEmfStoreException {
		super();
		this.emfStore = emfStore;
		this.accessControl = authenticationControl;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#createVersion(java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	public String createVersion(String sessionId, String projectId, String baseVersionSpec, String changePackage,
		String logMessage) throws RemoteException, EmfStoreException {
		LOGGER.debug("Client call on createRevision RECEIVED.");

		SessionId sessionIdObject = (SessionId) SerializationUtil.stringToEObject(sessionId);
		ProjectId projectIdObject = (ProjectId) SerializationUtil.stringToEObject(projectId);
		PrimaryVersionSpec primaryVersionSpec = (PrimaryVersionSpec) SerializationUtil.stringToEObject(baseVersionSpec);
		ChangePackage changePackageObject = (ChangePackage) SerializationUtil.stringToEObject(changePackage);

		return SerializationUtil.eObjectToString(emfStore.createVersion(sessionIdObject, projectIdObject,
			primaryVersionSpec, changePackageObject, (LogMessage) SerializationUtil.stringToEObject(logMessage)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#getChanges(java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public List<String> getChanges(String sessionId, String projectId, String source, String target)
		throws RemoteException, EmfStoreException {
		LOGGER.debug("Client call on getChanges RECEIVED.");
		List<String> result = new ArrayList<String>();
		for (ChangePackage cp : emfStore.getChanges((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId), (VersionSpec) SerializationUtil
				.stringToEObject(source), (VersionSpec) SerializationUtil.stringToEObject(target))) {

			result.add(SerializationUtil.eObjectToString(cp));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getHistoryInfo(String sessionId, String projectId, String query) throws RemoteException,
		EmfStoreException {
		LOGGER.debug("Client call on getHistoryInfo with query RECEIVED.");
		List<String> result = new ArrayList<String>();
		for (HistoryInfo info : emfStore.getHistoryInfo((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId), (HistoryQuery) SerializationUtil
				.stringToEObject(query))) {
			result.add(SerializationUtil.eObjectToString(info));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(String sessionId, String projectId, String versionSpec, String tag) throws RemoteException,
		EmfStoreException {
		LOGGER.debug("Client call on addTag with query RECEIVED.");
		emfStore.addTag((SessionId) SerializationUtil.stringToEObject(sessionId), (ProjectId) SerializationUtil
			.stringToEObject(projectId), (PrimaryVersionSpec) SerializationUtil.stringToEObject(versionSpec),
			(TagVersionSpec) SerializationUtil.stringToEObject(tag));
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(String sessionId, String projectId, String versionSpec, String tag) throws RemoteException,
		EmfStoreException {
		LOGGER.debug("Client call on removeTag with query RECEIVED.");
		emfStore.removeTag((SessionId) SerializationUtil.stringToEObject(sessionId), (ProjectId) SerializationUtil
			.stringToEObject(projectId), (PrimaryVersionSpec) SerializationUtil.stringToEObject(versionSpec),
			(TagVersionSpec) SerializationUtil.stringToEObject(tag));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#getProject(java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	public String getProject(String sessionId, String projectId, String versionSpec) throws RemoteException,
		EmfStoreException {
		LOGGER.debug("Client call on getProject RECEIVED.");
		return SerializationUtil.eObjectToString(emfStore.getProject((SessionId) SerializationUtil
			.stringToEObject(sessionId), (ProjectId) SerializationUtil.stringToEObject(projectId),
			(VersionSpec) SerializationUtil.stringToEObject(versionSpec)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#getProjectList(java.lang.String)
	 */
	public List<String> getProjectList(String sessionId) throws RemoteException, EmfStoreException {
		LOGGER.debug("Client call on getProjectList RECEIVED.");
		List<String> result = new ArrayList<String>();
		for (ProjectInfo pi : emfStore.getProjectList((SessionId) SerializationUtil.stringToEObject(sessionId))) {
			result.add(SerializationUtil.eObjectToString(pi));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#login(java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	public String login(String username, String password, String serverInfo, String version) throws RemoteException,
		AccessControlException {
		LOGGER.debug("Client call on login RECEIVED.");
		try {
			return SerializationUtil.eObjectToString(accessControl.logIn(username, password,
				(ClientVersionInfo) SerializationUtil.stringToEObject(version)));
		} catch (RMISerializationException e) {
			throw new AccessControlException(SERIALEX);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#resolveVersionSpec(java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	public String resolveVersionSpec(String sessionId, String projectId, String versionSpec) throws RemoteException,
		EmfStoreException {
		LOGGER.debug("Client call on resolveVersionSpec RECEIVED.");
		return SerializationUtil.eObjectToString(emfStore.resolveVersionSpec((SessionId) SerializationUtil
			.stringToEObject(sessionId), (ProjectId) SerializationUtil.stringToEObject(projectId),
			(VersionSpec) SerializationUtil.stringToEObject(versionSpec)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.rmi.RMIEmfStoreFacade#createProject(java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public String createProject(String sessionId, String name, String description, String logMessage)
		throws RemoteException, EmfStoreException {
		LOGGER.debug("Client call on createProject RECEIVED.");
		return SerializationUtil
			.eObjectToString(emfStore.createProject((SessionId) SerializationUtil.stringToEObject(sessionId), name,
				description, (LogMessage) SerializationUtil.stringToEObject(logMessage)));
	}

	/**
	 * {@inheritDoc}
	 */
	public String createProject(String sessionId, String name, String description, String logMessage, String project)
		throws EmfStoreException, RemoteException {
		LOGGER.debug("Client call on createProject RECEIVED.");
		return SerializationUtil.eObjectToString(emfStore.createProject((SessionId) SerializationUtil
			.stringToEObject(sessionId), name, description, (LogMessage) SerializationUtil.stringToEObject(logMessage),
			(Project) SerializationUtil.stringToEObject(project)));
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteProject(String sessionId, String projectId, boolean deleteFiles) throws EmfStoreException,
		RemoteException {
		LOGGER.debug("Client call on deleteProject RECEIVED.");
		emfStore.deleteProject((SessionId) SerializationUtil.stringToEObject(sessionId), (ProjectId) SerializationUtil
			.stringToEObject(projectId), deleteFiles);
	}

	/**
	 * {@inheritDoc}
	 */
	public String resolveUser(String sessionId, String orgUnitId) throws EmfStoreException, RemoteException {
		LOGGER.debug("Client call on resolveUser RECEIVED.");
		return SerializationUtil.eObjectToString(emfStore.resolveUser((SessionId) SerializationUtil
			.stringToEObject(sessionId), (ACOrgUnitId) SerializationUtil.stringToEObject(orgUnitId)));
	}

	/**
	 * {@inheritDoc}
	 */
	public FileInformation uploadFileChunk(String sessionId, String projectId, FileChunk fileChunk)
		throws EmfStoreException, RemoteException {
		LOGGER.debug("Client call on uploadFileChunk RECEIVED.");
		return emfStore.uploadFileChunk((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId), fileChunk);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileChunk downloadFileChunk(String sessionId, String projectId, FileInformation fileInformation)
		throws EmfStoreException, RemoteException {
		LOGGER.debug("Client call on downloadFileChunk RECEIVED.");
		return emfStore.downloadFileChunk((SessionId) SerializationUtil.stringToEObject(sessionId),
			(ProjectId) SerializationUtil.stringToEObject(projectId), fileInformation);
	}
}