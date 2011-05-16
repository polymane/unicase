/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.adapter.subclipse;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.adapter.commands.SubclipseCreateChangePackageCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.ui.BasicApplyPatchChangePackageCommand;
import org.unicase.changetracking.vcs.BasicVCSAdapter;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.patch.PatchChangePackage;
import org.unicase.model.task.WorkItem;

public class SubclipseVCSAdapter extends BasicVCSAdapter {

	public boolean doesChangePackageNeedRepoLocation() {
		return false;
	}
	
	@Override
	public ChangeTrackingCommand createChangePackage(IProject localProject,
			WorkItem workItem, RepositoryLocation remoteRepo, String name,
			String shortDescription, String longDescription) {
		return new SubclipseCreateChangePackageCommand(localProject, workItem, name, shortDescription, longDescription);
	}
	
	@Override
	public ChangeTrackingCommand applyChangePackage(ChangePackage changePackage) {
		return new BasicApplyPatchChangePackageCommand((PatchChangePackage) changePackage);
	}





}
