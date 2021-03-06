/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.eclipse.emf.emfstore.bowling.impl;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.emfstore.bowling.BowlingPackage;
import org.eclipse.emf.emfstore.bowling.Game;
import org.eclipse.emf.emfstore.bowling.Player;
import org.eclipse.emf.emfstore.bowling.util.BowlingValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Player</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#getStreet <em>Street</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#getStreetNumber <em>Street Number</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#getDateOfBirth <em>Date Of Birth</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#isIsProfessional <em>Is Professional</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#getEMail <em>EMail</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#getGames <em>Games</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#getTelephon <em>Telephon</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.bowling.impl.PlayerImpl#isIsAvailable <em>Is Available</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlayerImpl extends EObjectImpl implements Player {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected static final String STREET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected String street = STREET_EDEFAULT;

	/**
	 * The default value of the '{@link #getStreetNumber() <em>Street Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreetNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int STREET_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStreetNumber() <em>Street Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreetNumber()
	 * @generated
	 * @ordered
	 */
	protected int streetNumber = STREET_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateOfBirth() <em>Date Of Birth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateOfBirth()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_OF_BIRTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateOfBirth() <em>Date Of Birth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateOfBirth()
	 * @generated
	 * @ordered
	 */
	protected Date dateOfBirth = DATE_OF_BIRTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final double HEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected double height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsProfessional() <em>Is Professional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsProfessional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PROFESSIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsProfessional() <em>Is Professional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsProfessional()
	 * @generated
	 * @ordered
	 */
	protected boolean isProfessional = IS_PROFESSIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getEMail() <em>EMail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEMail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEMail() <em>EMail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEMail()
	 * @generated
	 * @ordered
	 */
	protected String eMail = EMAIL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGames() <em>Games</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGames()
	 * @generated
	 * @ordered
	 */
	protected EList<Game> games;

	/**
	 * The cached value of the '{@link #getTelephon() <em>Telephon</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTelephon()
	 * @generated
	 * @ordered
	 */
	protected EList<Enumerator> telephon;

	/**
	 * The default value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected String notes = NOTES_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsAvailable() <em>Is Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAvailable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_AVAILABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAvailable() <em>Is Available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAvailable()
	 * @generated
	 * @ordered
	 */
	protected boolean isAvailable = IS_AVAILABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BowlingPackage.Literals.PLAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreet(String newStreet) {
		String oldStreet = street;
		street = newStreet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__STREET, oldStreet, street));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStreetNumber() {
		return streetNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreetNumber(int newStreetNumber) {
		int oldStreetNumber = streetNumber;
		streetNumber = newStreetNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__STREET_NUMBER, oldStreetNumber, streetNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateOfBirth(Date newDateOfBirth) {
		Date oldDateOfBirth = dateOfBirth;
		dateOfBirth = newDateOfBirth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__DATE_OF_BIRTH, oldDateOfBirth, dateOfBirth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(double newHeight) {
		double oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsProfessional() {
		return isProfessional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsProfessional(boolean newIsProfessional) {
		boolean oldIsProfessional = isProfessional;
		isProfessional = newIsProfessional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__IS_PROFESSIONAL, oldIsProfessional, isProfessional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEMail() {
		return eMail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEMail(String newEMail) {
		String oldEMail = eMail;
		eMail = newEMail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__EMAIL, oldEMail, eMail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Game> getGames() {
		if (games == null) {
			games = new EObjectWithInverseResolvingEList<Game>(Game.class, this, BowlingPackage.PLAYER__GAMES, BowlingPackage.GAME__PLAYER);
		}
		return games;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Enumerator> getTelephon() {
		if (telephon == null) {
			telephon = new EDataTypeEList<Enumerator>(Enumerator.class, this, BowlingPackage.PLAYER__TELEPHON);
		}
		return telephon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotes(String newNotes) {
		String oldNotes = notes;
		notes = newNotes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__NOTES, oldNotes, notes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAvailable() {
		return isAvailable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAvailable(boolean newIsAvailable) {
		boolean oldIsAvailable = isAvailable;
		isAvailable = newIsAvailable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BowlingPackage.PLAYER__IS_AVAILABLE, oldIsAvailable, isAvailable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasName(DiagnosticChain diagnosticianChain, Map<?, ?> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (name == null || name == "") {
			if (diagnosticianChain != null) {
				diagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "name",
						 BowlingValidator.PLAYER__HAS_NAME,
						 "Name must filled out",
						 new Object [] { this,  BowlingPackage.eINSTANCE.getPlayer_Name()}));
			}
			return false;
		}	
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasStreet(DiagnosticChain diagnosticianChain, Map<?, ?> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (street == null || street == "") {
			if (diagnosticianChain != null) {
				diagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						"street",
						 BowlingValidator.PLAYER__HAS_STREET,
						 "Street must filled out",
						 new Object [] { this, BowlingPackage.eINSTANCE.getPlayer_Street() }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasDateOfBirth(DiagnosticChain diagnosticianChain, Map<?, ?> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		Calendar rightNow = Calendar.getInstance();
		if (dateOfBirth == null || (dateOfBirth.after(rightNow.getTime()))) {
			if (diagnosticianChain != null) {
				diagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "dateOfBirth",
						 BowlingValidator.PLAYER__HAS_DATE_OF_BIRTH,
						 "Date of Birth must be smaller than today's date",
						 new Object [] { this, BowlingPackage.eINSTANCE.getPlayer_DateOfBirth() }));
			}
			return false;
		}
				
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasCorrectStreetNumber(DiagnosticChain diagnosticianChain, Map<?, ?> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (streetNumber <= 0) {
			if (diagnosticianChain != null) {
				diagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "streetNumber",
						 BowlingValidator.PLAYER__HAS_CORRECT_STREET_NUMBER,
						 "Invalid Street Number",
						 new Object [] { this, BowlingPackage.eINSTANCE.getPlayer_StreetNumber() }));
			}
			return false;
		}
		
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasTelephon(DiagnosticChain diagnosticianChain, Map<?, ?> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (telephon == null) {
			if (diagnosticianChain != null) {
				diagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						"telephon",
						 BowlingValidator.PLAYER__HAS_TELEPHON,
						 "Telephon number must filled out",
						 new Object [] { this, BowlingPackage.eINSTANCE.getPlayer_Telephon() }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasHeight(DiagnosticChain diagnosticianChain, Map<?, ?> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (height <= 0.0) {
			if (diagnosticianChain != null) {
				diagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "height",
						 BowlingValidator.PLAYER__HAS_HEIGHT,
						 "Height must filled out",
						 new Object [] { this, BowlingPackage.eINSTANCE.getPlayer_Height() }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasIsAvailable(DiagnosticChain diagnosticianChain, Map<?, ?> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (isAvailable == false) {
			if (diagnosticianChain != null) {
				diagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "isAvailable",
						 BowlingValidator.PLAYER__HAS_IS_AVAILABLE,
						 "Must be set",
						 new Object [] { this, BowlingPackage.eINSTANCE.getPlayer_IsAvailable() }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasNotes(DiagnosticChain diagnosticianChain, Map<?, ?> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (notes == null || notes == "") {
			if (diagnosticianChain != null) {
				diagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "notes",
						 BowlingValidator.PLAYER__HAS_NOTES,
						 "Notes must filled out",
						 new Object [] { this, BowlingPackage.eINSTANCE.getPlayer_Notes() }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasGame(DiagnosticChain diagnosticianChain, Map<?, ?> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (games.isEmpty()) {
			if (diagnosticianChain != null) {
				diagnosticianChain.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "games",
						 BowlingValidator.PLAYER__HAS_GAME,
						 "Games must referenced",
						 new Object [] { this, BowlingPackage.eINSTANCE.getPlayer_Games() }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BowlingPackage.PLAYER__GAMES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGames()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BowlingPackage.PLAYER__GAMES:
				return ((InternalEList<?>)getGames()).basicRemove(otherEnd, msgs);
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
			case BowlingPackage.PLAYER__NAME:
				return getName();
			case BowlingPackage.PLAYER__STREET:
				return getStreet();
			case BowlingPackage.PLAYER__STREET_NUMBER:
				return getStreetNumber();
			case BowlingPackage.PLAYER__DATE_OF_BIRTH:
				return getDateOfBirth();
			case BowlingPackage.PLAYER__HEIGHT:
				return getHeight();
			case BowlingPackage.PLAYER__IS_PROFESSIONAL:
				return isIsProfessional();
			case BowlingPackage.PLAYER__EMAIL:
				return getEMail();
			case BowlingPackage.PLAYER__GAMES:
				return getGames();
			case BowlingPackage.PLAYER__TELEPHON:
				return getTelephon();
			case BowlingPackage.PLAYER__NOTES:
				return getNotes();
			case BowlingPackage.PLAYER__IS_AVAILABLE:
				return isIsAvailable();
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
			case BowlingPackage.PLAYER__NAME:
				setName((String)newValue);
				return;
			case BowlingPackage.PLAYER__STREET:
				setStreet((String)newValue);
				return;
			case BowlingPackage.PLAYER__STREET_NUMBER:
				setStreetNumber((Integer)newValue);
				return;
			case BowlingPackage.PLAYER__DATE_OF_BIRTH:
				setDateOfBirth((Date)newValue);
				return;
			case BowlingPackage.PLAYER__HEIGHT:
				setHeight((Double)newValue);
				return;
			case BowlingPackage.PLAYER__IS_PROFESSIONAL:
				setIsProfessional((Boolean)newValue);
				return;
			case BowlingPackage.PLAYER__EMAIL:
				setEMail((String)newValue);
				return;
			case BowlingPackage.PLAYER__GAMES:
				getGames().clear();
				getGames().addAll((Collection<? extends Game>)newValue);
				return;
			case BowlingPackage.PLAYER__TELEPHON:
				getTelephon().clear();
				getTelephon().addAll((Collection<? extends Enumerator>)newValue);
				return;
			case BowlingPackage.PLAYER__NOTES:
				setNotes((String)newValue);
				return;
			case BowlingPackage.PLAYER__IS_AVAILABLE:
				setIsAvailable((Boolean)newValue);
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
			case BowlingPackage.PLAYER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__STREET_NUMBER:
				setStreetNumber(STREET_NUMBER_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__DATE_OF_BIRTH:
				setDateOfBirth(DATE_OF_BIRTH_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__IS_PROFESSIONAL:
				setIsProfessional(IS_PROFESSIONAL_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__EMAIL:
				setEMail(EMAIL_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__GAMES:
				getGames().clear();
				return;
			case BowlingPackage.PLAYER__TELEPHON:
				getTelephon().clear();
				return;
			case BowlingPackage.PLAYER__NOTES:
				setNotes(NOTES_EDEFAULT);
				return;
			case BowlingPackage.PLAYER__IS_AVAILABLE:
				setIsAvailable(IS_AVAILABLE_EDEFAULT);
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
			case BowlingPackage.PLAYER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BowlingPackage.PLAYER__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case BowlingPackage.PLAYER__STREET_NUMBER:
				return streetNumber != STREET_NUMBER_EDEFAULT;
			case BowlingPackage.PLAYER__DATE_OF_BIRTH:
				return DATE_OF_BIRTH_EDEFAULT == null ? dateOfBirth != null : !DATE_OF_BIRTH_EDEFAULT.equals(dateOfBirth);
			case BowlingPackage.PLAYER__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case BowlingPackage.PLAYER__IS_PROFESSIONAL:
				return isProfessional != IS_PROFESSIONAL_EDEFAULT;
			case BowlingPackage.PLAYER__EMAIL:
				return EMAIL_EDEFAULT == null ? eMail != null : !EMAIL_EDEFAULT.equals(eMail);
			case BowlingPackage.PLAYER__GAMES:
				return games != null && !games.isEmpty();
			case BowlingPackage.PLAYER__TELEPHON:
				return telephon != null && !telephon.isEmpty();
			case BowlingPackage.PLAYER__NOTES:
				return NOTES_EDEFAULT == null ? notes != null : !NOTES_EDEFAULT.equals(notes);
			case BowlingPackage.PLAYER__IS_AVAILABLE:
				return isAvailable != IS_AVAILABLE_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", street: ");
		result.append(street);
		result.append(", streetNumber: ");
		result.append(streetNumber);
		result.append(", dateOfBirth: ");
		result.append(dateOfBirth);
		result.append(", height: ");
		result.append(height);
		result.append(", isProfessional: ");
		result.append(isProfessional);
		result.append(", eMail: ");
		result.append(eMail);
		result.append(", telephon: ");
		result.append(telephon);
		result.append(", notes: ");
		result.append(notes);
		result.append(", isAvailable: ");
		result.append(isAvailable);
		result.append(')');
		return result.toString();
	}

} // PlayerImpl
