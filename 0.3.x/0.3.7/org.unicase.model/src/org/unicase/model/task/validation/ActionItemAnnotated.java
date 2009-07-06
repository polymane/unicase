/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Thsi validation rule checks all actionitems except PM ais if they are annotated to functional requirements.
 * 
 * @author helming
 */
public class ActionItemAnnotated extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType != EMFEventType.NULL || !(eObj instanceof ActionItem)) {
			return ctx.createSuccessStatus();
		}
		ActionItem actionItem = (ActionItem) eObj;
		if (((ActionItem) eObj).getActivity().equals(ActivityType.MANAGEMENT)) {
			return ctx.createSuccessStatus();
		}
		EList<ModelElement> annotatedModelElements = actionItem.getAnnotatedModelElements();
		for (ModelElement me : annotatedModelElements) {
			if (me instanceof FunctionalRequirement) {
				return ctx.createSuccessStatus();
			}
		}
		EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
			(ModelElement) eObj, "annotatedModelElements");
		ctx.addResult(errorFeature);
		return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '" + ((ActionItem) eObj).getName()
			+ "'" });

	}

}
