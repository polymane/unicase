/** 
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.unicase.model.diagram.DiagramPackage;

/**
 * @generated
 */
public class MEDiagramItemSemanticEditPolicy
		extends
		org.unicase.ui.diagram.stateDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.State_2001 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(DiagramPackage.eINSTANCE
						.getMEDiagram_NewElements());
			}
			return getGEFWrapper(new org.unicase.ui.diagram.stateDiagram.edit.commands.StateCreateCommand(
					req));
		}
		if (org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.StateInitial_2002 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(DiagramPackage.eINSTANCE
						.getMEDiagram_NewElements());
			}
			return getGEFWrapper(new org.unicase.ui.diagram.stateDiagram.edit.commands.StateInitialCreateCommand(
					req));
		}
		if (org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.StateEnd_2003 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(DiagramPackage.eINSTANCE
						.getMEDiagram_NewElements());
			}
			return getGEFWrapper(new org.unicase.ui.diagram.stateDiagram.edit.commands.StateEndCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
