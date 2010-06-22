/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.impl;

import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.discussionintoissue.DiscussionIntoIssuePage1;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.discussionintoissue.DiscussionIntoIssuePage2;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.discussionintoissue.DiscussionIntoIssuePage3;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;

/**
 * @author pfeifferc
 */
public class DiscussionIntoIssueRefactoringWizard extends AbstractRefactoringWizard {

	/**
	 * @param abstractRefactoringStrategy the
	 */
	public DiscussionIntoIssueRefactoringWizard(AbstractRefactoringStrategy abstractRefactoringStrategy) {
		super(abstractRefactoringStrategy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPage(new DiscussionIntoIssuePage1("page_1", this));
		addPage(new DiscussionIntoIssuePage2("page_2", this));
		addPage(new DiscussionIntoIssuePage3("page_3", this));
	}
}