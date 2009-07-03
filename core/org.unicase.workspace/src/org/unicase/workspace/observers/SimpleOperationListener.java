/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.observers;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * Clients (like GUI classes) who are not interested if an operation has been run forward or backward (i.e. undone) can
 * use this add this listener to project space.
 * 
 * @author hodaie
 */
public abstract class SimpleOperationListener implements OperationListener {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.OperationListener#operationExecuted(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void operationExecuted(AbstractOperation operation) {
		operationPerformed(operation);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.OperationListener#operationUnDone(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void operationUnDone(AbstractOperation operation) {
		operationPerformed(operation.reverse());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param operation
	 */
	public abstract void operationPerformed(AbstractOperation operation);

}
