package org.unicase.ui.urmlDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class HazardCauseItemSemanticEditPolicy
		extends
		org.unicase.ui.urmlDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauseMitigations_4006 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.urmlDiagram.edit.commands.HazardCauseMitigationsCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauses_4011 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauseMitigations_4006 == req
				.getElementType()) {
			return null;
		}
		if (org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauses_4011 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.urmlDiagram.edit.commands.HazardCausesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCauseMitigationsEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.urmlDiagram.edit.commands.HazardCauseMitigationsReorientCommand(
					req));
		case org.unicase.ui.urmlDiagram.edit.parts.HazardCausesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.urmlDiagram.edit.commands.HazardCausesReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
