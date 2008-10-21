/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.navigator.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.document.LeafSection;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**
 * 
 * @author Hodaie This is implementation of New Model Element wizard. This
 *         wizard is show through "Add new model element..." command in context
 *         menu of Navigator (only on right click on LeafSection). The wizard
 *         shows a tree of model packages and their classes. The user can select
 *         a Model Element type in this tree and on finish the model element is
 *         created, added to Leaf- or CompositeSection and opend for editing.
 * 
 */
public class NewModelElementWizard extends Wizard implements IWorkbenchWizard {

	private ModelElement selectedME;
	/**
	 * . Through this field, the ModelTreePage tells the wizard which model
	 * element type is selected
	 */
	private EClass newMEType;

	/**
	 * Through this field, the ModelTreePage tells the wizard if it's ready to
	 * finish, i.e. if the selection a model element is and not a package.
	 */
	private boolean treePageCompleted;
	
	/**
	 * Through this field, the ModelTreePage tells the wizard, which diagram type should be created
	 * e.g. a Class Diagram or Usecase Diagram
	 */
	private DiagramType newDiagramType;

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void addPages() {

		ModelTreePage treePage = new ModelTreePage("ModelTreePage");
		addPage(treePage);

	}

	/**
	 * . ({@inheritDoc}) This method creates a model element instance from
	 * selected type, adds it to Leaf- or CompositeSection, and opens it.
	 */
	@Override
	public boolean performFinish() {
		final ModelElement newMEInstance;
		if (selectedME != null && newMEType != null) {
			// 1.create ME
			EPackage ePackage = newMEType.getEPackage();
			newMEInstance = (ModelElement) ActionHelper.createModelElement(ePackage.getEFactoryInstance(),newMEType);
			newMEInstance.setName("new " + newMEType.getName());

			if(newMEInstance instanceof MEDiagram) {
				((MEDiagram) newMEInstance).setType(this.newDiagramType);
				newMEInstance.setName("new " + this.newDiagramType.getLiteral());
			}
			// 2.add the newly created ME to LeafSection that was selected in
			// navigator
			if (selectedME instanceof LeafSection) {

				TransactionalEditingDomain domain = WorkspaceManager
						.getInstance().getCurrentWorkspace().getEditingDomain();
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						((LeafSection) selectedME).getModelElements().add(
								newMEInstance);
					}
				});

			}
			//FIXME: added DOLLI meeting structure as default - needs flexible approach.
			if (newMEInstance instanceof Meeting) {
				TransactionalEditingDomain domain = WorkspaceManager
						.getInstance().getCurrentWorkspace().getEditingDomain();
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						Meeting meeting = (Meeting) newMEInstance;

						// create all DOLLI sections
						CompositeMeetingSection objectiveSection = MeetingFactory.eINSTANCE
								.createCompositeMeetingSection();
						CompositeMeetingSection informationExchangeSection = MeetingFactory.eINSTANCE
								.createCompositeMeetingSection();
						CompositeMeetingSection miscSection = MeetingFactory.eINSTANCE
								.createCompositeMeetingSection();
						CompositeMeetingSection wrapUpSection = MeetingFactory.eINSTANCE
								.createCompositeMeetingSection();
						CompositeMeetingSection meetingCritiqueSection = MeetingFactory.eINSTANCE
								.createCompositeMeetingSection();
						IssueMeetingSection discussionSection = MeetingFactory.eINSTANCE
								.createIssueMeetingSection();
						WorkItemMeetingSection workItemsSection = MeetingFactory.eINSTANCE
								.createWorkItemMeetingSection();
						WorkItemMeetingSection newWorkItemsSection = MeetingFactory.eINSTANCE
								.createWorkItemMeetingSection();

						// set attributes
						objectiveSection.setName("Objective");
						informationExchangeSection
								.setName("Information exchange");
						miscSection.setName("Misc");
						wrapUpSection.setName("Wrap up");
						meetingCritiqueSection.setName("Meeting critique");
						discussionSection.setName("Discussion");
						workItemsSection.setName("Work items");
						newWorkItemsSection.setName("New work items");

						informationExchangeSection.setAllocatedTime(30);
						discussionSection.setAllocatedTime(50);
						wrapUpSection.setAllocatedTime(10);

						// set links
						informationExchangeSection.getSubsections().add(
								workItemsSection);
						informationExchangeSection.getSubsections().add(
								miscSection);
						wrapUpSection.getSubsections().add(newWorkItemsSection);
						wrapUpSection.getSubsections().add(
								meetingCritiqueSection);

						meeting.getSections().add(objectiveSection);
						meeting.getSections().add(informationExchangeSection);
						meeting.getSections().add(discussionSection);
						meeting.getSections().add(wrapUpSection);

						meeting.setIdentifiedIssuesSection(discussionSection);
						meeting
								.setIdentifiedWorkItemsSection(newWorkItemsSection);

						meeting.setName("Dolli meeting");
					}
				});
			}
			// 3.open the newly created ME
			ActionHelper.openModelElement(newMEInstance);
		}

		return true;
	}
		
	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// get the in navigator selected ME
		Object o;
		if (!selection.isEmpty()) {
			o = selection.getFirstElement();
			if (o instanceof ModelElement) {
				selectedME = (ModelElement) o;
			}
		}

	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public boolean canFinish() {
		return treePageCompleted;

	}

	/**
	 * @see newMEType
	 * @param newMEType
	 *            The ME type that was in ModelTreePage selected.
	 */
	public void setNewMEType(EClass newMEType) {
		this.newMEType = newMEType;
	}

	/**
	 * @see treePageCompeleted
	 * @param treePageCompleted
	 *            If ModelTreePage is complete (i.e. its selection is a ME)
	 */
	public void setTreePageCompleted(boolean treePageCompleted) {
		this.treePageCompleted = treePageCompleted;
	}

	/**
	 * @see newDiagramType
	 * @param type
	 *            the type of the diagram, to be created.
	 */
	public void setNewDiagramType(DiagramType type) {
		this.newDiagramType = type;
		
	}

}
