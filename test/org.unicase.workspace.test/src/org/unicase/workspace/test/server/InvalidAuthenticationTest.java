/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.server;

import org.junit.Test;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.test.SetupHelper;

/**
 * Has to be implemented.
 * 
 * @author wesendon
 */
// TODO: implementation has been postponed
public class InvalidAuthenticationTest extends ServerTests {

	/**
	 * has to be implemented.
	 * 
	 * @throws EmfStoreException in case of failure
	 */
	@Test
	public void doNothing() throws EmfStoreException {
		SessionId login = login(SetupHelper.getServerInfo(), "reader", "foo");
		login.getId();
	}
}
