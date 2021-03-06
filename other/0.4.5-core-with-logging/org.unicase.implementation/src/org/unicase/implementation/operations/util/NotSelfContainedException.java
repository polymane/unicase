/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.util;

import org.unicase.model.UnicaseModelElement;

/**
 * Exception to state that the selected packages are not self contained.
 * 
 * @author herrmama
 */
public class NotSelfContainedException extends RuntimeException {

	private static final long serialVersionUID = -3935186247946473183L;

	/**
	 * The element which is not contained.
	 */
	private final UnicaseModelElement element;

	/**
	 * Constructor.
	 * 
	 * @param element the element that is not self contained.
	 */
	public NotSelfContainedException(UnicaseModelElement element) {
		this.element = element;
	}

	/**
	 * Get the element that is not self contained.
	 * 
	 * @return the element
	 */
	public UnicaseModelElement getElement() {
		return element;
	}
}
