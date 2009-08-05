/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.dnd;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.TreeItem;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.common.dnd.dropadapters.AnnotationDropAdapter;
import org.unicase.ui.common.dnd.dropadapters.CompositeSectionDropAdapter;
import org.unicase.ui.common.dnd.dropadapters.LeafSectionDropAdapter;
import org.unicase.ui.common.dnd.dropadapters.MEDiagramDropAdapter;
import org.unicase.ui.common.dnd.dropadapters.MEDropAdapter;
import org.unicase.ui.common.dnd.dropadapters.MeetingDropAdapter;
import org.unicase.ui.common.dnd.dropadapters.ProjectDropAdapter;
import org.unicase.ui.common.dnd.dropadapters.WorkItemMeetingSectionDropAdapter;
import org.unicase.ui.common.dnd.dropadapters.WorkPackageDropAdapter;
import org.unicase.workspace.util.UnicaseCommand;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This is the central drop adapter for unicase views. This class acts as a dispatcher. It has a map of (EClass,
 * MEDropAdapter) which contains a reference to a specific drop adapter for each model element type.
 * 
 * @author Hodaie
 */
public class UCDropAdapter extends DropTargetAdapter {

	private TransactionalEditingDomain domain;
	private StructuredViewer viewer;

	private List<ModelElement> source;
	private ModelElement target;
	private EObject targetConatiner;
	private ModelElement dropee;

	private Map<EClass, MEDropAdapter> dropAdapters;

	/**
	 * this is used for performance, so that drop method do not need to find the appropriate drop adapter again.
	 */
	private MEDropAdapter targetDropAdapter;

	/**
	 * Actually I should be able to get event feedback from event.feedback But the problem is, the event feedback is
	 * correctly set in dragOver() method, but in drop() method it is set to 1 (only selection). That's why I save event
	 * feedback at the end of dragOver() in a variable, and check this variable in drop() instead of event.feedback
	 */
	private int eventFeedback;

	/**
	 * Constructor.
	 * 
	 * @param editingDomain editing domain
	 * @param viewer viewer
	 */
	public UCDropAdapter(TransactionalEditingDomain editingDomain, StructuredViewer viewer) {

		super();
		this.domain = editingDomain;
		this.viewer = viewer;

		dropAdapters = new HashMap<EClass, MEDropAdapter>();

		// MEDropAdapter
		dropAdapters.put(ModelPackage.eINSTANCE.getModelElement(), new MEDropAdapter(domain, viewer));

		// LeafSectionDropAdapter
		dropAdapters.put(DocumentPackage.eINSTANCE.getLeafSection(), new LeafSectionDropAdapter(domain, viewer));

		// CompositeSectionDropAdapter
		dropAdapters.put(DocumentPackage.eINSTANCE.getCompositeSection(), new CompositeSectionDropAdapter(domain,
			viewer));

		// WorkPackageDropAdapter
		dropAdapters.put(TaskPackage.eINSTANCE.getWorkPackage(), new WorkPackageDropAdapter(domain, viewer));

		// MeetingDropAdpater
		dropAdapters.put(MeetingPackage.eINSTANCE.getMeeting(), new MeetingDropAdapter(domain, viewer));

		// WorkItemMeetingSectionDropAdapter
		dropAdapters.put(MeetingPackage.eINSTANCE.getWorkItemMeetingSection(), new WorkItemMeetingSectionDropAdapter(
			domain, viewer));

		// MEDiagramDropAdapter
		dropAdapters.put(DiagramPackage.eINSTANCE.getMEDiagram(), new MEDiagramDropAdapter(domain, viewer));

		// AnnotationDropAdapter
		dropAdapters.put(ModelPackage.eINSTANCE.getAnnotation(), new AnnotationDropAdapter(domain, viewer));

		// ProjectDropAdapter
		dropAdapters.put(ModelPackage.eINSTANCE.getProject(), new ProjectDropAdapter(domain, viewer));

	}

	/**
	 * @param event DropTargetEvent
	 */
	@Override
	public void drop(final DropTargetEvent event) {

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				if ((eventFeedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER) {
					targetDropAdapter.dropMove(targetConatiner, target, source, true);
				} else if ((eventFeedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE) {
					targetDropAdapter.dropMove(targetConatiner, target, source, false);

				} else {
					targetDropAdapter.drop(event, target, source);
				}

			}

		}.run();

	}

