/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.conflictDetection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * Detects conflicts with a given {@link ConflictDetectionStrategy}.
 * 
 * @author koegel
 */
public class ConflictDetector {

	private ConflictDetectionStrategy conflictDetectionStrategy;

	/**
	 * Constructor. Uses default conflict detection strategy
	 */
	public ConflictDetector() {
		// this(new AlwaysFalseConflictDetectionStrategy());
		this(new FineGrainedConflictDetectionStrategy());
	}

	/**
	 * Constructor with a given strategy.
	 * 
	 * @param conflictDetectionStrategy the detection strategy to use
	 */
	public ConflictDetector(ConflictDetectionStrategy conflictDetectionStrategy) {
		this.conflictDetectionStrategy = conflictDetectionStrategy;
	}

	/**
	 * Determines if two change packages are conflicting.
	 * 
	 * @param changePackageA a changePackage
	 * @param changePackageB another change package
	 * @return true if the two packages conflict
	 */
	public boolean doConflict(ChangePackage changePackageA, ChangePackage changePackageB) {
		for (AbstractOperation operation : changePackageA.getOperations()) {
			for (AbstractOperation otherOperation : changePackageB.getOperations()) {
				if (conflictDetectionStrategy.doConflict(operation, otherOperation)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Determine if a change package conflicts with a list of change packages.
	 * 
	 * @param changePackage a change package
	 * @param changePackageList a list of change package
	 * @return true if the change package conflicts with any package in the list
	 */
	public boolean doConflict(ChangePackage changePackage, ArrayList<ChangePackage> changePackageList) {
		for (ChangePackage b : changePackageList) {
			if (doConflict(changePackage, b)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retrieve all operations in other ops that are conflicting with operations in ops. If any operation is in both
	 * lists, it is not considered to be conflicting.
	 * 
	 * @param ops A list of operations.
	 * @param otherOps A list of the other operations.
	 * @return A set of conflicting operations which is a subset of otherOps.
	 */
	public Set<AbstractOperation> getConflicting(List<AbstractOperation> ops, List<AbstractOperation> otherOps) {
		// the operations that are conflicting
		Set<AbstractOperation> conflicting = new HashSet<AbstractOperation>();

		// check each operation in ops against otherOps
		for (AbstractOperation position : ops) {
			for (AbstractOperation other : otherOps) {
				if (conflicting.contains(other)) {
					// a conflict has already been registered
					continue;
				}
				// if there is a conflict, add the other op to the
				// list of conflicting ops along with all ops that
				// require other ops
				if (conflictDetectionStrategy.doConflict(position, other)) {
					conflicting.addAll(getRequiring(otherOps, other));
					conflicting.add(other);
				}
			}

		}

		// return the set of conflicting operations in other ops
		return conflicting;
	}

	/**
	 * Retrieve all operations in ops that are required by op. The operation <code>op</code> must be part of
	 * <code>ops</code>.
	 * 
	 * @param ops A time ordered (ascending) list of operations containing op.
	 * @param op The operation for which the requirements should be determined.
	 * @return A list of operations that are required for op which is a subset of ops. <code>op</code> will not be part
	 *         of the returned list.
	 * @throws IllegalArgumentException If op is not in ops.
	 */
	public List<AbstractOperation> getRequired(List<AbstractOperation> ops, AbstractOperation op)
		throws IllegalArgumentException {
		// sanity check
		if (!ops.contains(op)) {
			throw new IllegalArgumentException("the ops list dos not contain op");
		}

		// Check all operations if they are (transitively) required by op.
		// We make use of the fact here that an operation can only require
		// operations that are before it in time.
		List<AbstractOperation> required = new ArrayList<AbstractOperation>();
		required.add(op);

		for (int i = ops.indexOf(op) - 1; i >= 0; i--) {
			AbstractOperation current = ops.get(i);
			// else check if it is required by any of the already required ops

			for (AbstractOperation req : required) {
				if (conflictDetectionStrategy.isRequired(current, req)) {
					required.add(0, current);
					break;
				}
			}
		}
		required.remove(op);

		// return the sub list of operations required by op
		return required;
	}

	/**
	 * Retrieve all operations in ops that require op.
	 * 
	 * @param ops A time ordered (ascending) list of operations containing op.
	 * @param op The operation for which the dependants should be determined.
	 * @return A list of operations that require op which is a subset of ops.
	 */
	public List<AbstractOperation> getRequiring(List<AbstractOperation> ops, AbstractOperation op) {
		// sanity check
		if (!ops.contains(op)) {
			throw new IllegalArgumentException("the ops list dos not contain op");
		}

		// Check all operations if they (transitively) require op.
		// We make use of the fact here that an operation can only
		// possibly require an operation that is before it in time.
		int opIdx = ops.indexOf(op);
		List<AbstractOperation> requiring = new ArrayList<AbstractOperation>();
		requiring.add(op);

		for (AbstractOperation current : ops) {
			// if the current op is before op, it can not require it
			if (ops.indexOf(current) <= opIdx) {
				continue;
			}
			// else check if it requires any of the already requiring ops
			for (AbstractOperation req : requiring) {
				if (conflictDetectionStrategy.isRequired(current, req)) {
					requiring.add(current);
					break;
				}
			}
		}
		requiring.remove(op);
		// return the sub list of operations requiring op
		return requiring;
	}

	/**
	 * Return all operations that are involved in a conflict of the two lists.
	 * 
	 * @param operationListA a list of operations
	 * @param operationListB another list of operations
	 * @return a set of operations
	 */
	public Set<AbstractOperation> getAllConflictInvolvedOperations(List<AbstractOperation> operationListA,
		List<AbstractOperation> operationListB) {
		Set<AbstractOperation> result = new HashSet<AbstractOperation>();
		for (AbstractOperation operationA : operationListA) {
			if (result.contains(operationA)) {
				continue;
			}
			List<AbstractOperation> reqAoperations = getRequiring(operationListA, operationA);
			Set<AbstractOperation> conflicting = getConflicting(reqAoperations, operationListB);
			if (conflicting.size() > 0) {
				result.addAll(conflicting);
				result.add(operationA);
			}
		}
		for (AbstractOperation operationB : operationListB) {
			if (result.contains(operationB)) {
				continue;
			}
			List<AbstractOperation> reqAoperations = getRequiring(operationListB, operationB);
			Set<AbstractOperation> conflicting = getConflicting(reqAoperations, operationListA);
			if (conflicting.size() > 0) {
				result.addAll(conflicting);
				result.add(operationB);
			}
		}
		return result;
	}
}
