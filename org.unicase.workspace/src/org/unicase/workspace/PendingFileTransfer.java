/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Pending File Transfer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.workspace.PendingFileTransfer#getAttachmentId <em>Attachment Id</em>}</li>
 * <li>{@link org.unicase.workspace.PendingFileTransfer#getFileVersion <em>File Version</em>}</li>
 * <li>{@link org.unicase.workspace.PendingFileTransfer#getFilePath <em>File Path</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.workspace.WorkspacePackage#getPendingFileTransfer()
 * @model
 * @generated
 */
public interface PendingFileTransfer extends EObject {
	/**
	 * Returns the value of the '<em><b>Attachment Id</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attachment Id</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attachment Id</em>' containment reference.
	 * @see #setAttachmentId(ModelElementId)
	 * @see org.unicase.workspace.WorkspacePackage#getPendingFileTransfer_AttachmentId()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getAttachmentId();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.PendingFileTransfer#getAttachmentId <em>Attachment Id</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Attachment Id</em>' containment reference.
	 * @see #getAttachmentId()
	 * @generated
	 */
	void setAttachmentId(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>File Version</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Version</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>File Version</em>' attribute.
	 * @see #setFileVersion(String)
	 * @see org.unicase.workspace.WorkspacePackage#getPendingFileTransfer_FileVersion()
	 * @model
	 * @generated
	 */
	String getFileVersion();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.PendingFileTransfer#getFileVersion <em>File Version</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>File Version</em>' attribute.
	 * @see #getFileVersion()
	 * @generated
	 */
	void setFileVersion(String value);

	/**
	 * Returns the value of the '<em><b>File Path</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Path</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>File Path</em>' attribute.
	 * @see #setFilePath(String)
	 * @see org.unicase.workspace.WorkspacePackage#getPendingFileTransfer_FilePath()
	 * @model
	 * @generated
	 */
	String getFilePath();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.PendingFileTransfer#getFilePath <em>File Path</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>File Path</em>' attribute.
	 * @see #getFilePath()
	 * @generated
	 */
	void setFilePath(String value);

} // PendingFileTransfer
