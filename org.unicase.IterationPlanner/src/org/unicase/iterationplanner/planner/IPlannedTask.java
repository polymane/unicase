package org.unicase.iterationplanner.planner;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.ITask;

public interface IPlannedTask {

	IPlannedTask clone() throws CloneNotSupportedException;

	ITask getTask();

	AssigneeExpertise getAssigneeExpertise();

	int getIterationNumber();
	

	/**
	 * true if Task, AssigneeExpertise, and iterationNumber are equal.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	boolean equals(Object obj);
	
	
	/**
	 * If two PlannedTask objects are equal (equals() method returns true for them) then their hashCode must be identical.
	 * @return
	 */
	int hashCode();

	/**
	 * true if Tasks in both instances are equal.
	 */
	boolean equalsTask(Object obj);
	
	/**
	 * if this planned task must be considered in expertise evaluation of iteration plan. When all 
	 * assignees have 0.0 expertise regarding a task, it should not be considered in evaluation of
	 * expertise criteria of iteration plan. 
	 * @return
	 */
	boolean isEvaluateExpertise();
	
	
	/**
	 * if this planned task must be considered in expertise evaluation of iteration plan. When all 
	 * assignees have 0.0 expertise regarding a task, it should not be considered in evaluation of
	 * expertise criteria of iteration plan. 
	 * @param evaluateExpertise
	 */
	void setEvaluateExperties(boolean evaluateExpertise);

}