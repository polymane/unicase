package scrm.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.KnowledgeSpaceKnowledgeSpaceCompartmentCanonicalEditPolicy;
import scrm.diagram.edit.policies.KnowledgeSpaceKnowledgeSpaceCompartmentItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenSCRMSpaceEditPolicy;
import scrm.diagram.edit.policies.SCRMSpaceChildCreationEditPolicy;
import scrm.diagram.edit.policies.SCRMSpaceDragDropEditPolicy;
import scrm.diagram.part.Messages;

/**
 * @generated
 */
public class KnowledgeSpaceKnowledgeSpaceCompartmentEditPart extends
		ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7001;

	/**
	 * @generated
	 */
	public KnowledgeSpaceKnowledgeSpaceCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public String getCompartmentName() {
		return Messages.KnowledgeSpaceKnowledgeSpaceCompartmentEditPart_title;
	}

	/**
	 * @generated
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new ResizableCompartmentEditPolicy());
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new KnowledgeSpaceKnowledgeSpaceCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new SCRMSpaceChildCreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new SCRMSpaceDragDropEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new KnowledgeSpaceKnowledgeSpaceCompartmentCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenSCRMSpaceEditPolicy());
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

}
