/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.unicase.model.classes.ClassesPackage;

/**
 * @generated
 */
public class ClassClassNode_methodsItemSemanticEditPolicy extends
	org.unicase.model.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.unicase.model.classDiagram.providers.ModelElementTypes.Method_3002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ClassesPackage.eINSTANCE.getClass_Methods());
			}
			return getGEFWrapper(new org.unicase.model.classDiagram.edit.commands.MethodCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
