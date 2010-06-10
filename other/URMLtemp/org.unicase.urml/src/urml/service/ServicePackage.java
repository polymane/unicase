/**
 * <copyright> </copyright> $Id$
 */
package urml.service;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import urml.danger.DangerPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see urml.service.ServiceFactory
 * @model kind="package"
 * @generated
 */
public interface ServicePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "service";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/urml/service";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.urml.service";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ServicePackage eINSTANCE = urml.service.impl.ServicePackageImpl.init();

	/**
	 * The meta object id for the '{@link urml.service.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see urml.service.impl.ServiceImpl
	 * @see urml.service.impl.ServicePackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__IDENTIFIER = DangerPackage.MITIGATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CREATOR = DangerPackage.MITIGATION__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CREATION_DATE = DangerPackage.MITIGATION__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = DangerPackage.MITIGATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = DangerPackage.MITIGATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ANNOTATIONS = DangerPackage.MITIGATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ATTACHMENTS = DangerPackage.MITIGATION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__INCOMING_DOCUMENT_REFERENCES = DangerPackage.MITIGATION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LEAF_SECTION = DangerPackage.MITIGATION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__STATE = DangerPackage.MITIGATION__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__APPLIED_STEREOTYPE_INSTANCES = DangerPackage.MITIGATION__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__COMMENTS = DangerPackage.MITIGATION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Mitigated Dangers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__MITIGATED_DANGERS = DangerPackage.MITIGATION__MITIGATED_DANGERS;

	/**
	 * The feature id for the '<em><b>Service Provider</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_PROVIDER = DangerPackage.MITIGATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Satisfied Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SATISFIED_REQUIREMENTS = DangerPackage.MITIGATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = DangerPackage.MITIGATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link urml.service.impl.ServiceProviderImpl <em>Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see urml.service.impl.ServiceProviderImpl
	 * @see urml.service.impl.ServicePackageImpl#getServiceProvider()
	 * @generated
	 */
	int SERVICE_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__IDENTIFIER = DangerPackage.ASSET__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__CREATOR = DangerPackage.ASSET__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__CREATION_DATE = DangerPackage.ASSET__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__NAME = DangerPackage.ASSET__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__DESCRIPTION = DangerPackage.ASSET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__ANNOTATIONS = DangerPackage.ASSET__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__ATTACHMENTS = DangerPackage.ASSET__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__INCOMING_DOCUMENT_REFERENCES = DangerPackage.ASSET__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__LEAF_SECTION = DangerPackage.ASSET__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__STATE = DangerPackage.ASSET__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__APPLIED_STEREOTYPE_INSTANCES = DangerPackage.ASSET__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__COMMENTS = DangerPackage.ASSET__COMMENTS;

	/**
	 * The feature id for the '<em><b>Endangered By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__ENDANGERED_BY = DangerPackage.ASSET__ENDANGERED_BY;

	/**
	 * The feature id for the '<em><b>Provided Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER__PROVIDED_SERVICES = DangerPackage.ASSET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROVIDER_FEATURE_COUNT = DangerPackage.ASSET_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link urml.service.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see urml.service.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the container reference '{@link urml.service.Service#getServiceProvider <em>Service Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Service Provider</em>'.
	 * @see urml.service.Service#getServiceProvider()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ServiceProvider();

	/**
	 * Returns the meta object for the reference list '{@link urml.service.Service#getSatisfiedRequirements <em>Satisfied Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Satisfied Requirements</em>'.
	 * @see urml.service.Service#getSatisfiedRequirements()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_SatisfiedRequirements();

	/**
	 * Returns the meta object for class '{@link urml.service.ServiceProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provider</em>'.
	 * @see urml.service.ServiceProvider
	 * @generated
	 */
	EClass getServiceProvider();

	/**
	 * Returns the meta object for the containment reference list '{@link urml.service.ServiceProvider#getProvidedServices <em>Provided Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided Services</em>'.
	 * @see urml.service.ServiceProvider#getProvidedServices()
	 * @see #getServiceProvider()
	 * @generated
	 */
	EReference getServiceProvider_ProvidedServices();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ServiceFactory getServiceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link urml.service.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see urml.service.impl.ServiceImpl
		 * @see urml.service.impl.ServicePackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Service Provider</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__SERVICE_PROVIDER = eINSTANCE.getService_ServiceProvider();

		/**
		 * The meta object literal for the '<em><b>Satisfied Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__SATISFIED_REQUIREMENTS = eINSTANCE.getService_SatisfiedRequirements();

		/**
		 * The meta object literal for the '{@link urml.service.impl.ServiceProviderImpl <em>Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see urml.service.impl.ServiceProviderImpl
		 * @see urml.service.impl.ServicePackageImpl#getServiceProvider()
		 * @generated
		 */
		EClass SERVICE_PROVIDER = eINSTANCE.getServiceProvider();

		/**
		 * The meta object literal for the '<em><b>Provided Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_PROVIDER__PROVIDED_SERVICES = eINSTANCE.getServiceProvider_ProvidedServices();

	}

} //ServicePackage