package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.Mathematical_GeophysicalModelUsedInNumericalMethodsItemSemanticEditPolicy;

/**
 * @generated
 */
public class Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart extends
		ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4065;

	/**
	 * @generated
	 */
	public Mathematical_GeophysicalModelUsedInNumericalMethodsEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new Mathematical_GeophysicalModelUsedInNumericalMethodsItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel5EditPart) {
			((WrappingLabel5EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMathematical_GeophysicalModel_NumericalMethodsLabel());
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
		super.addChildVisual(childEditPart, index);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel5EditPart) {
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
		return new Mathematical_GeophysicalModel_NumericalMethodsFigure();
	}

	/**
	 * @generated
	 */
	public Mathematical_GeophysicalModel_NumericalMethodsFigure getPrimaryShape() {
		return (Mathematical_GeophysicalModel_NumericalMethodsFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Mathematical_GeophysicalModel_NumericalMethodsFigure extends
			PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMathematical_GeophysicalModel_NumericalMethodsLabel;

		/**
		 * @generated
		 */
		public Mathematical_GeophysicalModel_NumericalMethodsFigure() {

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureMathematical_GeophysicalModel_NumericalMethodsLabel = new WrappingLabel();
			fFigureMathematical_GeophysicalModel_NumericalMethodsLabel
					.setText("used in");

			this.add(fFigureMathematical_GeophysicalModel_NumericalMethodsLabel);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMathematical_GeophysicalModel_NumericalMethodsLabel() {
			return fFigureMathematical_GeophysicalModel_NumericalMethodsLabel;
		}

	}

}
