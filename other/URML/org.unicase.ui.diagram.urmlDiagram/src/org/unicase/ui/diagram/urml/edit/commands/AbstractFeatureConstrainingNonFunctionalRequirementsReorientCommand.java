package org.unicase.ui.diagram.urml.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.unicase.model.urml.feature.AbstractFeature;
import org.unicase.model.urml.requirement.NonFunctionalRequirement;
import org.unicase.ui.diagram.urml.edit.policies.UrmlBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class AbstractFeatureConstrainingNonFunctionalRequirementsReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject referenceOwner;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public AbstractFeatureConstrainingNonFunctionalRequirementsReorientCommand(
		ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == referenceOwner instanceof AbstractFeature) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof NonFunctionalRequirement && newEnd instanceof AbstractFeature)) {
			return false;
		}
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints
			.canExistAbstractFeatureConstrainingNonFunctionalRequirements_4036(getNewSource(), getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof NonFunctionalRequirement && newEnd instanceof NonFunctionalRequirement)) {
			return false;
		}
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints
			.canExistAbstractFeatureConstrainingNonFunctionalRequirements_4036(getOldSource(), getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().getConstrainingNonFunctionalRequirements().remove(getOldTarget());
		getNewSource().getConstrainingNonFunctionalRequirements().add(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getConstrainingNonFunctionalRequirements().remove(getOldTarget());
		getOldSource().getConstrainingNonFunctionalRequirements().add(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected AbstractFeature getOldSource() {
		return (AbstractFeature) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected AbstractFeature getNewSource() {
		return (AbstractFeature) newEnd;
	}

	/**
	 * @generated
	 */
	protected NonFunctionalRequirement getOldTarget() {
		return (NonFunctionalRequirement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected NonFunctionalRequirement getNewTarget() {
		return (NonFunctionalRequirement) newEnd;
	}
}
