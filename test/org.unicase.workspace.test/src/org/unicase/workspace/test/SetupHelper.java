/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Properties;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.EmfStoreController;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.model.Project;
import org.unicase.model.util.FileUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.test.integration.forward.IntegrationTestHelper;

/**
 * Helper class for setup/cleanup test fixtures.
 * 
 * @author hodaie
 */
public class SetupHelper {

	private TransactionalEditingDomain domain;
	private Workspace workSpace;
	private ProjectSpace testProjectSpace;
	private Project testProject;
	private Usersession usersession;

	private ProjectId projectId;
	private Project compareProject;

	private TestProjectEnum projectTemplate;

	/**
	 * @param projectTemplate test project to initialize SetupHelper
	 */
	public SetupHelper(TestProjectEnum projectTemplate) {

		this.projectTemplate = projectTemplate;
	}

	/**
	 * Starts the server.
	 */
	public static void startSever() {
		try {
			ServerConfiguration.setTesting(true);
			Properties properties = ServerConfiguration.getProperties();
			properties.setProperty(ServerConfiguration.RMI_ENCRYPTION, ServerConfiguration.FALSE);
			EmfStoreController.runAsNewThread();
		} catch (FatalEmfStoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stops the server.
	 */
	public static void stopServer() {
		EmfStoreController server = EmfStoreController.getInstance();
		if (server != null) {
			server.stop();
		}

	}

	private static void copyDirectory(File sourceLocation, File targetLocation) throws IOException {

		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				targetLocation.mkdir();
			}

			String[] children = sourceLocation.list();
			for (int i = 0; i < children.length; i++) {
				copyDirectory(new File(sourceLocation, children[i]), new File(targetLocation, children[i]));
			}
		} else {

			InputStream in = new FileInputStream(sourceLocation);
			OutputStream out = new FileOutputStream(targetLocation);

			// Copy the bits from instream to outstream
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}
	}

	/**
	 * Setups server space.
	 */
	public static void setupServerSpace() {
		// 1.
		// create a new server space

		// import project history from local folder (it is located in our test plug-in)

		// add the history to server space

		// ===============================
		// 2.
		// copy whole folders and storage from file system to .unicase.test/emfstore

		ServerConfiguration.setTesting(true);
		String serverPath = ServerConfiguration.getServerHome();
		File targetLocation = new File(serverPath);
		String path = "TestProjects/Projects";
		String srcPath = Activator.getDefault().getBundle().getLocation() + path;
		if (File.separator.equals("/")) {
			srcPath = srcPath.replace("reference:file:", "");

		} else {
			srcPath = srcPath.replace("reference:file:/", "");
		}
		File sourceLocation = new File(srcPath);

		try {
			copyDirectory(sourceLocation, targetLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// start server.

		try {
			Properties properties = ServerConfiguration.getProperties();
			properties.setProperty(ServerConfiguration.RMI_ENCRYPTION, ServerConfiguration.FALSE);
			EmfStoreController.runAsNewThread();
		} catch (FatalEmfStoreException e) {
			e.printStackTrace();
		}

	}

	/**
	 * log in the test server.
	 */
	public void loginServer() {
		if (usersession == null) {
			usersession = WorkspaceFactory.eINSTANCE.createUsersession();

			ServerInfo serverInfo = getServerInfo();

			usersession.setServerInfo(serverInfo);
			usersession.setUsername("super");
			usersession.setPassword("super");
		}

		if (!usersession.isLoggedIn()) {
			try {
				usersession.logIn();
			} catch (AccessControlException e) {
				e.printStackTrace();
			} catch (EmfStoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Returns server info.
	 * 
	 * @return server info
	 */
	public static ServerInfo getServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(1099);
		serverInfo.setUrl("127.0.0.1");
		serverInfo.setCertificateAlias("unicase.org test test(!!!) certificate");
		return serverInfo;
	}

	/**
	 * Setups workspace.
	 */
	public void setupWorkSpace() {

		Configuration.setTesting(true);
		workSpace = WorkspaceManager.getInstance().getCurrentWorkspace();
		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");

	}

	/**
	 * Setups a new test project space by importing one of template test projects.
	 */
	public void setupTestProjectSpace() {

		final String path;
		path = projectTemplate.getPath();

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				String uriString = Activator.getDefault().getBundle().getLocation() + path;
				if (File.separator.equals("/")) {
					uriString = uriString.replace("reference:file:", "");

				} else {
					uriString = uriString.replace("reference:file:/", "");
				}
				try {
					testProjectSpace = importProject(uriString);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});

		testProject = testProjectSpace.getProject();

	}

	/**
	 * Setups a new test project space by importing a project file located at absolutePath.
	 * 
	 * @param absolutePath absolutePath to a project to import.
	 */
	public void setupTestProjectSpace(final String absolutePath) {

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				String uriString = Activator.getDefault().getBundle().getLocation() + absolutePath;
				if (File.separator.equals("/")) {
					uriString = uriString.replace("reference:file:", "");

				} else {
					uriString = uriString.replace("reference:file:/", "");
				}
				try {
					testProjectSpace = importProject(uriString);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});

		testProject = testProjectSpace.getProject();

	}

	/**
	 * Cleans server up.
	 */
	public static void cleanupServer() {
		String serverPath = ServerConfiguration.getServerHome();
		File serverDirectory = new File(serverPath);
		FileFilter serverFileFilter = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().startsWith("project-");
			}

		};
		File[] filesToDeleteOnServer = serverDirectory.listFiles(serverFileFilter);
		for (int i = 0; i < filesToDeleteOnServer.length; i++) {
			try {
				FileUtil.deleteFolder(filesToDeleteOnServer[i]);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		new File(serverPath + "storage.uss").delete();

	}

	/**
	 * Cleans workspace up.
	 */
	public void cleanupWorkspace() {

		String workspacePath = Configuration.getWorkspaceDirectory();
		File workspaceDirectory = new File(workspacePath);
		FileFilter workspaceFileFilter = new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().startsWith("ps-");
			}

		};
		File[] filesToDelete2 = workspaceDirectory.listFiles(workspaceFileFilter);
		for (int i = 0; i < filesToDelete2.length; i++) {
			try {
				FileUtil.deleteFolder(filesToDelete2[i]);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		new File(workspacePath + "workspace.ucw").delete();
	}

	/**
	 * Imports a project space from an exported project file.
	 * 
	 * @param uri path to an exported project file
	 * @return project space
	 * @throws IOException IOException
	 */
	public ProjectSpace importProject(String uri) throws IOException {
		return workSpace.importProject(uri);

	}

	/**
	 * This shares test project with server.
	 */
	public void shareProject() {
		if (usersession == null) {
			usersession = WorkspaceFactory.eINSTANCE.createUsersession();

			ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
			serverInfo.setPort(1099);
			serverInfo.setUrl("127.0.0.1");

			usersession.setServerInfo(serverInfo);
			usersession.setUsername("super");
			usersession.setPassword("super");

		}

		try {
			if (!usersession.isLoggedIn()) {
				usersession.logIn();
			}

			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					try {
						getTestProjectSpace().shareProject(usersession);

					} catch (EmfStoreException e) {
						e.printStackTrace();
					}
				}
			});

		} catch (AccessControlException e) {
			e.printStackTrace();
		} catch (EmfStoreException e) {
			e.printStackTrace();
		}

