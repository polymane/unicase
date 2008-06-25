/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.bug.impl.BugPackageImpl;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.impl.ChangePackageImpl;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.impl.ClassesPackageImpl;
import org.unicase.model.component.ComponentPackage;
import org.unicase.model.component.impl.ComponentPackageImpl;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.impl.DiagramPackageImpl;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.impl.DocumentPackageImpl;
import org.unicase.model.impl.ModelPackageImpl;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.impl.OrganizationPackageImpl;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.impl.RationalePackageImpl;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.impl.RequirementPackageImpl;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.MEState;
import org.unicase.model.task.StateType;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class TaskPackageImpl extends EPackageImpl implements TaskPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionItemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workPackageEClass = null;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stateTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.task.TaskPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TaskPackageImpl() {
		super(eNS_URI, TaskFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TaskPackage init() {
		if (isInited)
			return (TaskPackage) EPackage.Registry.INSTANCE
					.getEPackage(TaskPackage.eNS_URI);

		// Obtain or create and register package
		TaskPackageImpl theTaskPackage = (TaskPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof TaskPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new TaskPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ModelPackage.eNS_URI)
				: ModelPackage.eINSTANCE);
		OrganizationPackageImpl theOrganizationPackage = (OrganizationPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(OrganizationPackage.eNS_URI) instanceof OrganizationPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(OrganizationPackage.eNS_URI)
				: OrganizationPackage.eINSTANCE);
		DiagramPackageImpl theDiagramPackage = (DiagramPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(DiagramPackage.eNS_URI) instanceof DiagramPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(DiagramPackage.eNS_URI)
				: DiagramPackage.eINSTANCE);
		ClassesPackageImpl theClassesPackage = (ClassesPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ClassesPackage.eNS_URI) instanceof ClassesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ClassesPackage.eNS_URI)
				: ClassesPackage.eINSTANCE);
		DocumentPackageImpl theDocumentPackage = (DocumentPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(DocumentPackage.eNS_URI) instanceof DocumentPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(DocumentPackage.eNS_URI)
				: DocumentPackage.eINSTANCE);
		RequirementPackageImpl theRequirementPackage = (RequirementPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RequirementPackage.eNS_URI) instanceof RequirementPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RequirementPackage.eNS_URI)
				: RequirementPackage.eINSTANCE);
		RationalePackageImpl theRationalePackage = (RationalePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RationalePackage.eNS_URI) instanceof RationalePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RationalePackage.eNS_URI)
				: RationalePackage.eINSTANCE);
		ChangePackageImpl theChangePackage = (ChangePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ChangePackage.eNS_URI) instanceof ChangePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ChangePackage.eNS_URI)
				: ChangePackage.eINSTANCE);
		BugPackageImpl theBugPackage = (BugPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(BugPackage.eNS_URI) instanceof BugPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(BugPackage.eNS_URI)
				: BugPackage.eINSTANCE);
		ComponentPackageImpl theComponentPackage = (ComponentPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ComponentPackage.eNS_URI) instanceof ComponentPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ComponentPackage.eNS_URI)
				: ComponentPackage.eINSTANCE);

		// Create package meta-data objects
		theTaskPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theOrganizationPackage.createPackageContents();
		theDiagramPackage.createPackageContents();
		theClassesPackage.createPackageContents();
		theDocumentPackage.createPackageContents();
		theRequirementPackage.createPackageContents();
		theRationalePackage.createPackageContents();
		theChangePackage.createPackageContents();
		theBugPackage.createPackageContents();
		theComponentPackage.createPackageContents();

		// Initialize created meta-data
		theTaskPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theOrganizationPackage.initializePackageContents();
		theDiagramPackage.initializePackageContents();
		theClassesPackage.initializePackageContents();
		theDocumentPackage.initializePackageContents();
		theRequirementPackage.initializePackageContents();
		theRationalePackage.initializePackageContents();
		theChangePackage.initializePackageContents();
		theBugPackage.initializePackageContents();
		theComponentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTaskPackage.freeze();

		return theTaskPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionItem() {
		return actionItemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionItem_AssignedTo() {
		return (EReference) actionItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionItem_DueDate() {
		return (EAttribute) actionItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionItem_Done() {
		return (EAttribute) actionItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionItem_Estimate() {
		return (EAttribute) actionItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkPackage() {
		return workPackageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkPackage_ContainedWorkItems() {
		return (EReference) workPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkItem() {
		return workItemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkItem_ContainingWorkpackage() {
		return (EReference) workItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkItem_AssociatedChangePackages() {
		return (EReference) workItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMEState() {
		return meStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMEState_State() {
		return (EAttribute) meStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStateType() {
		return stateTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TaskFactory getTaskFactory() {
		return (TaskFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		actionItemEClass = createEClass(ACTION_ITEM);
		createEReference(actionItemEClass, ACTION_ITEM__ASSIGNED_TO);
		createEAttribute(actionItemEClass, ACTION_ITEM__DUE_DATE);
		createEAttribute(actionItemEClass, ACTION_ITEM__DONE);
		createEAttribute(actionItemEClass, ACTION_ITEM__ESTIMATE);

		workPackageEClass = createEClass(WORK_PACKAGE);
		createEReference(workPackageEClass, WORK_PACKAGE__CONTAINED_WORK_ITEMS);

		workItemEClass = createEClass(WORK_ITEM);
		createEReference(workItemEClass, WORK_ITEM__CONTAINING_WORKPACKAGE);
		createEReference(workItemEClass, WORK_ITEM__ASSOCIATED_CHANGE_PACKAGES);

		meStateEClass = createEClass(ME_STATE);
		createEAttribute(meStateEClass, ME_STATE__STATE);

		// Create enums
		stateTypeEEnum = createEEnum(STATE_TYPE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		OrganizationPackage theOrganizationPackage = (OrganizationPackage) EPackage.Registry.INSTANCE
				.getEPackage(OrganizationPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(ModelPackage.eNS_URI);
		ChangePackage theChangePackage = (ChangePackage) EPackage.Registry.INSTANCE
				.getEPackage(ChangePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		actionItemEClass.getESuperTypes().add(this.getWorkItem());
		workPackageEClass.getESuperTypes().add(this.getWorkItem());
		workItemEClass.getESuperTypes().add(theModelPackage.getAnnotation());

		// Initialize classes and features; add operations and parameters
		initEClass(actionItemEClass, ActionItem.class, "ActionItem",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionItem_AssignedTo(), theOrganizationPackage
				.getUser(), null, "assignedTo", null, 0, -1, ActionItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getActionItem_DueDate(), ecorePackage.getEDate(),
				"dueDate", null, 0, 1, ActionItem.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionItem_Done(), ecorePackage.getEBoolean(),
				"done", null, 0, 1, ActionItem.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionItem_Estimate(), ecorePackage.getEInt(),
				"estimate", null, 0, 1, ActionItem.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(workPackageEClass, WorkPackage.class, "WorkPackage",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkPackage_ContainedWorkItems(), this.getWorkItem(),
				this.getWorkItem_ContainingWorkpackage(), "containedWorkItems",
				null, 0, -1, WorkPackage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workItemEClass, WorkItem.class, "WorkItem", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkItem_ContainingWorkpackage(), this
				.getWorkPackage(), this.getWorkPackage_ContainedWorkItems(),
				"containingWorkpackage", null, 0, 1, WorkItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getWorkItem_AssociatedChangePackages(), theChangePackage
				.getModelChangePackage(), null, "associatedChangePackages",
				null, 0, -1, WorkItem.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(meStateEClass, MEState.class, "MEState", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMEState_State(), this.getStateType(), "state", null,
				0, 1, MEState.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(stateTypeEEnum, StateType.class, "StateType");
		addEEnumLiteral(stateTypeEEnum, StateType.CLOSED);
		addEEnumLiteral(stateTypeEEnum, StateType.OPEN);
		addEEnumLiteral(stateTypeEEnum, StateType.BLOCKED);
	}

} // TaskPackageImpl
