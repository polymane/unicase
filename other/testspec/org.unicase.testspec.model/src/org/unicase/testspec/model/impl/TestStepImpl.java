/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model.impl;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.ModelElement;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.testspec.model.ModelPackage;
import org.unicase.testspec.model.TestStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.testspec.model.impl.TestStepImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestStepImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestStepImpl#getException <em>Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestStepImpl extends ModelElementImpl implements TestStep {
	/**
	 * The default value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String INPUT_EDEFAULT = "%BEGINNTEXT%[n: ; t: ; r: ]";

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected String input = INPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutput() <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String OUTPUT_EDEFAULT = "%BEGINNTEXT%[n: ; t: ; r: ]";

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected String output = OUTPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected String exception = EXCEPTION_EDEFAULT;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated NOT
	 */
	protected static final String TEXTFIELD_TEMPLATE = "%BEGINNTEXT%";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated NOT
	 */
	protected String textfield_template = TEXTFIELD_TEMPLATE;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TEST_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setException(String newException) {
		String oldException = exception;
		exception = newException;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_STEP__EXCEPTION, oldException, exception));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(String newInput) {
		
		String oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_STEP__INPUT, oldInput, input));
		updateReferencedTestProtocol();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(String newOutput) {
		String oldOutput = output;
		output = newOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_STEP__OUTPUT, oldOutput, output));
		updateReferencedTestProtocol();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.TEST_STEP__INPUT:
				return getInput();
			case ModelPackage.TEST_STEP__OUTPUT:
				return getOutput();
			case ModelPackage.TEST_STEP__EXCEPTION:
				return getException();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.TEST_STEP__INPUT:
				setInput((String)newValue);
				return;
			case ModelPackage.TEST_STEP__OUTPUT:
				setOutput((String)newValue);
				return;
			case ModelPackage.TEST_STEP__EXCEPTION:
				setException((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.TEST_STEP__INPUT:
				setInput(INPUT_EDEFAULT);
				return;
			case ModelPackage.TEST_STEP__OUTPUT:
				setOutput(OUTPUT_EDEFAULT);
				return;
			case ModelPackage.TEST_STEP__EXCEPTION:
				setException(EXCEPTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.TEST_STEP__INPUT:
				return INPUT_EDEFAULT == null ? input != null : !INPUT_EDEFAULT.equals(input);
			case ModelPackage.TEST_STEP__OUTPUT:
				return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
			case ModelPackage.TEST_STEP__EXCEPTION:
				return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (input: ");
		result.append(input);
		result.append(", output: ");
		result.append(output);
		result.append(", exception: ");
		result.append(exception);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void updateReferencedTestProtocol() {	
		Set<ModelElement> s = this.getContainerModelElement().getAllContainedModelElements();

		for (Iterator<ModelElement> i = s.iterator(); i.hasNext();) {
			Object object = i.next();
			if (object instanceof TestProtocolImpl) {
				TestProtocolImpl tp = (TestProtocolImpl) object;
				TestCaseImpl tc = (TestCaseImpl)tp.getTestCase();
				
				if(tc != null) {
					tp.clearParams();
					for (Iterator<TestStep> iterator = tc.getStep().iterator(); iterator.hasNext();) {
						TestStepImpl ts = (TestStepImpl) iterator.next();
						tp.addTestStepInputOutput(ts.getName(), ts.getInputParams(), ts.getOutputParams());
					}
					tp.finishedTestSteps();
				}
			}
		}
		s = null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String[] getInputParams(){
		String[] lines = null;
		try {
			lines = input.substring(input.indexOf(textfield_template)+textfield_template.length(), input.length()).split("\n");
			return lines;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String[] getOutputParams(){
		String[] lines = null;
		try {
			lines = output.substring(output.indexOf(textfield_template)+textfield_template.length(), output.length()).split("\n");
			return lines;
		} catch (Exception e) {
			return null;
		}
	}

} //TestStepImpl
