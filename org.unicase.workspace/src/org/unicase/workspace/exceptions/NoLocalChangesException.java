/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.exceptions;

/**
 * Indicates that there are no local changes.
 * @author koegel
 *
 */
@SuppressWarnings("serial")
public class NoLocalChangesException extends WorkspaceException {

	private static final String MESSAGE = "No need to commit. There are no local changes.";
	
	/**
	 * Constructor.
	 */
	public NoLocalChangesException() {
		super(MESSAGE);
	}

}
