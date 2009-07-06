/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classDiagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class Association3ViewFactory extends ConnectionViewFactory {

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createConnectorStyle());
		styles.add(NotationFactory.eINSTANCE.createFontStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint,
		int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.model.classDiagram.edit.parts.Association3EditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(
			eObjectAdapter,
			view,
			org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.model.classDiagram.edit.parts.AssociationName3EditPart.VISUAL_ID),
			ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(
			eObjectAdapter,
			view,
			org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.model.classDiagram.edit.parts.AssociationSourceMultiplicity3EditPart.VISUAL_ID),
			ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(
			eObjectAdapter,
			view,
			org.unicase.model.classDiagram.part.ModelVisualIDRegistry
				.getType(org.unicase.model.classDiagram.edit.parts.AssociationTargetMultiplicity3EditPart.VISUAL_ID),
			ViewUtil.APPEND, true, getPreferencesHint());
	}
}
