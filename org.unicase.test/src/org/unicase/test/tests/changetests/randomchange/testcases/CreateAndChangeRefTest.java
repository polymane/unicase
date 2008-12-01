package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.IChangePackageTest;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

/**
 * 
 * This is a change package test. It creates randomly a ME A, changes one of its
 * non-containment references. The expected change package should contain two
 * operations - a create operation: created A - a change operation: either A.ref
 * changed to B or B.oppositeRef changed to A
 * 
 * @author Hodaie
 * 
 */
public class CreateAndChangeRefTest extends RandomChangeTestCase implements
		IChangePackageTest {

	private static final int EXPECTED_NUM_OF_CHANGES = 2;

	public CreateAndChangeRefTest(String testName, TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

	}

	@Override
	public void runTest() {
		final ModelElement me = ChangeTestHelper.createRandomME();
		// me.setName("newly created " + me.eClass().getName());

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				getTestProject().getModelElements().add(me);
				ChangeTestHelper.changeSimpleRef(me, getTestProject());
			}

		});

	}

	

		

	public int getExpectedNumOfChanges() {
		return EXPECTED_NUM_OF_CHANGES;
	}

	public boolean isSuccessful() {
		//temp impl
		return EXPECTED_NUM_OF_CHANGES == 1;
	}
	
	public ChangePackage getChangePackage(boolean removeChanges) {
		return ChangeTestHelper.getChangePackage(getTestProjectSpace()
				.getOperations(), true, removeChanges);

	}

}
