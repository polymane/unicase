/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.operations;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.workspace.test.WorkspaceTest;
import org.unicase.workspace.test.testmodel.TestElement;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Tests for MultiAttributes.
 * 
 * @author wesendon
 */
public class MultiAttributeTest extends WorkspaceTest {

	/**
	 * Add value to empty list.
	 */
	@Test
	public void addValueToEmptyTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();

				assertTrue(testElement.getStrings().size() == 0);

				MultiAttributeOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
				operation.setAdd(true);
				operation.setFeatureName("strings");
				operation.getIndexes().add(0);
				operation.getReferencedValues().add("inserted");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 1);
				assertTrue(testElement.getStrings().get(0).equals("inserted"));
			}
		}.run(false);
	}

	/**
	 * Add value to filled list.
	 */
	@Test
	public void addValueToFilledTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");

				assertTrue(testElement.getStrings().size() == 1);

				MultiAttributeOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
				operation.setAdd(true);
				operation.setFeatureName("strings");
				operation.getIndexes().add(0);
				operation.getReferencedValues().add("inserted");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 2);
				assertTrue(testElement.getStrings().get(0).equals("inserted"));
				assertTrue(testElement.getStrings().get(1).equals("first"));
			}
		}.run(false);
	}

	/**
	 * Add multiple values.
	 */
	@Test
	public void addMultipleValueToFilledTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");

				assertTrue(testElement.getStrings().size() == 1);

				MultiAttributeOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
				operation.setAdd(true);
				operation.setFeatureName("strings");
				operation.getIndexes().add(0);
				operation.getIndexes().add(2);
				operation.getReferencedValues().add("inserted");
				operation.getReferencedValues().add("inserted2");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 3);
				assertTrue(testElement.getStrings().get(0).equals("inserted"));
				assertTrue(testElement.getStrings().get(1).equals("first"));
				assertTrue(testElement.getStrings().get(2).equals("inserted2"));
			}
		}.run(false);
	}

	/**
	 * Remove last value.
	 */
	@Test
	public void removeValueToEmptyTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");

				assertTrue(testElement.getStrings().size() == 1);

				MultiAttributeOperation operation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
				operation.setAdd(false);
				operation.setFeatureName("strings");
				operation.getIndexes().add(0);
				operation.getReferencedValues().add("first");
				operation.setModelElementId(testElement.getModelElementId());

				operation.apply(getProject());

				assertTrue(testElement.getStrings().size() == 0);
			}
		}.run(false);
	}

	/**
	 * Test recorded operation.
	 */
	@Test
	public void recordedAddOperationsTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				getProjectSpace().getOperations().clear();
				testElement.getStrings().add("first");
				testElement.getStrings().addAll(Arrays.asList("second", "third"));

				AbstractOperation abstractOperation = getProjectSpace().getOperations().get(0);
				assertTrue(abstractOperation instanceof MultiAttributeOperation);
				MultiAttributeOperation ao = (MultiAttributeOperation) abstractOperation;
				assertTrue(ao.getIndexes().size() == 1);
				assertTrue(ao.getIndexes().get(0) == 0);
				assertTrue(ao.getReferencedValues().get(0).equals("first"));
				assertTrue(ao.isAdd());

				abstractOperation = getProjectSpace().getOperations().get(1);
				assertTrue(abstractOperation instanceof MultiAttributeOperation);
				ao = (MultiAttributeOperation) abstractOperation;
				assertTrue(ao.getIndexes().size() == 2);
				assertTrue(ao.getIndexes().get(0) == 1);
				assertTrue(ao.getIndexes().get(1) == 2);
				assertTrue(ao.getReferencedValues().get(0).equals("second"));
				assertTrue(ao.getReferencedValues().get(1).equals("third"));
				assertTrue(ao.isAdd());
			}
		}.run(false);
	}

	/**
	 * Test recorded remove operation.
	 */
	@Test
	public void recordedRemoveOperationsTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();

				testElement.getStrings().add("first");
				testElement.getStrings().addAll(Arrays.asList("second", "third"));

				getProjectSpace().getOperations().clear();

				testElement.getStrings().removeAll(Arrays.asList("second", "third"));

				assertTrue(getProjectSpace().getOperations().size() == 1);

				AbstractOperation abstractOperation = getProjectSpace().getOperations().get(0);
				assertTrue(abstractOperation instanceof MultiAttributeOperation);
				MultiAttributeOperation ao = (MultiAttributeOperation) abstractOperation;
				assertTrue(ao.getIndexes().get(0) == 1);
				assertTrue(ao.getIndexes().get(1) == 2);
				assertTrue(ao.getReferencedValues().get(0).equals("second"));
				assertTrue(ao.getReferencedValues().get(1).equals("third"));
				assertTrue(!ao.isAdd());
			}
		}.run(false);
	}

	/**
	 * Remove and reverse operation.
	 */
	@Test
	public void removeAndReverseTest() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				TestElement testElement = getTestElement();
				testElement.getStrings().add("first");
				testElement.getStrings().add("second");

				assertTrue(testElement.getStrings().size() == 2);
				assertTrue(testElement.getStrings().get(0).equals("first"));
				assertTrue(testElement.getStrings().get(1).equals("second"));
				getProjectSpace().getOperations().clear();

				testElement.getStrings().remove("second");
				assertTrue(testElement.getStrings().size() == 1);
				assertTrue(testElement.getStrings().get(0).equals("first"));

				AbstractOperation ao = getProjectSpace().getOperations().get(0).reverse();
				ao.apply(getProject());

				assertTrue(testElement.getStrings().size() == 2);
				assertTrue(testElement.getStrings().get(0).equals("first"));
				assertTrue(testElement.getStrings().get(1).equals("second"));
			}
		}.run(false);
	}
}