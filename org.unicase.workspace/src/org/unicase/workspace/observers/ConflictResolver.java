/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.observers;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.Project;

/**
 * Represents a controller that can merge conflicting changes resulting in a list of changes that is not conflicting any
 * more.
 * 
 * @author koegel
 */
public interface ConflictResolver {

	/**
	 * Resolves all conflicts between the given change packages "theirs" and the given local operations.
	 * 
	 * @param project the project at the time were all local changes are already applied and their operations are NOT,
	 *            in other words the base version plus local operations
	 * @param theirChangePackages an ordered list of change packages that are incoming in the update, in other words all
	 *            change packages from base to target
	 * @param myChangePackage the change package of operations that are to be applied locally
	 * @return true if the merge can proceed, false if it has to be cancelled
	 */
	boolean resolveConflicts(Project project, List<ChangePackage> theirChangePackages, ChangePackage myChangePackage);

	/**
	 * Get all operations that have been rejected in their changepackages.
	 * 
	 * @return a list of operations
	 */
	List<AbstractOperation> getRejectedTheirs();

	/**
	 * Get all operations of my local operations that have been accepted.
	 * 
	 * @return a list of operations
	 */
	List<AbstractOperation> getAcceptedMine();
}
