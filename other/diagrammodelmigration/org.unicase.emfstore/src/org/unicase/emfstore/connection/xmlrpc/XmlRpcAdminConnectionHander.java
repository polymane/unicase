/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.xmlrpc;

import org.unicase.emfstore.AdminEmfStore;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * Connection Handler for XML RPC AdminEmfstore interface.
 * 
 * @author wesendon
 */
public class XmlRpcAdminConnectionHander implements ConnectionHandler<AdminEmfStore> {

	/**
	 * String interface identifier.
	 */
	public static final String ADMINEMFSTORE = "AdminEmfStore";

	private static final String NAME = "XML RPC Admin Connection Handler";

	private static AdminEmfStore adminEmfStore;

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("static-access")
	public void init(AdminEmfStore adminEmfStore, AuthenticationControl accessControl) throws FatalEmfStoreException {
		this.adminEmfStore = adminEmfStore;
		XmlRpcWebserverManager webServer = XmlRpcWebserverManager.getInstance();
		webServer.initServer();
		webServer.addHandler(ADMINEMFSTORE, XmlRpcAdminEmfStoreImpl.class);
	}

	/**
	 * Returns AdminEmfstore.
	 * 
	 * @return admin emfstore
	 */
	public static AdminEmfStore getAdminEmfStore() {
		return adminEmfStore;
	}

	/**
	 * {@inheritDoc}
	 */
	public void stop(boolean force) {
		XmlRpcWebserverManager webserverManager = XmlRpcWebserverManager.getInstance();
		if (!webserverManager.removeHandler(ADMINEMFSTORE)) {
			webserverManager.stopServer();
		}
	}

}
