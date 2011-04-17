package org.unicase.iterationplanner.planner.impl.shiftdownplanner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.unicase.iterationplanner.assigneeRecommender.AssigneeExpertise;
import org.unicase.iterationplanner.assigneeRecommender.ITask;
import org.unicase.iterationplanner.assigneeRecommender.TaskPotentialAssigneeList;
import org.unicase.iterationplanner.planner.AbstractPlanner;
import org.unicase.iterationplanner.planner.AssigneeAvailabilityManager;
import org.unicase.iterationplanner.planner.IIterationPlan;
import org.unicase.iterationplanner.planner.IPlannedTask;
import org.unicase.iterationplanner.planner.ISelectionStrategy;
import org.unicase.iterationplanner.planner.PlannerParameters;
import org.unicase.iterationplanner.planner.PlannerUtil;


public class ShiftDownPlanner extends AbstractPlanner {


	public ShiftDownPlanner(int numOfIterations, List<TaskPotentialAssigneeList> taskPotentialAssigneeLists,
		AssigneeAvailabilityManager assigneeAvailabilityManager, ShiftDownEvaluator evaluator, ISelectionStrategy selector,
		PlannerParameters plannerParameters) {
		
		super(numOfIterations, taskPotentialAssigneeLists, assigneeAvailabilityManager, evaluator, selector, plannerParameters);
	}

	@Override
	protected void completeNextGeneration(List<IIterationPlan> nextGeneration) {
		// for now just clone some of individuals
		int numOfIndividualsToAdd = getPlannerParameters().getPopulationSize() - nextGeneration.size();
		Random random = getPlannerParameters().getRandom();
		for (int i = 0; i < numOfIndividualsToAdd; i++) {
			ShiftDownIterationPlan cloneCandidate = (ShiftDownIterationPlan) nextGeneration.get(random.nextInt(nextGeneration.size()));
			ShiftDownIterationPlan clone = (ShiftDownIterationPlan) cloneCandidate.clone();
			nextGeneration.add(clone);
		}
	}

	@Override
	protected void copyIntoNextGeneration(List<IIterationPlan> cloneCandidates) {
		Random random = getPlannerParameters().getRandom();
		int numOfClones = (int) ((getPlannerParameters().getPercentOfClones() / 100.0) * getPlannerParameters()
			.getPopulationSize());
		for (int i = 0; i < numOfClones; i++) {
			ShiftDownIterationPlan clone = (ShiftDownIterationPlan) cloneCandidates.get(random.nextInt(cloneCandidates.size())).clone();
			// we don't need to clone the object here.
			addToNextGeneration(clone);
		}
	}

	@Override
	protected List<IIterationPlan> createInitialPopulation() {
		List<IIterationPlan> initPopulation = new ArrayList<IIterationPlan>();
		int populationSize = getPlannerParameters().getPopulationSize();
		for (int i = 0; i < populationSize; i++) {
			ShiftDownIterationPlan iterPlan = createIterationPlan();
			initPopulation.add(iterPlan);
		}

		return initPopulation;
	}

	private ShiftDownIterationPlan createIterationPlan() {
		Random random = getPlannerParameters().getRandom();
		ShiftDownIterationPlan iterPlan = new ShiftDownIterationPlan(getNumOfIterations(), getTaskPotentialAssigneeListMap().keySet().size(), getAssigneeAvailabilityManager());

		for (ITask taskToPlan : getTaskPotentialAssigneeListMap().keySet()) {
			// set assignee and put it into an iteration
			ShiftDownPlannedTask plannedTask = new ShiftDownPlannedTask(taskToPlan);
			// we must first add this task to planned tasks, so that it is considered for computing total estimate for
			// an assignee in an iteration
			iterPlan.addPlannedTask(plannedTask);
			int iterationNumber = PlannerUtil.getInstance(random).getIterationNumberProbabilistic(taskToPlan,
				getNumOfIterations());
			iterPlan.setIterationNumberFor(plannedTask, iterationNumber);

			plannedTask.setEvaluateExperties(isEvaluateExperties(taskToPlan));
			List<AssigneeExpertise> potentialAssignees = getTaskPotentialAssigneeListMap().get(taskToPlan);
			AssigneeExpertise assignee = findAssignee(potentialAssignees, null);
			iterPlan.setAssigneeFor(plannedTask, assignee);

		}

		return iterPlan;
	}

	private AssigneeExpertise findAssignee(List<AssigneeExpertise> potentialAssignees, AssigneeExpertise currentAssignee) {

		return PlannerUtil.getInstance(getPlannerParameters().getRandom()).getAssigneeProbabilistic(potentialAssignees, currentAssignee);
	}

