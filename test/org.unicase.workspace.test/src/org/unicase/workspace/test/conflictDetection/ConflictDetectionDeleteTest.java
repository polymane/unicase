/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.conflictDetection;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.Project;
import org.unicase.model.bug.BugFactory;
import org.unicase.model.bug.BugReport;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Tests conflict detection behaviour on attributes.
 * 
 * @author chodnick
 */
public class ConflictDetectionDeleteTest extends ConflictDetectionTest {

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDelete() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		actor.setName("old name");

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				section.getModelElements().add(actor);
				getProjectSpace().getOperations().clear();

			}
		}.run(false);

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().deleteModelElement(actor1);
				actor2.setName("change to the deleted object on another working copy");

			}
		}.run(false);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDeleteAttributeChangesInDeltree() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		actor.setName("old name");
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				section.getModelElements().add(actor);
				getProjectSpace().getOperations().clear();

			}
		}.run(false);

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().deleteModelElement(section1);
				actor2.setName("change to object inside deltree on another working copy");

			}
		}.run(false);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDeleteAttributeChangesInDelObject() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProjectSpace().getOperations().clear();

			}
		}.run(false);

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		final LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().deleteModelElement(section1);
				section2.setName("change to object inside deltree on another working copy");

			}
		}.run(false);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void noConflictDeleteUnrelated() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();

		final Actor actor = RequirementFactory.eINSTANCE.createActor();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(actor);
				getProjectSpace().getOperations().clear();

			}
		}.run(false);

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		final Project project2 = ps2.getProject();

		final Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				actor1.setName("change to unrelated object on another working copy");
				project2.deleteModelElement(section2);

			}
		}.run(false);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDeleteContainmentChangesInDeltree() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final WorkPackage pack = TaskFactory.eINSTANCE.createWorkPackage();
		final BugReport br = BugFactory.eINSTANCE.createBugReport();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(pack);
				getProject().addModelElement(br);
				section.getModelElements().add(pack);
				getProjectSpace().getOperations().clear();
			}
		}.run(false);

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		final Project project2 = ps2.getProject();

		final BugReport br1 = (BugReport) getProject().getModelElement(br.getModelElementId());
		final WorkPackage pack1 = (WorkPackage) getProject().getModelElement(pack.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				br1.setContainingWorkpackage(pack1);
				project2.deleteModelElement(section2);

			}
		}.run(false);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDeleteNonContainmentChangesInDeltree() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		final Milestone mileStone = TaskFactory.eINSTANCE.createMilestone();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(useCase);
				getProject().addModelElement(mileStone);
				section.getModelElements().add(useCase);
				getProjectSpace().getOperations().clear();

			}
		}.run(false);

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		final Project project2 = ps2.getProject();

		final Milestone mileStone1 = (Milestone) getProject().getModelElement(mileStone.getModelElementId());
		final UseCase useCase1 = (UseCase) getProject().getModelElement(useCase.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				useCase1.getAnnotations().add(mileStone1);
				project2.deleteModelElement(section2);

			}
		}.run(false);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		// technically no conflict, since annotated milestone will not be deleted,
		// but there is no way to tell containment from non-containment changes,
		// therefore it is expected that this will be detected as a hard conflict
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if deleting an object is detected as conflict.
	 */
	@Test
	public void conflictDeleteMoveChangesInDeltree() {

		final LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		final WorkPackage pack = TaskFactory.eINSTANCE.createWorkPackage();
		final BugReport br1 = BugFactory.eINSTANCE.createBugReport();
		final BugReport br2 = BugFactory.eINSTANCE.createBugReport();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				getProject().addModelElement(section);
				getProject().addModelElement(pack);
				getProject().addModelElement(br1);

				br1.setContainingWorkpackage(pack);
				br2.setContainingWorkpackage(pack);

			}
		}.run(false);

		assertEquals(pack.getContainedWorkItems().get(0), br1);
		assertEquals(pack.getContainedWorkItems().get(1), br2);
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				section.getModelElements().add(pack);

				getProjectSpace().getOperations().clear();

			}
		}.run(false);

		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		final Project project2 = ps2.getProject();

		final WorkPackage pack1 = (WorkPackage) getProject().getModelElement(pack.getModelElementId());
		final LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				pack1.getContainedWorkItems().move(1, 0);
				project2.deleteModelElement(section2);

			}
		}.run(false);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		// a move change is a change... from users perspective it should not be lost, probably..
		// currently considered to be a hard conflict, because the user should know
		assertEquals(1, conflicts.size());

	}

}
