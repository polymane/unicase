/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import scrm.SCRMModelElement;

import scrm.SCRMSpace;
import scrm.requirements.IRequirement;
import scrm.requirements.Requirement;

import scrm.requirements.dataProcess.DataHandling;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataProcessSpace;
import scrm.requirements.dataProcess.ErrorHandling;
import scrm.requirements.dataProcess.InputDataReading;
import scrm.requirements.dataProcess.ResultsOutput;
import scrm.requirements.dataProcess.StatusMonitoring;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see scrm.requirements.dataProcess.DataProcessPackage
 * @generated
 */
public class DataProcessAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataProcessPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DataProcessPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataProcessSwitch<Adapter> modelSwitch = new DataProcessSwitch<Adapter>() {
		@Override
		public Adapter caseProcess(scrm.requirements.dataProcess.Process object) {
			return createProcessAdapter();
		}

		@Override
		public Adapter caseInputDataReading(InputDataReading object) {
			return createInputDataReadingAdapter();
		}

		@Override
		public Adapter caseDataHandling(DataHandling object) {
			return createDataHandlingAdapter();
		}

		@Override
		public Adapter caseResultsOutput(ResultsOutput object) {
			return createResultsOutputAdapter();
		}

		@Override
		public Adapter caseErrorHandling(ErrorHandling object) {
			return createErrorHandlingAdapter();
		}

		@Override
		public Adapter caseStatusMonitoring(StatusMonitoring object) {
			return createStatusMonitoringAdapter();
		}

		@Override
		public Adapter caseDataProcessSpace(DataProcessSpace object) {
			return createDataProcessSpaceAdapter();
		}

		@Override
		public Adapter caseSCRMModelElement(SCRMModelElement object) {
			return createSCRMModelElementAdapter();
		}

		@Override
		public Adapter caseIRequirement(IRequirement object) {
			return createIRequirementAdapter();
		}

		@Override
		public Adapter caseRequirement(Requirement object) {
			return createRequirementAdapter();
		}

		@Override
		public Adapter caseSCRMSpace(SCRMSpace object) {
			return createSCRMSpaceAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.InputDataReading <em>Input Data Reading</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.InputDataReading
	 * @generated
	 */
	public Adapter createInputDataReadingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.DataHandling <em>Data Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.DataHandling
	 * @generated
	 */
	public Adapter createDataHandlingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.ResultsOutput <em>Results Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.ResultsOutput
	 * @generated
	 */
	public Adapter createResultsOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.ErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.ErrorHandling
	 * @generated
	 */
	public Adapter createErrorHandlingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.StatusMonitoring <em>Status Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.StatusMonitoring
	 * @generated
	 */
	public Adapter createStatusMonitoringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.Process
	 * @generated
	 */
	public Adapter createProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.dataProcess.DataProcessSpace <em>Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.dataProcess.DataProcessSpace
	 * @generated
	 */
	public Adapter createDataProcessSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.SCRMModelElement <em>SCRM Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.SCRMModelElement
	 * @generated
	 */
	public Adapter createSCRMModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.IRequirement <em>IRequirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.IRequirement
	 * @generated
	 */
	public Adapter createIRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.requirements.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.requirements.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scrm.SCRMSpace <em>SCRM Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scrm.SCRMSpace
	 * @generated
	 */
	public Adapter createSCRMSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DataProcessAdapterFactory
