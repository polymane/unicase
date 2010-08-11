/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.refactoring.strategies.dialogs.util.RefactoringDialogHelper;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;
import org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy;

/**
 * Refactoring input dialog.
 * 
 * @author pfeifferc
 */
public abstract class AbstractListSelectionRefactoringDialog extends ListSelectionDialog implements
		AbstractRefactoringDialog {

	private RefactoringResult refactoringResult;
	
	private RefactoringDialogHelper refactoringDialogHelper;
	
	private RefactoringStrategy abstractRefactoringStrategy;
	
	/**
	 * @param parentShell the
	 * @param input the
	 * @param contentProvider the
	 * @param labelProvider the
	 * @param message the
	 */
	public AbstractListSelectionRefactoringDialog(Shell parentShell,
			Object input, IStructuredContentProvider contentProvider,
			ILabelProvider labelProvider, String message) {
		super(parentShell, input, contentProvider, labelProvider, message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * The model element the refactoring is about.
	 */
	private UnicaseModelElement unicaseModelElement;


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleShellCloseEvent() {
//		cancelPressed();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardDialog#cancelPressed()
	 */
	@Override
	protected void cancelPressed() {
		setRefactoringResult(RefactoringResult.ABORT);
		super.cancelPressed();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardDialog#close()
	 */
	@Override
	public boolean close() {
		dispose();
		return super.close();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		performFinish();
		super.okPressed();
	}
	
	/**
	 * Perform the finish.
	 */
	public abstract void performFinish();

	/**
	 * To be called when disposed.
	 */
	public void dispose() {
		refactoringDialogHelper.dispose();
	}
	
	/**
	 * @return true if not canceled or closed, false otherwise
	 */
	public RefactoringResult getRefactoringResult() {
		return refactoringResult;
	}

	/**
	 * Set the refactoring result.
	 * 
	 * @param refactoringResult the
	 */
	public void setRefactoringResult(RefactoringResult refactoringResult) {
		this.refactoringResult = refactoringResult;
	}

	/**
	 * @return the abstract refactoring strategy
	 */
	public RefactoringStrategy getAbstractRefactoringStrategy() {
		return abstractRefactoringStrategy;
	}

	/**
	 * {@inheritDoc}
	 */
	public RefactoringDialogHelper getRefactoringDialogHelper() {
		return refactoringDialogHelper;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public UnicaseModelElement getInvalidModelElement() {
		return unicaseModelElement;
	}
}