/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.startup.plugins;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.metamodel.Project;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.impl.ProjectSpaceImpl;

/**
 * Is used to rerecord changes.
 * 
 * @author wesendon
 */
public class ChangeReRecorder {

	private ProjectSpaceImpl projectSpace;

	/**
	 * Initialises the transiet projecstapce which is needed for rerecording.
	 * 
	 * @param project
	 *            initial project
	 */
	public void init(Project project) {
		if (project == null) {
			throw new IllegalStateException();
		}
		projectSpace = (ProjectSpaceImpl) WorkspaceFactory.eINSTANCE
				.createProjectSpace();
		projectSpace.setBaseVersion(VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec());
		projectSpace.setIdentifier("testProjectSpace");
		projectSpace.setLastUpdated(new Date());
		projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE
				.createOperationComposite());
		projectSpace.setProjectDescription("ps description");
		projectSpace.setProjectId(EsmodelFactory.eINSTANCE.createProjectId());
		projectSpace.setProjectName("ps name");
		projectSpace.setProject(project);
		projectSpace.makeTransient();
		projectSpace.init();
	}

	/**
	 * Converts the operations through rerecording.
	 * 
	 * @param operations
	 *            list of operations
	 * @return new operations
	 */
	public List<AbstractOperation> convertOperations(
			List<AbstractOperation> operations) {
		projectSpace.getOperations().clear();
		applyOperationForOperation(operations);
		ChangePackage changePackage = projectSpace.getLocalChangePackage(true);
		return changePackage.getCopyOfOperations();
	}

	private void applyOperationForOperation(List<AbstractOperation> operations) {
		int index = 0;
		for (AbstractOperation operation : operations) {
			Date clientDate = operation.getClientDate();
			projectSpace.applyOperationsWithRecording(Arrays.asList(operation),
					true);
			if (index >= projectSpace.getOperations().size()) {
				continue;
			}
			ListIterator<AbstractOperation> listIterator = projectSpace
					.getOperations().listIterator(index);

//			listIterator = handleCompositeOperation(index, operation,
//					listIterator);

			while (listIterator.hasNext()) {
				setDate(clientDate, listIterator.next());
			}
			index = projectSpace.getOperations().size();
		}
	}

	@SuppressWarnings("unused")
	private ListIterator<AbstractOperation> handleCompositeOperation(int index,
			AbstractOperation operation,
			ListIterator<AbstractOperation> listIterator) {
		
		if (operation instanceof CompositeOperation
				&& ((CompositeOperation) operation).getMainOperation() == null) {
			CompositeOperation oldComp = (CompositeOperation) operation;

			CompositeOperation composite = OperationsFactory.eINSTANCE
					.createCompositeOperation();
			composite.setAccepted(oldComp.isAccepted());
			composite.setCompositeDescription(oldComp.getDescription());
			composite.setCompositeName(oldComp.getName());
			composite.setModelElementId(null);
			
			while (listIterator.hasNext()) {
				AbstractOperation abstractOperation = listIterator.next();
				composite.getSubOperations().add(abstractOperation);
				listIterator.remove();
			}
			if (composite.getSubOperations().size() > 0) {
				AbstractOperation mainOperation = composite.getSubOperations()
						.get(composite.getSubOperations().size() - 1);
				composite.setMainOperation(mainOperation);
			} else {
				//TODO
			}

			listIterator = projectSpace.getOperations().listIterator(index);
		}
		return listIterator;
	}

	private void setDate(Date clientDate, AbstractOperation operation) {
		if (operation instanceof CompositeOperation) {
			for (AbstractOperation subOperation : ((CompositeOperation) operation)
					.getSubOperations()) {
				setDate(clientDate, subOperation);
			}
		}
		operation.setClientDate(clientDate == null ? null : (Date) clientDate
				.clone());
	}

	/**
	 * Returns a copy of the project.
	 * 
	 * @return project
	 */
	public Project getProject() {
		return (Project) EcoreUtil.copy(projectSpace.getProject());
	}

}
