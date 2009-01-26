/**
 * <copyright> </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.docExport.exportModel.ExportModelPackage;
import org.unicase.docExport.exportModel.impl.ExportModelPackageImpl;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl;
import org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SpecialRenderersPackageImpl extends EPackageImpl implements SpecialRenderersPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass meetingRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass milestoneRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stepsAttributeRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass methodRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass packageFlatRendererEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SpecialRenderersPackageImpl() {
		super(eNS_URI, SpecialRenderersFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * Simple dependencies are satisfied by calling this method on all dependent packages before doing anything else.
	 * This method drives initialization for interdependent packages directly, in parallel with this package, itself.
	 * <p>
	 * Of this package and its interdependencies, all packages which have not yet been registered by their URI values
	 * are first created and registered. The packages are then initialized in two steps: meta-model objects for all of
	 * the packages are created before any are initialized, since one package's meta-model objects may refer to those of
	 * another.
	 * <p>
	 * Invocation of this method will not affect any packages that have already been initialized. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SpecialRenderersPackage init() {
		if (isInited)
			return (SpecialRenderersPackage) EPackage.Registry.INSTANCE.getEPackage(SpecialRenderersPackage.eNS_URI);

		// Obtain or create and register package
		SpecialRenderersPackageImpl theSpecialRenderersPackage = (SpecialRenderersPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI) instanceof SpecialRenderersPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI) : new SpecialRenderersPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ExportModelPackageImpl theExportModelPackage = (ExportModelPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ExportModelPackage.eNS_URI) instanceof ExportModelPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ExportModelPackage.eNS_URI) : ExportModelPackage.eINSTANCE);
		RenderersPackageImpl theRenderersPackage = (RenderersPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RenderersPackage.eNS_URI) instanceof RenderersPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RenderersPackage.eNS_URI) : RenderersPackage.eINSTANCE);
		DefaultRenderersPackageImpl theDefaultRenderersPackage = (DefaultRenderersPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(DefaultRenderersPackage.eNS_URI) instanceof DefaultRenderersPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(DefaultRenderersPackage.eNS_URI)
			: DefaultRenderersPackage.eINSTANCE);
		OptionsPackageImpl theOptionsPackage = (OptionsPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(OptionsPackage.eNS_URI) instanceof OptionsPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(OptionsPackage.eNS_URI) : OptionsPackage.eINSTANCE);

		// Create package meta-data objects
		theSpecialRenderersPackage.createPackageContents();
		theExportModelPackage.createPackageContents();
		theRenderersPackage.createPackageContents();
		theDefaultRenderersPackage.createPackageContents();
		theOptionsPackage.createPackageContents();

		// Initialize created meta-data
		theSpecialRenderersPackage.initializePackageContents();
		theExportModelPackage.initializePackageContents();
		theRenderersPackage.initializePackageContents();
		theDefaultRenderersPackage.initializePackageContents();
		theOptionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSpecialRenderersPackage.freeze();

		return theSpecialRenderersPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMeetingRenderer() {
		return meetingRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMilestoneRenderer() {
		return milestoneRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStepsAttributeRenderer() {
		return stepsAttributeRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMethodRenderer() {
		return methodRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPackageFlatRenderer() {
		return packageFlatRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SpecialRenderersFactory getSpecialRenderersFactory() {
		return (SpecialRenderersFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
	 * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		meetingRendererEClass = createEClass(MEETING_RENDERER);

		milestoneRendererEClass = createEClass(MILESTONE_RENDERER);

		stepsAttributeRendererEClass = createEClass(STEPS_ATTRIBUTE_RENDERER);

		methodRendererEClass = createEClass(METHOD_RENDERER);

		packageFlatRendererEClass = createEClass(PACKAGE_FLAT_RENDERER);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
	 * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
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
		RenderersPackage theRenderersPackage = (RenderersPackage) EPackage.Registry.INSTANCE
			.getEPackage(RenderersPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		meetingRendererEClass.getESuperTypes().add(theRenderersPackage.getModelElementRenderer());
		milestoneRendererEClass.getESuperTypes().add(theRenderersPackage.getModelElementRenderer());
		stepsAttributeRendererEClass.getESuperTypes().add(theRenderersPackage.getAttributeRenderer());
		methodRendererEClass.getESuperTypes().add(theRenderersPackage.getAttributeRenderer());
		packageFlatRendererEClass.getESuperTypes().add(theRenderersPackage.getModelElementRenderer());

		// Initialize classes and features; add operations and parameters
		initEClass(meetingRendererEClass, MeetingRenderer.class, "MeetingRenderer", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		initEClass(milestoneRendererEClass, MilestoneRenderer.class, "MilestoneRenderer", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		initEClass(stepsAttributeRendererEClass, StepsAttributeRenderer.class, "StepsAttributeRenderer", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(methodRendererEClass, MethodRenderer.class, "MethodRenderer", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		initEClass(packageFlatRendererEClass, PackageFlatRenderer.class, "PackageFlatRenderer", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} // SpecialRenderersPackageImpl
