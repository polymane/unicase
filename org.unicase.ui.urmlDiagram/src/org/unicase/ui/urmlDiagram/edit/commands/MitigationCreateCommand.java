package org.unicase.ui.urmlDiagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.hazard.HazardFactory;
import org.unicase.model.hazard.Mitigation;

/**
 * @generated
 */
public class MitigationCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public MitigationCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return DiagramPackage.eINSTANCE.getMEDiagram();
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		Mitigation newElement = HazardFactory.eINSTANCE.createMitigation();

		MEDiagram owner = (MEDiagram) getElementToEdit();
		owner.getNewElements().add(newElement);

		MEDiagram childHolder = (MEDiagram) getElementToEdit();
		childHolder.getElements().add(newElement);

		return newElement;
	}

}
