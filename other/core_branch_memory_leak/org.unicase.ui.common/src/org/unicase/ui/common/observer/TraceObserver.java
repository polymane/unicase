/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.observer;

import org.eclipse.emf.ecore.EObject;
import org.unicase.util.observer.IObserver;

/**
 * Listens on a trace from one model element to another one over a certain feature.
 * 
 * @author helming
 */
public interface TraceObserver extends IObserver {
	/**
	 * Called if a model element is traced from another one.
	 * 
	 * @param source the source of the trace
	 * @param target the trace model element
	 * @param feature the feature over which is traced
	 * @param view the view triggering the trace
	 */
	void onTrace(EObject source, EObject target, String feature, String view);
}
