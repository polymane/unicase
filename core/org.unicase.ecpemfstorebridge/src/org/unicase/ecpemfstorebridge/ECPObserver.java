/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import org.eclipse.emf.ecore.EObject;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.PostECPWorkspaceInitiator;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.common.observer.ModelElementOpenObserver;
import org.unicase.ui.common.observer.TraceObserver;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author emueller
 * @author wesendon
 */
public class ECPObserver implements PostECPWorkspaceInitiator, TraceObserver, ModelElementOpenObserver {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ecp.model.PostECPWorkspaceInitiator#workspaceInitComplete(org.unicase.ecp.model.workSpaceModel.ECPWorkspace)
	 */
	public void workspaceInitComplete(ECPWorkspace currentWorkspace) {
		ECPWorkspaceManager.getObserverBus().register(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.observer.ModelElementOpenObserver#onOpen(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public void onOpen(EObject opened, String sourceView, String openView) {
		final String source = sourceView;
		final String readView = openView;
		final EObject me = opened;
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(me);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project p = ModelUtil.getProject(me);
				WorkspaceUtil
					.logReadEvent(projectSpace, (p == null ? null : p.getModelElementId(me)), source, readView);
			}
		}.run();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.observer.TraceObserver#onTrace(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.String)
	 */
	public void onTrace(EObject source, EObject target, String feature, String view) {
		if (source instanceof EObject && target instanceof EObject) {
			final EObject targetModelElement = target;
			final EObject sourceModelElement = source;
			final String featureName = feature;

			new UnicaseCommand() {
				@Override
				protected void doRun() {
					ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
						.getActiveProjectSpace();
					Project p1 = ModelUtil.getProject(sourceModelElement);
					Project p2 = ModelUtil.getProject(targetModelElement);
					WorkspaceUtil.logTraceEvent(activeProjectSpace, p1 == null ? null : p1
						.getModelElementId(sourceModelElement), p2 == null ? null : p2
						.getModelElementId(targetModelElement), featureName);
				}
			}.run();
		}

	}
}
