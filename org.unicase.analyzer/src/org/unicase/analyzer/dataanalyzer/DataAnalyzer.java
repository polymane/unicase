/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.dataanalyzer;

import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;

/**
 * @author liya
 *
 */
public interface DataAnalyzer {

	/**
	 * Returns the specified values of the given ProjectAnalysisData.
	 * 
	 * @param data ProjectAnalysisData
	 * @return values per column
	 */
	List<Object> getValue(ProjectAnalysisData data);

	/**
	 * Returns the names of the columns.
	 * 
	 * @return the names of the columns
	 */
	List<String> getName();
}
