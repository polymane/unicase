/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataObject;

import org.eclipse.emf.common.util.EList;

import scrm.knowledge.Model;
import scrm.requirements.IRequirement;
import scrm.requirements.Interface;
import scrm.requirements.Requirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.dataObject.Data#getDefinedRequirement <em>Defined Requirement</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.Data#getAccuracy <em>Accuracy</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.Data#getRange <em>Range</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.Data#getFormat <em>Format</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.Data#getProvidedInterface <em>Provided Interface</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.Data#getRequiredInterface <em>Required Interface</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.Data#getDescribedModel <em>Described Model</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.Data#getContaining <em>Containing</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.dataObject.DataObjectPackage#getData()
 * @model
 * @generated
 */
public interface Data extends IRequirement {
	/**
	 * Returns the value of the '<em><b>Defined Requirement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Requirement#getHandlingData <em>Handling Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Requirement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined Requirement</em>' reference.
	 * @see #setDefinedRequirement(Requirement)
	 * @see scrm.requirements.dataObject.DataObjectPackage#getData_DefinedRequirement()
	 * @see scrm.requirements.Requirement#getHandlingData
	 * @model opposite="handlingData"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	Requirement getDefinedRequirement();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataObject.Data#getDefinedRequirement <em>Defined Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defined Requirement</em>' reference.
	 * @see #getDefinedRequirement()
	 * @generated
	 */
	void setDefinedRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Accuracy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accuracy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accuracy</em>' attribute.
	 * @see #setAccuracy(String)
	 * @see scrm.requirements.dataObject.DataObjectPackage#getData_Accuracy()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='5'"
	 * @generated
	 */
	String getAccuracy();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataObject.Data#getAccuracy <em>Accuracy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accuracy</em>' attribute.
	 * @see #getAccuracy()
	 * @generated
	 */
	void setAccuracy(String value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' attribute.
	 * @see #setRange(String)
	 * @see scrm.requirements.dataObject.DataObjectPackage#getData_Range()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='6'"
	 * @generated
	 */
	String getRange();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataObject.Data#getRange <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' attribute.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(String value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see scrm.requirements.dataObject.DataObjectPackage#getData_Format()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='8'"
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataObject.Data#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Provided Interface</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Interface#getProvidingData <em>Providing Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Interface</em>' reference.
	 * @see #setProvidedInterface(Interface)
	 * @see scrm.requirements.dataObject.DataObjectPackage#getData_ProvidedInterface()
	 * @see scrm.requirements.Interface#getProvidingData
	 * @model opposite="providingData"
	 * @generated
	 */
	Interface getProvidedInterface();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataObject.Data#getProvidedInterface <em>Provided Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Interface</em>' reference.
	 * @see #getProvidedInterface()
	 * @generated
	 */
	void setProvidedInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Required Interface</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Interface#getRequiringData <em>Requiring Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interface</em>' reference.
	 * @see #setRequiredInterface(Interface)
	 * @see scrm.requirements.dataObject.DataObjectPackage#getData_RequiredInterface()
	 * @see scrm.requirements.Interface#getRequiringData
	 * @model opposite="requiringData"
	 * @generated
	 */
	Interface getRequiredInterface();

	/**
	 * Sets the value of the '{@link scrm.requirements.dataObject.Data#getRequiredInterface <em>Required Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Interface</em>' reference.
	 * @see #getRequiredInterface()
	 * @generated
	 */
	void setRequiredInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Described Model</b></em>' reference list.
	 * The list contents are of type {@link scrm.knowledge.Model}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.Model#getInvolvedData <em>Involved Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Described Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Described Model</em>' reference list.
	 * @see scrm.requirements.dataObject.DataObjectPackage#getData_DescribedModel()
	 * @see scrm.knowledge.Model#getInvolvedData
	 * @model opposite="involvedData"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='8'"
	 * @generated
	 */
	EList<Model> getDescribedModel();

	/**
	 * Returns the value of the '<em><b>Containing</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.dataObject.Data}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing</em>' reference list.
	 * @see scrm.requirements.dataObject.DataObjectPackage#getData_Containing()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='4'"
	 * @generated
	 */
	EList<Data> getContaining();

} // Data