		projectId = testProjectSpace.getProjectId();
	}

	/**
	 * Commits the changes to server.
	 */
	public void commitChanges() {
		final LogMessage logMessage = createLogMessage(usersession.getUsername(), "some message");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				System.out.println(IntegrationTestHelper.getChangePackage(getTestProjectSpace().getOperations(), true,
					false).getOperations().size()
					+ " operations.");
				try {
					getTestProjectSpace().commit(logMessage);
					System.out.println("commit successful!");
				} catch (NoLocalChangesException e) {
					// do nothing
				} catch (EmfStoreException e) {
					e.printStackTrace();
				}

			}
		});

	}

	/**
	 * Create LogMessage.
	 * 
	 * @param name name
	 * @param message message
	 * @return LogMessage
	 */
	public static LogMessage createLogMessage(String name, String message) {
		final LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(name);
		logMessage.setDate(Calendar.getInstance().getTime());
		logMessage.setMessage(message);
		return logMessage;
	}

	/**
	 * Returns project to be compared with test project. This is project that lies on server after committing the
	 * changes. We check out and return it.
	 * 
	 * @return project lying on the server
	 * @throws EmfStoreException EmfStoreException
	 */
	public Project getCompareProject() throws EmfStoreException {

		final ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("CompareProject");
		projectInfo.setDescription("compare project description");
		projectInfo.setProjectId(projectId);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				try {
					compareProject = WorkspaceManager.getInstance().getCurrentWorkspace().checkout(usersession,
						projectInfo).getProject();
				} catch (EmfStoreException e) {
					e.printStackTrace();
				}

			}

		});
		return compareProject;
	}

	/**
	 * @return the testProject
	 */
	public Project getTestProject() {
		return testProject;
	}

	/**
	 * @return test project space
	 */
	public ProjectSpace getTestProjectSpace() {
		return testProjectSpace;
	}

	/**
	 * @return workspace
	 */
	public Workspace getWorkSpace() {
		return workSpace;
	}

	/**
	 * @return editing domain
	 */
	public TransactionalEditingDomain getDomain() {
		return domain;
	}

	/**
	 * @return the usersession
	 */
	public Usersession getUsersession() {
		return usersession;
	}

	/**
	 * Creates a versionsepc.
	 * 
	 * @param i verion
	 * @return versionspec
	 */
	public static PrimaryVersionSpec createPrimaryVersionSpec(int i) {
		PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		versionSpec.setIdentifier(i);
		return versionSpec;
	}
}
