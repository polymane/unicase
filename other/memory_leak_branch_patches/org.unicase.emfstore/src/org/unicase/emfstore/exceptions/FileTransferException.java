/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.exceptions;

/**
 * Exception class for file transfers.
 * 
 * @author C
 */
public class FileTransferException extends EmfStoreException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message Error message
	 */
	public FileTransferException(String message) {
		super(message);
	}

	/**
	 * @param e exception originally thrown
	 * @param message Error message
	 */
	public FileTransferException(String message, Throwable e) {
		super(message, e);
	}
}
