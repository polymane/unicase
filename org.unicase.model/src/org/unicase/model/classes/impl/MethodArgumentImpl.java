/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.model.classes.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.classes.ArgumentDirectionType;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.MethodArgument;
import org.unicase.model.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.classes.impl.MethodArgumentImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodArgumentImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodArgumentImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodArgumentImpl#getSignature <em>Signature</em>}</li>
 *   <li>{@link org.unicase.model.classes.impl.MethodArgumentImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodArgumentImpl extends ModelElementImpl implements
		MethodArgument {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final ArgumentDirectionType DIRECTION_EDEFAULT = ArgumentDirectionType.UNDEFINED;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected ArgumentDirectionType direction = DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignature() <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNATURE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodArgumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassesPackage.Literals.METHOD_ARGUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.METHOD_ARGUMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArgumentDirectionType getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(ArgumentDirectionType newDirection) {
		ArgumentDirectionType oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.METHOD_ARGUMENT__DIRECTION, oldDirection,
					direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.METHOD_ARGUMENT__DEFAULT_VALUE,
					oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSignature() {
		// TODO: implement this method to return the 'Signature' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature(String newSignature) {
		// TODO: implement this method to set the 'Signature' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLabel() {
		if (label != null) {
			return label;
		} else {
			String label = "";

			if (this.getDirection() != ArgumentDirectionType.UNDEFINED) {
				label += this.getDirection().getLiteral();
				label += " ";
			}

			if (this.getName() != null) {
				label += this.getName();
			}

			if (this.getType() != null) {
				label += ": ";
				label += this.getType();
			}

			if (this.getDefaultValue() != null) {
				label += "= ";
				label += this.getDefaultValue();
			}

			return label;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;

		String validSignatureRegExp;

		validSignatureRegExp = "";
		validSignatureRegExp += "\\s*(?:in|out|inout)?\\s*";
		validSignatureRegExp += "\\w*\\s*";
		validSignatureRegExp += "(?::\\s*\\w*)?\\s*";
		validSignatureRegExp += "(?:=\\s*\\w*)?\\s*";

		if (newLabel.matches(validSignatureRegExp)) {
			Pattern p = Pattern.compile("\\b(?:in|out|inout)\\b");
			Matcher m = p.matcher(newLabel);
			boolean b = m.find();

			if (b) {
				String directionLiteral = m.group();
				this.setDirection(ArgumentDirectionType.get(directionLiteral));
				newLabel = newLabel.replaceFirst("\\b(?:in|out|inout)\\b", "");
			}

			p = Pattern.compile("(?<!:(\\s{0,5}))\\w+");
			m = p.matcher(newLabel);
			b = m.find();

			if (b) {
				String nameString = m.group();
				this.setName(nameString);
			}

			p = Pattern.compile("(?<=:(\\s{0,5}))\\w+");
			m = p.matcher(newLabel);
			b = m.find();

			if (b) {
				String typeString = m.group();
				this.setType(typeString);
			}

			label = null;
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ClassesPackage.METHOD_ARGUMENT__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ClassesPackage.METHOD_ARGUMENT__TYPE:
			return getType();
		case ClassesPackage.METHOD_ARGUMENT__DIRECTION:
			return getDirection();
		case ClassesPackage.METHOD_ARGUMENT__DEFAULT_VALUE:
			return getDefaultValue();
		case ClassesPackage.METHOD_ARGUMENT__SIGNATURE:
			return getSignature();
		case ClassesPackage.METHOD_ARGUMENT__LABEL:
			return getLabel();
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
		case ClassesPackage.METHOD_ARGUMENT__TYPE:
			setType((String) newValue);
			return;
		case ClassesPackage.METHOD_ARGUMENT__DIRECTION:
			setDirection((ArgumentDirectionType) newValue);
			return;
		case ClassesPackage.METHOD_ARGUMENT__DEFAULT_VALUE:
			setDefaultValue((String) newValue);
			return;
		case ClassesPackage.METHOD_ARGUMENT__SIGNATURE:
			setSignature((String) newValue);
			return;
		case ClassesPackage.METHOD_ARGUMENT__LABEL:
			setLabel((String) newValue);
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
		case ClassesPackage.METHOD_ARGUMENT__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case ClassesPackage.METHOD_ARGUMENT__DIRECTION:
			setDirection(DIRECTION_EDEFAULT);
			return;
		case ClassesPackage.METHOD_ARGUMENT__DEFAULT_VALUE:
			setDefaultValue(DEFAULT_VALUE_EDEFAULT);
			return;
		case ClassesPackage.METHOD_ARGUMENT__SIGNATURE:
			setSignature(SIGNATURE_EDEFAULT);
			return;
		case ClassesPackage.METHOD_ARGUMENT__LABEL:
			setLabel(LABEL_EDEFAULT);
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
		case ClassesPackage.METHOD_ARGUMENT__TYPE:
			return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT
					.equals(type);
		case ClassesPackage.METHOD_ARGUMENT__DIRECTION:
			return direction != DIRECTION_EDEFAULT;
		case ClassesPackage.METHOD_ARGUMENT__DEFAULT_VALUE:
			return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null
					: !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
		case ClassesPackage.METHOD_ARGUMENT__SIGNATURE:
			return SIGNATURE_EDEFAULT == null ? getSignature() != null
					: !SIGNATURE_EDEFAULT.equals(getSignature());
		case ClassesPackage.METHOD_ARGUMENT__LABEL:
			return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT
					.equals(label);
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(", direction: ");
		result.append(direction);
		result.append(", defaultValue: ");
		result.append(defaultValue);
		result.append(", label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //MethodArgumentImpl
