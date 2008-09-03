/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.connection.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.unicase.emfstore.ServerConfiguration;

public abstract class AbstractUnicaseRMIFacade extends UnicastRemoteObject {

	private static final long serialVersionUID = 2586931338749730039L;

	public AbstractUnicaseRMIFacade() throws RemoteException {
		super(0, new RMISSLClientSocketFactory(),
		new RMISSLServerSocketFactory());
//		String property = ServerConfiguration.getProperties().getProperty(
//				ServerConfiguration.RMI_ENCRYPTION,
//				ServerConfiguration.DEFAULT_RMI_ENCRYTION);
//		if(property.equals("yes")) {
//			super(0, new RMISSLClientSocketFactory(),
//					new RMISSLServerSocketFactory());
//		} else {
//			super();
//		}
	}
}
