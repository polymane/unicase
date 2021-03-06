/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.accesscontrol.roles.impl;

import org.eclipse.emf.ecore.EClass;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.accesscontrol.roles.ReaderRole;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.metamodel.ModelElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Reader Role</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class ReaderRoleImpl extends RoleImpl implements ReaderRole {
	@Override
	public boolean canAdministrate(ProjectId projectId) {
		return false;
	}

	@Override
	public boolean canCreate(ProjectId projectId, ModelElement modelElement) {
		return false;
	}

	@Override
	public boolean canDelete(ProjectId projectId, ModelElement modelElement) {
		return false;
	}

	@Override
	public boolean canModify(ProjectId projectId, ModelElement modelElement) {
		return false;
	}

	@Override
	public boolean canRead(ProjectId projectId, ModelElement modelElement) {
		return isMyProject(projectId);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ReaderRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RolesPackage.Literals.READER_ROLE;
	}

} // ReaderRoleImpl
