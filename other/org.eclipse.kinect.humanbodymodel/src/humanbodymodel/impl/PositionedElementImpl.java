/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package humanbodymodel.impl;

import humanbodymodel.HumanLink;
import humanbodymodel.HumanbodymodelPackage;
import humanbodymodel.PositionedElement;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Positioned Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link humanbodymodel.impl.PositionedElementImpl#getX <em>X</em>}</li>
 *   <li>{@link humanbodymodel.impl.PositionedElementImpl#getY <em>Y</em>}</li>
 *   <li>{@link humanbodymodel.impl.PositionedElementImpl#getZ <em>Z</em>}</li>
 *   <li>{@link humanbodymodel.impl.PositionedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link humanbodymodel.impl.PositionedElementImpl#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link humanbodymodel.impl.PositionedElementImpl#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link humanbodymodel.impl.PositionedElementImpl#getColor_r <em>Color r</em>}</li>
 *   <li>{@link humanbodymodel.impl.PositionedElementImpl#getColor_g <em>Color g</em>}</li>
 *   <li>{@link humanbodymodel.impl.PositionedElementImpl#getColor_b <em>Color b</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PositionedElementImpl extends EObjectImpl implements PositionedElement {
	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final float X_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected float x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final float Y_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected float y = Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getZ() <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZ()
	 * @generated
	 * @ordered
	 */
	protected static final float Z_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getZ() <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZ()
	 * @generated
	 * @ordered
	 */
	protected float z = Z_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The cached value of the '{@link #getIncomingLinks() <em>Incoming Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<HumanLink> incomingLinks;

	/**
	 * The cached value of the '{@link #getOutgoingLinks() <em>Outgoing Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<HumanLink> outgoingLinks;

	/**
	 * The default value of the '{@link #getColor_r() <em>Color r</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor_r()
	 * @generated
	 * @ordered
	 */
	protected static final int COLOR_R_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColor_r() <em>Color r</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor_r()
	 * @generated
	 * @ordered
	 */
	protected int color_r = COLOR_R_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor_g() <em>Color g</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor_g()
	 * @generated
	 * @ordered
	 */
	protected static final int COLOR_G_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColor_g() <em>Color g</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor_g()
	 * @generated
	 * @ordered
	 */
	protected int color_g = COLOR_G_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor_b() <em>Color b</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor_b()
	 * @generated
	 * @ordered
	 */
	protected static final int COLOR_B_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColor_b() <em>Color b</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor_b()
	 * @generated
	 * @ordered
	 */
	protected int color_b = COLOR_B_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PositionedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HumanbodymodelPackage.Literals.POSITIONED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(float newX) {
		float oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HumanbodymodelPackage.POSITIONED_ELEMENT__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(float newY) {
		float oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HumanbodymodelPackage.POSITIONED_ELEMENT__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getZ() {
		return z;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZ(float newZ) {
		float oldZ = z;
		z = newZ;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HumanbodymodelPackage.POSITIONED_ELEMENT__Z, oldZ, z));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HumanbodymodelPackage.POSITIONED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HumanLink> getIncomingLinks() {
		if (incomingLinks == null) {
			incomingLinks = new EObjectResolvingEList<HumanLink>(HumanLink.class, this, HumanbodymodelPackage.POSITIONED_ELEMENT__INCOMING_LINKS);
		}
		return incomingLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HumanLink> getOutgoingLinks() {
		if (outgoingLinks == null) {
			outgoingLinks = new EObjectResolvingEList<HumanLink>(HumanLink.class, this, HumanbodymodelPackage.POSITIONED_ELEMENT__OUTGOING_LINKS);
		}
		return outgoingLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColor_r() {
		return color_r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor_r(int newColor_r) {
		int oldColor_r = color_r;
		color_r = newColor_r;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_R, oldColor_r, color_r));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColor_g() {
		return color_g;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor_g(int newColor_g) {
		int oldColor_g = color_g;
		color_g = newColor_g;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_G, oldColor_g, color_g));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColor_b() {
		return color_b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor_b(int newColor_b) {
		int oldColor_b = color_b;
		color_b = newColor_b;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_B, oldColor_b, color_b));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HumanbodymodelPackage.POSITIONED_ELEMENT__X:
				return getX();
			case HumanbodymodelPackage.POSITIONED_ELEMENT__Y:
				return getY();
			case HumanbodymodelPackage.POSITIONED_ELEMENT__Z:
				return getZ();
			case HumanbodymodelPackage.POSITIONED_ELEMENT__NAME:
				return getName();
			case HumanbodymodelPackage.POSITIONED_ELEMENT__INCOMING_LINKS:
				return getIncomingLinks();
			case HumanbodymodelPackage.POSITIONED_ELEMENT__OUTGOING_LINKS:
				return getOutgoingLinks();
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_R:
				return getColor_r();
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_G:
				return getColor_g();
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_B:
				return getColor_b();
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
			case HumanbodymodelPackage.POSITIONED_ELEMENT__X:
				setX((Float)newValue);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__Y:
				setY((Float)newValue);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__Z:
				setZ((Float)newValue);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__INCOMING_LINKS:
				getIncomingLinks().clear();
				getIncomingLinks().addAll((Collection<? extends HumanLink>)newValue);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__OUTGOING_LINKS:
				getOutgoingLinks().clear();
				getOutgoingLinks().addAll((Collection<? extends HumanLink>)newValue);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_R:
				setColor_r((Integer)newValue);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_G:
				setColor_g((Integer)newValue);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_B:
				setColor_b((Integer)newValue);
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
			case HumanbodymodelPackage.POSITIONED_ELEMENT__X:
				setX(X_EDEFAULT);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__Y:
				setY(Y_EDEFAULT);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__Z:
				setZ(Z_EDEFAULT);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__INCOMING_LINKS:
				getIncomingLinks().clear();
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__OUTGOING_LINKS:
				getOutgoingLinks().clear();
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_R:
				setColor_r(COLOR_R_EDEFAULT);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_G:
				setColor_g(COLOR_G_EDEFAULT);
				return;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_B:
				setColor_b(COLOR_B_EDEFAULT);
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
			case HumanbodymodelPackage.POSITIONED_ELEMENT__X:
				return x != X_EDEFAULT;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__Y:
				return y != Y_EDEFAULT;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__Z:
				return z != Z_EDEFAULT;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HumanbodymodelPackage.POSITIONED_ELEMENT__INCOMING_LINKS:
				return incomingLinks != null && !incomingLinks.isEmpty();
			case HumanbodymodelPackage.POSITIONED_ELEMENT__OUTGOING_LINKS:
				return outgoingLinks != null && !outgoingLinks.isEmpty();
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_R:
				return color_r != COLOR_R_EDEFAULT;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_G:
				return color_g != COLOR_G_EDEFAULT;
			case HumanbodymodelPackage.POSITIONED_ELEMENT__COLOR_B:
				return color_b != COLOR_B_EDEFAULT;
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
		result.append(" (x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", z: ");
		result.append(z);
		result.append(", name: ");
		result.append(name);
		result.append(", color_r: ");
		result.append(color_r);
		result.append(", color_g: ");
		result.append(color_g);
		result.append(", color_b: ");
		result.append(color_b);
		result.append(')');
		return result.toString();
	}

} //PositionedElementImpl
