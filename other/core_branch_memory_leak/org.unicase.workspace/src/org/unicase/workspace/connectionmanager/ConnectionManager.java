/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.connectionmanager;

import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ServerInfo;

/**
 * The connection manager manages the connection to the EmfStore. It will initiate, reinitiate and terminate the
 * connection as needed.
 * 
 * @author Maximilian Koegel
 * @author wesendon
 * @generated NOT
 */
public interface ConnectionManager extends EmfStore {

	/**
	 * Connection related failure message.
	 */
	String REMOTE = "Server could not be reached.";

	/**
	 * Connection related failure message.
	 */
	String LOGIN_FIRST = "Session unkown to Connection manager, log in first!";

	/**
	 * Connection related failure message.
	 */
	String UNSUPPORTED_ENCODING = "Problem with en/decoding.";

	/**
	 * Connection related failure message.
	 */
	String LOGIN_REFUSED = "Login refused.";

	/**
	 * Connection related failure message.
	 */
	String INCOMPATIBLE_VERSION = "Client version not compatible with server. Please update your client.";

	/**
	 * Log into the server given by server info. The connection manager will also remember the serverInfo associated
	 * with the session id.
	 * 
	 * @param username the user name
	 * @param password the password
	 * @param severInfo the server info for the server to log into
	 * @param clientVersionInfo the client's version
	 * @return a session id that can be used for later authentication
	 * @throws EmfStoreException in case of failure
	 * @generated NOT
	 */
	SessionId logIn(String username, String password, ServerInfo severInfo, ClientVersionInfo clientVersionInfo)
		throws EmfStoreException;

	/**
	 * Deletes a session on the server.
	 * 
	 * @param sessionId id to be deleted.
	 * @throws EmfStoreException in case of failure on server
	 */
	void logout(SessionId sessionId) throws EmfStoreException;
}