	/**
	 * This is called continually from dragOver() event handler. This checks drop target and drop source to be not Null,
	 * and sets the target, source, and dropee fields.
	 * 
	 * @param event DropTargetEvent
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean extractDnDSourceAndTarget(DropTargetEvent event) {
		boolean result = true;
		List<Object> tmpSource = (List<Object>) DragSourcePlaceHolder.getDragSource();
		if (tmpSource == null) {
			result = false;
		}

		for (Object obj : tmpSource) {
			if (!(obj instanceof ModelElement)) {
				result = false;
			}
		}

		source = (List<ModelElement>) DragSourcePlaceHolder.getDragSource();
		if (source.size() == 0) {
			return false;
		}

		// take care that you cannot drop anything on project (project is not a
		// ModelElement)
		if (event.item == null || event.item.getData() == null || !(event.item.getData() instanceof ModelElement)) {
			result = false;
		}

		// check if source and target are in the same project
		if (result) {
			dropee = source.get(0);
			target = (ModelElement) event.item.getData();
			if (!target.getProject().equals(dropee.getProject())) {
				result = false;
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dragOver(DropTargetEvent event) {
		source = null;
		target = null;
		targetConatiner = null;
		targetDropAdapter = null;
		eventFeedback = 1;

		event.detail = DND.DROP_COPY;
		if (!extractDnDSourceAndTarget(event)) {
			event.detail = DND.DROP_NONE;
			return;
		}

		setInitialEventFeedback(event);
		eventFeedback = event.feedback;

		if (source.size() > 1) {
			event.detail = DND.DROP_NONE;
			return;
		}

		if ((eventFeedback & DND.FEEDBACK_INSERT_AFTER) == DND.FEEDBACK_INSERT_AFTER
			|| (eventFeedback & DND.FEEDBACK_INSERT_BEFORE) == DND.FEEDBACK_INSERT_BEFORE) {
			targetConatiner = target.eContainer();
			targetDropAdapter = getTargetDropAdapter(targetConatiner.eClass());

		} else {
			targetDropAdapter = getTargetDropAdapter(target.eClass());
		}

		if (!targetDropAdapter.canDrop(eventFeedback, event, source, target, dropee)) {
			event.detail = DND.DROP_NONE;
		}

	}

	/**
	 * This method searches drop adaptors map recursively to find the appropriate drop adapter for this model element
	 * type or one of its super types in model hierarchy.
	 * 
	 * @param targetEClass
	 * @return specific drop target for this model element type or one of its super types in model hierarchy.
	 */
	private MEDropAdapter getTargetDropAdapter(EClass targetEClass) {

		MEDropAdapter ret = dropAdapters.get(targetEClass);
		if (ret == null) {
			ret = getTargetDropAdapter(getSuperTypeHavingADropAdapter(targetEClass.getESuperTypes()));
		}

		return ret;
	}

	/**
	 * This is used by getDropTarget() method. It takes super classes of targetEClass and tries to find a unique drop
	 * adapter that matches one of super types. If there are more than one matching drop adapters, an exception is
	 * thrown. If there is no matching drop adapter, this method searches recursively until it finds one, or throws the
	 * exception.
	 * 
	 * @param superClazz super classes of targetEClass. If there is no match at the first call of method, this will be a
	 *            collection of super classes of each input super class.
	 * @return an EClass that is both super class of targetEClass (directly of indirectly) and has a drop adapter.
	 */
	private EClass getSuperTypeHavingADropAdapter(Collection<EClass> superClazz) {

		EClass ret = null;
		if (superClazz.size() == 0) {
			return ret;
		}

		Set<EClass> intersection = new HashSet<EClass>(dropAdapters.keySet());
		intersection.retainAll(superClazz);

		// check if intersection contains many classes, but if they are in an inheritance hierarchy keep only the
		// deepest class.
		// This must be discussed as a potential modeling problem.

		if (intersection.size() > 1) {
			Set<EClass> toBeRemoved = new HashSet<EClass>();
			for (EClass eClass1 : intersection) {
				for (EClass eClass2 : intersection) {
					if (!eClass2.equals(eClass1) && eClass2.isSuperTypeOf(eClass1)) {
						toBeRemoved.add(eClass2);
					}
				}
			}
			intersection.removeAll(toBeRemoved);
		}

		if (intersection.size() > 1) {
			throw new IllegalStateException("More than one drop adapter for this type found!");

		} else if (intersection.size() == 0) {
			Set<EClass> eclazz = new HashSet<EClass>();
			for (EClass superClass : superClazz) {
				eclazz.addAll(superClass.getESuperTypes());
			}
			ret = getSuperTypeHavingADropAdapter(eclazz);
		} else {
			ret = (EClass) intersection.toArray()[0];
		}

		return ret;
	}

	/**
	 * This sets the initial event feedback, and is also responsible for showing INSERT_AFTER and INSERT_BEFORE
	 * feedbacks according to mouse cursor position.
	 * 
	 * @param event DropTargetEvent
	 */
	private void setInitialEventFeedback(DropTargetEvent event) {
		event.feedback = DND.FEEDBACK_SELECT;

		if (event.item != null) {
			Rectangle rect = ((TreeItem) event.item).getBounds();
			Point pt = viewer.getControl().toControl(event.x, event.y);
			if (pt.y < rect.y + 5) {
				event.feedback = DND.FEEDBACK_INSERT_BEFORE;
			}
			if (pt.y > rect.y + rect.height - 5) {
				event.feedback = DND.FEEDBACK_INSERT_AFTER;
			}

		}
		event.feedback |= DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;

	}

}
