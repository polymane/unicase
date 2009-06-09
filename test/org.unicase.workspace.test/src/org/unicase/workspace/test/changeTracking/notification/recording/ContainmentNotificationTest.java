/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.notification.recording;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.unicase.model.document.DocumentFactory;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

/**
 * Tests the notification recording for attribute features.
 * @author chodnick
 *
 */
public class ContainmentNotificationTest extends NotificationTest{

	/**
	 * Change order within a list and check the generated notification.
	 */
	@Test
	public void moveOnSameFeature() {

		LeafSection section1 = DocumentFactory.eINSTANCE.createLeafSection();
		LeafSection section2 = DocumentFactory.eINSTANCE.createLeafSection();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		
		getProject().addModelElement(section1);
		getProject().addModelElement(section2);
		getProject().addModelElement(useCase);
		
		useCase.setName("testUseCase");
		section1.getModelElements().add(useCase);
		
		// reattach usecase to another leaf section
		//section2.getModelElements().add(useCase);
		useCase.setLeafSection(section2);
		
		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one SET notification is expected, resetting the leaf section
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);
		assertSame(useCase, n.getNotifier());
		assertTrue(n.isSetEvent());
		assertEquals(n.getOldValue(), section1);
		assertEquals(n.getNewValue(), section2);
		assertEquals(n.getReference().getName(), "leafSection");
		
		
	}
	
	/**
	 * Change order within a list and check the generated notification.
	 */
	@Test
	public void moveOnDifferentFeatures() {

		LeafSection section = DocumentFactory.eINSTANCE.createLeafSection();		
		FunctionalRequirement req = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		FunctionalRequirement child = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		
		getProject().addModelElement(section);
		getProject().addModelElement(req);
		getProject().addModelElement(child);
		
		section.getModelElements().add(child);
		
		// reattach child to a functional requirement
		//req.getRefiningRequirements().add(child);
		child.setRefinedRequirement(req);
		
		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly two SET notification is expected, resetting the leaf section to "null" and the refined req to "req"
		assertEquals(2, rec.size());

		// check first set
		NotificationInfo n1 = rec.get(0);
		assertSame(child, n1.getNotifier());
		assertTrue(n1.isSetEvent());
		assertEquals(n1.getReference().getName(), "leafSection");
		assertEquals(n1.getOldValue(), section);
		assertEquals(n1.getNewValue(), null);
		
		// check second set
		NotificationInfo n2 = rec.get(1);
		assertSame(child, n2.getNotifier());
		assertTrue(n2.isSetEvent());
		assertEquals(n2.getReference().getName(), "refinedRequirement");
		assertEquals(n2.getOldValue(), null);
		assertEquals(n2.getNewValue(), req);
		
	}	
	

}
