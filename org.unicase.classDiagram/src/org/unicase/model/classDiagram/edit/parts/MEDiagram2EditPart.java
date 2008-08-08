package org.unicase.model.classDiagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class MEDiagram2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1001;

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
	public MEDiagram2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy() {
					public Command getCommand(Request request) {
						if (understandsRequest(request)) {
							if (request instanceof CreateViewAndElementRequest) {
								CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
										.getViewAndElementDescriptor()
										.getCreateElementRequestAdapter();
								IElementType type = (IElementType) adapter
										.getAdapter(IElementType.class);
								if (type == org.unicase.model.classDiagram.providers.ModelElementTypes.Attribute_2001) {
									EditPart compartmentEditPart = getChildBySemanticHint(org.unicase.model.classDiagram.part.ModelVisualIDRegistry
											.getType(org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID));
									return compartmentEditPart == null ? null
											: compartmentEditPart
													.getCommand(request);
								}
								if (type == org.unicase.model.classDiagram.providers.ModelElementTypes.Method_2002) {
									EditPart compartmentEditPart = getChildBySemanticHint(org.unicase.model.classDiagram.part.ModelVisualIDRegistry
											.getType(org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID));
									return compartmentEditPart == null ? null
											: compartmentEditPart
													.getCommand(request);
								}
							}
							return super.getCommand(request);
						}
						return null;
					}
				});
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.model.classDiagram.edit.policies.MEDiagram2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new org.unicase.model.classDiagram.edit.policies.ModelTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ClassFigure figure = new ClassFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ClassFigure getPrimaryShape() {
		return (ClassFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.model.classDiagram.edit.parts.WrappingLabelEditPart) {
			((org.unicase.model.classDiagram.edit.parts.WrappingLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureClassFigure_name());
			return true;
		}
		if (childEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_attributes();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart) childEditPart)
							.getFigure());
			return true;
		}
		if (childEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_methods();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_attributes();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart) childEditPart)
							.getFigure());
			return true;
		}
		if (childEditPart instanceof org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_methods();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart) childEditPart)
							.getFigure());
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

		if (editPart instanceof org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart) {
			return getPrimaryShape().getFigureClassFigure_attributes();
		}
		if (editPart instanceof org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart) {
			return getPrimaryShape().getFigureClassFigure_methods();
		}
		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(40), getMapMode().DPtoLP(40));
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
			layout.setSpacing(getMapMode().DPtoLP(5));
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.model.classDiagram.edit.parts.WrappingLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ClassFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureClassFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureClassFigure_attributes;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureClassFigure_methods;

		/**
		 * @generated
		 */
		public ClassFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure classFigure_Header0 = new RectangleFigure();
			classFigure_Header0.setBorder(new LineBorder(null, getMapMode()
					.DPtoLP(1)));

			this.add(classFigure_Header0);

			ToolbarLayout layoutClassFigure_Header0 = new ToolbarLayout();
			layoutClassFigure_Header0.setStretchMinorAxis(true);
			layoutClassFigure_Header0
					.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutClassFigure_Header0.setSpacing(0);
			layoutClassFigure_Header0.setVertical(true);

			classFigure_Header0.setLayoutManager(layoutClassFigure_Header0);

			RectangleFigure classFigure_NameContainer1 = new RectangleFigure();
			classFigure_NameContainer1.setOutline(false);

			classFigure_Header0.add(classFigure_NameContainer1);

			org.unicase.model.classDiagram.unicase.CenterLayout layoutClassFigure_NameContainer1 = new org.unicase.model.classDiagram.unicase.CenterLayout();

			classFigure_NameContainer1
					.setLayoutManager(layoutClassFigure_NameContainer1);

			fFigureClassFigure_name = new WrappingLabel();
			fFigureClassFigure_name.setText("");

			fFigureClassFigure_name.setFont(FFIGURECLASSFIGURE_NAME_FONT);

			fFigureClassFigure_name.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(0), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5)));

			classFigure_NameContainer1.add(fFigureClassFigure_name);

			fFigureClassFigure_attributes = new RectangleFigure();

			this.add(fFigureClassFigure_attributes);
			fFigureClassFigure_attributes.setLayoutManager(new StackLayout());

			fFigureClassFigure_methods = new RectangleFigure();

			this.add(fFigureClassFigure_methods);
			fFigureClassFigure_methods.setLayoutManager(new StackLayout());

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureClassFigure_name() {
			return fFigureClassFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureClassFigure_attributes() {
			return fFigureClassFigure_attributes;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureClassFigure_methods() {
			return fFigureClassFigure_methods;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURECLASSFIGURE_NAME_FONT = new Font(Display
			.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9,
			SWT.NORMAL);

}
