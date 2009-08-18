/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.mergetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.Project;
import org.unicase.workspace.observers.ConflictResolver;

/**
 * .
 * 
 * @author wesendon
 */
public class MergeWizard extends Wizard implements ConflictResolver {

	private final Project project;
	private final List<ChangePackage> theirChangePackages;
	private final ChangePackage myChangePackage;
	
	/**
	 * Default constructor.
	 * @param myChangePackage 
	 * @param theirChangePackages 
	 * @param project 
	 */
	public MergeWizard(Project project, List<ChangePackage> theirChangePackages, ChangePackage myChangePackage) {
		super();
		this.project = project;
		this.theirChangePackages = theirChangePackages;
		this.myChangePackage = myChangePackage;
		setWindowTitle("Merge Wizard");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		super.addPages();
		addPage(new MergeWizardPage("Merge Operation",project, theirChangePackages, myChangePackage));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<AbstractOperation> getAcceptedMine() {
		return new ArrayList<AbstractOperation>();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<AbstractOperation> getRejectedTheirs() {
		return new ArrayList<AbstractOperation>();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean resolveConflicts(Project project,
			List<ChangePackage> theirChangePackages,
			ChangePackage myChangePackage) {

		System.out.println(theirChangePackages);
		System.out.println(myChangePackage);

		return false;
	}

}
