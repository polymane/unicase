/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.unicase.emfstore.esmodel.FileIdentifier;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.emfstore.filetransfer.FileTransferInformation;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Abstract class for the file transfer job encapsulating methods used for downloads and uploads.
 * 
 * @author pfeifferc, jfinis
 */
public abstract class FileTransferJob extends Job {

	private ConnectionManager connectionManager;
	private Exception exception;
	private File file;
	private ProjectId projectId;
	private SessionId sessionId;
	private boolean canceled;

	private final ProjectSpaceImpl projectSpace;
	private final FileTransferManager transferManager;
	private final FileTransferCacheManager cache;
	private final FileTransferInformation fileInformation;
	private final FileIdentifier fileId;

	/**
	 * Constructor to be called by subclasses.
	 * 
	 * @param transferManager the transfer manager handling the transfer job
	 * @param fileInfo the transfer information of the job
	 * @param name of the transfer job
	 */
	protected FileTransferJob(FileTransferManager transferManager, FileTransferInformation fileInfo, String name) {
		super(name);
		this.fileInformation = fileInfo;
		this.fileId = fileInfo.getFileIdentifier();
		this.projectSpace = transferManager.getProjectSpace();
		this.transferManager = transferManager;
		this.cache = transferManager.getCache();
	}

	/**
	 * Gets the attributes required for the file transfer.
	 * 
	 * @throws FileTransferException if there are any null values in the attributes
	 */
	protected void getConnectionAttributes() throws FileTransferException {
		connectionManager = WorkspaceManager.getInstance().getConnectionManager();
		projectId = projectSpace.getProjectId();
		if (projectSpace.getUsersession() == null) {
			throw new FileTransferException("Session ID is unknown. Please login first!");
		} else {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					sessionId = projectSpace.getUsersession().getSessionId();
				}
			}.run(false);
		}
	}

	/**
	 * @param monitor monitor
	 */
	protected void setTotalWork(IProgressMonitor monitor) {
		monitor.beginTask("Transfering ",
			(int) (Math.ceil(fileInformation.getFileSize()) / FilePartitionerUtil.getChunkSize()));
	}

	/**
	 * @see org.eclipse.core.runtime.jobs.Job#canceling()
	 */
	@Override
	protected void canceling() {
		canceled = true;
		super.canceling();
	}

	/**
	 * Increments the chunk number by 1.
	 */
	protected void incrementChunkNumber() {
		fileInformation.setChunkNumber(fileInformation.getChunkNumber() + 1);
	}

	/**
	 * @param monitor progress monitor
	 */
	protected void initializeMonitor(IProgressMonitor monitor) {
		// set monitor total work based on file size previously retrieved
		setTotalWork(monitor);
		// set progress based on how many file chunks that have already been sent
		monitor.worked(fileInformation.getChunkNumber());
	}

	/**
	 * @return the exception, if there has been any. Null otherwise.
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * Returns the connection manager, handling the connection to the emf store.
	 * 
	 * @return the connection manager
	 */
	protected ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	/**
	 * Returns the transferred file.
	 * 
	 * @return the file where the file transfer is stored
	 */
	protected File getFile() {
		return file;
	}

	/**
	 * Sets the transferred file.
	 * 
	 * @param file the file to store the transfer in
	 */
	protected void setFile(File file) {
		this.file = file;
	}

	/**
	 * Returns the project id of the project to which the file transfer belongs.
	 * 
	 * @return project id
	 */
	protected ProjectId getProjectId() {
		return projectId;
	}

	/**
	 * Returns the session id for the connection with the emf store.
	 * 
	 * @return session id
	 */
	protected SessionId getSessionId() {
		return sessionId;
	}

	/**
	 * Whether the user canceled the transfer.
	 * 
	 * @return true iff canceled
	 */
	protected boolean isCanceled() {
		return canceled;
	}

	/**
	 * Returns the project space which is associated with the file transfer.
	 * 
	 * @return the associated project space
	 */
	protected ProjectSpaceImpl getProjectSpace() {
		return projectSpace;
	}

	/**
	 * Returns the file transfer manager administering the file transfer.
	 * 
	 * @return the file transfer manager
	 */
	protected FileTransferManager getTransferManager() {
		return transferManager;
	}

	/**
	 * Returns the cache manager associated with the project space of this file transfer.
	 * 
	 * @return the cache manager
	 */
	protected FileTransferCacheManager getCache() {
		return cache;
	}

	/**
	 * Returns the file transfer information of this transfer.
	 * 
	 * @return transfer information
	 */
	protected FileTransferInformation getFileInformation() {
		return fileInformation;
	}

	/**
	 * Returns the file identifier of this file transfer.
	 * 
	 * @return the file identifier
	 */
	protected FileIdentifier getFileId() {
		return fileId;
	}

	/**
	 * Sets the exception for this transfer. Do this in case an exception occurs. This exception can later be retrieved
	 * by get exception.
	 * 
	 * @param exception the exception that occurred
	 */
	protected void setException(Exception exception) {
		this.exception = exception;
	}

}