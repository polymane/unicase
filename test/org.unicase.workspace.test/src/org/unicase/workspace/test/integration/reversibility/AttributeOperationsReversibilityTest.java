/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.integration.reversibility;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.util.SerializationException;
import org.unicase.workspace.test.integration.forward.IntegrationTestHelper;

/**
 * @author Hodaie
 */
public class AttributeOperationsReversibilityTest extends OperationsReversibilityTest {

	private long randomSeed = 1;

	/**
	 * Finds an attribute with isMany = true and moves elements inside this attribute.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void multiAttributeMoveReversibilityTest() throws SerializationException, EmfStoreException {
		System.out.println("MultiAttributeMoveReversibilityTest");

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				testHelper.doMultiAttributeMove();
				getTestProjectSpace().revert();
			}
		});

		
		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "MultiAttributeMoveReversibilityTest"));

	}
	
	/**
	 * 1. Get a random model element form test project; 2. get randomly one of its attributes. 3. change the attribute
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void attributeChangeReversibilityTest() throws SerializationException, EmfStoreException {
		System.out.println("AttributeChangeReversibilityTest");

		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doChangeAttribute();
				getTestProjectSpace().revert();
			}

		});

	
		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "AttributeChangeReversibilityTest"));

	}
	
	
	/**
	 * Change the same attribute on a randomly selected ME twice.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void attributeTransitiveChangeReversibilityTest() throws SerializationException, EmfStoreException {
		System.out.println("AttributeTransitiveChangeReversibilityTest");
		final IntegrationTestHelper testHelper = new IntegrationTestHelper(randomSeed, getTestProject());
		TransactionalEditingDomain domain = IntegrationTestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				testHelper.doAttributeTransitiveChange();
				getTestProjectSpace().revert();
			}

		});

		
		assertTrue(IntegrationTestHelper.areEqual(getTestProject(), getCompareProject(), "AttributeTransitiveChangeReversibilityTest"));

	}


}
