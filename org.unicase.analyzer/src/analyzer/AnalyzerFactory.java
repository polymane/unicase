/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package analyzer;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see analyzer.AnalyzerPackage
 * @generated
 */
public interface AnalyzerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnalyzerFactory eINSTANCE = analyzer.impl.AnalyzerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Project Analysis Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Analysis Data</em>'.
	 * @generated
	 */
	ProjectAnalysisData createProjectAnalysisData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnalyzerPackage getAnalyzerPackage();

} //AnalyzerFactory
