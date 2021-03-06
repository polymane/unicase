/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.exceptions;

import org.eclipse.emf.common.notify.Notification;

/**
 * Represents exceptional condition where the used implementation (subclass) of {@link Notification} is unknown.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class UnknownNotificationImplementationException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param notification the notification of which the type is unknown.
	 */
	public UnknownNotificationImplementationException(Notification notification) {
		super("Unkown Notification Implementation: " + notification.getClass().getCanonicalName());
	}

	/**
	 * Constructor.
	 * 
	 * @param notification the notification of which the type is unknown.
	 * @param cause the underlying cause
	 */
	public UnknownNotificationImplementationException(Notification notification, Exception cause) {
		super("Unkown Notification Implementation: " + notification.getClass().getCanonicalName(), cause);
	}
}
