package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.NumericalMethodRealizingRequirementItemSemanticEditPolicy;

/**
 * @generated
 */
public class NumericalMethodRealizingRequirementEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4016;

	/**
	 * @generated
	 */
	public NumericalMethodRealizingRequirementEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new NumericalMethodRealizingRequirementItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel10EditPart) {
			((WrappingLabel10EditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureNumericalMethod_RealizingRequirementLabel());
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
		if (childEditPart instanceof WrappingLabel10EditPart) {
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
		return new NumericalMethod_RealizingRequirementFigure();
	}

	/**
	 * @generated
	 */
	public NumericalMethod_RealizingRequirementFigure getPrimaryShape() {
		return (NumericalMethod_RealizingRequirementFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class NumericalMethod_RealizingRequirementFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureNumericalMethod_RealizingRequirementLabel;

		/**
		 * @generated
		 */
		public NumericalMethod_RealizingRequirementFigure() {
			this.setLineWidth(1);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureNumericalMethod_RealizingRequirementLabel = new WrappingLabel();
			fFigureNumericalMethod_RealizingRequirementLabel.setText("realizes");

			this.add(fFigureNumericalMethod_RealizingRequirementLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNumericalMethod_RealizingRequirementLabel() {
			return fFigureNumericalMethod_RealizingRequirementLabel;
		}

	}

}
