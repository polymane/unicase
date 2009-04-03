/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core;

import java.util.List;

import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.core.subinterfaces.HistorySubInterfaceImpl;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.model.Project;

/**
 * todo.
 */
public class EmfStoreImpl extends AbstractEmfstoreInterface implements EmfStore {

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace the serverspace
	 * @param authorizationControl the accesscontrol
	 * @throws FatalEmfStoreException is
	 */
	public EmfStoreImpl(ServerSpace serverSpace, AuthorizationControl authorizationControl)
		throws FatalEmfStoreException {
		super(serverSpace, authorizationControl);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<HistoryInfo> getHistoryInfo(SessionId sessionId, ProjectId projectId, HistoryQuery historyQuery)
		throws EmfStoreException {
		sanityCheckObjects(new Object[] { sessionId, projectId, historyQuery });
		checkReadAccess(sessionId, projectId, null);
		return getSubInterface(HistorySubInterfaceImpl.class).getHistoryInfo(projectId, historyQuery);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(SessionId sessionId, ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		sanityCheckObjects(new Object[] { sessionId, projectId, versionSpec, tag });
		checkProjectAdminAccess(sessionId, projectId);
		getSubInterface(HistorySubInterfaceImpl.class).addTag(projectId, versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(SessionId sessionId, ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		sanityCheckObjects(new Object[] { sessionId, projectId, versionSpec, tag });
		checkProjectAdminAccess(sessionId, projectId);
		getSubInterface(HistorySubInterfaceImpl.class).removeTag(projectId, versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionId, String name, String description, LogMessage logMessage)
		throws EmfStoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectInfo createProject(SessionId sessionId, String name, String description, LogMessage logMessage,
		Project project) throws EmfStoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(SessionId sessionId, ProjectId projectId,
		PrimaryVersionSpec baseVersionSpec, ChangePackage changePackage, LogMessage logMessage)
		throws EmfStoreException, InvalidVersionSpecException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChanges(SessionId sessionId, ProjectId projectId, VersionSpec source,
		VersionSpec target) throws EmfStoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
		throws EmfStoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Project getProject(SessionId sessionId, ProjectId projectId, VersionSpec versionSpec)
		throws EmfStoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ProjectInfo> getProjectList(SessionId sessionId) throws EmfStoreException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId, ACOrgUnitId id) throws EmfStoreException {
		return null;
	}

}
