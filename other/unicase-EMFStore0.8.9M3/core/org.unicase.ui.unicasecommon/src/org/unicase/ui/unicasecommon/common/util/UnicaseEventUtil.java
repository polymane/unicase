/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.util;

import java.util.Calendar;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.versioning.events.AnnotationEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsFactory;
import org.unicase.model.Annotation;

/**
 * Helper class to log events.
 * 
 * @author helming
 */
public final class UnicaseEventUtil {

	private UnicaseEventUtil() {
		// nothing to do
	}

	/**
	 * @param me The annotated model element
	 * @param annotation the new annoation
	 */
	public static void logAnnotationEvent(EObject me, Annotation annotation) {
		final AnnotationEvent annotationEvent = EventsFactory.eINSTANCE.createAnnotationEvent();
		annotationEvent.setAnnotatedElement(ModelUtil.getProject(me).getModelElementId(me));
		annotationEvent.setAnnotation(ModelUtil.getProject(annotation).getModelElementId(annotation));
		annotationEvent.setTimestamp(Calendar.getInstance().getTime());
		final ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
			.getActiveProjectSpace();
		if (activeProjectSpace != null) {

			new EMFStoreCommand() {
				@Override
				protected void doRun() {
					activeProjectSpace.addEvent(annotationEvent);
				}
			}.run();

		}

	}

}
