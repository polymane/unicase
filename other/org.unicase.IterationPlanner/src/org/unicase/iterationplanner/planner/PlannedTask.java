package org.unicase.iterationplanner.planner;

import org.unicase.iterationplanner.assigneerecommendation.AssigneeExpertise;
import org.unicase.iterationplanner.assigneerecommendation.Task;

/**
 * This represents a task along with the assigneeExpertise chosen by planner algorithm to do this task. The
 * assigneeExpertise is actually an instance of AssigneeExperties, to experss its qualification for doing this task. The
 * expertise will then be used to evaluate IterationPlans.
 * 
 * @author zardosht
 */
public class PlannedTask {
	private final Task task;
	private AssigneeExpertise assigneeExpertise;
	private int iterationNumber;

	public PlannedTask(Task task) {
		this.task = task;
	}

	@Override
	public PlannedTask clone() {
		PlannedTask clone = new PlannedTask(this.task);
		clone.setAssigneeExpertise(this.assigneeExpertise);
		clone.setIterationNumber(this.iterationNumber);
		return clone;
	}

	public Task getTask() {
		return task;
	}

	public void setAssigneeExpertise(AssigneeExpertise assigneeExpertise) {
		this.assigneeExpertise = assigneeExpertise;
	}

	@Override
	public String toString() {
		String result = "Iteration: " + iterationNumber + " ---> "
			+ assigneeExpertise.getAssignee().getOrgUnit().getName() + " ---> " + task.getWorkItem().getName()
			+ " (Obejct: " + super.toString() + ")";
		return result;
	}

	public AssigneeExpertise getAssigneeExpertise() {
		return assigneeExpertise;
	}

	public void setIterationNumber(int iterationNumber) {
		this.iterationNumber = iterationNumber;
	}

	public int getIterationNumber() {
		return iterationNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PlannedTask)) {
			return false;
		}
		PlannedTask incomming = (PlannedTask) obj;
		if (!this.assigneeExpertise.equals(incomming.assigneeExpertise)) {
			return false;
		}
		if (!this.task.equals(incomming.task)) {
			return false;
		}
		if (this.iterationNumber != incomming.iterationNumber) {
			return false;
		}
		return true;
	}

}
