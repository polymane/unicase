/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.papyrus.PapyrusFactory;
import org.unicase.papyrus.PapyrusPackage;
import org.unicase.papyrus.SysMLClass;
import org.unicase.papyrus.SysMLDiagramType;
import org.unicase.papyrus.SysMLModel;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.papyrus.UMLModel;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class PapyrusFactoryImpl extends EFactoryImpl implements PapyrusFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static PapyrusFactory init() {
		try {
			PapyrusFactory thePapyrusFactory = (PapyrusFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/model/papyrus");
			if (thePapyrusFactory != null) {
				return thePapyrusFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PapyrusFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PapyrusFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case PapyrusPackage.UML_MODEL:
			return createUMLModel();
		case PapyrusPackage.SYS_ML_MODEL:
			return createSysMLModel();
		case PapyrusPackage.SYS_ML_CLASS:
			return createSysMLClass();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case PapyrusPackage.UML_DIAGRAM_TYPE:
			return createUMLDiagramTypeFromString(eDataType, initialValue);
		case PapyrusPackage.SYS_ML_DIAGRAM_TYPE:
			return createSysMLDiagramTypeFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case PapyrusPackage.UML_DIAGRAM_TYPE:
			return convertUMLDiagramTypeToString(eDataType, instanceValue);
		case PapyrusPackage.SYS_ML_DIAGRAM_TYPE:
			return convertSysMLDiagramTypeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLModel createUMLModel() {
		UMLModelImpl umlModel = new UMLModelImpl();
		return umlModel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SysMLModel createSysMLModel() {
		SysMLModelImpl sysMLModel = new SysMLModelImpl();
		return sysMLModel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SysMLClass createSysMLClass() {
		SysMLClassImpl sysMLClass = new SysMLClassImpl();
		return sysMLClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLDiagramType createUMLDiagramTypeFromString(EDataType eDataType, String initialValue) {
		UMLDiagramType result = UMLDiagramType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertUMLDiagramTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SysMLDiagramType createSysMLDiagramTypeFromString(EDataType eDataType, String initialValue) {
		SysMLDiagramType result = SysMLDiagramType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertSysMLDiagramTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PapyrusPackage getPapyrusPackage() {
		return (PapyrusPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PapyrusPackage getPackage() {
		return PapyrusPackage.eINSTANCE;
	}

} // PapyrusFactoryImpl
