/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

// BEGIN IGNORE UNNECCESSARY IMPORT
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.classes.Class;

/**
 * Handler for {@link ExtractSuperClassOperation}.
 * 
 * @author herrmi
 */
public class ExtractSuperClassHandler extends OperationHandlerBase {

	@Override
	protected SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection) {
		ExtractSuperClassOperation operation = OperationsFactory.eINSTANCE.createExtractSuperClassOperation();

		List<Class> subClasses = SelectionHelper.getSelectedElements(structuredSelection);
		operation.getSubClasses().addAll(OperationHelper.getIds(subClasses));

		return operation;
	}

}
