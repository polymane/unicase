package org.unicase.ui.tom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.unicase.ui.tom.gestures.Gesture;

public class RestrictionGestureExecutionStrategy extends
GestureExecutionStrategy {


	/**
	 * @param gestures The gestures being examined
	 */
	public RestrictionGestureExecutionStrategy(List<Gesture> gestures) {
		super(gestures);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.GestureExecutionStrategy#getExecutableGestures()
	 */
	@Override
	public List<Gesture> getExecutableGestures() {
		List<Gesture> executableGestures = new ArrayList<Gesture>();

		for (Gesture gesture : getGestures()) {
			List<Gesture> restrictingGestures = gesture.getRestrictingGestures();
			boolean disjoint = Collections.disjoint(restrictingGestures, getGestures());

			if (disjoint) {
				executableGestures.add(gesture);
			}
		}

		Collections.sort(executableGestures, new Comparator<Gesture>() {

			public int compare(Gesture o1, Gesture o2) {
				if (o1.getPriority() < o2.getPriority()) {
					return -1;
				}else if (o1.getPriority() == o2.getPriority()) {
					return 0;
				}else{
					return 1;
				}	
			}
		});

		return executableGestures;
	}

}
