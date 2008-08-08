package org.unicase.model.classDiagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented by
 * a domain model object.
 * 
 * @generated
 */
public class ModelVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.unicase.classDiagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
					.equals(view.getType())) {
				return org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.getInstance().logError(
								"Unable to parse view type as a visualID number: "
										+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (DiagramPackage.eINSTANCE.getMEDiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((MEDiagram) domainElement)) {
			return org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getModelID(containerView);
		if (!org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
			if (ClassesPackage.eINSTANCE.getAttribute().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
			if (ClassesPackage.eINSTANCE.getMethod().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			if (ClassesPackage.eINSTANCE.getClass_().isSuperTypeOf(
					domainElement.eClass())) {
				return org.unicase.model.classDiagram.edit.parts.MEDiagram2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getModelID(containerView);
		if (!org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case org.unicase.model.classDiagram.edit.parts.MEDiagram2EditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.ClassClassNode_attributesEditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.AttributeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.ClassClassNode_methodsEditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.MethodEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.MEDiagram2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case org.unicase.model.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID:
			if (org.unicase.model.classDiagram.edit.parts.AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (ClassesPackage.eINSTANCE.getAssociation().isSuperTypeOf(
				domainElement.eClass())) {
			return org.unicase.model.classDiagram.edit.parts.AssociationEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(MEDiagram element) {
		return true;
	}

}
