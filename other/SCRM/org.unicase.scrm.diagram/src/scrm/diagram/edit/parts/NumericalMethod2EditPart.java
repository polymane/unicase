package scrm.diagram.edit.parts;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import scrm.SCRMDiagram;
import scrm.diagram.edit.policies.NumericalMethod2ItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class NumericalMethod2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3002;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public NumericalMethod2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new NumericalMethod2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenMEEditorPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new NumericalMethodFigure();
	}

	/**
	 * @generated
	 */
	public NumericalMethodFigure getPrimaryShape() {
		return (NumericalMethodFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof NumericalMethodName2EditPart) {
			((NumericalMethodName2EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureNumericalMethod_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof NumericalMethodName2EditPart) {
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
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated NOT: adjusted size
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(135, 20);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(ScrmVisualIDRegistry
				.getType(NumericalMethodName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSource() {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM: 
			case KNOWLEDGE_DIAGRAM:
				types.add(ScrmElementTypes.NumericalMethodSolvedProblem_4057);
				types.add(ScrmElementTypes.NumericalMethodDependencies_4015);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM:	
			case KNOWLEDGE_DIAGRAM:
				if (targetEditPart instanceof ScientificProblemEditPart) {
				types.add(ScrmElementTypes.NumericalMethodSolvedProblem_4057);
				}
				if (targetEditPart instanceof ScientificProblem2EditPart) {
					types.add(ScrmElementTypes.NumericalMethodSolvedProblem_4057);
				}
				if (targetEditPart instanceof AssumptionEditPart) {
					types.add(ScrmElementTypes.NumericalMethodDependencies_4015);
				}
				if (targetEditPart instanceof Assumption2EditPart) {
					types.add(ScrmElementTypes.NumericalMethodDependencies_4015);
				}
		}
		
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM: 
			case KNOWLEDGE_DIAGRAM:
				if (relationshipType == ScrmElementTypes.NumericalMethodSolvedProblem_4057) {
					types.add(ScrmElementTypes.ScientificProblem_2007);
					types.add(ScrmElementTypes.ScientificProblem_3001);
				} else if (relationshipType == ScrmElementTypes.NumericalMethodDependencies_4015) {
					types.add(ScrmElementTypes.Assumption_2008);
					types.add(ScrmElementTypes.Assumption_3004);
				}
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM: 
				types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
				types.add(ScrmElementTypes.PerformanceDescribedMethod_4059);
			case KNOWLEDGE_DIAGRAM:
				types.add(ScrmElementTypes.MathematicalModelNumericalMethods_4011);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		List<IElementType> types = new LinkedList<IElementType>();
		switch(scrmDiagram.getDiagramType()) {
			case DEFAULT_DIAGRAM: 
				if (relationshipType == ScrmElementTypes.RequirementRealizedMethod_4050) {
					types.add(ScrmElementTypes.Process_2035);
					types.add(ScrmElementTypes.Performance_2015);
					types.add(ScrmElementTypes.InputDataReading_2036);
					types.add(ScrmElementTypes.DataHandling_2037);
					types.add(ScrmElementTypes.ResultsOutput_2038);
					types.add(ScrmElementTypes.ErrorHandling_2039);
					types.add(ScrmElementTypes.StatusMonitoring_2040);
					types.add(ScrmElementTypes.Requirement_2034);
					types.add(ScrmElementTypes.DataProcessSpace_2046);
					types.add(ScrmElementTypes.Performance_3011);
					types.add(ScrmElementTypes.Requirement_3012);
					types.add(ScrmElementTypes.StatusMonitoring_3016);
					types.add(ScrmElementTypes.ResultsOutput_3017);
					types.add(ScrmElementTypes.Process_3018);
					types.add(ScrmElementTypes.InputDataReading_3019);
					types.add(ScrmElementTypes.ErrorHandling_3020);
					types.add(ScrmElementTypes.DataHandling_3021);
					types.add(ScrmElementTypes.DataProcessSpace_3022);
					break;
				}
				if (relationshipType == ScrmElementTypes.PerformanceDescribedMethod_4059) {
					types.add(ScrmElementTypes.Performance_2015);
					types.add(ScrmElementTypes.Performance_3011);
				}
			case KNOWLEDGE_DIAGRAM:
				if (relationshipType == ScrmElementTypes.MathematicalModelNumericalMethods_4011) {
					types.add(ScrmElementTypes.MathematicalModel_2005);
					types.add(ScrmElementTypes.MathematicalModel_3003);
				}
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public class NumericalMethodFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureNumericalMethod_name;

		/**
		 * @generated NOT: adjusted size
		 */
		public NumericalMethodFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(135),
					getMapMode().DPtoLP(20)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureNumericalMethod_name = new WrappingLabel();
			fFigureNumericalMethod_name.setText("");

			fFigureNumericalMethod_name
					.setFont(FFIGURENUMERICALMETHOD_NAME_FONT);

			GridData constraintFFigureNumericalMethod_name = new GridData();
			constraintFFigureNumericalMethod_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureNumericalMethod_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureNumericalMethod_name.horizontalIndent = 0;
			constraintFFigureNumericalMethod_name.horizontalSpan = 1;
			constraintFFigureNumericalMethod_name.verticalSpan = 1;
			constraintFFigureNumericalMethod_name.grabExcessHorizontalSpace = false;
			constraintFFigureNumericalMethod_name.grabExcessVerticalSpace = false;
			this.add(fFigureNumericalMethod_name,
					constraintFFigureNumericalMethod_name);
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNumericalMethod_name() {
			return fFigureNumericalMethod_name;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 255, 204, 0);

	/**
	 * @generated
	 */
	static final Font FFIGURENUMERICALMETHOD_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 11, SWT.BOLD);

}
