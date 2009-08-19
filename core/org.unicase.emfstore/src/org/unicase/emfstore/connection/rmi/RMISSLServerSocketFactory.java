/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.rmi;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.rmi.server.RMIServerSocketFactory;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.emfstore.EmfStoreController;
import org.unicase.emfstore.connection.ServerKeyStoreManager;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.ServerKeyStoreException;

/**
 * Custom SocketFactory for rmi with encryption.
 * 
 * @author Wesendonk
 */
@SuppressWarnings("serial")
public class RMISSLServerSocketFactory implements RMIServerSocketFactory, Serializable {

	private static Log logger;

	/**
	 * in development.
	 */
	public int id;

	/**
	 * Default constructor.
	 */
	public RMISSLServerSocketFactory() {
		super();
		logger = LogFactory.getLog(RMISSLServerSocketFactory.class);
		id = 07701522;
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerSocket createServerSocket(int port) throws IOException {
		SSLServerSocketFactory serverSocketFactory = null;
		SSLContext context;

		try {
			context = SSLContext.getInstance("TLS");
			context.init(ServerKeyStoreManager.getInstance().getKeyManagerFactory().getKeyManagers(), null, null);
			serverSocketFactory = context.getServerSocketFactory();
		} catch (NoSuchAlgorithmException e) {
			logger.error("Couldn't initialize server socket.");
			EmfStoreController.getInstance().shutdown(new FatalEmfStoreException());
		} catch (KeyManagementException e) {
			logger.error("Couldn't initialize server socket.");
			EmfStoreController.getInstance().shutdown(new FatalEmfStoreException());
		} catch (ServerKeyStoreException e) {
			logger.error("Couldn't initialize server socket.");
			EmfStoreController.getInstance().shutdown(new FatalEmfStoreException());
		}

		return serverSocketFactory.createServerSocket(port);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return getClass() == obj.getClass() && ((RMISSLServerSocketFactory) obj).id == this.id;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return id;
	}
}