package org.unicase.workspace;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

public class Configuration {

	private static Map<Object, Object> resourceSaveOptions;

	public static String getWorkspaceDirectory() {
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
		sb.append(".unicase");
		sb.append(File.separatorChar);
		try {
			File workspace = new File(sb.toString());
			if (!workspace.exists()) {
				workspace.mkdir();
			}
		} catch (Exception e) {
			// FIXME MK
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String getWorkspacePath() {
		String workSpacePath = getWorkspaceDirectory() + "workspace";
		return workSpacePath;
	}

	public static Map<Object, Object> getResourceSaveOptions() {
		if (resourceSaveOptions == null) {
			resourceSaveOptions = new HashMap<Object, Object>();
			resourceSaveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
					Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		}
		return resourceSaveOptions;
	}
	
	public static ServerInfo getDefaultServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setDisplayName("DefaultServer");
		serverInfo.setName("EmfStoreOne");
		serverInfo.setPort(1099);
		serverInfo.setUrl("localhost");
		return serverInfo;
	}
}
