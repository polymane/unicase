/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task.util;

import org.unicase.model.ModelElement;

/**
 * Exception to show that there is a circular dependency in the workitem
 * dependencies, e.g. two tasks block each other.
 * 
 * @author helming
 * 
 */
@SuppressWarnings("serial")
public class CircularDependencyException extends Exception {

	private ModelElement modelElement;

	/**
	 * default constructor.
	 * 
	 * @param modelElement
	 *            the {@link ModelElement} where the Exception was found.
	 */
	public CircularDependencyException(ModelElement modelElement) {
		super();
		this.modelElement = modelElement;
	}

	/**
	 * Return the modelelement where the circular dependency was found.
	 * 
	 * @return the modelelement
	 */
	public ModelElement getModelElement() {
		return modelElement;
	}

}
