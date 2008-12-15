/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.connection.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.unicase.emfstore.AdminEmfStore;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * Facade for AdminEmfstore interface for rmi transport layer.
 * 
 * @author Wesendonk
 */
public interface RMIAdminEmfStoreFacade extends Remote {

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getProjectInfos(org.unicase.emfstore.esmodel.SessionId)
	 * @param sessionId
	 *            the session id
	 * @return list of projects
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	List<String> getProjectInfos(String sessionId) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getGroups(org.unicase.emfstore.esmodel.SessionId)
	 * @param sessionId
	 *            the session id
	 * @return list of groups
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	List<String> getGroups(String sessionId) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getUsers(org.unicase.emfstore.esmodel.SessionId)
	 * @param sessionid
	 *            the session id
	 * @return list of user
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	List<String> getUsers(String sessionid) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getOrgUnits(org.unicase.emfstore.esmodel.SessionId)
	 * @param sessionId
	 *            the session id
	 * @return list of orgUnits
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	List<String> getOrgUnits(String sessionId) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getGroups(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the session id
	 * @param user
	 *            the user
	 * @return list of groups
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	List<String> getGroups(String sessionId, String user)
			throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#removeGroup(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the session id
	 * @param user
	 *            the user
	 * @param group
	 *            the group
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void removeGroup(String sessionId, String user, String group)
			throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getParticipants(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId)
	 * @param sessionId
	 *            the session id
	 * @param projectId
	 *            the project id
	 * @return list of orgUnits
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	List<String> getParticipants(String sessionId, String projectId)
			throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#addParticipant(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the session id
	 * @param projectId
	 *            the project id
	 * @param participant
	 *            the orgUnit
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void addParticipant(String sessionId, String projectId, String participant)
			throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#removeParticipant(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the session id
	 * @param projectId
	 *            the project id
	 * @param participant
	 *            the orgUnit
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void removeParticipant(String sessionId, String projectId,
			String participant) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getRole(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the session id
	 * @param projectId
	 *            the project id
	 * @param orgUnitId
	 *            the orgUnit id
	 * @return the role
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	String getRole(String sessionId, String projectId, String orgUnitId)
			throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#changeRole(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.ProjectId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId,
	 *      org.eclipse.emf.ecore.EClass)
	 * @param sessionId
	 *            the session id
	 * @param projectId
	 *            the project id
	 * @param orgUnitId
	 *            the orgUnit id
	 * @param eClass
	 *            the new role
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void changeRole(String sessionId, String projectId, String orgUnitId,
			String eClass) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#createGroup(org.unicase.emfstore.esmodel.SessionId,
	 *      String)
	 * @param sessionId
	 *            the session id
	 * @param name
	 *            the name
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void createGroup(String sessionId, String name) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#deleteGroup(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the session id
	 * @param id
	 *            the orgUnit id
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void deleteGroup(String sessionId, String id) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#createUser(org.unicase.emfstore.esmodel.SessionId,
	 *      String)e
	 * @param sessionId
	 *            the session id
	 * @param name
	 *            the name
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void createUser(String sessionId, String name) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#deleteUser(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the session id
	 * @param id
	 *            the orgUnit id
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void deleteUser(String sessionId, String id) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getMembers(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the sessionId
	 * @param groupId
	 *            the group Id
	 * @return list of member
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	List<String> getMembers(String sessionId, String groupId)
			throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#addMember(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the session id
	 * @param group
	 *            the group id
	 * @param member
	 *            the user id
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void addMember(String sessionId, String group, String member)
			throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#removeMember(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the session id
	 * @param group
	 *            the group id
	 * @param member
	 *            the member id
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void removeMember(String sessionId, String group, String member)
			throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#changeOrgUnit(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId, String,
	 *      String)
	 * @param sessionId
	 *            the session i d
	 * @param orgUnitId
	 *            the orgUnit id
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	void changeOrgUnit(String sessionId, String orgUnitId, String name,
			String description) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link AdminEmfStore}.
	 * 
	 * @see AdminEmfStore#getOrgUnit(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId)
	 * @param sessionId
	 *            the session id
	 * @param orgUnitId
	 *            the orgUnit id
	 * @return an orgUnit
	 * @throws RemoteException
	 *             transport related exception
	 * @throws EmfStoreException
	 *             if an error in the EmfStore occurs
	 */
	String getOrgUnit(String sessionId, String orgUnitId)
			throws RemoteException, EmfStoreException;
}
