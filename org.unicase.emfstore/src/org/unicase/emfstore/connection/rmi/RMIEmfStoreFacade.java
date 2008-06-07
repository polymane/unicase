package org.unicase.emfstore.connection.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;

public interface RMIEmfStoreFacade extends Remote {

	/**
	 * 
	 * @param sessionId
	 *            as string
	 * @return a list of ProjectInfo objects in a serialized form
	 * @throws RemoteException
	 * @throws EmfStoreException
	 */
	public List<String> getProjectList(String sessionId)
			throws RemoteException, EmfStoreException;

	public String getProject(String sessionId, String projectId,
			String versionSpec) throws RemoteException, EmfStoreException;

	public String createVersion(String sessionId, String projectId,
			String baseVersionSpec, String changePackage, String logMessage)
			throws RemoteException, EmfStoreException;

	public String resolveVersionSpec(String sessionId, String projectId,
			String versionSpec) throws RemoteException, EmfStoreException;

	public List<String> getChanges(String sessionId, String projectId,
			String source, String target) throws RemoteException,
			EmfStoreException;

	public List<String> getHistoryInfo(String sessionId, String projectId,
			String source, String target) throws RemoteException,
			EmfStoreException;

	public String createProject(String sessionId, String name,
			String description, String logMessage) throws RemoteException,
			EmfStoreException;

	public String login(String username, String password, String serverInfo)
			throws RemoteException, AccessControlException;

	public void sendString(String str) throws RemoteException;

}
