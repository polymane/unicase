/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

/**
 * Tests the MultiReferenceMoveOperation.
 * @author koegel
 *
 */
public class MultiReferenceMoveOperationTest extends OperationTest {

	/**
	 * Change a multi reference and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void makeMultiReferenceMove() throws UnsupportedOperationException, UnsupportedNotificationException {
		UseCase useCase1 = RequirementFactory.eINSTANCE.createUseCase();
		useCase1.setIdentifier("usecase1");
		getProject().addModelElement(useCase1);
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(actor);
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		useCase2.setIdentifier("usecase2");
		getProject().addModelElement(useCase2);
		UseCase useCase3 = RequirementFactory.eINSTANCE.createUseCase();
		useCase3.setIdentifier("usecase3");
		getProject().addModelElement(useCase3);
		
		actor.getInitiatedUseCases().add(useCase1);
		actor.getInitiatedUseCases().add(useCase2);
		actor.getInitiatedUseCases().add(useCase3);

		assertEquals(actor, useCase1.getInitiatingActor());
		assertEquals(actor, useCase2.getInitiatingActor());
		assertEquals(actor, useCase3.getInitiatingActor());
		EList<UseCase> initiatedUseCases = actor.getInitiatedUseCases();
		assertEquals(3, initiatedUseCases.size());
		assertEquals(useCase1, initiatedUseCases.get(0));
		assertEquals(useCase2, initiatedUseCases.get(1));
		assertEquals(useCase3, initiatedUseCases.get(2));
		
		clearOperations();
		
		actor.getInitiatedUseCases().move(2, 1);
		
		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof MultiReferenceMoveOperation);
		MultiReferenceMoveOperation multiReferenceMoveOperation  = (MultiReferenceMoveOperation) operation;
		
		assertEquals("initiatedUseCases", multiReferenceMoveOperation.getFeatureName());
		assertEquals(actor.getModelElementId(), multiReferenceMoveOperation.getModelElementId());
		assertEquals(2, multiReferenceMoveOperation.getNewIndex());	
		assertEquals(1, multiReferenceMoveOperation.getOldIndex());	
		assertEquals(useCase2.getModelElementId(), multiReferenceMoveOperation.getReferencedModelElementId());	
		
		assertEquals(actor, useCase1.getInitiatingActor());
		assertEquals(actor, useCase2.getInitiatingActor());
		assertEquals(actor, useCase3.getInitiatingActor());
		assertEquals(3, initiatedUseCases.size());
		assertEquals(useCase1, initiatedUseCases.get(0));
		assertEquals(useCase2, initiatedUseCases.get(2));
		assertEquals(useCase3, initiatedUseCases.get(1));

	}
	
	/**
	 * Change a multi reference and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void reverseMultiReferenceMove() throws UnsupportedOperationException, UnsupportedNotificationException {
		UseCase useCase1 = RequirementFactory.eINSTANCE.createUseCase();
		useCase1.setIdentifier("usecase1");
		getProject().addModelElement(useCase1);
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(actor);
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		useCase2.setIdentifier("usecase2");
		getProject().addModelElement(useCase2);
		UseCase useCase3 = RequirementFactory.eINSTANCE.createUseCase();
		useCase3.setIdentifier("usecase3");
		getProject().addModelElement(useCase3);
		
		actor.getInitiatedUseCases().add(useCase1);
		actor.getInitiatedUseCases().add(useCase2);
		actor.getInitiatedUseCases().add(useCase3);

		assertEquals(actor, useCase1.getInitiatingActor());
		assertEquals(actor, useCase2.getInitiatingActor());
		assertEquals(actor, useCase3.getInitiatingActor());
		EList<UseCase> initiatedUseCases = actor.getInitiatedUseCases();
		assertEquals(3, initiatedUseCases.size());
		assertEquals(useCase1, initiatedUseCases.get(0));
		assertEquals(useCase2, initiatedUseCases.get(1));
		assertEquals(useCase3, initiatedUseCases.get(2));
		
		clearOperations();

		actor.getInitiatedUseCases().move(2, 1);

		List<AbstractOperation> operations = getProjectSpace().getOperations();
		
		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);

		AbstractOperation reverse = operation.reverse();
		
		assertEquals(true, reverse instanceof MultiReferenceMoveOperation);
		MultiReferenceMoveOperation multiReferenceMoveOperation  = (MultiReferenceMoveOperation) reverse;
		
		assertEquals("initiatedUseCases", multiReferenceMoveOperation.getFeatureName());
		assertEquals(actor.getModelElementId(), multiReferenceMoveOperation.getModelElementId());
		assertEquals(1, multiReferenceMoveOperation.getNewIndex());	
		assertEquals(2, multiReferenceMoveOperation.getOldIndex());	
		assertEquals(useCase2.getModelElementId(), multiReferenceMoveOperation.getReferencedModelElementId());	
		
		reverse.apply(getProject());
		
		assertEquals(actor, useCase1.getInitiatingActor());
		assertEquals(actor, useCase2.getInitiatingActor());
		assertEquals(actor, useCase3.getInitiatingActor());
		assertEquals(3, initiatedUseCases.size());
		assertEquals(useCase1, initiatedUseCases.get(0));
		assertEquals(useCase2, initiatedUseCases.get(1));
		assertEquals(useCase3, initiatedUseCases.get(2));

	}
}
