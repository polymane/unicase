package scrm.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LabeledContainer;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import scrm.diagram.edit.policies.DataProcessSpaceItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenDiagramEditPolicy;
import scrm.diagram.opener.OpenSCRMSpaceEditPolicy;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class DataProcessSpaceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2046;

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
	public DataProcessSpaceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new DataProcessSpaceItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenSCRMSpaceEditPolicy());
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
		return primaryShape = new LabeledContainer();
	}

	/**
	 * @generated
	 */
	public LabeledContainer getPrimaryShape() {
		return (LabeledContainer) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(4);
		types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
		types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
		types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		types.add(ScrmElementTypes.ProcessSuccessor_4047);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof NumericalMethodEditPart) {
			types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
		}
		if (targetEditPart instanceof NumericalMethod2EditPart) {
			types.add(ScrmElementTypes.RequirementRealizedMethod_4050);
		}
		if (targetEditPart instanceof FeatureEditPart) {
			types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
		}
		if (targetEditPart instanceof Feature2EditPart) {
			types.add(ScrmElementTypes.RequirementSpecifiedFeature_4052);
		}
		if (targetEditPart instanceof ProcessEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof PerformanceEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof InputDataReadingEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof DataHandlingEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof ResultsOutputEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof ErrorHandlingEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof StatusMonitoringEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof RequirementEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof scrm.diagram.edit.parts.DataProcessSpaceEditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof Performance2EditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof Requirement2EditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof StatusMonitoring2EditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof ResultsOutput2EditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof Process2EditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof InputDataReading2EditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof ErrorHandling2EditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof DataHandling2EditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof DataProcessSpace2EditPart) {
			types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		}
		if (targetEditPart instanceof ProcessEditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof InputDataReadingEditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof DataHandlingEditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof ResultsOutputEditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof ErrorHandlingEditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof StatusMonitoringEditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof scrm.diagram.edit.parts.DataProcessSpaceEditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof StatusMonitoring2EditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof ResultsOutput2EditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof Process2EditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof InputDataReading2EditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof ErrorHandling2EditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof DataHandling2EditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		if (targetEditPart instanceof DataProcessSpace2EditPart) {
			types.add(ScrmElementTypes.ProcessSuccessor_4047);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.RequirementRealizedMethod_4050) {
			types.add(ScrmElementTypes.NumericalMethod_2006);
			types.add(ScrmElementTypes.NumericalMethod_3002);
		} else if (relationshipType == ScrmElementTypes.RequirementSpecifiedFeature_4052) {
			types.add(ScrmElementTypes.Feature_2009);
			types.add(ScrmElementTypes.Feature_3009);
		} else if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
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
		} else if (relationshipType == ScrmElementTypes.ProcessSuccessor_4047) {
			types.add(ScrmElementTypes.Process_2035);
			types.add(ScrmElementTypes.InputDataReading_2036);
			types.add(ScrmElementTypes.DataHandling_2037);
			types.add(ScrmElementTypes.ResultsOutput_2038);
			types.add(ScrmElementTypes.ErrorHandling_2039);
			types.add(ScrmElementTypes.StatusMonitoring_2040);
			types.add(ScrmElementTypes.DataProcessSpace_2046);
			types.add(ScrmElementTypes.StatusMonitoring_3016);
			types.add(ScrmElementTypes.ResultsOutput_3017);
			types.add(ScrmElementTypes.Process_3018);
			types.add(ScrmElementTypes.InputDataReading_3019);
			types.add(ScrmElementTypes.ErrorHandling_3020);
			types.add(ScrmElementTypes.DataHandling_3021);
			types.add(ScrmElementTypes.DataProcessSpace_3022);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(4);
		types.add(ScrmElementTypes.RequirementRefinedRequirement_4054);
		types.add(ScrmElementTypes.DataDefinitionDefinedRequirement_4055);
		types.add(ScrmElementTypes.DataFlowSpecifiedProcess_4056);
		types.add(ScrmElementTypes.ProcessSuccessor_4047);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == ScrmElementTypes.RequirementRefinedRequirement_4054) {
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
		} else if (relationshipType == ScrmElementTypes.DataDefinitionDefinedRequirement_4055) {
			types.add(ScrmElementTypes.DataDefinition_2017);
			types.add(ScrmElementTypes.DataDefinition_3007);
		} else if (relationshipType == ScrmElementTypes.DataFlowSpecifiedProcess_4056) {
			types.add(ScrmElementTypes.DataFlow_2016);
			types.add(ScrmElementTypes.DataFlow_3008);
		} else if (relationshipType == ScrmElementTypes.ProcessSuccessor_4047) {
			types.add(ScrmElementTypes.Process_2035);
			types.add(ScrmElementTypes.InputDataReading_2036);
			types.add(ScrmElementTypes.DataHandling_2037);
			types.add(ScrmElementTypes.ResultsOutput_2038);
			types.add(ScrmElementTypes.ErrorHandling_2039);
			types.add(ScrmElementTypes.StatusMonitoring_2040);
			types.add(ScrmElementTypes.DataProcessSpace_2046);
			types.add(ScrmElementTypes.StatusMonitoring_3016);
			types.add(ScrmElementTypes.ResultsOutput_3017);
			types.add(ScrmElementTypes.Process_3018);
			types.add(ScrmElementTypes.InputDataReading_3019);
			types.add(ScrmElementTypes.ErrorHandling_3020);
			types.add(ScrmElementTypes.DataHandling_3021);
			types.add(ScrmElementTypes.DataProcessSpace_3022);
		}
		return types;
	}

}