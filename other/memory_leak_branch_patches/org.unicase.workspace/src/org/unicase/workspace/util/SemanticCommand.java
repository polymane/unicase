/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.metamodel.Project;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.exceptions.UnkownProjectException;

/**
 * Command for executing semantic operations on a project.
 * 
 * @author koegel
 */
public class SemanticCommand extends UnicaseCommand {

	private final Project project;
	private final SemanticCompositeOperation semanticOperation;

	/**
	 * Constructor.
	 * 
	 * @param project the project to run the operation on.
	 * @param semanticOpertation the operation to execute.
	 */
	public SemanticCommand(Project project, SemanticCompositeOperation semanticOpertation) {
		if (semanticOpertation.getName() == null || semanticOpertation.getDescription() == null
			|| semanticOpertation.getModelElementId() == null) {
			throw new IllegalArgumentException("Name, description or modelElementId are not set!");
		}
		this.project = project;
		this.semanticOperation = semanticOpertation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.util.UnicaseCommand#doRun()
	 */
	@Override
	protected void doRun() {
		Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		try {
			ProjectSpace projectSpace = currentWorkspace.getProjectSpace(project);
			CompositeOperationHandle handle = projectSpace.beginCompositeOperation();
			semanticOperation.semanticApply(project);
			try {
				handle.end(semanticOperation);
			} catch (InvalidHandleException e) {
				WorkspaceUtil.logException(
					"Semantic command failed because of illegal state of composite operation handle!", e);
			}

		} catch (UnkownProjectException e) {
			// project is not in a projectspace, just execute operation
			semanticOperation.semanticApply(project);
			return;
		}

	}
}
