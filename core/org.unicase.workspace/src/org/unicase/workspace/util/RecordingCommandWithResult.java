/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.eclipse.emf.transaction.RecordingCommand;
import org.unicase.workspace.Configuration;

/**
 * Recording command that can buffer a result for later retrieval.
 * 
 * @author koegel
 * @param <T>
 */
public abstract class RecordingCommandWithResult<T> extends RecordingCommand {

	private T result;

	/**
	 * Constructor. The editing domain needs to be initialized by the workspace manager before using this constructor.
	 */
	public RecordingCommandWithResult() {
		super(Configuration.getEditingDomain());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected final void doExecute() {
		this.result = doRun();
	}

	/**
	 * The actual action that is being executed.
	 * 
	 * @return the result
	 */
	protected abstract T doRun();

	/**
	 * Executes the command on the workspaces editing domain. Will throw an illegal state exception if the editing
	 * domain is not initialized.
	 * 
	 * @return the result
	 */
	public T run() {
		this.execute();
		return this.result;
	}

}
