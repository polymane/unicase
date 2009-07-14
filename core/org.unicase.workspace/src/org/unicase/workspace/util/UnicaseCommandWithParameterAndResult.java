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
 * @param <T> result type
 * @param <U> parameter type
 */
public abstract class UnicaseCommandWithParameterAndResult<T, U> extends RecordingCommand {

	private T result;
	private U parameter;

	/**
	 * Constructor. The editing domain needs to be initialized by the workspace manager before using this constructor.
	 */
	public UnicaseCommandWithParameterAndResult() {
		super(Configuration.getEditingDomain());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected final void doExecute() {
		this.result = doRun(parameter);
	}

	/**
	 * The actual action that is being executed.
	 * 
	 * @param parameter the parameter
	 * @return the result
	 */
	protected abstract T doRun(U parameter);

	/**
	 * Executes the command on the workspaces editing domain.
	 * 
	 * @param parameter the parameter
	 * @return the result
	 */
	public T run(U parameter) {
		this.parameter = parameter;
		// this.execute();
		Configuration.getEditingDomain().getCommandStack().execute(this);
		return this.result;
	}

}
