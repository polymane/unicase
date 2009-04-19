/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.intergerationtest.tests;


import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Test;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.intergerationtest.TestHelper;
import org.unicase.model.ModelElement;
import org.unicase.model.util.SerializationException;

/**
 * This tests AttrubuteOperation. This is a compare test. It takes randomly a ME from test project, changes one of its
 * EAttributes, extract changes from test project, applies changes to compare project. Test succeeds when compare
 * project and test project are identical.
 * 
 * @author Hodaie
 */
public class AttributeChangeTest extends IntegrationTestCase {

	private ModelElement me;

	private EAttribute attributeToChange;
	

	
	/**
	 * 1. Get a random model element form test project; 2. get randomly one of its attributes. 3. 
	 * 
	 * @throws EmfStoreException EmfStoreException
	 * @throws SerializationException SerializationException
	 * 
	 */
	@Test
	public void runTest() throws SerializationException, EmfStoreException {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");

		me = TestHelper.getRandomME(getTestProject());
		attributeToChange = TestHelper.getRandomAttribute(me);

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				TestHelper.changeAttribute(me, attributeToChange);
			}

		});
		
		commitChanges();
		
		assertTrue(TestHelper.areEqual(getTestProject(), getCompareProject()));

	}

	
	
}
