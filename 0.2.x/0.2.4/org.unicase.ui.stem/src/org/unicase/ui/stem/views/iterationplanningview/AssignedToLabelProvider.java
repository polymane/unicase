/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.bug.BugReport;
import org.unicase.model.task.ActionItem;

/**.
 * LabelProvider for Assigned to column in IterationPlanningView
 * @author Helming
 *
 */
public class AssignedToLabelProvider extends IterationPlanningLabelProvider {

	
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	/**.
	 * Constructor
	 */
	public AssignedToLabelProvider() {
		super();
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	
	/**.
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		EObject assignee = getAssignee(element);
		if (assignee==null){
			return null;
		}
		return adapterFactoryLabelProvider.getImage(assignee);
	}

	
	/**.
	 * returns the Assignee of an Assignable element
	 * @param element the Assignable
	 * @return
	 */
	private EObject getAssignee(Object element) {
		
		if(element instanceof BugReport){
			return ((BugReport) element).getAssignee();
		}
		if(element instanceof ActionItem){
			ActionItem ai = (ActionItem) element;
				return ai.getAssignee();
		}
		return null;
	}

	/**.
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public String getText(Object element) {
		EObject assignee = getAssignee(element);
		if (assignee==null){
			return "N/A";
		}
		return adapterFactoryLabelProvider.getText(assignee);
	}
	
	

	
	
	
}
