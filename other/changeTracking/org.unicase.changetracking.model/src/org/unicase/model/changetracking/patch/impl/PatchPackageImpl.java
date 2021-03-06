/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.model.changetracking.patch.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.model.ModelPackage;

import org.unicase.model.attachment.AttachmentPackage;

import org.unicase.model.changetracking.ChangetrackingPackage;

import org.unicase.model.changetracking.git.GitPackage;

import org.unicase.model.changetracking.git.impl.GitPackageImpl;

import org.unicase.model.changetracking.impl.ChangetrackingPackageImpl;

import org.unicase.model.changetracking.patch.PatchChangePackage;
import org.unicase.model.changetracking.patch.PatchFactory;
import org.unicase.model.changetracking.patch.PatchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PatchPackageImpl extends EPackageImpl implements PatchPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patchChangePackageEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.changetracking.patch.PatchPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PatchPackageImpl()
	{
		super(eNS_URI, PatchFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PatchPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PatchPackage init()
	{
		if (isInited) return (PatchPackage)EPackage.Registry.INSTANCE.getEPackage(PatchPackage.eNS_URI);

		// Obtain or create and register package
		PatchPackageImpl thePatchPackage = (PatchPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PatchPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PatchPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ChangetrackingPackageImpl theChangetrackingPackage = (ChangetrackingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ChangetrackingPackage.eNS_URI) instanceof ChangetrackingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ChangetrackingPackage.eNS_URI) : ChangetrackingPackage.eINSTANCE);
		GitPackageImpl theGitPackage = (GitPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GitPackage.eNS_URI) instanceof GitPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GitPackage.eNS_URI) : GitPackage.eINSTANCE);

		// Create package meta-data objects
		thePatchPackage.createPackageContents();
		theChangetrackingPackage.createPackageContents();
		theGitPackage.createPackageContents();

		// Initialize created meta-data
		thePatchPackage.initializePackageContents();
		theChangetrackingPackage.initializePackageContents();
		theGitPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePatchPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PatchPackage.eNS_URI, thePatchPackage);
		return thePatchPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatchChangePackage()
	{
		return patchChangePackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatchFactory getPatchFactory()
	{
		return (PatchFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		patchChangePackageEClass = createEClass(PATCH_CHANGE_PACKAGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ChangetrackingPackage theChangetrackingPackage = (ChangetrackingPackage)EPackage.Registry.INSTANCE.getEPackage(ChangetrackingPackage.eNS_URI);
		AttachmentPackage theAttachmentPackage = (AttachmentPackage)EPackage.Registry.INSTANCE.getEPackage(AttachmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		patchChangePackageEClass.getESuperTypes().add(theChangetrackingPackage.getChangePackage());
		patchChangePackageEClass.getESuperTypes().add(theAttachmentPackage.getFileAttachment());

		// Initialize classes and features; add operations and parameters
		initEClass(patchChangePackageEClass, PatchChangePackage.class, "PatchChangePackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //PatchPackageImpl
