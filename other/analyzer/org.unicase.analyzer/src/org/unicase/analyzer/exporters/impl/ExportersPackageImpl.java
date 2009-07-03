/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.analyzer.exporters.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.analyzer.AnalyzerPackage;

import org.unicase.analyzer.exporters.Exporter;
import org.unicase.analyzer.exporters.ExportersFactory;
import org.unicase.analyzer.exporters.ExportersPackage;

import org.unicase.analyzer.impl.AnalyzerPackageImpl;

import org.unicase.analyzer.iterator.IteratorPackage;

import org.unicase.analyzer.iterator.impl.IteratorPackageImpl;

import org.unicase.emfstore.esmodel.EsmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExportersPackageImpl extends EPackageImpl implements ExportersPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exporterEClass = null;

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
	 * @see org.unicase.analyzer.exporters.ExportersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExportersPackageImpl() {
		super(eNS_URI, ExportersFactory.eINSTANCE);
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
	public static ExportersPackage init() {
		if (isInited) return (ExportersPackage)EPackage.Registry.INSTANCE.getEPackage(ExportersPackage.eNS_URI);

		// Obtain or create and register package
		ExportersPackageImpl theExportersPackage = (ExportersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExportersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExportersPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EsmodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AnalyzerPackageImpl theAnalyzerPackage = (AnalyzerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnalyzerPackage.eNS_URI) instanceof AnalyzerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnalyzerPackage.eNS_URI) : AnalyzerPackage.eINSTANCE);
		IteratorPackageImpl theIteratorPackage = (IteratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(IteratorPackage.eNS_URI) instanceof IteratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(IteratorPackage.eNS_URI) : IteratorPackage.eINSTANCE);

		// Create package meta-data objects
		theExportersPackage.createPackageContents();
		theAnalyzerPackage.createPackageContents();
		theIteratorPackage.createPackageContents();

		// Initialize created meta-data
		theExportersPackage.initializePackageContents();
		theAnalyzerPackage.initializePackageContents();
		theIteratorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExportersPackage.freeze();

		return theExportersPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExporter() {
		return exporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExporter_FileName() {
		return (EAttribute)exporterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExportersFactory getExportersFactory() {
		return (ExportersFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		exporterEClass = createEClass(EXPORTER);
		createEAttribute(exporterEClass, EXPORTER__FILE_NAME);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(exporterEClass, Exporter.class, "Exporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExporter_FileName(), theEcorePackage.getEString(), "fileName", null, 0, 1, Exporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //ExportersPackageImpl
