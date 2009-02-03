/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.EsmodelFactory;

/**
 * Represents the current Workspace Configuration.
 * 
 * @author koegel
 */
public final class Configuration {

	private Configuration() {
		// nothing to do
	}

	// private static Map<Object, Object> resourceSaveOptions;

	/**
	 * Get the Workspace directory.
	 * 
	 * @return the workspace directory path string
	 */
	public static String getWorkspaceDirectory() {
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
		sb.append(".unicase");
		if (!isReleaseVersion()) {
			if (isInternalReleaseVersion()) {
				sb.append(".internal");
			} else {
				sb.append(".dev");
			}
		}

		sb.append(File.separatorChar);
		File workspace = new File(sb.toString());
		if (!workspace.exists()) {
			workspace.mkdir();
		}
		return sb.toString();
	}

	/**
	 * Get the Workspace file path.
	 * 
	 * @return the workspace file path string
	 */
	public static String getWorkspacePath() {
		String workSpacePath = getWorkspaceDirectory() + "workspace.ucw";
		return workSpacePath;
	}

	/**
	 * Get the default resource save options.
	 * 
	 * @return the resource save options
	 */
	public static Map<Object, Object> getResourceSaveOptions() {
		// MK: the options below should only be used with resourcemodification
		// tracking enabled
		// if (resourceSaveOptions == null) {
		// resourceSaveOptions = new HashMap<Object, Object>();
		// resourceSaveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
		// Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		// }
		return null;
	}

	/**
	 * Get the default server info.
	 * 
	 * @return server info
	 */
	public static List<ServerInfo> getDefaultServerInfos() {
		List<ServerInfo> serverInfos = new ArrayList<ServerInfo>();

		if (isReleaseVersion()) {
			serverInfos.add(getReleaseServerInfo());
		}
		if (isInternalReleaseVersion()) {
			serverInfos.add(getInternalServerInfo());
		}
		if (isDeveloperVersion()) {
			serverInfos.add(getLocalhostServerInfo());
		}
		return serverInfos;
	}

	private static ServerInfo getReleaseServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setDisplayName("unicase Server");
		serverInfo.setName("unicase Server");
		serverInfo.setPort(1099);
		serverInfo.setUrl("unicase.in.tum.de");
		return serverInfo;
	}

	private static ServerInfo getInternalServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setDisplayName("unicase Developer Server");
		serverInfo.setName("unicase Developer Server");
		serverInfo.setPort(1099);
		serverInfo.setUrl("unicase-dev.in.tum.de");
		return serverInfo;
	}

	private static ServerInfo getLocalhostServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setDisplayName("Localhost Server");
		serverInfo.setName("Localhost Server");
		serverInfo.setPort(1099);
		serverInfo.setUrl("localhost");

		Usersession superUsersession = WorkspaceFactory.eINSTANCE.createUsersession();
		superUsersession.setPassword("super");
		superUsersession.setSavePassword(true);
		superUsersession.setServerInfo(serverInfo);
		superUsersession.setUsername("super");
		serverInfo.setLastUsersession(superUsersession);

		return serverInfo;
	}

	/**
	 * Returns maximum number of model elements allowed per resource.
	 * 
	 * @return the maximum number
	 */
	public static int getMaxMECountPerResource() {
		return 100;
	}

	/**
	 * Returns maximum size of of a resource file on expand.
	 * 
	 * @return the maximum number
	 */
	public static int getMaxResourceFileSizeOnExpand() {
		return 50000;
	}

	/**
	 * Get the client version as in the org.unicase.workspace manifest file.
	 * 
	 * @return the client version number
	 */
	public static ClientVersionInfo getClientVersion() {
		ClientVersionInfo clientVersionInfo = EsmodelFactory.eINSTANCE.createClientVersionInfo();
		clientVersionInfo.setName("unicase.org eclipse client");

		Bundle emfStoreBundle = Platform.getBundle("org.unicase.workspace");
		String emfStoreVersionString = (String) emfStoreBundle.getHeaders().get(
			org.osgi.framework.Constants.BUNDLE_VERSION);

		clientVersionInfo.setVersion(emfStoreVersionString);
		return clientVersionInfo;
	}

	/**
	 * Determine if this is a release version or not.
	 * 
	 * @return true if it is a release version
	 */
	public static boolean isReleaseVersion() {
		return !isInternalReleaseVersion() && !getClientVersion().getVersion().endsWith("qualifier");
	}

	/**
	 * Determines if this is an internal release or not.
	 * 
	 * @return true if it is an internal release
	 */
	public static boolean isInternalReleaseVersion() {
		return getClientVersion().getVersion().endsWith("internal");
	}

	/**
	 * Determines if this is an developer version or not.
	 * 
	 * @return true if it is a developer version
	 */
	public static boolean isDeveloperVersion() {
		return !isReleaseVersion() && !isInternalReleaseVersion();
	}

	/**
	 * Return the file extension for project space files.
	 * 
	 * @return the file extension
	 */
	public static String getProjectSpaceFileExtension() {
		return ".ups";
	}

	/**
	 * Return the file extension for operation composite files.
	 * 
	 * @return the file extension
	 */
	public static String getOperationCompositeFileExtension() {
		return ".uoc";
	}

	/**
	 * Return the name of the project folder.
	 * 
	 * @return the folder name
	 */
	public static String getProjectFolderName() {
		return "project";
	}

	/**
	 * Return the prefix of the project space directory
	 * 
	 * @return the prefix
	 */
	public static String getProjectSpaceDirectoryPrefix() {
		return "ps-";
	}

	/**
	 * Return project fragement file extension.
	 * 
	 * @return the file extension
	 */
	public static String getProjectFragmentFileExtension() {
		return ".upf";
	}
}
