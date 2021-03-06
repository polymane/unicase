/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.ecore.EClass;

/**
 * Represents the exception that a feature is not known to a model element.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class UnkownFeatureException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param eClass the EClass of the element
	 * @param featureName the missing features name
	 */
	public UnkownFeatureException(EClass eClass, String featureName) {
		super("The feature \"" + featureName + " is unkown for EClass \"" + eClass.getName());
	}

}
