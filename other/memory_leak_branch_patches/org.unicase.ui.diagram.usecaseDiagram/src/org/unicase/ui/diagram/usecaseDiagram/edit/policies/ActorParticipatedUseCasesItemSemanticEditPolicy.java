/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class ActorParticipatedUseCasesItemSemanticEditPolicy
		extends
		org.unicase.ui.diagram.usecaseDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ActorParticipatedUseCasesItemSemanticEditPolicy() {
		super(
				org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
