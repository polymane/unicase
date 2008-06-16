/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.io.File;

public class ServerConfiguration {

	public final static String RESOURCE_STORAGE = "ResourceStorage";

	public final static String DEFAULT_RESOURCE_STORAGE = "org.unicase.emfstore.storage.TeneoStorage";
//	public final static String DEFAULT_RESOURCE_STORAGE = "org.unicase.emfstore.storage.XMLStorage";

	
	public static String getConfDirectory() {
		StringBuffer sb = new StringBuffer(getServerHome());
		sb.append(".");
		sb.append(File.separatorChar);
		sb.append("conf");
		sb.append(File.separatorChar);
		return sb.toString();
	}

	public static String getConfFile() {
		return getConfDirectory() + "es.properties";
	}

	public static String getServerHome() {
		StringBuffer sb = new StringBuffer(getUserHome());
		sb.append(".unison");
		sb.append(File.separatorChar);
		sb.append("emfstore");
		sb.append(File.separatorChar);
		return sb.toString();
	}

	public static String getUserHome() {
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
		return sb.toString();
	}
}
