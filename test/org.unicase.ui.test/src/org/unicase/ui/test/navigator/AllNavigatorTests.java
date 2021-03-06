/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.test.navigator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test cases to validate the proper functioning of UNICASE Navigator.
 * 
 * @author Nitesh
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { CreateProjectUITest.class, DeleteProjectUITest.class, ImportProjectTest.class })
public class AllNavigatorTests {
}
