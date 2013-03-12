/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;
import org.unicase.uiModeling.diagram.UiModelingConstants;
import org.unicase.uiModeling.diagram.util.UiModelingDiagramUtil;

/**
 * @generated
 */
public class DropdownList2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3011;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * The x-coordinate of this edit part's figure.
	 */
	private int x;

	/**
	 * The y-coordinate of this edit part's figure.
	 */
	private int y;

	/**
	 * The width of this edit part's figure.
	 */
	private int width;

	/**
	 * The height of this edit part's figure.
	 */
	private int height;

	/**
	 * @generated
	 */
	public DropdownList2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(
			org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new org.unicase.uiModeling.diagram.edit.policies.DropdownList2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
		// editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
	 * {@inheritDoc}
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object notifier = notification.getNotifier();
		Object feature = notification.getFeature();
		EObject element = EditPartUtility.getElement(this);

		// only change layout if this element or the diagram element changed
		if (getDiagramView() == notifier) {
			if (UiModelingConstants.POSITIONING_ENABLED.equals(feature)) {
				boolean positioningEnabled = notification.getNewBooleanValue();
				if (positioningEnabled) {
					// TODO: set values of edit part to widget OR widget to editpart
				}
			} else if (UiModelingConstants.SIZING_ENABLED.equals(feature)) {
				boolean sizingEnabled = notification.getNewBooleanValue();
				if (sizingEnabled) {
					// TODO: set values of edit part to widget OR widget to editpart
				}
			}
		} else if (element == notifier) {
			if (UiModelingDiagramUtil.isPositioningEnabled(element)) {
				if (UiModelingConstants.WIDGET_X.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (x != newValue) {
						x = newValue;
						UiModelingDiagramUtil.setViewFeature(this, UiModelingConstants.NOTATION_X, newValue);
					}
				} else if (UiModelingConstants.WIDGET_Y.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (y != newValue) {
						y = newValue;
						UiModelingDiagramUtil.setViewFeature(this, UiModelingConstants.NOTATION_Y, newValue);
					}
				}
			}
			if (UiModelingDiagramUtil.isSizingEnabled(element)) {
				if (UiModelingConstants.WIDGET_WIDTH.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (width != newValue) {
						width = newValue;
						UiModelingDiagramUtil.setViewFeature(this, UiModelingConstants.NOTATION_WIDTH, newValue);
					}
				} else if (UiModelingConstants.WIDGET_HEIGHT.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (height != newValue) {
						height = newValue;
						UiModelingDiagramUtil.setViewFeature(this, UiModelingConstants.NOTATION_HEIGHT, newValue);
					}
				}
			}
		} else {
			if (UiModelingDiagramUtil.isPositioningEnabled(element)) {
				if (UiModelingConstants.NOTATION_X.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (x != newValue) {
						UiModelingDiagramUtil.setElementFeature(this, UiModelingConstants.WIDGET_X, newValue);
					}
				} else if (UiModelingConstants.NOTATION_Y.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (y != newValue) {
						UiModelingDiagramUtil.setElementFeature(this, UiModelingConstants.WIDGET_Y, newValue);
					}
				}
			}
			if (UiModelingDiagramUtil.isSizingEnabled(element)) {
				if (UiModelingConstants.NOTATION_WIDTH.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (width != newValue) {
						UiModelingDiagramUtil.setElementFeature(this, UiModelingConstants.WIDGET_WIDTH, newValue);
					}
				} else if (UiModelingConstants.NOTATION_HEIGHT.equals(feature)) {
					int newValue = notification.getNewIntValue();
					if (height != newValue) {
						UiModelingDiagramUtil.setElementFeature(this, UiModelingConstants.WIDGET_HEIGHT, newValue);
					}
				}
			}
		}
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new DropdownListDescriptor();
	}

	/**
	 * @generated
	 */
	public DropdownListDescriptor getPrimaryShape() {
		return (DropdownListDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.WrappingLabel2EditPart) {
			((org.unicase.uiModeling.diagram.edit.parts.WrappingLabel2EditPart) childEditPart)
				.setLabel(getPrimaryShape().getDropdownList_text());
			return true;
		}
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getDropdownList_items();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart) childEditPart)
				.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.WrappingLabel2EditPart) {
			return true;
		}
		if (childEditPart instanceof org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getDropdownList_items();
			pane.remove(((org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart) childEditPart)
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
		if (editPart instanceof org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart) {
			return getPrimaryShape().getDropdownList_items();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part. Body of this method does not depend on settings in generation model so you may
	 * safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane. Respects layout one may have set for generated
	 * figure.
	 * 
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
		return getChildBySemanticHint(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
			.getType(org.unicase.uiModeling.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
				.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == org.unicase.uiModeling.diagram.providers.UiModelingElementTypes.DropdownItem_3008) {
				return getChildBySemanticHint(org.unicase.uiModeling.diagram.part.UiModelingVisualIDRegistry
					.getType(org.unicase.uiModeling.diagram.edit.parts.DropdownListDropdownItemsCompartment2EditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class DropdownListDescriptor extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fDropdownList_text;
		/**
		 * @generated
		 */
		private RectangleFigure fDropdownList_items;

		/**
		 * @generated
		 */
		public DropdownListDescriptor() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fDropdownList_text = new WrappingLabel();

			fDropdownList_text.setText("<Please select>");

			fDropdownList_text.setFont(FDROPDOWNLIST_TEXT_FONT);

			GridData constraintFDropdownList_text = new GridData();
			constraintFDropdownList_text.verticalAlignment = GridData.BEGINNING;
			constraintFDropdownList_text.horizontalAlignment = GridData.FILL;
			constraintFDropdownList_text.horizontalIndent = 0;
			constraintFDropdownList_text.horizontalSpan = 1;
			constraintFDropdownList_text.verticalSpan = 1;
			constraintFDropdownList_text.grabExcessHorizontalSpace = true;
			constraintFDropdownList_text.grabExcessVerticalSpace = false;
			this.add(fDropdownList_text, constraintFDropdownList_text);

			fDropdownList_items = new RectangleFigure();

			fDropdownList_items.setOutline(false);

			GridData constraintFDropdownList_items = new GridData();
			constraintFDropdownList_items.verticalAlignment = GridData.FILL;
			constraintFDropdownList_items.horizontalAlignment = GridData.FILL;
			constraintFDropdownList_items.horizontalIndent = 0;
			constraintFDropdownList_items.horizontalSpan = 1;
			constraintFDropdownList_items.verticalSpan = 1;
			constraintFDropdownList_items.grabExcessHorizontalSpace = true;
			constraintFDropdownList_items.grabExcessVerticalSpace = true;
			this.add(fDropdownList_items, constraintFDropdownList_items);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getDropdownList_text() {
			return fDropdownList_text;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getDropdownList_items() {
			return fDropdownList_items;
		}

	}

	/**
	 * @generated
	 */
	static final Font FDROPDOWNLIST_TEXT_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

}
