/**
 * <copyright> </copyright> $Id$
 */
package urml.usecase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.metamodel.MetamodelPackage;

import org.unicase.model.ModelPackage;

import org.unicase.model.urml.UrmlPackage;

import org.unicase.model.urml.impl.UrmlPackageImpl;

import urml.danger.DangerPackage;

import urml.danger.impl.DangerPackageImpl;

import urml.feature.FeaturePackage;

import urml.feature.impl.FeaturePackageImpl;

import urml.goal.GoalPackage;

import urml.goal.impl.GoalPackageImpl;

import urml.requirement.RequirementPackage;

import urml.requirement.impl.RequirementPackageImpl;

import urml.service.ServicePackage;

import urml.service.impl.ServicePackageImpl;

import urml.usecase.Actor;
import urml.usecase.ApplicationDomainUseCase;
import urml.usecase.SolutionDomainUseCase;
import urml.usecase.UseCase;
import urml.usecase.UsecaseFactory;
import urml.usecase.UsecasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UsecasePackageImpl extends EPackageImpl implements UsecasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationDomainUseCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solutionDomainUseCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorEClass = null;

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
	 * @see urml.usecase.UsecasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UsecasePackageImpl() {
		super(eNS_URI, UsecaseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UsecasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UsecasePackage init() {
		if (isInited)
			return (UsecasePackage) EPackage.Registry.INSTANCE.getEPackage(UsecasePackage.eNS_URI);

		// Obtain or create and register package
		UsecasePackageImpl theUsecasePackage = (UsecasePackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UsecasePackageImpl ? EPackage.Registry.INSTANCE
			.get(eNS_URI)
			: new UsecasePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		UrmlPackageImpl theUrmlPackage = (UrmlPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UrmlPackage.eNS_URI) instanceof UrmlPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(UrmlPackage.eNS_URI)
			: UrmlPackage.eINSTANCE);
		GoalPackageImpl theGoalPackage = (GoalPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(GoalPackage.eNS_URI) instanceof GoalPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(GoalPackage.eNS_URI)
			: GoalPackage.eINSTANCE);
		RequirementPackageImpl theRequirementPackage = (RequirementPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RequirementPackage.eNS_URI) instanceof RequirementPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RequirementPackage.eNS_URI) : RequirementPackage.eINSTANCE);
		ServicePackageImpl theServicePackage = (ServicePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ServicePackage.eNS_URI) instanceof ServicePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ServicePackage.eNS_URI) : ServicePackage.eINSTANCE);
		DangerPackageImpl theDangerPackage = (DangerPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(DangerPackage.eNS_URI) instanceof DangerPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(DangerPackage.eNS_URI) : DangerPackage.eINSTANCE);
		FeaturePackageImpl theFeaturePackage = (FeaturePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(FeaturePackage.eNS_URI) instanceof FeaturePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(FeaturePackage.eNS_URI) : FeaturePackage.eINSTANCE);

		// Create package meta-data objects
		theUsecasePackage.createPackageContents();
		theUrmlPackage.createPackageContents();
		theGoalPackage.createPackageContents();
		theRequirementPackage.createPackageContents();
		theServicePackage.createPackageContents();
		theDangerPackage.createPackageContents();
		theFeaturePackage.createPackageContents();

		// Initialize created meta-data
		theUsecasePackage.initializePackageContents();
		theUrmlPackage.initializePackageContents();
		theGoalPackage.initializePackageContents();
		theRequirementPackage.initializePackageContents();
		theServicePackage.initializePackageContents();
		theDangerPackage.initializePackageContents();
		theFeaturePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUsecasePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UsecasePackage.eNS_URI, theUsecasePackage);
		return theUsecasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseCase() {
		return useCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCase_Steps() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCase_Actors() {
		return (EReference) useCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicationDomainUseCase() {
		return applicationDomainUseCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationDomainUseCase_DetailedGoal() {
		return (EReference) applicationDomainUseCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolutionDomainUseCase() {
		return solutionDomainUseCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolutionDomainUseCase_DetailedFeature() {
		return (EReference) solutionDomainUseCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActor() {
		return actorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_UseCases() {
		return (EReference) actorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsecaseFactory getUsecaseFactory() {
		return (UsecaseFactory) getEFactoryInstance();
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
		useCaseEClass = createEClass(USE_CASE);
		createEReference(useCaseEClass, USE_CASE__STEPS);
		createEReference(useCaseEClass, USE_CASE__ACTORS);

		applicationDomainUseCaseEClass = createEClass(APPLICATION_DOMAIN_USE_CASE);
		createEReference(applicationDomainUseCaseEClass, APPLICATION_DOMAIN_USE_CASE__DETAILED_GOAL);

		solutionDomainUseCaseEClass = createEClass(SOLUTION_DOMAIN_USE_CASE);
		createEReference(solutionDomainUseCaseEClass, SOLUTION_DOMAIN_USE_CASE__DETAILED_FEATURE);

		actorEClass = createEClass(ACTOR);
		createEReference(actorEClass, ACTOR__USE_CASES);
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
		UrmlPackage theUrmlPackage = (UrmlPackage) EPackage.Registry.INSTANCE.getEPackage(UrmlPackage.eNS_URI);
		org.unicase.model.requirement.RequirementPackage theRequirementPackage_1 = (org.unicase.model.requirement.RequirementPackage) EPackage.Registry.INSTANCE
			.getEPackage(org.unicase.model.requirement.RequirementPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(MetamodelPackage.eNS_URI);
		GoalPackage theGoalPackage = (GoalPackage) EPackage.Registry.INSTANCE.getEPackage(GoalPackage.eNS_URI);
		FeaturePackage theFeaturePackage = (FeaturePackage) EPackage.Registry.INSTANCE
			.getEPackage(FeaturePackage.eNS_URI);
		DangerPackage theDangerPackage = (DangerPackage) EPackage.Registry.INSTANCE.getEPackage(DangerPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		useCaseEClass.getESuperTypes().add(theUrmlPackage.getUrmlModelElement());
		applicationDomainUseCaseEClass.getESuperTypes().add(this.getUseCase());
		solutionDomainUseCaseEClass.getESuperTypes().add(this.getUseCase());
		actorEClass.getESuperTypes().add(theDangerPackage.getAsset());

		// Initialize classes and features; add operations and parameters
		initEClass(useCaseEClass, UseCase.class, "UseCase", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCase_Steps(), theRequirementPackage_1.getStep(), null, "steps", null, 0, -1,
			UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseCase_Actors(), this.getActor(), this.getActor_UseCases(), "actors", null, 0, -1,
			UseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getUseCase_Actors().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(applicationDomainUseCaseEClass, ApplicationDomainUseCase.class, "ApplicationDomainUseCase",
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplicationDomainUseCase_DetailedGoal(), theGoalPackage.getGoal(), theGoalPackage
			.getGoal_DetailingUseCases(), "detailedGoal", null, 0, -1, ApplicationDomainUseCase.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getApplicationDomainUseCase_DetailedGoal().getEKeys().add(
			theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(solutionDomainUseCaseEClass, SolutionDomainUseCase.class, "SolutionDomainUseCase", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolutionDomainUseCase_DetailedFeature(), theFeaturePackage.getAbstractFeature(),
			theFeaturePackage.getAbstractFeature_DetailingUseCases(), "detailedFeature", null, 0, 1,
			SolutionDomainUseCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSolutionDomainUseCase_DetailedFeature().getEKeys().add(
			theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(actorEClass, Actor.class, "Actor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActor_UseCases(), this.getUseCase(), this.getUseCase_Actors(), "useCases", null, 0, -1,
			Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
			IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getActor_UseCases().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
	}

} //UsecasePackageImpl
