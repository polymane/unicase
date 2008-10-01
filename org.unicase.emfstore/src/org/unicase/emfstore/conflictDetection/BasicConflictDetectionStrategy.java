/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.conflictDetection;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * Very basic conflict detection strategy. Will only check if same model element is touched.
 * @author koegel
 *
 */
public class BasicConflictDetectionStrategy implements
		ConflictDetectionStrategy {

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#doConflict(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation, org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean doConflict(AbstractOperation operationA,
			AbstractOperation operationB) {
		return operationA.getModelElementId().equals(operationB.getModelElementId());
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#isRequired(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation, org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean isRequired(AbstractOperation requiredOperation,
			AbstractOperation operation) {
		return doConflict(requiredOperation, operation);
	}
}
