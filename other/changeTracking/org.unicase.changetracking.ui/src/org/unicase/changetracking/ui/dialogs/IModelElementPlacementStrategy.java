/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui.dialogs;

import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;

public interface IModelElementPlacementStrategy {

	void placeModelElementInProject(Project project, UnicaseModelElement modelElement);
	
}
