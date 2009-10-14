/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
/**
 * Test Suite for running all tests of workspace.
 * @author chodnick
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	AutoSaveContainerTest.class,
	ModelChangeListenerTest.class,
	ModelElementCacheTest.class,
	ProjectChangeObserverTest.class
})
public class AllModelTests {

}
