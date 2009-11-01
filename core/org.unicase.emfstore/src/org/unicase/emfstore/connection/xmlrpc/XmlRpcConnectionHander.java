/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.xmlrpc;

import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * Connection Handler for XML RPC Emfstore interface.
 * 
 * @author wesendon
 */
public class XmlRpcConnectionHander implements ConnectionHandler<EmfStore> {

	/**
	 * String interface identifier.
	 */
	public static final String EMFSTORE = "EmfStore";

	private static final String NAME = "XML RPC Connection Handler";

	private static EmfStore emfStore;

	private static AuthenticationControl accessControl;

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
	public void init(EmfStore emfStore, AuthenticationControl accessControl) throws FatalEmfStoreException {
		this.emfStore = emfStore;
		this.accessControl = accessControl;
		XmlRpcWebserverManager webServer = XmlRpcWebserverManager.getInstance();
		webServer.initServer();
		webServer.addHandler(EMFSTORE, XmlRpcEmfStoreImpl.class);
	}

	/**
	 * Returns Emfstore.
	 * 
	 * @return emfstore
	 */
	public static EmfStore getEmfStore() {
		return emfStore;
	}

	/**
	 * Returns AccessControl.
	 * 
	 * @return access control
	 */
	public static AuthenticationControl getAccessControl() {
		return accessControl;
	}

	/**
	 * {@inheritDoc}
	 */
	public void stop(boolean force) {
		// TODO OW
	}

}
