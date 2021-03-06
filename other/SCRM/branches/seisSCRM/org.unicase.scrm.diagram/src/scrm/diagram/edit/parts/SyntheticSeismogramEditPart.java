package scrm.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
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
import scrm.diagram.edit.policies.OpenMEEditorPolicy;
import scrm.diagram.edit.policies.SyntheticSeismogramItemSemanticEditPolicy;
import scrm.diagram.part.ScrmVisualIDRegistry;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class SyntheticSeismogramEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2055;

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
	public SyntheticSeismogramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SyntheticSeismogramItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenMEEditorPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
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
		return primaryShape = new SyntheticSeismogramFigure();
	}

	/**
	 * @generated
	 */
	public SyntheticSeismogramFigure getPrimaryShape() {
		return (SyntheticSeismogramFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SyntheticSeismogramNameEditPart) {
			((SyntheticSeismogramNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSyntheticSeismogram_name());
			return true;
		}
		if (childEditPart instanceof SyntheticSeismogramDescriptionEditPart) {
			((SyntheticSeismogramDescriptionEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSyntheticSeismogram_description());
			return true;
		}
		if (childEditPart instanceof SyntheticSeismogramAccuracyEditPart) {
			((SyntheticSeismogramAccuracyEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSyntheticSeismogram_accuracy());
			return true;
		}
		if (childEditPart instanceof SyntheticSeismogramFormatEditPart) {
			((SyntheticSeismogramFormatEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSyntheticSeismogram_format());
			return true;
		}
		if (childEditPart instanceof SyntheticSeismogramRangeEditPart) {
			((SyntheticSeismogramRangeEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSyntheticSeismogram_range());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SyntheticSeismogramNameEditPart) {
			return true;
		}
		if (childEditPart instanceof SyntheticSeismogramDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof SyntheticSeismogramAccuracyEditPart) {
			return true;
		}
		if (childEditPart instanceof SyntheticSeismogramFormatEditPart) {
			return true;
		}
		if (childEditPart instanceof SyntheticSeismogramRangeEditPart) {
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
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(195, 120);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
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
				.getType(SyntheticSeismogramNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case REQUIREMENTS_DIAGRAM:
			types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			types.add(ScrmElementTypes.DataDefinitionProvidedInterface_4076);
			types.add(ScrmElementTypes.DataDefinitionRequiredInterface_4077);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case REQUIREMENTS_DIAGRAM:
			if (targetEditPart instanceof RequirementEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof PerformanceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof ProcessEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof InputDataReadingEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof ResultsOutputEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof ErrorHandlingEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof StatusMonitoringEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof SolverEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof MeshCreationEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof PreProcessingEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof PostProcessingEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof DataProcessSpaceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof Requirement2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof Performance2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof Process2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof InputDataReading2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof ResultsOutput2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof ErrorHandling2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof StatusMonitoring2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof Solver2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof MeshCreation2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof PreProcessing2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof PostProcessing2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof DataProcessSpace2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4075);
			}
			if (targetEditPart instanceof UserInterfaceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionProvidedInterface_4076);
			}
			if (targetEditPart instanceof SoftwareInterfaceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionProvidedInterface_4076);
			}
			if (targetEditPart instanceof UserInterface2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionProvidedInterface_4076);
			}
			if (targetEditPart instanceof SoftwareInterface2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionProvidedInterface_4076);
			}
			if (targetEditPart instanceof UserInterfaceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionRequiredInterface_4077);
			}
			if (targetEditPart instanceof SoftwareInterfaceEditPart) {
				types.add(ScrmElementTypes.DataDefinitionRequiredInterface_4077);
			}
			if (targetEditPart instanceof UserInterface2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionRequiredInterface_4077);
			}
			if (targetEditPart instanceof SoftwareInterface2EditPart) {
				types.add(ScrmElementTypes.DataDefinitionRequiredInterface_4077);
			}
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
		case REQUIREMENTS_DIAGRAM:
			if (relationshipType == ScrmElementTypes.DataDefinitionDefinedRequirement_4075) {
				types.add(ScrmElementTypes.Requirement_2034);
				types.add(ScrmElementTypes.Performance_2015);
				types.add(ScrmElementTypes.Process_2035);
				types.add(ScrmElementTypes.InputDataReading_2036);
				types.add(ScrmElementTypes.ResultsOutput_2038);
				types.add(ScrmElementTypes.ErrorHandling_2039);
				types.add(ScrmElementTypes.StatusMonitoring_2040);
				types.add(ScrmElementTypes.Solver_2048);
				types.add(ScrmElementTypes.MeshCreation_2049);
				types.add(ScrmElementTypes.PreProcessing_2050);
				types.add(ScrmElementTypes.PostProcessing_2051);
				types.add(ScrmElementTypes.DataProcessSpace_2046);
				types.add(ScrmElementTypes.Requirement_3012);
				types.add(ScrmElementTypes.Performance_3011);
				types.add(ScrmElementTypes.Process_3025);
				types.add(ScrmElementTypes.InputDataReading_3026);
				types.add(ScrmElementTypes.ResultsOutput_3024);
				types.add(ScrmElementTypes.ErrorHandling_3027);
				types.add(ScrmElementTypes.StatusMonitoring_3023);
				types.add(ScrmElementTypes.Solver_3031);
				types.add(ScrmElementTypes.MeshCreation_3032);
				types.add(ScrmElementTypes.PreProcessing_3033);
				types.add(ScrmElementTypes.PostProcessing_3034);
				types.add(ScrmElementTypes.DataProcessSpace_3029);
			} else if (relationshipType == ScrmElementTypes.DataDefinitionProvidedInterface_4076) {
				types.add(ScrmElementTypes.UserInterface_2012);
				types.add(ScrmElementTypes.SoftwareInterface_2013);
				types.add(ScrmElementTypes.UserInterface_3014);
				types.add(ScrmElementTypes.SoftwareInterface_3013);
			} else if (relationshipType == ScrmElementTypes.DataDefinitionRequiredInterface_4077) {
				types.add(ScrmElementTypes.UserInterface_2012);
				types.add(ScrmElementTypes.SoftwareInterface_2013);
				types.add(ScrmElementTypes.UserInterface_3014);
				types.add(ScrmElementTypes.SoftwareInterface_3013);
			}
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
			types.add(ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		SCRMDiagram scrmDiagram = (SCRMDiagram) getDiagramView().getElement();
		switch (scrmDiagram.getDiagramType()) {
		case DEFAULT_DIAGRAM:
			if (relationshipType == ScrmElementTypes.Mathematical_GeophysicalModelInvolvedData_4067) {
				types.add(ScrmElementTypes.Mathematical_GeophysicalModel_2047);
				types.add(ScrmElementTypes.Mathematical_GeophysicalModel_3030);
			}
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class SyntheticSeismogramFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureSyntheticSeismogram_name;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSyntheticSeismogram_description;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSyntheticSeismogram_accuracy;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSyntheticSeismogram_range;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSyntheticSeismogram_format;

		/**
		 * @generated NOT: adjusted size
		 */
		public SyntheticSeismogramFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(32),
					getMapMode().DPtoLP(32)));
			this.setBackgroundColor(THIS_BACK);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(195),
					getMapMode().DPtoLP(120)));
			createContents();
		}

		/**
		 * @generated NOT: enabled text wrap
		 */
		private void createContents() {

			fFigureSyntheticSeismogram_name = new WrappingLabel();
			fFigureSyntheticSeismogram_name.setText("");

			fFigureSyntheticSeismogram_name
					.setFont(FFIGURESYNTHETICSEISMOGRAM_NAME_FONT);

			GridData constraintFFigureSyntheticSeismogram_name = new GridData();
			constraintFFigureSyntheticSeismogram_name.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSyntheticSeismogram_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureSyntheticSeismogram_name.horizontalIndent = 0;
			constraintFFigureSyntheticSeismogram_name.horizontalSpan = 1;
			constraintFFigureSyntheticSeismogram_name.verticalSpan = 1;
			constraintFFigureSyntheticSeismogram_name.grabExcessHorizontalSpace = false;
			constraintFFigureSyntheticSeismogram_name.grabExcessVerticalSpace = false;
			this.add(fFigureSyntheticSeismogram_name,
					constraintFFigureSyntheticSeismogram_name);

			fFigureSyntheticSeismogram_description = new WrappingLabel();
			fFigureSyntheticSeismogram_description.setText("");
			fFigureSyntheticSeismogram_description.setTextWrap(true);

			GridData constraintFFigureSyntheticSeismogram_description = new GridData();
			constraintFFigureSyntheticSeismogram_description.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSyntheticSeismogram_description.horizontalAlignment = GridData.FILL;
			constraintFFigureSyntheticSeismogram_description.horizontalIndent = 0;
			constraintFFigureSyntheticSeismogram_description.horizontalSpan = 1;
			constraintFFigureSyntheticSeismogram_description.verticalSpan = 1;
			constraintFFigureSyntheticSeismogram_description.grabExcessHorizontalSpace = true;
			constraintFFigureSyntheticSeismogram_description.grabExcessVerticalSpace = false;
			this.add(fFigureSyntheticSeismogram_description,
					constraintFFigureSyntheticSeismogram_description);

			fFigureSyntheticSeismogram_accuracy = new WrappingLabel();
			fFigureSyntheticSeismogram_accuracy.setText("");
			fFigureSyntheticSeismogram_accuracy.setTextWrap(true);

			GridData constraintFFigureSyntheticSeismogram_accuracy = new GridData();
			constraintFFigureSyntheticSeismogram_accuracy.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSyntheticSeismogram_accuracy.horizontalAlignment = GridData.FILL;
			constraintFFigureSyntheticSeismogram_accuracy.horizontalIndent = 0;
			constraintFFigureSyntheticSeismogram_accuracy.horizontalSpan = 1;
			constraintFFigureSyntheticSeismogram_accuracy.verticalSpan = 1;
			constraintFFigureSyntheticSeismogram_accuracy.grabExcessHorizontalSpace = true;
			constraintFFigureSyntheticSeismogram_accuracy.grabExcessVerticalSpace = false;
			this.add(fFigureSyntheticSeismogram_accuracy,
					constraintFFigureSyntheticSeismogram_accuracy);

			fFigureSyntheticSeismogram_range = new WrappingLabel();
			fFigureSyntheticSeismogram_range.setText("");
			fFigureSyntheticSeismogram_range.setTextWrap(true);

			GridData constraintFFigureSyntheticSeismogram_range = new GridData();
			constraintFFigureSyntheticSeismogram_range.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSyntheticSeismogram_range.horizontalAlignment = GridData.FILL;
			constraintFFigureSyntheticSeismogram_range.horizontalIndent = 0;
			constraintFFigureSyntheticSeismogram_range.horizontalSpan = 1;
			constraintFFigureSyntheticSeismogram_range.verticalSpan = 1;
			constraintFFigureSyntheticSeismogram_range.grabExcessHorizontalSpace = true;
			constraintFFigureSyntheticSeismogram_range.grabExcessVerticalSpace = false;
			this.add(fFigureSyntheticSeismogram_range,
					constraintFFigureSyntheticSeismogram_range);

			fFigureSyntheticSeismogram_format = new WrappingLabel();
			fFigureSyntheticSeismogram_format.setText("");
			fFigureSyntheticSeismogram_format.setTextWrap(true);

			GridData constraintFFigureSyntheticSeismogram_format = new GridData();
			constraintFFigureSyntheticSeismogram_format.verticalAlignment = GridData.BEGINNING;
			constraintFFigureSyntheticSeismogram_format.horizontalAlignment = GridData.FILL;
			constraintFFigureSyntheticSeismogram_format.horizontalIndent = 0;
			constraintFFigureSyntheticSeismogram_format.horizontalSpan = 1;
			constraintFFigureSyntheticSeismogram_format.verticalSpan = 1;
			constraintFFigureSyntheticSeismogram_format.grabExcessHorizontalSpace = true;
			constraintFFigureSyntheticSeismogram_format.grabExcessVerticalSpace = false;
			this.add(fFigureSyntheticSeismogram_format,
					constraintFFigureSyntheticSeismogram_format);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSyntheticSeismogram_name() {
			return fFigureSyntheticSeismogram_name;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSyntheticSeismogram_description() {
			return fFigureSyntheticSeismogram_description;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSyntheticSeismogram_accuracy() {
			return fFigureSyntheticSeismogram_accuracy;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSyntheticSeismogram_range() {
			return fFigureSyntheticSeismogram_range;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSyntheticSeismogram_format() {
			return fFigureSyntheticSeismogram_format;
		}

	}

	/**
	 * @generated NOT: adjusted color
	 */
	static final Color THIS_BACK = new Color(null, 51, 255, 102);

	/**
	 * @generated
	 */
	static final Font FFIGURESYNTHETICSEISMOGRAM_NAME_FONT = new Font(
			Display.getCurrent(), "Arial", 9, SWT.BOLD);

}
