/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.conflictDetection;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReadOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElementId;

/**
 * A conflict detection strategy that will operate on a per attribute and
 * feature level.
 * 
 * @author koegel
 * 
 */
public class FineGrainedConflictDetectionStrategy implements
		ConflictDetectionStrategy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#doConflict(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation,
	 *     
	 *      org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean doConflict(AbstractOperation operationA,
			AbstractOperation operationB) {
		if (operationA instanceof ReadOperation
				|| operationB instanceof ReadOperation) {
			return false;
		} else if (operationA instanceof DiagramLayoutOperation) {
			return doConflict((DiagramLayoutOperation) operationA, operationB);

		} else if (operationA instanceof AttributeOperation) {
			return doConflict((AttributeOperation) operationA, operationB);
		} else if (operationA instanceof MultiReferenceMoveOperation) {
			return doConflict((MultiReferenceMoveOperation) operationA,
					operationB);
		} else if (operationA instanceof SingleReferenceOperation) {
			return doConflict((SingleReferenceOperation) operationA, operationB);
		} else if (operationA instanceof MultiReferenceOperation) {
			return doConflict((MultiReferenceOperation) operationA, operationB);
		} else if (operationA instanceof CreateDeleteOperation) {
			return doConflict((CreateDeleteOperation) operationA, operationB);
		} else if (operationA instanceof CompositeOperation) {
			return doConflict((CompositeOperation) operationA, operationB);
		}
		throw new IllegalArgumentException("Unkown operation type: "
				+ operationA);

	}

	private boolean doConflict(MultiReferenceOperation operationA,
			AbstractOperation operationB) {
		if (operationB instanceof AttributeOperation) {
			return false;
		} else if (operationB instanceof MultiReferenceMoveOperation) {
			boolean sameFeature = ((FeatureOperation) operationA)
					.getFeatureName().equals(
							((MultiReferenceMoveOperation) operationB)
									.getFeatureName());
			boolean sameElement = operationA.getModelElementId().equals(
					operationB.getModelElementId());
			return sameElement && sameFeature;
		} else if (operationB instanceof ReferenceOperation) {
			MultiReferenceOperation multiOperationA = operationA;
			ReferenceOperation referenceOperationB = (ReferenceOperation) operationB;
			boolean sameFeature = multiOperationA.getFeatureName().equals(
					referenceOperationB.getFeatureName());
			if (multiOperationA.getOppositeFeatureName() != null) {
				sameFeature = sameFeature
						|| multiOperationA.getOppositeFeatureName().equals(
								referenceOperationB.getFeatureName());
			}
			boolean sameElement = multiOperationA.getModelElementId().equals(
					referenceOperationB.getModelElementId());
			return sameFeature && sameElement;
		} else {
			return doConflict(operationB, operationA);
		}
	}

	private boolean doConflict(CompositeOperation operationA,
			AbstractOperation operationB) {
		for (AbstractOperation subOperationA : operationA.getSubOperations()) {
			if (doConflict(subOperationA, operationB)) {
				return true;
			}
		}
		return false;
	}

	private boolean doConflict(DiagramLayoutOperation operationA,
			AbstractOperation operationB) {
		if (operationB instanceof DiagramLayoutOperation) {
			return operationA.getModelElementId().equals(
					operationA.getModelElementId());
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.conflictDetection.ConflictDetectionStrategy#isRequired(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation,
	 *     
	 *      org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public boolean isRequired(AbstractOperation requiredOperation,
			AbstractOperation operation) {
		if (requiredOperation instanceof ReadOperation
				|| operation instanceof ReadOperation) {
			return false;
		}
		return false;
	}

	private boolean doConflict(CreateDeleteOperation operationA,
			AbstractOperation operationB) {
		if (operationB instanceof CompositeOperation) {
			return doConflict(operationB, operationA);
		}
		if (operationB instanceof ReferenceOperation) {
			for (ModelElementId modelElementId : ((ReferenceOperation) operationB)
					.getOtherInvolvedModelElements()) {
				if (operationA.getModelElementId().equals(modelElementId)) {
					return true;
				}
			}
		}
		return operationA.getModelElementId().equals(
				operationB.getModelElementId());
	}

	private boolean doConflict(AttributeOperation operationA,
			AbstractOperation operationB) {
		if (!operationA.getModelElementId().equals(
				operationB.getModelElementId())) {
			return false;
		}
		if (operationB instanceof FeatureOperation) {
			FeatureOperation featureOperationB = (FeatureOperation) operationB;
			return featureOperationB.getFeatureName().equals(
					operationA.getFeatureName());
		}
		return doConflict(operationB, operationA);
	}

	private boolean doConflict(MultiReferenceMoveOperation operationA,
			AbstractOperation operationB) {
		if (operationB instanceof MultiReferenceMoveOperation) {
			boolean sameElement = operationA.getModelElementId().equals(
					operationB.getModelElementId());
			boolean sameFeature = operationA.getFeatureName()
					.equals(
							((MultiReferenceMoveOperation) operationB)
									.getFeatureName());
			return sameElement && sameFeature;
		} else if (operationB instanceof AttributeOperation) {
			return false;
		}
		return doConflict(operationB, operationA);
	}

	private boolean doConflict(SingleReferenceOperation operationA,
			AbstractOperation operationB) {
		if (operationB instanceof SingleReferenceOperation) {
			ReferenceOperation singleOperationB = (SingleReferenceOperation) operationB;
			boolean sameFeature = operationA.getFeatureName().equals(
					singleOperationB.getFeatureName());
			if (operationA.getOppositeFeatureName() != null) {
				sameFeature = sameFeature
						|| operationA.getOppositeFeatureName().equals(
								singleOperationB.getFeatureName());
			}
			boolean sameElement = operationA.getModelElementId().equals(
					operationB.getModelElementId());
			return sameFeature && sameElement;
		} else if (operationB instanceof AttributeOperation) {
			return false;
		} else if (operationB instanceof MultiReferenceMoveOperation) {
			return false;
		}
		return doConflict(operationB, operationA);
	}
}
