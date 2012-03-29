/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.UseCase;

/**
 * Checks whether a usecase is connected to a functional requirement.
 * 
 * @author wesendonk
 * @author naughton
 */
public class UseCaseMissingRequirementConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof UseCase) {
				EList<NonFunctionalRequirement> nonFunctionalRequirements = ((UseCase) eObj)
					.getNonFunctionalRequirements();
				EList<FunctionalRequirement> functionalRequirements = ((UseCase) eObj).getFunctionalRequirements();
				if ((nonFunctionalRequirements.size() + functionalRequirements.size()) < 1) {
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((UseCase) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
