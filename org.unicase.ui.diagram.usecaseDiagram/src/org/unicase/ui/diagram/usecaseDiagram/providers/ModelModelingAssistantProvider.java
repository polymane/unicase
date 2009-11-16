/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.ui.common.diagram.providers.ModelingAssistantProvider;

/**
 * @generated
 */

public class ModelModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.MEDiagramEditPart) {
			List types = new ArrayList();
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.Actor_2001);
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart) {
			List types = new ArrayList();
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001);
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002);
			return types;
		}
		if (sourceEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
			List types = new ArrayList();
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003);
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
			List types = new ArrayList();
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001);
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002);
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003);
			types
					.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001);
			}
			if (targetEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002);
			}
			return types;
		}
		if (sourceEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003);
			}
			if (targetEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
			List types = new ArrayList();
			if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.Actor_2001);
			}
			if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.Actor_2001);
			}
			if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
			}
			if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorEditPart) {
			List types = new ArrayList();
			if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
			}
			if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
			}
			return types;
		}
		if (sourceEditPart instanceof org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseEditPart) {
			List types = new ArrayList();
			if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
			}
			if (relationshipType == org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004) {
				types
						.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin
						.getInstance().getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog
				.setMessage(org.unicase.ui.diagram.usecaseDiagram.part.Messages.ModelModelingAssistantProviderMessage);
		dialog
				.setTitle(org.unicase.ui.diagram.usecaseDiagram.part.Messages.ModelModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
