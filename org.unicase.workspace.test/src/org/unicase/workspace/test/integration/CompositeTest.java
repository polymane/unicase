/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.integration;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.util.SerializationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Runs a random set of operations.
 * 
 * @author hodaie
 */
public class CompositeTest extends IntegrationTestCase {

	private long randomSeed = 1;


	private boolean testAll = true;
	private int maxTimesToRunATestCase = 3;
	private int randomSelectIterations = 50;
	private int testAllIterations = 20;

	private TestHelper testHelper;

	/**
	 * Runs a random set of operations.
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {
		System.out.println("CompositeTest");

		TransactionalEditingDomain domain = TestHelper.getDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				doTest();

			}

		});

		commitChanges();
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject(), "CompositeTest"));

	}
	

	private void doTest() {
		testHelper = new TestHelper(randomSeed, getTestProject());

		if (testAll) {

			for (int i = 0; i < testAllIterations; i++) {
				testAll();
			}

		} else {

			for (int i = 0; i < randomSelectIterations; i++) {
				randomSelectTest();
			}

		}
	}

	private void randomSelectTest() {
		List<Integer> testsToRun = new ArrayList<Integer>();
		for (int i = 0; i < TestHelper.NUM_OF_TESTS; i++) {
			testsToRun.add(new Integer(i));
		}

		Integer testToRun = testHelper.getRandomPosition(testsToRun.size());

		int timesToRun = testHelper.getRandomPosition(maxTimesToRunATestCase);
		// make sure the test runs at least once
		if (timesToRun == 0) {
			timesToRun += 1;
		}

		runTestCase(testToRun, timesToRun);

	}

	private void testAll() {
		List<Integer> testsToRun = new ArrayList<Integer>();
		for (int i = 0; i < TestHelper.NUM_OF_TESTS; i++) {
			testsToRun.add(new Integer(i));
		}

		for (int j = 0; j < TestHelper.NUM_OF_TESTS; j++) {
			int index = testHelper.getRandomPosition(testsToRun.size());
			Integer testToRun = testsToRun.get(index);
			
			int timesToRun = testHelper.getRandomPosition(maxTimesToRunATestCase);
			// make sure the test runs at least once
			if (timesToRun == 0) {
				timesToRun += 1;
			}
			runTestCase(testToRun, timesToRun);
			testsToRun.remove(testToRun);
		}

	}

	private void runTestCase(Integer testToRun, int timesToRun) {

		for (int i = 0; i < timesToRun; i++) {
			switch (testToRun.intValue()) {
			case 0:
				// Delete 
				System.out.println("Delete");
				testHelper.doDelete();
				break;

			case 1:
				// CreateAndDelete 
				System.out.println("CreateAndDelete");
				testHelper.doCreateChangeRefDelete();
				break;

			case 2:
				// MultiReferenceMove
				System.out.println("MultiReferenceMove");
				testHelper.doMultiReferenceMove();
				break;

			case 3:
				// ContainmentReferenceMove
				System.out.println("ContainmentReferenceMove");
				testHelper.doContainmentReferenceMove();
				break;

			case 4:
				// NonContainmentReferenceRemove
				System.out.println("NonContainmentReferenceRemove");
				testHelper.doNonContainmentReferenceRemove();
				break;

			case 5:
				// AttributeTransitiveChange
				System.out.println("AttributeTransitiveChange");
				testHelper.doAttributeTransitiveChange();
				break;

			case 6:
				// MultiAttributeMove
				System.out.println("MultiAttributeMove");
				testHelper.doMultiAttributeMove();
				break;

			case 7:
				// AttributeChange
				System.out.println("AttributeChange");
				testHelper.doChangeAttribute();
				break;

			case 8:
				// DeleteAndRevertDelete
				System.out.println("DeleteAndRevertDelete");
				testHelper.doDeleteAndRevert();
				break;

			case 9:
				// CreateAndChangeRef
				System.out.println("CreateAndChangeRef");
				testHelper.doCreateAndChangeRef();
				break;

			case 10:
				// CreateAndChangeAttribute
				System.out.println("CreateAndChangeAttribute");
				testHelper.doCreateAndChangeAttribute();
				break;

			case 11:
				// NonContainmentReferenceAdd
				System.out.println("NonContainmentReferenceAdd");
				testHelper.doNonContainmentReferenceAdd();
				break;

			case 12:
				// ContainmentReferenceAddNew
				System.out.println("ContainmentReferenceAddNew");
				testHelper.doContainemntReferenceAddNew();
				break;

			default:
				break;

			}
		}

	}

	/**
	 * @param testAll the testAll to set
	 */
	public void setTestAll(boolean testAll) {
		this.testAll = testAll;
	}

	/**
	 * @return the testAll
	 */
	public boolean isTestAll() {
		return testAll;
	}

	/**
	 * @param testAllIterations the testAllIterations to set
	 */
	public void setTestAllIterations(int testAllIterations) {
		this.testAllIterations = testAllIterations;
	}

	/**
	 * @return the testAllIterations
	 */
	public int getTestAllIterations() {
		return testAllIterations;
	}

	/**
	 * @param randomSelectIterations the randomSelectIterations to set
	 */
	public void setRandomSelectIterations(int randomSelectIterations) {
		this.randomSelectIterations = randomSelectIterations;
	}

	/**
	 * @return the randomSelectIterations
	 */
	public int getRandomSelectIterations() {
		return randomSelectIterations;
	}

	/**
	 * @param maxTimesToRunATestCase the maxTimesToRunATestCase to set
	 */
	public void setMaxTimesToRunATestCase(int maxTimesToRunATestCase) {
		this.maxTimesToRunATestCase = maxTimesToRunATestCase;
	}

	/**
	 * @return the maxTimesToRunATestCase
	 */
	public int getMaxTimesToRunATestCase() {
		return maxTimesToRunATestCase;
	}

}
