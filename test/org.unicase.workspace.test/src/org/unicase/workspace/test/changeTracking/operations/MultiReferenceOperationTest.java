/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.model.ModelElementId;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;

/**
 * Tests the MultiReferenceOperation.
 * 
 * @author koegel
 */
public class MultiReferenceOperationTest extends OperationTest {

	/**
	 * Change a multi reference and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void changeMultiReference() throws UnsupportedOperationException, UnsupportedNotificationException {
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		useCase.setIdentifier("usecase");
		getProject().addModelElement(useCase);
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(actor);

		clearOperations();

		actor.getInitiatedUseCases().add(useCase);

		assertEquals(actor, useCase.getInitiatingActor());
		EList<UseCase> initiatedUseCases = actor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof MultiReferenceOperation);
		MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) operation;

		assertEquals("initiatedUseCases", multiReferenceOperation.getFeatureName());
		assertEquals(0, multiReferenceOperation.getIndex());
		assertEquals(actor.getModelElementId(), multiReferenceOperation.getModelElementId());
		assertEquals("initiatingActor", multiReferenceOperation.getOppositeFeatureName());
		assertEquals(true, multiReferenceOperation.isAdd());
		assertEquals(true, multiReferenceOperation.isBidirectional());

		EList<ModelElementId> referencedModelElements = multiReferenceOperation.getReferencedModelElements();
		assertEquals(1, referencedModelElements.size());
		assertEquals(useCase.getModelElementId(), referencedModelElements.get(0));

		Set<ModelElementId> otherInvolvedModelElements = multiReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(useCase.getModelElementId()));

	}

	/**
	 * Change a multi reference and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void reverseMultiReference() throws UnsupportedOperationException, UnsupportedNotificationException {
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		useCase.setIdentifier("usecase1");
		getProject().addModelElement(useCase);
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(actor);

		clearOperations();

		actor.getInitiatedUseCases().add(useCase);

		assertEquals(actor, useCase.getInitiatingActor());
		EList<UseCase> initiatedUseCases = actor.getInitiatedUseCases();
		assertEquals(1, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof MultiReferenceOperation);
		MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) operation;

		AbstractOperation reverse = multiReferenceOperation.reverse();
		assertEquals(true, reverse instanceof MultiReferenceOperation);

		MultiReferenceOperation reversedMultiReferenceOperation = (MultiReferenceOperation) reverse;
		assertEquals("initiatedUseCases", reversedMultiReferenceOperation.getFeatureName());
		assertEquals(0, reversedMultiReferenceOperation.getIndex());
		assertEquals(actor.getModelElementId(), reversedMultiReferenceOperation.getModelElementId());
		assertEquals("initiatingActor", reversedMultiReferenceOperation.getOppositeFeatureName());
		assertEquals(false, reversedMultiReferenceOperation.isAdd());
		assertEquals(true, reversedMultiReferenceOperation.isBidirectional());

		EList<ModelElementId> referencedModelElements = reversedMultiReferenceOperation.getReferencedModelElements();
		assertEquals(1, referencedModelElements.size());
		assertEquals(useCase.getModelElementId(), referencedModelElements.get(0));

		Set<ModelElementId> otherInvolvedModelElements = reversedMultiReferenceOperation
			.getOtherInvolvedModelElements();
		assertEquals(1, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(useCase.getModelElementId()));

		reversedMultiReferenceOperation.apply(getProject());

		assertEquals(0, actor.getInitiatedUseCases().size());
		assertEquals(null, useCase.getInitiatingActor());
	}

	/**
	 * Change a multi reference and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void addManyMultiReference() throws UnsupportedOperationException, UnsupportedNotificationException {
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		useCase.setIdentifier("usecase1");
		getProject().addModelElement(useCase);
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(actor);
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		useCase2.setIdentifier("usecase2");
		getProject().addModelElement(useCase2);
		UseCase useCase3 = RequirementFactory.eINSTANCE.createUseCase();
		useCase3.setIdentifier("usecase3");
		getProject().addModelElement(useCase3);

		clearOperations();

		List<UseCase> useCases = new ArrayList<UseCase>();
		useCases.add(useCase);
		useCases.add(useCase2);
		useCases.add(useCase3);
		actor.getInitiatedUseCases().addAll(useCases);

		assertEquals(actor, useCase.getInitiatingActor());
		assertEquals(actor, useCase2.getInitiatingActor());
		assertEquals(actor, useCase3.getInitiatingActor());
		EList<UseCase> initiatedUseCases = actor.getInitiatedUseCases();
		assertEquals(3, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		assertEquals(useCase2, initiatedUseCases.get(1));
		assertEquals(useCase3, initiatedUseCases.get(2));

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof MultiReferenceOperation);
		MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) operation;

		assertEquals("initiatedUseCases", multiReferenceOperation.getFeatureName());
		assertEquals(0, multiReferenceOperation.getIndex());
		assertEquals(actor.getModelElementId(), multiReferenceOperation.getModelElementId());
		assertEquals("initiatingActor", multiReferenceOperation.getOppositeFeatureName());
		assertEquals(true, multiReferenceOperation.isAdd());
		assertEquals(true, multiReferenceOperation.isBidirectional());

		EList<ModelElementId> referencedModelElements = multiReferenceOperation.getReferencedModelElements();
		assertEquals(3, referencedModelElements.size());
		assertEquals(useCase.getModelElementId(), referencedModelElements.get(0));
		assertEquals(useCase2.getModelElementId(), referencedModelElements.get(1));
		assertEquals(useCase3.getModelElementId(), referencedModelElements.get(2));

		Set<ModelElementId> otherInvolvedModelElements = multiReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(3, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(useCase.getModelElementId()));
		assertEquals(true, otherInvolvedModelElements.contains(useCase2.getModelElementId()));
		assertEquals(true, otherInvolvedModelElements.contains(useCase3.getModelElementId()));

	}

	/**
	 * Change a multi reference and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void removeManyMultiReference() throws UnsupportedOperationException, UnsupportedNotificationException {
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		useCase.setIdentifier("usecase1");
		getProject().addModelElement(useCase);
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		getProject().addModelElement(actor);
		UseCase useCase2 = RequirementFactory.eINSTANCE.createUseCase();
		useCase2.setIdentifier("usecase2");
		getProject().addModelElement(useCase2);
		UseCase useCase3 = RequirementFactory.eINSTANCE.createUseCase();
		useCase3.setIdentifier("usecase3");
		getProject().addModelElement(useCase3);
		List<UseCase> useCases = new ArrayList<UseCase>();
		useCases.add(useCase);
		useCases.add(useCase2);
		useCases.add(useCase3);
		actor.getInitiatedUseCases().addAll(useCases);

		clearOperations();

		assertEquals(actor, useCase.getInitiatingActor());
		assertEquals(actor, useCase2.getInitiatingActor());
		assertEquals(actor, useCase3.getInitiatingActor());
		EList<UseCase> initiatedUseCases = actor.getInitiatedUseCases();
		assertEquals(3, initiatedUseCases.size());
		assertEquals(useCase, initiatedUseCases.get(0));
		assertEquals(useCase2, initiatedUseCases.get(1));
		assertEquals(useCase3, initiatedUseCases.get(2));

		actor.getInitiatedUseCases().removeAll(useCases);

		assertEquals(null, useCase.getInitiatingActor());
		assertEquals(null, useCase2.getInitiatingActor());
		assertEquals(null, useCase3.getInitiatingActor());
		assertEquals(0, initiatedUseCases.size());

		List<AbstractOperation> operations = getProjectSpace().getOperations();

		assertEquals(1, operations.size());
		AbstractOperation operation = operations.get(0);
		assertEquals(true, operation instanceof MultiReferenceOperation);
		MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) operation;

		assertEquals("initiatedUseCases", multiReferenceOperation.getFeatureName());
		assertEquals(0, multiReferenceOperation.getIndex());
		assertEquals(actor.getModelElementId(), multiReferenceOperation.getModelElementId());
		assertEquals("initiatingActor", multiReferenceOperation.getOppositeFeatureName());
		assertEquals(false, multiReferenceOperation.isAdd());
		assertEquals(true, multiReferenceOperation.isBidirectional());

		EList<ModelElementId> referencedModelElements = multiReferenceOperation.getReferencedModelElements();
		assertEquals(3, referencedModelElements.size());
		assertEquals(useCase.getModelElementId(), referencedModelElements.get(0));
		assertEquals(useCase2.getModelElementId(), referencedModelElements.get(1));
		assertEquals(useCase3.getModelElementId(), referencedModelElements.get(2));

		Set<ModelElementId> otherInvolvedModelElements = multiReferenceOperation.getOtherInvolvedModelElements();
		assertEquals(3, otherInvolvedModelElements.size());
		assertEquals(true, otherInvolvedModelElements.contains(useCase.getModelElementId()));
		assertEquals(true, otherInvolvedModelElements.contains(useCase2.getModelElementId()));
		assertEquals(true, otherInvolvedModelElements.contains(useCase3.getModelElementId()));

	}

	/**
	 * Change a multi reference and check the generated operation.
	 * 
	 * @throws UnsupportedOperationException on test fail
	 * @throws UnsupportedNotificationException on test fail
	 */
	@Test
	public void listContainsTest() throws UnsupportedOperationException, UnsupportedNotificationException {

		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		useCase.setIdentifier("usecase");
		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		getProject().addModelElement(section);

		clearOperations();
		section.getModelElements().add(useCase);

		List<AbstractOperation> ops = getProjectSpace().getLocalOperations().getOperations();

		MultiReferenceOperation addOp = (MultiReferenceOperation) ops.get(1);

		for (ModelElementId id : addOp.getReferencedModelElements()) {
			if (id.equals(useCase.getModelElementId())) {
				assertTrue(addOp.getReferencedModelElements().contains(useCase.getModelElementId()));
			}
		}

	}

}
