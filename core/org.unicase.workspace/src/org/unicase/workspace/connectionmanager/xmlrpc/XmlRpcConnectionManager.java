/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.connectionmanager.xmlrpc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.unicase.emfstore.connection.xmlrpc.XmlRpcConnectionHander;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.emfstore.exceptions.UnknownSessionException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * XML RPC based Implementation of ConnectionManager.
 * 
 * @author wesendon
 */
public class XmlRpcConnectionManager implements ConnectionManager {

	private Map<SessionId, XmlRpcClientManager> clients;

	/**
	 * Default Constructor.
	 */
	public XmlRpcConnectionManager() {
		clients = new HashMap<SessionId, XmlRpcClientManager>();
	}

	private XmlRpcClientManager getClient(SessionId sessionId) throws EmfStoreException {
		XmlRpcClientManager clientManager = clients.get(sessionId);
		if (clientManager == null) {
			throw new UnknownSessionException(LOGIN_FIRST);
		}
		return clientManager;
	}

	/**
	 * {@inheritDoc}
	 */
	public SessionId logIn(String username, String password, ServerInfo serverInfo, ClientVersionInfo clientVersionInfo)
		throws EmfStoreException {
		XmlRpcClientManager clientManager = new XmlRpcClientManager(XmlRpcConnectionHander.EMFSTORE);
		clientManager.initConnection(serverInfo);
		SessionId id = clientManager.callWithResult("logIn", SessionId.class, username, password, clientVersionInfo);
		clients.put(id, clientManager);
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	public void logout(SessionId sessionId) throws EmfStoreException {
		getClient(sessionId).call("logout", sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(SessionId sessionId, ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		getClient(sessionId).call("addTag", sessionId, projectId, versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createEmptyProject(SessionId sessionId, String name, String description, LogMessage logMessage)
		throws EmfStoreException {
		return getClient(sessionId).callWithResult("createEmptyProject", ProjectInfo.class, sessionId, name,
			description, logMessage);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionId, String name, String description, LogMessage logMessage,
		Project project) throws EmfStoreException {
		return getClient(sessionId).callWithResult("createProject", ProjectInfo.class, sessionId, name, description,
			logMessage, project);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId, ProjectId projectId,
		PrimaryVersionSpec baseVersionSpec, ChangePackage changePackage, LogMessage logMessage)
		throws EmfStoreException, InvalidVersionSpecException {
		return getClient(sessionId).callWithResult("createVersion", PrimaryVersionSpec.class, sessionId, projectId,
			baseVersionSpec, changePackage, logMessage);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteProject(SessionId sessionId, ProjectId projectId, boolean deleteFiles) throws EmfStoreException {
		getClient(sessionId).call("deleteProject", sessionId, projectId, deleteFiles);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileChunk downloadFileChunk(SessionId sessionId, ProjectId projectId, FileInformation fileInformation)
		throws EmfStoreException {
		return getClient(sessionId).callWithResult("downloadFileChunk", FileChunk.class, sessionId, projectId,
			fileInformation);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectHistory exportProjectHistoryFromServer(SessionId sessionId, ProjectId projectId)
		throws EmfStoreException {
		return getClient(sessionId).callWithResult("exportProjectHistoryFromServer", ProjectHistory.class, sessionId,
			projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChanges(SessionId sessionId, ProjectId projectId, VersionSpec source,
		VersionSpec target) throws EmfStoreException {
		return getClient(sessionId).callWithListResult("getChanges", ChangePackage.class, sessionId, projectId, source,
			target);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<HistoryInfo> getHistoryInfo(SessionId sessionId, ProjectId projectId, HistoryQuery historyQuery)
		throws EmfStoreException {
		return getClient(sessionId).callWithListResult("getHistoryInfo", HistoryInfo.class, sessionId, projectId,
			historyQuery);
	}

	/**
	 * {@inheritDoc}
	 */
	public Project getProject(SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
		throws EmfStoreException {
		return getClient(sessionId).callWithResult("getProject", Project.class, sessionId, projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId) throws EmfStoreException {
		return getClient(sessionId).callWithListResult("getProjectList", ProjectInfo.class, sessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectId importProjectHistoryToServer(SessionId sessionId, ProjectHistory projectHistory)
		throws EmfStoreException {
		return getClient(sessionId).callWithResult("importProjectHistoryToServer", ProjectId.class, sessionId,
			projectHistory);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(SessionId sessionId, ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		getClient(sessionId).call("removeTag", sessionId, projectId, versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId, ACOrgUnitId id) throws EmfStoreException {
		return getClient(sessionId).callWithResult("resolveUser", ACUser.class, sessionId, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
		throws EmfStoreException {
		return getClient(sessionId).callWithResult("resolveVersionSpec", PrimaryVersionSpec.class, sessionId,
			projectId, versionSpec);
	}

	/**
	 * {@inheritDoc}
	 */
	public void transmitProperty(SessionId sessionId, OrgUnitProperty changedProperty, ACUser tmpUser,
		ProjectId projectId) throws EmfStoreException {
		getClient(sessionId).call("transmitProperty", sessionId, changedProperty, tmpUser, projectId);
	}

	/**
	 * {@inheritDoc}
	 */
	public FileInformation uploadFileChunk(SessionId sessionId, ProjectId projectId, FileChunk fileChunk)
		throws EmfStoreException {
		return getClient(sessionId).callWithResult("uploadFileChunk", FileInformation.class, sessionId, projectId,
			fileChunk);
	}
}
