package org.unicase.ui.web.tabs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.workspace.ProjectSpace;

public class TaskListView extends AbstractListView {

	public TaskListView(ProjectSpace projectSpace, Composite composite) {
		super(projectSpace, composite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<EStructuralFeature> getFeatureList() {
		ArrayList<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		list.add(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__STATE);
		list.add(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME);
		list.add(TaskPackage.Literals.WORK_ITEM__ASSIGNEE);
		list.add(MetamodelPackage.Literals.MODEL_ELEMENT__CREATION_DATE);
		list.add(MetamodelPackage.Literals.MODEL_ELEMENT__CREATOR);
		list.add(TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE);
		list.add(TaskPackage.Literals.WORK_ITEM__DUE_DATE);
		list.add(TaskPackage.Literals.WORK_ITEM__PRIORITY);

		return list;
	}
	

	@Override
	public void setListInput() {	
		final List<? extends Checkable> taskItems = getProjectSpace().getProject()
				.getAllModelElementsbyClass(
						TaskPackage.eINSTANCE.getCheckable(),
						new BasicEList<Checkable>());
		
		for (Iterator<? extends Checkable> iterator = taskItems.iterator(); iterator.hasNext();) {
			Checkable item = iterator.next();
			if (item instanceof ActionItem) {
				if (((ActionItem) item).isDone()) {
					iterator.remove();
				}
			} else if (item instanceof BugReport) {
				if (((BugReport) item).isDone()) {
					iterator.remove();
				}
			} else if (item instanceof Issue) {
				if (((Issue) item).getSolution() != null) {
					iterator.remove();
				}
			}
		}
		
		
		final WritableList list = (WritableList) (getInput());
		if (list == null) {
			// the case of first time of input setting to table
			WritableList emfList = new WritableList(Realm.getDefault(),
					taskItems, UnicaseModelElement.class);
			setInput(emfList);
		} else {
			list.getRealm().asyncExec(new Runnable() {

				public void run() {
					// remove all elements
					list.retainAll(new BasicEList<UnicaseModelElement>());
					// adds new task items
					list.addAll(taskItems);
				}
			});
		}
	}


}
