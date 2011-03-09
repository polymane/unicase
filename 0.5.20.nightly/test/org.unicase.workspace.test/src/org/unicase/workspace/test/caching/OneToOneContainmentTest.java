/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.caching;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.Solution;

/**
 * Tests the Attribute Operation.
 * 
 * @author koegel
 */
public class OneToOneContainmentTest extends CachingTest {

	/**
	 * Add a one to one containment child and check for project cache update.
	 */
	@Test
	public void addIssueSolution() {

		Issue issue = RationaleFactory.eINSTANCE.createIssue();
		getProject().addModelElement(issue);

		assertTrue(getProject().contains(issue));
		assertEquals(getProject(), issue.getProject());

		Solution solution = RationaleFactory.eINSTANCE.createSolution();
		issue.setSolution(solution);

		assertTrue(getProject().contains(solution));
		assertEquals(getProject(), solution.getProject());
		assertEquals(issue, solution.getIssue());
		assertEquals(solution, issue.getSolution());
	}
}