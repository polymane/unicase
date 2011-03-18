package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.ScientificProblemRepresentingModelItemSemanticEditPolicy;

/**
 * @generated
 */
public class ScientificProblemRepresentingModelEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4006;

	/**
	 * @generated
	 */
	public ScientificProblemRepresentingModelEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ScientificProblemRepresentingModelItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel2EditPart) {
			((WrappingLabel2EditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureScientificProblem_RepresentingModelLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel2EditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new ScientificProblem_RepresentingModelFigure();
	}

	/**
	 * @generated
	 */
	public ScientificProblem_RepresentingModelFigure getPrimaryShape() {
		return (ScientificProblem_RepresentingModelFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ScientificProblem_RepresentingModelFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureScientificProblem_RepresentingModelLabel;

		/**
		 * @generated
		 */
		public ScientificProblem_RepresentingModelFigure() {
			this.setLineWidth(1);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureScientificProblem_RepresentingModelLabel = new WrappingLabel();
			fFigureScientificProblem_RepresentingModelLabel.setText("represents");

			this.add(fFigureScientificProblem_RepresentingModelLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureScientificProblem_RepresentingModelLabel() {
			return fFigureScientificProblem_RepresentingModelLabel;
		}

	}

}