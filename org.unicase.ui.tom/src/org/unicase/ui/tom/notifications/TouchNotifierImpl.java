package org.unicase.ui.tom.notifications;

import java.util.ArrayList;
import java.util.List;

/**
 * @author schroech
 *
 */
public class TouchNotifierImpl implements TouchNotifier {

	private List<TouchAdapter> adapters;
	private boolean deliver = true;

	/**
	 * Default constructor.
	 */
	public TouchNotifierImpl() {
		adapters = new ArrayList<TouchAdapter>();
	}
	
	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.notifications.TouchNotifier#getAdapters()
	*/
	public List<TouchAdapter> getAdapters() {
		return adapters;
	}

	/**
	 * @param adapters The list of {@link TouchAdapter}s
	 */
	public void setAdapters(List<TouchAdapter> adapters) {
		this.adapters = adapters;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.notifications.TouchNotifier#notifyAdapters(org.unicase.ui.tom.notifications.TouchNotification)
	*/
	public void notifyAdapters(TouchNotification notification) {
		List<TouchAdapter> adapters = getAdapters();
		if (adapters != null && deliver())
		{
			for (TouchAdapter touchAdapter : adapters) {
				touchAdapter.notifyChanged(notification);
			}
		}
	}

	/**
	 * Temporarily enables or disabled delivery of notifications.
	 * 
	 * @param deliver The flag indicating if notifications will be delivered
	 */
	public void setDeliver(boolean deliver) {
		this.deliver = deliver;
	}

	/**
	 * @return The flag indicating if notifications will be delivered
	 */
	public boolean deliver() {
		return deliver;
	}


}
