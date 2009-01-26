/**
 * <copyright> </copyright>
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage
 * @generated
 */
public interface DefaultRenderersFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	DefaultRenderersFactory eINSTANCE = org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersFactoryImpl
		.init();

	/**
	 * Returns a new object of class '<em>Default Model Element Renderer</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Default Model Element Renderer</em>'.
	 * @generated
	 */
	DefaultModelElementRenderer createDefaultModelElementRenderer();

	/**
	 * Returns a new object of class '<em>Default Attribute Renderer</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Default Attribute Renderer</em>'.
	 * @generated
	 */
	DefaultAttributeRenderer createDefaultAttributeRenderer();

	/**
	 * Returns a new object of class '<em>Default Document Renderer</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Default Document Renderer</em>'.
	 * @generated
	 */
	DefaultDocumentRenderer createDefaultDocumentRenderer();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	DefaultRenderersPackage getDefaultRenderersPackage();

} // DefaultRenderersFactory