	@Override
	protected void crossoverIntoNextGeneration(List<IIterationPlan> parentCandidates) {
		// do for numOfChildren
		// get two parents
		// child = crossOver(parent1, parent2);
		// nextGeneration.add(child);
		Random random = getPlannerParameters().getRandom();
		int numOfChildren = (int) ((getPlannerParameters().getPercentOfCrossOverChildren() / 100.0) * getPlannerParameters()
			.getPopulationSize());

		//crossover returns two children, therefore numOfChildren/2
		for (int i = 0; i < numOfChildren / 2; i++) {
			ShiftDownIterationPlan parent1 = (ShiftDownIterationPlan) parentCandidates.get(random.nextInt(parentCandidates.size()));
			ShiftDownIterationPlan parent2 = (ShiftDownIterationPlan) parentCandidates.get(random.nextInt(parentCandidates.size()));
			List<ShiftDownIterationPlan> children = crossover(parent1, parent2);
			addToNextGeneration(children.get(0));
			addToNextGeneration(children.get(1));
		}
	}

	/**
	 * P1 x P2 ==> C1 & C2 
	 * 1. merge first iteration of both parents and set it as first iteration (I1) of both children. Obviously task 
	 * that are common in first iteration of parents will not be duplicated.
	 * 2. in children go through task in I1 and for each of them remove it from other iteration or backlog if
	 * you find a duplicate of it there. 
	 * 3. run the Invariant correction on both C1 & C2 (i.e. shift down low priority tasks, until invariant is held).
	 * 
	 *  
	 * @param parent1
	 * @param parent2
	 * @return 2 children
	 */
	private List<ShiftDownIterationPlan> crossover(ShiftDownIterationPlan p1, ShiftDownIterationPlan p2) {
		List<ShiftDownIterationPlan> children = new ArrayList<ShiftDownIterationPlan>();
		PlannerUtil plannerUtil = PlannerUtil.getInstance(getPlannerParameters().getRandom());
		ShiftDownIterationPlan clone1 = (ShiftDownIterationPlan) p1.clone();
		ShiftDownIterationPlan clone2 = (ShiftDownIterationPlan) p2.clone();
		
		Set<IPlannedTask> plannedTasksInP1I0 = new HashSet<IPlannedTask>(); 
		plannedTasksInP1I0.addAll(clone1.getAllPlannedTasksForIteration(0));
		Set<IPlannedTask> allPlannedTasksInP1 = new HashSet<IPlannedTask>(); 
		allPlannedTasksInP1.addAll(plannerUtil.getPlannedTasks(clone1));
		
		Set<IPlannedTask> plannedTasksInP2I0 = new HashSet<IPlannedTask>(); 
		plannedTasksInP2I0.addAll(clone2.getAllPlannedTasksForIteration(0));
		Set<IPlannedTask> allPlannedTasksInP2 = new HashSet<IPlannedTask>(); 
		allPlannedTasksInP2.addAll(plannerUtil.getPlannedTasks(clone2));
		
		Set<IPlannedTask> plannedTasksForI0 = plannerUtil.unionOnTasks(plannedTasksInP1I0, plannedTasksInP2I0);

		ShiftDownIterationPlan c1 = new ShiftDownIterationPlan(clone1.getNumOfIterations(), getTaskPotentialAssigneeListMap().keySet().size(), getAssigneeAvailabilityManager());
		ShiftDownIterationPlan c2 = new ShiftDownIterationPlan(clone2.getNumOfIterations(), getTaskPotentialAssigneeListMap().keySet().size(), getAssigneeAvailabilityManager());
		c1.setCrossover(true);
		c2.setCrossover(true);
		for(IPlannedTask pt : plannedTasksForI0){
			try {
				c1.addPlannedTask(pt.clone());
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
			try {
				c2.addPlannedTask(pt.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		
		
		//remove from all tasks of p1 and p2 those that are in tasksForI0. 
		//then add all remaining tasks of p1 to c1 and p2 to c2.
		//Because tasksForI0 is union of I0 of both parents and we don't want these to be other iterations in children.
		Set<IPlannedTask> restTasksForC1 = plannerUtil.subtractOnTasks(allPlannedTasksInP1, plannedTasksForI0);
		Set<IPlannedTask> restTasksForC2 = plannerUtil.subtractOnTasks(allPlannedTasksInP2, plannedTasksForI0);
		c1.addAll(restTasksForC1); 
		c2.addAll(restTasksForC2);
		
		assert(plannerUtil.getPlannedTasks(c1).size() == getTaskPotentialAssigneeListMap().keySet().size());
		assert(plannerUtil.getPlannedTasks(c2).size() == getTaskPotentialAssigneeListMap().keySet().size());
		assert(plannerUtil.subtractOnTasks(plannerUtil.getPlannedTasks(c1), allPlannedTasksInP1).size() == 0);
		assert(plannerUtil.subtractOnTasks(plannerUtil.getPlannedTasks(c2), allPlannedTasksInP2).size() == 0);
	
		c1.setCrossover(false);
		c2.setCrossover(false);
		
		children.add(c1);
		children.add(c2);

//		children.add(p1.clone());
//		children.add(p2.clone());
		
		return children;
	}

	@Override
	protected boolean isBreakCretieriaMet() {
		return false;
	}

	@Override
	protected void mutateIntoNextGeneration(List<IIterationPlan> mutationCandidates) {
		Random random = getPlannerParameters().getRandom();
		int numOfMutants = (int) ((getPlannerParameters().getPrecentOfMutants() / 100.0) * getPlannerParameters()
			.getPopulationSize());

		for (int i = 0; i < numOfMutants; i++) {
			ShiftDownIterationPlan mutationCandidate = (ShiftDownIterationPlan) mutationCandidates.get(random.nextInt(mutationCandidates.size()));
			ShiftDownIterationPlan mutant = mutate(mutationCandidate);
			addToNextGeneration(mutant);
		}
	}

	private ShiftDownIterationPlan mutate(ShiftDownIterationPlan mutationCandidate) {
		// mutation possibilities: 1. change iteration of a task, change assignee of a task
		// 1. well question is, for how many tasks should we do these changes?
		// 2. another question is, how to choose the tasks to mutate? random?
		// Answers:
		// 1. it will be set as a planner parameter (e.g. 10 %)
		// 2. I choose them from high priority tasks in backlog. If backlog does not have enough tasks, 
		//    then no problem. Choose as long as this 10% are in backlog, or backlog does not have any tasks 
		
		ShiftDownIterationPlan mutantIterationPlan = (ShiftDownIterationPlan) mutationCandidate.clone();
		int percentOfTasksToMutate = getPlannerParameters().getPercentOfTasksToMutate();

		Collection<IPlannedTask> tasksToMutate = selectTasksToMutate(mutantIterationPlan, percentOfTasksToMutate);
		
		for (IPlannedTask taskToMutate : tasksToMutate) {
			List<AssigneeExpertise> potentialAssignees = getTaskPotentialAssigneeListMap().get(taskToMutate.getTask());
			AssigneeExpertise assigneeExpertise = findAssignee(potentialAssignees, taskToMutate.getAssigneeExpertise());
			int iterationNumber = PlannerUtil.getInstance(getPlannerParameters().getRandom())
				.getIterationNumberProbabilistic(taskToMutate.getTask(), getNumOfIterations());
			mutantIterationPlan.setIterationNumberFor(taskToMutate, iterationNumber);
			mutantIterationPlan.setAssigneeFor(taskToMutate, assigneeExpertise);
		}
		return mutantIterationPlan;
	}


	private Collection<IPlannedTask> selectTasksToMutate(ShiftDownIterationPlan mutantIterationPlan, int percentOfTasksToMutate) {
		Set<IPlannedTask> allPlannedTasksInMutantIterationPlan = PlannerUtil.getInstance(getPlannerParameters().getRandom()).getPlannedTasks(mutantIterationPlan);
		int numOfTasksToMutate = (int) ((percentOfTasksToMutate / 100.0) * allPlannedTasksInMutantIterationPlan.size());
		Set<IPlannedTask> allPlannedTasksForBacklog = mutantIterationPlan.getAllPlannedTasksForIteration(mutantIterationPlan.getBacklogNumber());
		List<IPlannedTask> result = new ArrayList<IPlannedTask>();
		for(int i = 0; i < numOfTasksToMutate; i++){
			if(allPlannedTasksForBacklog.size() == 0){
				return result;
			}
			if(result.size() == allPlannedTasksForBacklog.size()){
				return result;
			}
			IPlannedTask highestPrioTask = selectHighestPrioTask(allPlannedTasksForBacklog);
			result.add(highestPrioTask);
			allPlannedTasksForBacklog.remove(highestPrioTask);
		}
		return result;
	}

	private IPlannedTask selectHighestPrioTask(Set<IPlannedTask> allPlannedTasks) {
		IPlannedTask result = allPlannedTasks.toArray(new ShiftDownPlannedTask[allPlannedTasks.size()])[0];
		for(IPlannedTask pt : allPlannedTasks){
			if(pt.getTask().getPriority() > result.getTask().getPriority()){
				result = pt;
			}
		}
		
		return result;
	}

	@Override
	protected void trimNextGeneration(List<IIterationPlan> nextGeneration) {
		//for now just delete some poor random individuals
		int populationSize = getPlannerParameters().getPopulationSize();
		Random random = getPlannerParameters().getRandom();
		while (populationSize < nextGeneration.size()) {
			int currentSize = nextGeneration.size();
			nextGeneration.remove(random.nextInt(currentSize));
		}
	}

	@Override
	public void checkInvariants(List<IIterationPlan> iterPlans) {
		
	}
}
