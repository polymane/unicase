/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies;

import java.util.Collection;
import java.util.Map;

import org.unicase.model.ModelElement;

/**
 * @author Henning Femmer
 */
public interface RecommendationStrategy {

	/**
	 * This method calculates the arithmetic average of all results of the managers matchingStrategies and returns a
	 * hashmap of all values above the threshold.
	 * 
	 * @param base The ModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base
	 * @return a Map (ModelElement,Double)
	 */
	Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements);
}
