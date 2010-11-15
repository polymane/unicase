/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;

/**
 * Util class for EMFStore clients to ease connecting to the server.
 * 
 * @author koegel
 */
public final class EMFStoreClientUtil {

	private static final String LOCALHOST_GENERATED_ENTRY_NAME = "EMFStore (generated entry)";

	/**
	 * Private constructor for util class.
	 */
	private EMFStoreClientUtil() {
		// do nothing
	}

	/**
	 * Gives a server info for a given port and url. Searches first for already existing ones. If the search fails, it
	 * creates a new one and registers it for later lookup.
	 * 
	 * @param url the server url (e.g. IP address or DNS name)
	 * @param port the server port
	 * @return a server info
	 */
	private static ServerInfo giveServerInfo(String url, int port) {
		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		for (ServerInfo existingServerInfo : workspace.getServerInfos()) {
			if (existingServerInfo.getName().equals(LOCALHOST_GENERATED_ENTRY_NAME)) {
				if (url.equals(existingServerInfo.getUrl()) && port == existingServerInfo.getPort()) {
					return existingServerInfo;
				}
			}
		}
		ServerInfo serverInfo = createServerInfo(url, port);
		workspace.getServerInfos().add(serverInfo);
		workspace.save();
		return serverInfo;
	}

	/**
	 * Create a server info for a given port and url.
	 * 
	 * @param url the server url (e.g. IP address or DNS name)
	 * @param port the server port
	 * @return a server info
	 */
	private static ServerInfo createServerInfo(String url, int port) {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setName(LOCALHOST_GENERATED_ENTRY_NAME);
		serverInfo.setUrl(url);
		serverInfo.setPort(port);
		serverInfo.setCertificateAlias("unicase.org test test(!!!) certificate");
		return serverInfo;
	}

	/**
	 * Create a default user session with the default super user and password and a server on localhost on the default
	 * port.
	 * 
	 * @return a usersession
	 */
	public static Usersession createUsersession() {
		return createUsersession("super", "super", "localhost", 8080);
	}

	/**
	 * Create a usersession for the given credentials and server info.
	 * 
	 * @param username the username
	 * @param password the password
	 * @param serverUrl server url
	 * @param serverPort server port
	 * @return a user session
	 */
	public static Usersession createUsersession(String username, String password, String serverUrl, int serverPort) {
		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		for (Usersession usersession : workspace.getUsersessions()) {
			ServerInfo existingServerInfo = usersession.getServerInfo();
			if (existingServerInfo != null && existingServerInfo.getName().equals(LOCALHOST_GENERATED_ENTRY_NAME)
				&& existingServerInfo.getUrl().equals(serverUrl) && existingServerInfo.getPort() == serverPort) {
				String encPassword = KeyStoreManager.getInstance().encrypt(password, existingServerInfo);
				if (username.equals(usersession.getUsername()) && encPassword.equals(usersession.getPassword())) {
					return usersession;
				}
			}
		}
		Usersession usersession = WorkspaceFactory.eINSTANCE.createUsersession();
		usersession.setServerInfo(giveServerInfo(serverUrl, serverPort));
		usersession.setUsername(username);
		usersession.setPassword(password);
		workspace.getUsersessions().add(usersession);
		workspace.save();
		return usersession;
	}

	/**
	 * Checks, if the given credentials can be authenticated at the given server.
	 * 
	 * @param username the username
	 * @param password the password
	 * @param serverUrl server url
	 * @param serverPort server port
	 * @return true, if username & password are right
	 * @throws EmfStoreException Problem with the EMFStore Server
	 */
	public static boolean dryLogin(String username, String password, String serverUrl, int serverPort)
		throws EmfStoreException {
		Usersession usersession = WorkspaceFactory.eINSTANCE.createUsersession();
		usersession.setServerInfo(createServerInfo(serverUrl, serverPort));
		usersession.setUsername(username);
		usersession.setPassword(password);
		try {
			usersession.logIn();
		} catch (AccessControlException e) {
			return false;
		}
		return true;
	}
}
