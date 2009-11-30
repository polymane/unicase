/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.accesscontrol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.accesscontrol.authentication.LDAPVerifier;
import org.unicase.emfstore.accesscontrol.authentication.SimplePropertyFileVerifyer;
import org.unicase.emfstore.core.MonitorProvider;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ServerAdmin;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidPropertyException;
import org.unicase.emfstore.exceptions.SessionTimedOutException;
import org.unicase.model.ModelElement;

/**
 * A simple implementation of Authentication and Authorization Control.
 * 
 * @author koegel
 * @author wesendonk
 */
public class AccessControlImpl implements AuthenticationControl, AuthorizationControl {

	private Map<SessionId, ACUserContainer> sessionUserMap;
	private ServerSpace serverSpace;
	private AuthenticationControl authenticationControl;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace the server space to work on
	 * @throws FatalEmfStoreException an exception
	 */
	public AccessControlImpl(ServerSpace serverSpace) throws FatalEmfStoreException {
		this.sessionUserMap = new HashMap<SessionId, ACUserContainer>();
		this.serverSpace = serverSpace;

		String property = ServerConfiguration.getProperties().getProperty(ServerConfiguration.AUTHENTICATION_POLICY,
			ServerConfiguration.AUTHENTICATION_POLICY_DEFAULT);
		if (property.equals(ServerConfiguration.AUTHENTICATION_LDAP)) {
			authenticationControl = new LDAPVerifier();
		} else if (property.equals(ServerConfiguration.AUTHENTICATION_SPFV)) {
			authenticationControl = new SimplePropertyFileVerifyer(ServerConfiguration.getProperties().getProperty(
				ServerConfiguration.AUTHENTICATION_SPFV_FILEPATH,
				ServerConfiguration.AUTHENTICATION_SPFV_FILEPATH_DEFAULT));
		} else {
			throw new InvalidPropertyException();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.accesscontrol.AuthenticationControl#logIn(java.lang.String, java.lang.String)
	 */
	public SessionId logIn(String username, String password, ClientVersionInfo clientVersionInfo)
		throws AccessControlException {
		ACUser user = resolveUser(username);
		SessionId sessionId = authenticationControl.logIn(user.getName(), password, clientVersionInfo);
		sessionUserMap.put(sessionId, new ACUserContainer(user));
		return sessionId;
	}

	/**
	 * Resolve a String to a user.
	 * 
	 * @param username
	 * @return the ACuser instance with the given name
	 * @throws AccessControlException if there is no such user
	 */
	private ACUser resolveUser(String username) throws AccessControlException {
		synchronized (MonitorProvider.getInstance().getMonitor()) {
			for (ACUser user : serverSpace.getUsers()) {
				if (user.getName().equals(username)) {
					return user;
				}
			}
			throw new AccessControlException();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.accesscontrol.AuthorizationControl#checkSession(org.unicase.emfstore.esmodel.SessionId)
	 */
	public void checkSession(SessionId sessionId) throws AccessControlException {
		if (!sessionUserMap.containsKey(sessionId)) {
			throw new SessionTimedOutException("Session ID unkown.");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see 
	 *      org.unicase.emfstore.accesscontrol.AuthorizationControl#checkWriteAccess(org.unicase.emfstore.esmodel.SessionId
	 *      , � � �org.unicase.emfstore.esmodel.ProjectId, java.util.Set)
	 */
	public void checkWriteAccess(SessionId sessionId, ProjectId projectId, Set<ModelElement> modelElements)
		throws AccessControlException {
		checkSession(sessionId);
		ACUser user = getUser(sessionId);
		List<Role> roles = new ArrayList<Role>();
		roles.addAll(user.getRoles());
		roles.addAll(getRolesFromGroups(user));
		// MK: remove access control simplification
		if (!canWrite(roles, projectId, null)) {
			throw new AccessControlException();
			// for (ModelElement modelElement : modelElements) {
			// if (!canWrite(roles, projectId, modelElement)) {
			// throw new AccessControlException();
			// }
		}
	}

	/**
	 * Check if the given list of roles can write to the model element in the project.
	 * 
	 * @param roles a list of roles
	 * @param projectId a project id
	 * @param modelElement a model element
	 * @return true if one of the roles can write
	 * @throws AccessControlException
	 */
	private boolean canWrite(List<Role> roles, ProjectId projectId, ModelElement modelElement)
		throws AccessControlException {
		for (Role role : roles) {
			if (role.canModify(projectId, modelElement) || role.canCreate(projectId, modelElement)
				|| role.canDelete(projectId, modelElement)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the given list of roles can read the model element in the project.
	 * 
	 * @param roles a list of roles
	 * @param projectId a project id
	 * @param modelElement a model element
	 * @return true if one of the roles can read
	 * @throws AccessControlException
	 */
	private boolean canRead(List<Role> roles, ProjectId projectId, ModelElement modelElement)
		throws AccessControlException {
		for (Role role : roles) {
			if (role.canRead(projectId, modelElement)) {
				return true;
			}
		}
		return false;
	}

	private List<Role> getRolesFromGroups(ACOrgUnit orgUnit) {
		ArrayList<Role> roles = new ArrayList<Role>();
		for (ACGroup group : getGroups(orgUnit)) {
			roles.addAll(group.getRoles());
		}
		return roles;
	}

	private List<ACGroup> getGroups(ACOrgUnit orgUnit) {
		synchronized (MonitorProvider.getInstance().getMonitor()) {
			ArrayList<ACGroup> groups = new ArrayList<ACGroup>();
			for (ACGroup group : serverSpace.getGroups()) {
				if (group.getMembers().contains(orgUnit)) {
					groups.add(group);
					groups.addAll(getGroups(group));
				}
			}
			return groups;
		}
	}

	private ACUser getUser(ACOrgUnitId orgUnitId) throws AccessControlException {
		synchronized (MonitorProvider.getInstance().getMonitor()) {
			for (ACUser user : serverSpace.getUsers()) {
				if (user.getId().equals(orgUnitId)) {
					return user;
				}
			}
			throw new AccessControlException("Given User doesn't exist.");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see 
	 *      org.unicase.emfstore.accesscontrol.AuthorizationControl#checkReadAccess(org.unicase.emfstore.esmodel.SessionId
	 *      , � � �org.unicase.emfstore.esmodel.ProjectId, java.util.Set)
	 */
	public void checkReadAccess(SessionId sessionId, ProjectId projectId, Set<ModelElement> modelElements)
		throws AccessControlException {
		checkSession(sessionId);
		ACUser user = getUser(sessionId);
		List<Role> roles = new ArrayList<Role>();
		roles.addAll(user.getRoles());
		roles.addAll(getRolesFromGroups(user));
		// MK: remove access control simplification
		if (!canRead(roles, projectId, null)) {
			throw new AccessControlException();
			// for (ModelElement modelElement : modelElements) {
			// if (!canRead(roles, projectId, modelElement)) {
			// throw new AccessControlException();
			// }
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see 
	 *      org.unicase.emfstore.accesscontrol.AuthorizationControl#checkProjectAdminAccess(org.unicase.emfstore.esmodel.
	 *      SessionId, � � �org.unicase.emfstore.esmodel.ProjectId)
	 */
	public void checkProjectAdminAccess(SessionId sessionId, ProjectId projectId) throws AccessControlException {
		checkSession(sessionId);
		ACUser user = getUser(sessionId);
		List<Role> roles = new ArrayList<Role>();
		roles.addAll(user.getRoles());
		roles.addAll(getRolesFromGroups(user));
		for (Role role : roles) {
			if (role.canAdministrate(projectId)) {
				return;
			}
		}
		throw new AccessControlException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.accesscontrol.AuthorizationControl#checkServerAdminAccess(org.unicase.emfstore.esmodel.SessionId)
	 */
	public void checkServerAdminAccess(SessionId sessionId) throws AccessControlException {
		checkSession(sessionId);
		ACUser user = getUser(sessionId);
		List<Role> roles = new ArrayList<Role>();
		roles.addAll(user.getRoles());
		roles.addAll(getRolesFromGroups(user));
		for (Role role : roles) {
			if (role instanceof ServerAdmin) {
				return;
			}
		}
		throw new AccessControlException();

	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(SessionId sessionId) throws AccessControlException {
		checkSession(sessionId);
		ACUser tmpUser = sessionUserMap.get(sessionId).getRawUser();
		ACUser user = (ACUser) EcoreUtil.copy(tmpUser);
		for (Role role : getRolesFromGroups(tmpUser)) {
			user.getRoles().add((Role) EcoreUtil.copy(role));
		}
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	public ACUser resolveUser(ACOrgUnitId id) throws AccessControlException {
		ACUser tmpUser = getUser(id);
		ACUser user = (ACUser) EcoreUtil.copy(tmpUser);
		for (Role role : getRolesFromGroups(tmpUser)) {
			user.getRoles().add((Role) EcoreUtil.copy(role));
		}
		return user;
	}

	private ACUser getUser(SessionId sessionId) throws AccessControlException {
		try {
			return sessionUserMap.get(sessionId).getUser();
		} catch (AccessControlException e) {
			sessionUserMap.remove(sessionId);
			throw e;
		}
	}

	// extract to normal class
	/**
	 * @author wesendonk
	 */
	private class ACUserContainer {
		private ACUser acUser;
		// private long firstActive;
		private long lastActive;

		public ACUserContainer(ACUser acUser) {
			this.acUser = acUser;
			// firstActive = System.currentTimeMillis();
			active();
		}

		/**
		 * Get the ACUser.
		 * 
		 * @return
		 * @throws AccessControlException
		 */
		public ACUser getUser() throws AccessControlException {
			// OW: timeout behaviour does not work as expected
			checkLastActive();
			active();
			return getRawUser();
		}

		public ACUser getRawUser() {
			return acUser;
		}

		public void checkLastActive() throws AccessControlException {
			// OW finish implementing this method
			String property = ServerConfiguration.getProperties().getProperty(ServerConfiguration.SESSION_TIMEOUT,
				ServerConfiguration.SESSION_TIMEOUT_DEFAULT);
			if (System.currentTimeMillis() - lastActive > Integer.parseInt(property)
			/* || System.currentTimeMillis() - firstActive > Integer.parseInt(property) */) {
				// OW: delete from map
				throw new SessionTimedOutException("Usersession timed out.");
			}
		}

		private void active() {
			lastActive = System.currentTimeMillis();
		}
	}

}