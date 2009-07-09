/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.AnalyzerPackage;

import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.exporters.Exporter;

import org.unicase.analyzer.iterator.VersionIterator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.analyzer.impl.AnalyzerConfigurationImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.unicase.analyzer.impl.AnalyzerConfigurationImpl#getAnalyzerName <em>Analyzer Name</em>}</li>
 *   <li>{@link org.unicase.analyzer.impl.AnalyzerConfigurationImpl#getExporterName <em>Exporter Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnalyzerConfigurationImpl extends EObjectImpl implements AnalyzerConfiguration {
	/**
	 * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterator()
	 * @generated
	 * @ordered
	 */
	protected VersionIterator iterator;

	/**
	 * The default value of the '{@link #getAnalyzerName() <em>Analyzer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalyzerName()
	 * @generated
	 * @ordered
	 */
	protected static final String ANALYZER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnalyzerName() <em>Analyzer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalyzerName()
	 * @generated
	 * @ordered
	 */
	protected String analyzerName = ANALYZER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getExporterName() <em>Exporter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExporterName()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPORTER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExporterName() <em>Exporter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExporterName()
	 * @generated
	 * @ordered
	 */
	protected String exporterName = EXPORTER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalyzerConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.ANALYZER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionIterator getIterator() {
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterator(VersionIterator newIterator, NotificationChain msgs) {
		VersionIterator oldIterator = iterator;
		iterator = newIterator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR, oldIterator, newIterator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterator(VersionIterator newIterator) {
		if (newIterator != iterator) {
			NotificationChain msgs = null;
			if (iterator != null)
				msgs = ((InternalEObject)iterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR, null, msgs);
			if (newIterator != null)
				msgs = ((InternalEObject)newIterator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR, null, msgs);
			msgs = basicSetIterator(newIterator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR, newIterator, newIterator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnalyzerName() {
		return analyzerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalyzerName(String newAnalyzerName) {
		String oldAnalyzerName = analyzerName;
		analyzerName = newAnalyzerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYZER_CONFIGURATION__ANALYZER_NAME, oldAnalyzerName, analyzerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExporterName() {
		return exporterName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExporterName(String newExporterName) {
		String oldExporterName = exporterName;
		exporterName = newExporterName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER_NAME, oldExporterName, exporterName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR:
				return basicSetIterator(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR:
				return getIterator();
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ANALYZER_NAME:
				return getAnalyzerName();
			case AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER_NAME:
				return getExporterName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR:
				setIterator((VersionIterator)newValue);
				return;
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ANALYZER_NAME:
				setAnalyzerName((String)newValue);
				return;
			case AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER_NAME:
				setExporterName((String)newValue);
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
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR:
				setIterator((VersionIterator)null);
				return;
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ANALYZER_NAME:
				setAnalyzerName(ANALYZER_NAME_EDEFAULT);
				return;
			case AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER_NAME:
				setExporterName(EXPORTER_NAME_EDEFAULT);
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
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR:
				return iterator != null;
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ANALYZER_NAME:
				return ANALYZER_NAME_EDEFAULT == null ? analyzerName != null : !ANALYZER_NAME_EDEFAULT.equals(analyzerName);
			case AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER_NAME:
				return EXPORTER_NAME_EDEFAULT == null ? exporterName != null : !EXPORTER_NAME_EDEFAULT.equals(exporterName);
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
		result.append(" (analyzerName: ");
		result.append(analyzerName);
		result.append(", exporterName: ");
		result.append(exporterName);
		result.append(')');
		return result.toString();
	}

} //AnalyzerConfigurationImpl
