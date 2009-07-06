/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.usecaseDiagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class ModelNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance().getImageRegistry().put(
			"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem
			&& !isOwnView(((org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorGroup) element;
			return org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance().getBundledImage(
				group.getIcon());
		}

		if (element instanceof org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Diagram?http://unicase.org/model/diagram?MEDiagram", org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.MEDiagram_77); //$NON-NLS-1$
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/requirement?Actor", org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.Actor_1001); //$NON-NLS-1$
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getImage(
				"Navigator?TopLevelNode?http://unicase.org/model/requirement?UseCase", org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCase_1002); //$NON-NLS-1$
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/requirement?Actor?participatedUseCases", org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_3001); //$NON-NLS-1$
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/requirement?Actor?initiatedUseCases", org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_3002); //$NON-NLS-1$
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/requirement?UseCase?includedUseCases", org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_3003); //$NON-NLS-1$
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID:
			return getImage(
				"Navigator?Link?http://unicase.org/model/requirement?UseCase?extendedUseCases", org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_3004); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance()
			.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
			&& org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.isKnownElementType(elementType)) {
			image = org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.usecaseDiagram.navigator.ModelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case org.unicase.ui.usecaseDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_77Text(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_1001Text(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseEditPart.VISUAL_ID:
			return getUseCase_1002Text(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID:
			return getActorParticipatedUseCases_3001Text(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID:
			return getActorInitiatedUseCases_3002Text(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID:
			return getUseCaseIncludedUseCases_3003Text(view);
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID:
			return getUseCaseExtendedUseCases_3004Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getMEDiagram_77Text(View view) {
		MEDiagram domainModelElement = (MEDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
				"No domain element for view with visualID = " + 77); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getActor_1001Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.usecaseDiagram.providers.ModelParserProvider.HintAdapter(
			org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.Actor_1001, (view.getElement() != null ? view
				.getElement() : view), org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.usecaseDiagram.edit.parts.ActorNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUseCase_1002Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.usecaseDiagram.providers.ModelParserProvider.HintAdapter(
			org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCase_1002, (view.getElement() != null ? view
				.getElement() : view), org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.usecaseDiagram.edit.parts.UseCaseNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin.getInstance().logError(
				"Parser was not found for label " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getActorParticipatedUseCases_3001Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.usecaseDiagram.providers.ModelParserProvider.HintAdapter(
			org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_3001, (view
				.getElement() != null ? view.getElement() : view),
			org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.usecaseDiagram.edit.parts.LabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getActorInitiatedUseCases_3002Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.usecaseDiagram.providers.ModelParserProvider.HintAdapter(
			org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_3002,
			(view.getElement() != null ? view.getElement() : view),
			org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.usecaseDiagram.edit.parts.Label2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUseCaseIncludedUseCases_3003Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.usecaseDiagram.providers.ModelParserProvider.HintAdapter(
			org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_3003,
			(view.getElement() != null ? view.getElement() : view),
			org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.usecaseDiagram.edit.parts.IncludeLabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUseCaseExtendedUseCases_3004Text(View view) {

		IAdaptable hintAdapter = new org.unicase.ui.usecaseDiagram.providers.ModelParserProvider.HintAdapter(
			org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_3004,
			(view.getElement() != null ? view.getElement() : view),
			org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.ui.usecaseDiagram.edit.parts.ExtendLabelEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);
		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return org.unicase.ui.usecaseDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
			.equals(org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry.getModelID(view));
	}

}
