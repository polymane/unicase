package org.unicase.model.classDiagram.edit.policies;

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
		org.unicase.model.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(DiagramPackage.eINSTANCE
						.getMEDiagram_NewElements());
			}
			return getGEFWrapper(new org.unicase.model.classDiagram.edit.commands.ClassCreateCommand(
					req));
		}
		if (org.unicase.model.classDiagram.providers.ModelElementTypes.Package_2002 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(DiagramPackage.eINSTANCE
						.getMEDiagram_NewElements());
			}
			return getGEFWrapper(new org.unicase.model.classDiagram.edit.commands.PackageCreateCommand(
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
