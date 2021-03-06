/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.unicasecommon.common.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseEventUtil;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * . This is a generic handler to add different types of Annotations to a ModelElement
 * 
 * @author Hodaie
 */
public class AddAnnotationHandler extends AbstractHandler {

	private static final String ADD_ACTIONITEM_COMMAND_ID = "org.unicase.ui.common.commands.annotateActionItem";
	private static final String ADD_ISSUE_COMMAND_ID = "org.unicase.ui.common.commands.annotateIssue";

	private ExecutionEvent event;

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Annotation annotation = null;
		this.event = event;

		// 1. extract the model element, to which the Annotation will be
		// attached
		// see ActionHelper.getModelElement()
		UnicaseModelElement me = UnicaseActionHelper.getModelElement(event);
		// 2. extract command and create the appropriate annotation object
		Project project = me.getProject();
		if (!(me.getLeafSection() == null)) {
			annotation = createAnnotation(me.getLeafSection(), 1);
		} else if (me.eContainer() instanceof WorkPackage) {
			annotation = createAnnotation(me, 2);
		} else if (!(project == null)) {
			annotation = createAnnotation(project, 3);
		} else {
			return null;
		}
		attachAnnotation(me, annotation);
		// log event
		UnicaseEventUtil.logAnnotationEvent(me, annotation);

		// 3. open annotation object for further editing
		openAnnotation(annotation);

		return null;
	}

	/**
	 * . This creates the appropriate Annotation based on selected menu command and adds it to Project
	 * 
	 * @param leafSection
	 * @return
	 */
	private Annotation createAnnotation(final Object object, final int i) {
		final Annotation result;

		if (event.getCommand().getId().equals(ADD_ACTIONITEM_COMMAND_ID)) {
			result = TaskFactory.eINSTANCE.createActionItem();
			result.setName("New Action Item");
			result.setDescription("");

		} else if (event.getCommand().getId().equals(ADD_ISSUE_COMMAND_ID)) {
			result = RationaleFactory.eINSTANCE.createIssue();
			result.setName("New Issue");
			result.setDescription("");
		} else {
			result = null;
		}

		new UnicaseCommand() {
			@SuppressWarnings("unchecked")
			@Override
			protected void doRun() {
				if (i == 1) {
					((LeafSection) object).getModelElements().add(result);
				} else if (i == 2) {

					EObject parent = ((EObject) object).eContainer();
					while (!(parent instanceof Project) && result.eContainer() == null && !(object instanceof LeafSection)) {
						EReference reference = getStructuralFeature(result, parent);
						if (reference != null && reference.isMany()) {
							Object object = parent.eGet(reference);
							EList<EObject> eList = (EList<EObject>) object;
							eList.add(result);
						}

					}

				} else if (i == 3) {
					((Project) object).getModelElements().add(result);
				}
			}

		}.run();

		return result;
	}

	/**
	 * . This attaches the Annotation to ModelElement
	 * 
	 * @param me
	 * @param annotation
	 */
	private void attachAnnotation(final UnicaseModelElement me, final Annotation annotation) {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				me.getAnnotations().add(annotation);
			}
		}.run();
	}

	/**
	 * . This opens Annotation for further editing
	 * 
	 * @param annotation
	 */
	private void openAnnotation(Annotation annotation) {

		ActionHelper.openModelElement(annotation, this.getClass().getName());

	}

	private EReference getStructuralFeature(final ModelElement newMEInstance, EObject parent) {
		// the value of the 'EAll Containments' reference list.
		List<EReference> eallcontainments = parent.eClass().getEAllContainments();
		EReference reference = null;
		for (EReference containmentitem : eallcontainments) {

			if (containmentitem.getEReferenceType().equals(newMEInstance)) {
				reference = containmentitem;

				break;
			} else if (containmentitem.getEReferenceType().isSuperTypeOf(newMEInstance.eClass())) {

				reference = containmentitem;
				break;
			}
		}
		return reference;
	}

}
