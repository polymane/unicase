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

import scrm.diagram.edit.policies.InterfaceDetailsOfRequiringFunctionsAndPropertiesItemSemanticEditPolicy;

/**
 * @generated
 */
public class InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart extends
		ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4071;

	/**
	 * @generated
	 */
	public InterfaceDetailsOfRequiringFunctionsAndPropertiesEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new InterfaceDetailsOfRequiringFunctionsAndPropertiesItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel24EditPart) {
			((WrappingLabel24EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureInterface_DetailsOfRequiringFunctionsAndPropertiesLabel());
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
		if (childEditPart instanceof WrappingLabel24EditPart) {
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
		return new Interface_DetailsOfRequiringFunctionsAndPropertiesFigure();
	}

	/**
	 * @generated
	 */
	public Interface_DetailsOfRequiringFunctionsAndPropertiesFigure getPrimaryShape() {
		return (Interface_DetailsOfRequiringFunctionsAndPropertiesFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Interface_DetailsOfRequiringFunctionsAndPropertiesFigure
			extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureInterface_DetailsOfRequiringFunctionsAndPropertiesLabel;

		/**
		 * @generated
		 */
		public Interface_DetailsOfRequiringFunctionsAndPropertiesFigure() {

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureInterface_DetailsOfRequiringFunctionsAndPropertiesLabel = new WrappingLabel();
			fFigureInterface_DetailsOfRequiringFunctionsAndPropertiesLabel
					.setText("requiring details");

			this.add(fFigureInterface_DetailsOfRequiringFunctionsAndPropertiesLabel);

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
		public WrappingLabel getFigureInterface_DetailsOfRequiringFunctionsAndPropertiesLabel() {
			return fFigureInterface_DetailsOfRequiringFunctionsAndPropertiesLabel;
		}

	}

}
