/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package bowling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tournament</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bowling.Tournament#getTitle <em>Title</em>}</li>
 *   <li>{@link bowling.Tournament#getType <em>Type</em>}</li>
 *   <li>{@link bowling.Tournament#getMatchups <em>Matchups</em>}</li>
 *   <li>{@link bowling.Tournament#getPlayerlist <em>Playerlist</em>}</li>
 * </ul>
 * </p>
 *
 * @see bowling.BowlingPackage#getTournament()
 * @model
 * @generated
 */
public interface Tournament extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see bowling.BowlingPackage#getTournament_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link bowling.Tournament#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link bowling.TournamentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see bowling.TournamentType
	 * @see #setType(TournamentType)
	 * @see bowling.BowlingPackage#getTournament_Type()
	 * @model
	 * @generated
	 */
	TournamentType getType();

	/**
	 * Sets the value of the '{@link bowling.Tournament#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see bowling.TournamentType
	 * @see #getType()
	 * @generated
	 */
	void setType(TournamentType value);

	/**
	 * Returns the value of the '<em><b>Matchups</b></em>' containment reference list.
	 * The list contents are of type {@link bowling.Matchup}.
	 * It is bidirectional and its opposite is '{@link bowling.Matchup#getTournament <em>Tournament</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matchups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matchups</em>' containment reference list.
	 * @see bowling.BowlingPackage#getTournament_Matchups()
	 * @see bowling.Matchup#getTournament
	 * @model opposite="tournament" containment="true"
	 *        annotation="org.unicase.ui.meeditor position='right'"
	 * @generated
	 */
	EList<Matchup> getMatchups();

	/**
	 * Returns the value of the '<em><b>Playerlist</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link bowling.Playerlist#getTournament <em>Tournament</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Playerlist</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Playerlist</em>' reference.
	 * @see #setPlayerlist(Playerlist)
	 * @see bowling.BowlingPackage#getTournament_Playerlist()
	 * @see bowling.Playerlist#getTournament
	 * @model opposite="tournament"
	 *        annotation="org.unicase.ui.meeditor position='right'"
	 * @generated
	 */
	Playerlist getPlayerlist();

	/**
	 * Sets the value of the '{@link bowling.Tournament#getPlayerlist <em>Playerlist</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Playerlist</em>' reference.
	 * @see #getPlayerlist()
	 * @generated
	 */
	void setPlayerlist(Playerlist value);

} // Tournament
