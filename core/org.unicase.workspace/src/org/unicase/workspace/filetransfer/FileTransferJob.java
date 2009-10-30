/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

/**
 * Abstract class for the file transfer job encapsulating methods used for downloads and uploads.
 * 
 * @author pfeifferc
 */
public abstract class FileTransferJob { // extends Job {

	// private ConnectionManager connectionManager;
	// private Exception exception;
	// private File file;
	// private FileAttachment fileAttachment;
	// private FileInformation fileInformation;
	// private PendingFileTransfer transfer;
	// private ProjectId projectId;
	// private SessionId sessionId;
	// private boolean cancelled;
	//
	// /**
	// * @param name of the transfer job
	// */
	// public FileTransferJob(String name) {
	// super(name);
	// }
	//
	// /**
	// * Sets a pending file transfer from the pending file transfers.
	// *
	// * @param version version of the file
	// */
	// protected void setPendingFileTransferVersion(final int version) {
	// new UnicaseCommand() {
	// @Override
	// protected void doRun() {
	// transfer.setFileVersion(version);
	// ((ProjectSpaceImpl) WorkspaceManager.getProjectSpace(fileAttachment)).saveProjectSpaceOnly();
	// }
	// }.run();
	// }
	//
	// /**
	// * Removes the preliminary file name from a transfer.
	// */
	// protected void removePendingFileTransferPreliminaryFileName() {
	// new UnicaseCommand() {
	// @Override
	// protected void doRun() {
	// transfer.setPreliminaryFileName(null);
	// ((ProjectSpaceImpl) WorkspaceManager.getProjectSpace(fileAttachment)).saveProjectSpaceOnly();
	// }
	// }.run();
	// }
	//
	// /**
	// * Sets a pending file transfer from the pending file transfers.
	// */
	// protected void setPendingFileTransfer() {
	// new UnicaseCommand() {
	// @Override
	// protected void doRun() {
	// transfer.setChunkNumber(fileInformation.getChunkNumber());
	// ((ProjectSpaceImpl) WorkspaceManager.getProjectSpace(fileAttachment)).saveProjectSpaceOnly();
	// }
	// }.run();
	// }
	//
	// /**
	// * Removes a pending file transfer from the pending file transfers. *
	// */
	// protected void removePendingFileTransfer() {
	// new UnicaseCommand() {
	// @Override
	// protected void doRun() {
	// WorkspaceManager.getProjectSpace(fileAttachment).getPendingFileTransfers().remove(transfer);
	// ((ProjectSpaceImpl) WorkspaceManager.getProjectSpace(fileAttachment)).saveProjectSpaceOnly();
	// }
	// }.run();
	// }
	//
	// /**
	// * Gets the attributes required for the file transfer.
	// *
	// * @throws FileTransferException if there are any null values in the attributes
	// */
	// protected void getConnectionAttributes() throws FileTransferException {
	// connectionManager = WorkspaceManager.getInstance().getConnectionManager();
	// projectId = WorkspaceManager.getProjectSpace(fileAttachment).getProjectId();
	// if (WorkspaceManager.getProjectSpace(fileAttachment).getUsersession() == null) {
	// throw new FileTransferException("Session ID is unknown. Please login first!");
	// } else {
	// new UnicaseCommand() {
	// @Override
	// protected void doRun() {
	// sessionId = WorkspaceManager.getProjectSpace(fileAttachment).getUsersession().getSessionId();
	// }
	// }.run();
	// }
	// }
	//
	// /**
	// * Sets the attributes required for the file transfer.
	// */
	// protected void setAttributes() {
	// // read values from file attachment
	// new UnicaseCommand() {
	// @Override
	// protected void doRun() {
	// if (fileAttachment.getFileID() == null || fileAttachment.getFileID().equals("")
	// || Integer.parseInt(fileAttachment.getFileID()) <= fileInformation.getFileVersion()) {
	// fileAttachment.setFileName(fileInformation.getFileName());
	// fileAttachment.setFileID("" + fileInformation.getFileVersion());
	// fileAttachment.setFileSize(fileInformation.getFileSize());
	// }
	// }
	// }.run();
	// }
	//
	// /**
	// * @param monitor monitor
	// */
	// protected void setTotalWork(IProgressMonitor monitor) {
	// monitor.beginTask("Transfering ", (int) (Math.ceil(getFileInformation().getFileSize()) / FilePartitionerUtil
	// .getChunkSize()));
	// }
	//
	// /**
	// * @see org.eclipse.core.runtime.jobs.Job#canceling()
	// */
	// @Override
	// protected void canceling() {
	// cancelled = true;
	// super.canceling();
	// }
	//
	// /**
	// * Increments the chunk number by 1.
	// */
	// protected void incrementChunkNumber() {
	// fileInformation.setChunkNumber(fileInformation.getChunkNumber() + 1);
	// }
	//
	// /**
	// * @param monitor progress monitor
	// */
	// protected void initializeMonitor(IProgressMonitor monitor) {
	// // set monitor total work based on file size previously retrieved
	// setTotalWork(monitor);
	// // set progress based on how many file chunks that have already been sent
	// monitor.worked(getFileInformation().getChunkNumber());
	// }
	//
	// /**
	// * @return the exception, if there has been any. Null otherwise.
	// */
	// public Exception getException() {
	// return exception;
	// }
	//
	// /**
	// * @param e exception thrown
	// */
	// protected void setException(Exception e) {
	// this.exception = e;
	// }
	//
	// /**
	// * @return the connection manager.
	// */
	// protected ConnectionManager getConnectionManager() {
	// return connectionManager;
	// }
	//
	// /**
	// * @return the session id
	// */
	// protected SessionId getSessionId() {
	// return sessionId;
	// }
	//
	// /**
	// * @return project id
	// */
	// protected ProjectId getProjectId() {
	// return projectId;
	// }
	//
	// /**
	// * @return the file information data object
	// */
	// public FileInformation getFileInformation() {
	// return fileInformation;
	// }
	//
	// /**
	// */
	// protected void setFileInformation() {
	// this.fileInformation = new FileInformation();
	// fileInformation.setChunkNumber(transfer.getChunkNumber());
	// fileInformation.setFileName(transfer.getFileName());
	// fileInformation.setFileVersion(transfer.getFileVersion());
	// fileInformation.setFileAttachmentId(transfer.getAttachmentId().getId());
	// }
	//
	// /**
	// * @param fileAttachment file attachment
	// */
	// protected void setFileAttachment(FileAttachment fileAttachment) {
	// this.fileAttachment = fileAttachment;
	// }
	//
	// /**
	// * @return file
	// */
	// protected File getFile() {
	// return file;
	// }
	//
	// /**
	// * @param file file
	// */
	// protected void setFile(File file) {
	// this.file = file;
	// }
	//
	// /**
	// * @param transfer transfer
	// */
	// protected void setTransfer(PendingFileTransfer transfer) {
	// this.transfer = transfer;
	// }
	//
	// /**
	// * @return the transfer
	// */
	// protected PendingFileTransfer getTransfer() {
	// return transfer;
	// }
	//
	// /**
	// * @throws FileTransferException if the job execution has been halted
	// */
	// protected void checkCancelled() throws FileTransferException {
	// if (cancelled || transfer.getAttachmentId() == null) {
	// throw new FileTransferException("File transfer has been cancelled!");
	// }
	// if (!WorkspaceManager.getProjectSpace(fileAttachment).getPendingFileTransfers().contains(getTransfer())) {
	// throw new FileTransferException("File transfer has been cancelled!");
	// }
	// }
}