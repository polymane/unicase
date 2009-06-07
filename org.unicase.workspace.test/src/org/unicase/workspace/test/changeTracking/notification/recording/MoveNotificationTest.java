/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.changeTracking.notification.recording;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.UseCase;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecording;

import java.util.List;

/**
 * Tests the notification recording for attribute features.
 * @author chodnick
 *
 */
public class MoveNotificationTest extends NotificationTest{

	/**
	 * Change order within a list and check the generated notification.
	 */
	@Test
	public void changeList() {

		Actor actor1 = RequirementFactory.eINSTANCE.createActor();
		Actor actor2 = RequirementFactory.eINSTANCE.createActor();
		UseCase useCase = RequirementFactory.eINSTANCE.createUseCase();
		
		getProject().addModelElement(useCase);
		getProject().addModelElement(actor1);
		getProject().addModelElement(actor2);
		
		actor1.setName("testActor1");
		actor2.setName("testActor2");
		useCase.setName("testUseCase");
		
		// notifications from this operations are tested
		useCase.getParticipatingActors().add(actor1);
		useCase.getParticipatingActors().add(actor2);
		
		// now move actor 2 to top of the list
		useCase.getParticipatingActors().move(0, actor2);

		NotificationRecording recording = getProjectSpace().getNotificationRecorder().getRecording();
		List<NotificationInfo> rec = recording.asMutableList();
		
		// exactly one MOVE notification is expected
		assertEquals(1, rec.size());

		NotificationInfo n = rec.get(0);
		assertSame(useCase, n.getNotifier());
		assertTrue(n.isMoveEvent());
		assertEquals(n.getNewValue(), actor2);
		assertEquals(n.getReference().getName(), "participatingActors");
		
		assertEquals(n.getPosition(), 0);
		assertEquals(n.getOldValue(), 1);
		
	}
	

}
