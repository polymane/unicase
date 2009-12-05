/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.unicase.link.util.LinkListener;
import org.unicase.link.util.ui.OpenLink;

/**
 * 
 * @author Kameliya Terzieva, Fatih Ulusoy, Jan Finis
 * The activator class controls the emfstore life cycle.
 */
public class Activator extends AbstractUIPlugin implements IStartup {

	/**
	 * The Plugin ID.
	 */
	public static final String PLUGIN_ID = "org.unicase.link";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor.
	 */
	public Activator() {
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	// BEGIN SUPRESS CATCH EXCEPTION
	public void start(BundleContext context) throws Exception{
		super.start(context);
		
		//LinkTrigger.getInstance().getUrlMessageHandler()
		//	.addObserver(OpenLink.getInstance());
		
		if (LinkListener.getInstance().getHandedUrl() != null) {
			OpenLink.openURL(LinkListener.getInstance().getHandedUrl());
		}
		
		plugin = this;
	}

	/**
	 * Plugin stop.
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		
		super.stop(context);
	}
	// END SUPRESS CATCH EXCEPTION
	
	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.startup.IStartup#earylStartup
	 */
	public void earlyStartup() {

	}
}
