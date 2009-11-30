/** 
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stateDiagram.navigator;

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
import org.unicase.model.state.StateEnd;
import org.unicase.model.state.StateInitial;

/**
 * @generated
 */
public class ModelNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		org.unicase.ui.stateDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		org.unicase.ui.stateDiagram.part.ModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem
				&& !isOwnView(((org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof org.unicase.ui.stateDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.stateDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.stateDiagram.navigator.ModelNavigatorGroup) element;
			return org.unicase.ui.stateDiagram.part.ModelDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.stateDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://unicase.org/model/diagram?MEDiagram", org.unicase.ui.stateDiagram.providers.ModelElementTypes.MEDiagram_55); //$NON-NLS-1$
		case org.unicase.ui.stateDiagram.edit.parts.StateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/state?State", org.unicase.ui.stateDiagram.providers.ModelElementTypes.State_2001); //$NON-NLS-1$
		case org.unicase.ui.stateDiagram.edit.parts.StateInitialEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/state?StateInitial", org.unicase.ui.stateDiagram.providers.ModelElementTypes.StateInitial_2002); //$NON-NLS-1$
		case org.unicase.ui.stateDiagram.edit.parts.StateEndEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://unicase.org/model/state?StateEnd", org.unicase.ui.stateDiagram.providers.ModelElementTypes.StateEnd_2003); //$NON-NLS-1$
		case org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://unicase.org/model/state?Transition", org.unicase.ui.stateDiagram.providers.ModelElementTypes.Transition_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = org.unicase.ui.stateDiagram.part.ModelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& org.unicase.ui.stateDiagram.providers.ModelElementTypes
						.isKnownElementType(elementType)) {
			image = org.unicase.ui.stateDiagram.providers.ModelElementTypes
					.getImage(elementType);
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
		if (element instanceof org.unicase.ui.stateDiagram.navigator.ModelNavigatorGroup) {
			org.unicase.ui.stateDiagram.navigator.ModelNavigatorGroup group = (org.unicase.ui.stateDiagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem) {
			org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem navigatorItem = (org.unicase.ui.stateDiagram.navigator.ModelNavigatorItem) element;
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
		switch (org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
				.getVisualID(view)) {
		case org.unicase.ui.stateDiagram.edit.parts.MEDiagramEditPart.VISUAL_ID:
			return getMEDiagram_55Text(view);
		case org.unicase.ui.stateDiagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001Text(view);
		case org.unicase.ui.stateDiagram.edit.parts.StateInitialEditPart.VISUAL_ID:
			return getStateInitial_2002Text(view);
		case org.unicase.ui.stateDiagram.edit.parts.StateEndEditPart.VISUAL_ID:
			return getStateEnd_2003Text(view);
		case org.unicase.ui.stateDiagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getMEDiagram_55Text(View view) {
		MEDiagram domainModelElement = (MEDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.stateDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"No domain element for view with visualID = " + 55); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_2001Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.stateDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.stateDiagram.providers.ModelElementTypes.State_2001,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.stateDiagram.edit.parts.StateNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.stateDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getStateInitial_2002Text(View view) {
		StateInitial domainModelElement = (StateInitial) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.stateDiagram.part.ModelDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 2002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStateEnd_2003Text(View view) {
		StateEnd domainModelElement = (StateEnd) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			org.unicase.ui.stateDiagram.part.ModelDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 2003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_4001Text(View view) {
		IAdaptable hintAdapter = new org.unicase.ui.stateDiagram.providers.ModelParserProvider.HintAdapter(
				org.unicase.ui.stateDiagram.providers.ModelElementTypes.Transition_4001,
				(view.getElement() != null ? view.getElement() : view),
				org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
						.getType(org.unicase.ui.stateDiagram.edit.parts.TransitionNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			org.unicase.ui.stateDiagram.part.ModelDiagramEditorPlugin
					.getInstance().logError(
							"Parser was not found for label " + 6001); //$NON-NLS-1$
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
		return org.unicase.ui.stateDiagram.edit.parts.MEDiagramEditPart.MODEL_ID
				.equals(org.unicase.ui.stateDiagram.part.ModelVisualIDRegistry
						.getModelID(view));
	}

}
