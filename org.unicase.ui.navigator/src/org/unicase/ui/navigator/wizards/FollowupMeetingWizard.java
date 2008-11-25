package org.unicase.ui.navigator.wizards;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.model.document.LeafSection;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author naughton
 * 
 *         Wizard for creating a follow-up meeting.
 * 
 */
public class FollowupMeetingWizard extends Wizard implements IWorkbenchWizard {

	private Meeting selectedMeeting;
	private Meeting followupMeeting;
	private boolean canFinish;
	private MeetingNameDescriptionPage namePage;
	private MeetingWorkItemCarryPage itemCarryPage;

	/**
	 * Sets if the wizard can be finished.
	 * 
	 * @param canFinish Can the wizard finish?
	 */
	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}

	/**
	 * Accesses the meeting the followup meeting is based on.
	 * 
	 * @return Base meeting.
	 */
	public Meeting getSelectedMeeting() {
		return selectedMeeting;
	}

	/**
	 * Accesses the meeting being generated.
	 * 
	 * @return Followup meeting.
	 */
	public Meeting getFollowupMeeting() {
		return followupMeeting;
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void addPages() {
		namePage = new MeetingNameDescriptionPage(
				"NamePage");
		addPage(namePage);
		itemCarryPage = new MeetingWorkItemCarryPage(
				"ItemCarryPage");
		addPage(itemCarryPage);
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public boolean canFinish() {
		return canFinish;

	}

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		followupMeeting = MeetingFactory.eINSTANCE.createMeeting();
		canFinish = false;
		// get the meeting selected in the navigator
		Object firstElement;
		if (!selection.isEmpty()) {
			firstElement = selection.getFirstElement();
			if (firstElement instanceof Meeting) {
				selectedMeeting = (Meeting) firstElement;
			} else {
				throw new IllegalArgumentException("No Meeting selected!");
			}
		} else {
			throw new IllegalArgumentException("Nothing selected!");
		}
	}
	
	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public boolean performFinish() {
		if (!(selectedMeeting.eContainer() instanceof LeafSection)) {
			return false;
		} else {
			createFollowupMeeting();
			return true;
		}
	}

	private void createFollowupMeeting() {
		final LeafSection leafSection = (LeafSection) selectedMeeting.eContainer();
		TransactionalEditingDomain domain = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getEditingDomain();
		
		followupMeeting.setName(namePage.getMeetingName());
		followupMeeting.setDescription(namePage.getMeetingDescription());
		
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				leafSection.getModelElements().add(followupMeeting);
			}
		});

		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				addMeetingSections(followupMeeting);
			}
		});

		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				addMeetingSubSections(followupMeeting);
			}
		});

		final List<WorkItem> statusItems = itemCarryPage.getStatusWorkItems();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				addMeetingStatusItems(followupMeeting, statusItems);
			}
		});
		
		ActionHelper.openModelElement(followupMeeting, this.getClass()
				.getName());
	}
	
	private void addMeetingStatusItems(Meeting meeting,
			List<WorkItem> statusItems) {
		CompositeMeetingSection informationExchangeSection = (CompositeMeetingSection)meeting.getSections().get(1);
		WorkItemMeetingSection workItemMeetingSection = (WorkItemMeetingSection) informationExchangeSection.getSubsections().get(0);
		for(WorkItem workItem : statusItems) {
			workItemMeetingSection.getIncludedWorkItems().add(workItem);
		}
	}
	
	private void addMeetingSections(Meeting meeting) {		
		CompositeMeetingSection objectiveSection = (CompositeMeetingSection) ActionHelper.createModelElement(MeetingFactory.eINSTANCE, MeetingPackage.eINSTANCE.getCompositeMeetingSection());
		CompositeMeetingSection informationExchangeSection = (CompositeMeetingSection) ActionHelper.createModelElement(MeetingFactory.eINSTANCE, MeetingPackage.eINSTANCE.getCompositeMeetingSection());
		CompositeMeetingSection wrapUpSection = (CompositeMeetingSection) ActionHelper.createModelElement(MeetingFactory.eINSTANCE, MeetingPackage.eINSTANCE.getCompositeMeetingSection());
		IssueMeetingSection discussionSection = (IssueMeetingSection) ActionHelper.createModelElement(MeetingFactory.eINSTANCE, MeetingPackage.eINSTANCE.getIssueMeetingSection());


		//set attributes
		objectiveSection.setName("Objective");
		informationExchangeSection.setName("Information sharing");
		wrapUpSection.setName("Wrap up");
		discussionSection.setName("Discussion");

		
		informationExchangeSection.setAllocatedTime(30);
		discussionSection.setAllocatedTime(50);
		wrapUpSection.setAllocatedTime(10);
		
		//set links
		meeting.getSections().add(objectiveSection);
		meeting.getSections().add(informationExchangeSection);
		meeting.getSections().add(discussionSection);
		meeting.getSections().add(wrapUpSection);
		
	
		meeting.setIdentifiedIssuesSection(discussionSection);
	}
	
	private void addMeetingSubSections(Meeting meeting) {
		CompositeMeetingSection miscSection = (CompositeMeetingSection) ActionHelper.createModelElement(MeetingFactory.eINSTANCE, MeetingPackage.eINSTANCE.getCompositeMeetingSection());
		CompositeMeetingSection meetingCritiqueSection = (CompositeMeetingSection) ActionHelper.createModelElement(MeetingFactory.eINSTANCE, MeetingPackage.eINSTANCE.getCompositeMeetingSection());
		WorkItemMeetingSection workItemsSection = (WorkItemMeetingSection) ActionHelper.createModelElement(MeetingFactory.eINSTANCE, MeetingPackage.eINSTANCE.getWorkItemMeetingSection());
		WorkItemMeetingSection newWorkItemsSection = (WorkItemMeetingSection) ActionHelper.createModelElement(MeetingFactory.eINSTANCE, MeetingPackage.eINSTANCE.getWorkItemMeetingSection());
		
		workItemsSection.setName("Action items");
		newWorkItemsSection.setName("New action items");
		miscSection.setName("Misc");
		meetingCritiqueSection.setName("Meeting critique");
		
		CompositeMeetingSection informationExchangeSection = (CompositeMeetingSection)meeting.getSections().get(1);
		CompositeMeetingSection wrapUpSection = (CompositeMeetingSection)meeting.getSections().get(3);
		
		//set links
		informationExchangeSection.getSubsections().add(workItemsSection);
		informationExchangeSection.getSubsections().add(miscSection);
		wrapUpSection.getSubsections().add(newWorkItemsSection);
		wrapUpSection.getSubsections().add(meetingCritiqueSection);
		
		meeting.setIdentifiedWorkItemsSection(newWorkItemsSection);
	}
}
