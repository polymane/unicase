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
import org.unicase.model.Project;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.workspace.ProjectSpace;

/**
 * Tests conflict detection behaviour on attributes.
 * 
 * @author chodnick
 */
public class ConflictDetectionMultiReferenceTest extends ConflictDetectionTest {

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddAddSameObjectSameIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(actor1);
		section2.getModelElements().add(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// same operations going on in both working copies, no conflicts expected
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddAddSameObjectSameIndexNonZero() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		section.getModelElements().add(dummy);

		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(actor1);
		section2.getModelElements().add(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// same operations going on in both working copies, no conflicts expected
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddAddSameObjectDifferentIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(dummy);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(actor1);
		section2.getModelElements().add(dummy2);
		section2.getModelElements().add(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// index conflicts expected: op from project1 index-conflicts with both ops from project2
		assertEquals(2, cd.getConflictingIndexIntegrity(ops1, ops2).size());
		assertEquals(1, cd.getConflictingIndexIntegrity(ops2, ops1).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddSameObjectSameIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(actor1);
		actor2.setLeafSection(section2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// no index conflict expected: the operations are perfect opposites
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		assertEquals(0, cd.getConflictingIndexIntegrity(ops1, ops2).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetParentSetSameObjectSameIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		actor2.setLeafSection(section2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// no index conflict expected: operations are identical
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		assertEquals(0, cd.getConflictingIndexIntegrity(ops1, ops2).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddSameObjectDifferentIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(actor1);

		section2.getModelElements().add(dummy2);
		actor2.setLeafSection(section2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// index conflict expected: when adding by setting parent, index is unknown
		// and is thus potentially conflicting
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		assertEquals(1, cd.getConflictingIndexIntegrity(ops2, ops1).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetParentSetSameObjectDifferentIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);

		section2.getModelElements().add(dummy2);
		actor2.setLeafSection(section2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// no index conflict expected:
		// appending, then adding at 0 and gives same result in reverse order
		// appending and appending the same thing gives also same result in reverse order
		assertEquals(cd.getConflictingIndexIntegrity(ops2, ops1).size(), cd.getConflictingIndexIntegrity(ops1, ops2)
			.size());
		assertEquals(0, cd.getConflictingIndexIntegrity(ops1, ops2).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddAddDifferentObjectSameIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(actor1);
		section2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// obviously an index-integrity conflict
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddAddDifferentObjectDifferentIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(actor1);
		section2.getModelElements().add(actor2);
		section2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// obviously an index-integrity conflict
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddDifferentObjectSameIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		section2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict, outcome does not depend on serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddDifferentObjectDifferentIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		section2.getModelElements().add(actor2);
		section2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// no index-conflict:
		// appending and adding at 0 gives same result in reverse
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		assertEquals(0, cd.getConflictingIndexIntegrity(ops2, ops1).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetParentSetDifferentObjectSameIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		dummy2.setLeafSection(section2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// obviously an index-integrity conflict
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetParentSetDifferentObjectDifferentIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		section2.getModelElements().add(actor2);
		section2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// no index-conflict, outcome does not depend on serialization for each op
		// add at 0 and append or append and add at 0 does not matter
		assertEquals(cd.getConflictingIndexIntegrity(ops2, ops1).size(), cd.getConflictingIndexIntegrity(ops1, ops2)
			.size());
		assertEquals(0, cd.getConflictingIndexIntegrity(ops1, ops2).size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddRemoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(actor1);
		section2.getModelElements().add(actor2);
		section2.getModelElements().remove(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddParentSetRemoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		section1.getModelElements().add(actor1);
		section2.getModelElements().add(actor2);
		actor2.setLeafSection(otherSection2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddParentSetRemoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		actor1.setLeafSection(section1);
		actor2.setLeafSection(section2);
		actor2.setLeafSection(otherSection2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddRemoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		actor2.setLeafSection(section2);
		section2.getModelElements().remove(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddIndirectRemoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		actor1.setLeafSection(section1);
		actor2.setLeafSection(section2);
		otherSection2.getModelElements().add(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddIndirectRemoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		section1.getModelElements().add(actor1);
		section2.getModelElements().add(actor2);
		otherSection2.getModelElements().add(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// hard conflict between add and remove, serialization matters
		Set<AbstractOperation> conflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveRemoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		actor.setLeafSection(section);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().remove(actor1);
		section2.getModelElements().remove(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());

		// no index conflict
		Set<AbstractOperation> indexConflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(indexConflicts.size(), 0);
		// no hard conflict
		Set<AbstractOperation> hardConflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(hardConflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveRemoveIndirectlySameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		actor.setLeafSection(section);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		section1.getModelElements().remove(actor1);
		otherSection2.getModelElements().add(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetRemoveRemoveIndirectlySameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		actor.setLeafSection(section);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		actor1.setLeafSection(section1);
		otherSection2.getModelElements().add(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetRemoveParentSetRemoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection anotherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(anotherSection);
		getProject().addModelElement(actor);

		actor.setLeafSection(section);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		LeafSection anotherSection2 = (LeafSection) project2.getModelElement(anotherSection.getModelElementId());

		actor1.setLeafSection(otherSection1);
		actor2.setLeafSection(anotherSection2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(conflicts.size(), 0);

		// a hard conflict, though. serialization matters
		Set<AbstractOperation> hardConflicts = cd.getConflicting(ops1, ops2);
		assertEquals(cd.getConflicting(ops1, ops2).size(), cd.getConflicting(ops2, ops1).size());

		assertEquals(hardConflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveIndirectlyRemoveIndirectlySameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		actor.setLeafSection(section);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		otherSection1.getModelElements().add(actor1);
		otherSection2.getModelElements().add(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// index conflict expected, implicitly actor gets a new parent in each copy
		// since that op has no index
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetRemoveRemoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		actor.setLeafSection(section);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(otherSection.getModelElementId());

		actor1.setLeafSection(otherSection1);
		otherSection2.getModelElements().remove(actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddMoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		section.getModelElements().add(dummy);
		getProject().addModelElement(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(actor1);
		section2.getModelElements().add(actor2);
		section2.getModelElements().move(0, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// index conflict arises: if the add happens before the move, the move will work
		// if it does after the move, the move could be ineffective
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetAddMoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		section2.getModelElements().add(actor2);
		section2.getModelElements().move(0, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// index conflict arises: if the add happens before the move, the move will work
		// if it does after the move, the move could be ineffective
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveMoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().remove(actor1);
		section2.getModelElements().move(0, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// no index conflict arises: the element is gone in any serialization
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictParentSetRemoveMoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(otherSection1);
		section2.getModelElements().move(0, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// no index conflict arises: if the section change happens before the move, the move will work
		// if it does after the move, the move could be ineffective. In either case the item is gone.
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictRemoveIndirectlyMoveSameObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		Actor actor = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		section.getModelElements().add(dummy);
		section.getModelElements().add(actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection otherSection1 = (LeafSection) getProject().getModelElement(otherSection.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		otherSection1.getModelElements().add(actor1);
		section2.getModelElements().move(0, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// no index conflict arises: if the section change happens before the move, the move will work
		// if it does after the move, the move could be ineffective. In either case the change is gone.
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictMoveMoveSameObjectDifferentIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy1 = RequirementFactory.eINSTANCE.createActor();
		Actor dummy2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		section.getModelElements().add(dummy1);
		section.getModelElements().add(dummy2);

		section.getModelElements().add(actor);
		assertEquals(section.getModelElements().get(2), actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().move(1, actor1);
		section2.getModelElements().move(0, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// an index conflict arises: result depends on which move comes last
		assertEquals(conflicts.size(), 1);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictMoveMoveSameObjectSameIndex() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();

		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy1 = RequirementFactory.eINSTANCE.createActor();
		Actor dummy2 = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);

		section.getModelElements().add(dummy1);
		section.getModelElements().add(dummy2);

		section.getModelElements().add(actor);
		assertEquals(section.getModelElements().get(2), actor);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor actor2 = (Actor) project2.getModelElement(actor.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().move(1, actor1);
		section2.getModelElements().move(1, actor2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		// no index conflict
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());

		// no index conflict arises: operations are identical
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void conflictAddRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();
		Actor anotherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);
		getProject().addModelElement(anotherDummy);

		section.getModelElements().add(anotherDummy);
		section.getModelElements().add(otherDummy);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor otherDummy2 = (Actor) project2.getModelElement(otherDummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(2, actor1);
		section2.getModelElements().remove(otherDummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// an index-integrity conflict (the remove index:1 is smaller than the add index:2, thus the added item
		// ends up somewhere else, depending on serialization)
		assertEquals(1, conflicts.size());

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictAddRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(0, actor1);
		section2.getModelElements().remove(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict (the change happens at the boundary)
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictAddParentSetRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();
		Actor otherDummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);

		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);
		getProject().addModelElement(otherDummy);

		section.getModelElements().add(otherDummy);
		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		section1.getModelElements().add(1, actor1);
		dummy2.setLeafSection(otherSection2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict (the change happens at the boundary)
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictParentSetAddRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection section2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		section2.getModelElements().remove(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict (outcome does not depend on serialization)
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictParentSetAddRemoveIndirectlyDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		otherSection2.getModelElements().add(dummy2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict (outcome does not depend on serialization)
		assertEquals(conflicts.size(), 0);

	}

	/**
	 * Tests if manipulating multi-features is detected as a conflict.
	 */
	@Test
	public void noConflictPerentSetAddParentSetRemoveDifferentObject() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection otherSection = DocumentFactory.eINSTANCE.createLeafSection();
		Actor actor = RequirementFactory.eINSTANCE.createActor();
		Actor dummy = RequirementFactory.eINSTANCE.createActor();

		getProject().addModelElement(section);
		getProject().addModelElement(otherSection);
		getProject().addModelElement(actor);
		getProject().addModelElement(dummy);

		section.getModelElements().add(dummy);

		getProjectSpace().getOperations().clear();
		ProjectSpace ps2 = cloneProjectSpace(getProjectSpace());
		Project project2 = ps2.getProject();

		Actor actor1 = (Actor) getProject().getModelElement(actor.getModelElementId());
		Actor dummy2 = (Actor) project2.getModelElement(dummy.getModelElementId());

		LeafSection section1 = (LeafSection) getProject().getModelElement(section.getModelElementId());
		LeafSection otherSection2 = (LeafSection) project2.getModelElement(section.getModelElementId());

		actor1.setLeafSection(section1);
		dummy2.setLeafSection(otherSection2);

		List<AbstractOperation> ops1 = getProjectSpace().getLocalOperations().getOperations();
		List<AbstractOperation> ops2 = ps2.getLocalOperations().getOperations();

		ConflictDetector cd = new ConflictDetector(getConflictDetectionStrategy());
		Set<AbstractOperation> conflicts = cd.getConflictingIndexIntegrity(ops1, ops2);
		assertEquals(cd.getConflictingIndexIntegrity(ops1, ops2).size(), cd.getConflictingIndexIntegrity(ops2, ops1)
			.size());
		// no index-integrity conflict (outcome does not depend on serialization)
		assertEquals(conflicts.size(), 0);

	}

}
