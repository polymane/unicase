/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies;

import org.unicase.ui.refactoring.Activator;
import org.unicase.ui.refactoring.strategies.dialogs.RefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.impl.MENewNameRefactoringWizard;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;

/**
 * The model element new name refactoring strategy.
 * 
 * @author pfeifferc
 */
public class MENewNameRefactoringStrategy extends AbstractRefactoringStrategy {

	private static final String ID = "org.unicase.validation.MENewNameRefactoringStrategy";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		RefactoringDialog refactoringDialog = new RefactoringDialog(getShell(),
			new MENewNameRefactoringWizard(this));
		refactoringDialog.setTitleImage(Activator.getImageDescriptor("icons/validation.png").createImage());
		refactoringDialog.open();
		return refactoringDialog.getRefactoringResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return "Rename the model element";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return ID;
	}
}