/**
 * <copyright>Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html</copyright>
 *
 * $Id$
 */
package org.unicase.model.profile.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.impl.AttachmentPackageImpl;
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
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.meeting.impl.MeetingPackageImpl;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.impl.OrganizationPackageImpl;
import org.unicase.model.profile.Profile;
import org.unicase.model.profile.ProfileFactory;
import org.unicase.model.profile.ProfilePackage;
import org.unicase.model.profile.Stereotype;
import org.unicase.model.profile.StereotypeAttribute;
import org.unicase.model.profile.StereotypeAttributeInstance;
import org.unicase.model.profile.StereotypeAttributeInstanceString;
import org.unicase.model.profile.StereotypeAttributeSimple;
import org.unicase.model.profile.StereotypeInstance;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.impl.RationalePackageImpl;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.impl.RequirementPackageImpl;
import org.unicase.model.state.StatePackage;
import org.unicase.model.state.impl.StatePackageImpl;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.impl.TaskPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfilePackageImpl extends EPackageImpl implements ProfilePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass profileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeAttributeSimpleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeAttributeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeAttributeInstanceStringEClass = null;

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
	 * @see org.unicase.model.profile.ProfilePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProfilePackageImpl() {
		super(eNS_URI, ProfileFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProfilePackage init() {
		if (isInited)
			return (ProfilePackage) EPackage.Registry.INSTANCE
					.getEPackage(ProfilePackage.eNS_URI);

		// Obtain or create and register package
		ProfilePackageImpl theProfilePackage = (ProfilePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof ProfilePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new ProfilePackageImpl());

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
		TaskPackageImpl theTaskPackage = (TaskPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(TaskPackage.eNS_URI) instanceof TaskPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(TaskPackage.eNS_URI)
				: TaskPackage.eINSTANCE);
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
		MeetingPackageImpl theMeetingPackage = (MeetingPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(MeetingPackage.eNS_URI) instanceof MeetingPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(MeetingPackage.eNS_URI)
				: MeetingPackage.eINSTANCE);
		StatePackageImpl theStatePackage = (StatePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(StatePackage.eNS_URI) instanceof StatePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(StatePackage.eNS_URI)
				: StatePackage.eINSTANCE);
		AttachmentPackageImpl theAttachmentPackage = (AttachmentPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(AttachmentPackage.eNS_URI) instanceof AttachmentPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(AttachmentPackage.eNS_URI)
				: AttachmentPackage.eINSTANCE);

		// Create package meta-data objects
		theProfilePackage.createPackageContents();
		theModelPackage.createPackageContents();
		theOrganizationPackage.createPackageContents();
		theTaskPackage.createPackageContents();
		theDiagramPackage.createPackageContents();
		theClassesPackage.createPackageContents();
		theDocumentPackage.createPackageContents();
		theRequirementPackage.createPackageContents();
		theRationalePackage.createPackageContents();
		theChangePackage.createPackageContents();
		theBugPackage.createPackageContents();
		theComponentPackage.createPackageContents();
		theMeetingPackage.createPackageContents();
		theStatePackage.createPackageContents();
		theAttachmentPackage.createPackageContents();

		// Initialize created meta-data
		theProfilePackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theOrganizationPackage.initializePackageContents();
		theTaskPackage.initializePackageContents();
		theDiagramPackage.initializePackageContents();
		theClassesPackage.initializePackageContents();
		theDocumentPackage.initializePackageContents();
		theRequirementPackage.initializePackageContents();
		theRationalePackage.initializePackageContents();
		theChangePackage.initializePackageContents();
		theBugPackage.initializePackageContents();
		theComponentPackage.initializePackageContents();
		theMeetingPackage.initializePackageContents();
		theStatePackage.initializePackageContents();
		theAttachmentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProfilePackage.freeze();

		return theProfilePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProfile() {
		return profileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProfile_AffectedContainers() {
		return (EReference) profileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProfile_Stereotypes() {
		return (EReference) profileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotype() {
		return stereotypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotype_Required() {
		return (EAttribute) stereotypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotype_Profile() {
		return (EReference) stereotypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotype_StereotypeInstances() {
		return (EReference) stereotypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotype_StereotypeAttributes() {
		return (EReference) stereotypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeInstance() {
		return stereotypeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeInstance_Stereotype() {
		return (EReference) stereotypeInstanceEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeInstance_ModelElement() {
		return (EReference) stereotypeInstanceEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeInstance_StereotypeAttributeInstances() {
		return (EReference) stereotypeInstanceEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeAttribute() {
		return stereotypeAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeAttribute_Stereotype() {
		return (EReference) stereotypeAttributeEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeAttribute_StereotypeAttributeInstances() {
		return (EReference) stereotypeAttributeEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeAttributeSimple() {
		return stereotypeAttributeSimpleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypeAttributeSimple_Type() {
		return (EAttribute) stereotypeAttributeSimpleEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeAttributeInstance() {
		return stereotypeAttributeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeAttributeInstance_StereotypeInstance() {
		return (EReference) stereotypeAttributeInstanceEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStereotypeAttributeInstance_StereotypeAttribute() {
		return (EReference) stereotypeAttributeInstanceEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeAttributeInstanceString() {
		return stereotypeAttributeInstanceStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypeAttributeInstanceString_Value() {
		return (EAttribute) stereotypeAttributeInstanceStringEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileFactory getProfileFactory() {
		return (ProfileFactory) getEFactoryInstance();
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
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		profileEClass = createEClass(PROFILE);
		createEReference(profileEClass, PROFILE__AFFECTED_CONTAINERS);
		createEReference(profileEClass, PROFILE__STEREOTYPES);

		stereotypeEClass = createEClass(STEREOTYPE);
		createEAttribute(stereotypeEClass, STEREOTYPE__REQUIRED);
		createEReference(stereotypeEClass, STEREOTYPE__PROFILE);
		createEReference(stereotypeEClass, STEREOTYPE__STEREOTYPE_INSTANCES);
		createEReference(stereotypeEClass, STEREOTYPE__STEREOTYPE_ATTRIBUTES);

		stereotypeInstanceEClass = createEClass(STEREOTYPE_INSTANCE);
		createEReference(stereotypeInstanceEClass,
				STEREOTYPE_INSTANCE__STEREOTYPE);
		createEReference(stereotypeInstanceEClass,
				STEREOTYPE_INSTANCE__MODEL_ELEMENT);
		createEReference(stereotypeInstanceEClass,
				STEREOTYPE_INSTANCE__STEREOTYPE_ATTRIBUTE_INSTANCES);

		stereotypeAttributeEClass = createEClass(STEREOTYPE_ATTRIBUTE);
		createEReference(stereotypeAttributeEClass,
				STEREOTYPE_ATTRIBUTE__STEREOTYPE);
		createEReference(stereotypeAttributeEClass,
				STEREOTYPE_ATTRIBUTE__STEREOTYPE_ATTRIBUTE_INSTANCES);

		stereotypeAttributeSimpleEClass = createEClass(STEREOTYPE_ATTRIBUTE_SIMPLE);
		createEAttribute(stereotypeAttributeSimpleEClass,
				STEREOTYPE_ATTRIBUTE_SIMPLE__TYPE);

		stereotypeAttributeInstanceEClass = createEClass(STEREOTYPE_ATTRIBUTE_INSTANCE);
		createEReference(stereotypeAttributeInstanceEClass,
				STEREOTYPE_ATTRIBUTE_INSTANCE__STEREOTYPE_INSTANCE);
		createEReference(stereotypeAttributeInstanceEClass,
				STEREOTYPE_ATTRIBUTE_INSTANCE__STEREOTYPE_ATTRIBUTE);

		stereotypeAttributeInstanceStringEClass = createEClass(STEREOTYPE_ATTRIBUTE_INSTANCE_STRING);
		createEAttribute(stereotypeAttributeInstanceStringEClass,
				STEREOTYPE_ATTRIBUTE_INSTANCE_STRING__VALUE);
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
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		profileEClass.getESuperTypes().add(theModelPackage.getModelElement());
		stereotypeEClass.getESuperTypes()
				.add(theModelPackage.getModelElement());
		stereotypeInstanceEClass.getESuperTypes().add(
				theModelPackage.getModelElement());
		stereotypeAttributeEClass.getESuperTypes().add(
				theModelPackage.getModelElement());
		stereotypeAttributeSimpleEClass.getESuperTypes().add(
				this.getStereotypeAttribute());
		stereotypeAttributeInstanceEClass.getESuperTypes().add(
				theModelPackage.getModelElement());
		stereotypeAttributeInstanceStringEClass.getESuperTypes().add(
				this.getStereotypeAttributeInstance());

		// Initialize classes and features; add operations and parameters
		initEClass(profileEClass, Profile.class, "Profile", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProfile_AffectedContainers(), theModelPackage
				.getModelElement(), null, "affectedContainers", null, 0, -1,
				Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		getProfile_AffectedContainers().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getProfile_Stereotypes(), this.getStereotype(), this
				.getStereotype_Profile(), "stereotypes", null, 0, -1,
				Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		getProfile_Stereotypes().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());

		initEClass(stereotypeEClass, Stereotype.class, "Stereotype",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotype_Required(), ecorePackage.getEBoolean(),
				"required", null, 0, 1, Stereotype.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getStereotype_Profile(), this.getProfile(), this
				.getProfile_Stereotypes(), "profile", null, 0, 1,
				Stereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		getStereotype_Profile().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getStereotype_StereotypeInstances(), this
				.getStereotypeInstance(), this
				.getStereotypeInstance_Stereotype(), "stereotypeInstances",
				null, 0, -1, Stereotype.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStereotype_StereotypeInstances().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getStereotype_StereotypeAttributes(), this
				.getStereotypeAttribute(), this
				.getStereotypeAttribute_Stereotype(), "stereotypeAttributes",
				null, 0, -1, Stereotype.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStereotype_StereotypeAttributes().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());

		initEClass(stereotypeInstanceEClass, StereotypeInstance.class,
				"StereotypeInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStereotypeInstance_Stereotype(),
				this.getStereotype(), this.getStereotype_StereotypeInstances(),
				"stereotype", null, 0, 1, StereotypeInstance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		getStereotypeInstance_Stereotype().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getStereotypeInstance_ModelElement(), theModelPackage
				.getModelElement(), theModelPackage
				.getModelElement_AppliedStereotypeInstances(), "modelElement",
				null, 0, 1, StereotypeInstance.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStereotypeInstance_ModelElement().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getStereotypeInstance_StereotypeAttributeInstances(),
				this.getStereotypeAttributeInstance(), this
						.getStereotypeAttributeInstance_StereotypeInstance(),
				"stereotypeAttributeInstances", null, 0, -1,
				StereotypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStereotypeInstance_StereotypeAttributeInstances().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());

		initEClass(stereotypeAttributeEClass, StereotypeAttribute.class,
				"StereotypeAttribute", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStereotypeAttribute_Stereotype(), this
				.getStereotype(), this.getStereotype_StereotypeAttributes(),
				"stereotype", null, 0, 1, StereotypeAttribute.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		getStereotypeAttribute_Stereotype().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getStereotypeAttribute_StereotypeAttributeInstances(),
				this.getStereotypeAttributeInstance(), this
						.getStereotypeAttributeInstance_StereotypeAttribute(),
				"stereotypeAttributeInstances", null, 0, -1,
				StereotypeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStereotypeAttribute_StereotypeAttributeInstances().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());

		initEClass(stereotypeAttributeSimpleEClass,
				StereotypeAttributeSimple.class, "StereotypeAttributeSimple",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypeAttributeSimple_Type(), ecorePackage
				.getEString(), "type", null, 0, 1,
				StereotypeAttributeSimple.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(stereotypeAttributeInstanceEClass,
				StereotypeAttributeInstance.class,
				"StereotypeAttributeInstance", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStereotypeAttributeInstance_StereotypeInstance(),
				this.getStereotypeInstance(), this
						.getStereotypeInstance_StereotypeAttributeInstances(),
				"stereotypeInstance", null, 0, 1,
				StereotypeAttributeInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStereotypeAttributeInstance_StereotypeInstance().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getStereotypeAttributeInstance_StereotypeAttribute(),
				this.getStereotypeAttribute(), this
						.getStereotypeAttribute_StereotypeAttributeInstances(),
				"stereotypeAttribute", null, 0, 1,
				StereotypeAttributeInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStereotypeAttributeInstance_StereotypeAttribute().getEKeys().add(
				theModelPackage.getIdentifiableElement_Identifier());

		initEClass(stereotypeAttributeInstanceStringEClass,
				StereotypeAttributeInstanceString.class,
				"StereotypeAttributeInstanceString", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypeAttributeInstanceString_Value(),
				ecorePackage.getEString(), "value", null, 0, 1,
				StereotypeAttributeInstanceString.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
	}

} //ProfilePackageImpl
