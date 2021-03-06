/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.classes.Package;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether a class is connected to a package.
 * 
 * @author wesendonk
 * @author naughton
 */
public class ClassNotContainedInPackageConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof org.unicase.model.classes.Class) {
				Package package1 = ((org.unicase.model.classes.Class) eObj).getParentPackage();
				if (package1 == null) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						(UnicaseModelElement) eObj, "parentPackage");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((org.unicase.model.classes.Class) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
