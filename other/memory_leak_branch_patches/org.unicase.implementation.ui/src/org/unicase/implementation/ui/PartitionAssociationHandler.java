/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.PartitionAssociationOperation;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.model.classes.Association;
// END IGNORE UNNECCESSARY IMPORT
/**
 * Handler for the {@link PartitionAssociationOperation}.
 * 
 * @author herrmi
 */
public class PartitionAssociationHandler extends OperationHandlerBase {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SemanticCompositeOperation initOperation(IStructuredSelection structuredSelection) {
		Association association = SelectionHelper.getSelectedElement(structuredSelection);

		PartitionAssociationOperation operation = OperationsFactory.eINSTANCE.createPartitionAssociationOperation();
		operation.setAssociation(OperationHelper.getId(association));

		return operation;
	}


}
