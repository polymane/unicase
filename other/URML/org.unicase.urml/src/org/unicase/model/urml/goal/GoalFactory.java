/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.goal;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.model.urml.goal.GoalPackage
 * @generated
 */
public interface GoalFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	GoalFactory eINSTANCE = org.unicase.model.urml.goal.impl.GoalFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Goal</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Goal</em>'.
	 * @generated
	 */
	Goal createGoal();

	/**
	 * Returns a new object of class '<em>Reference</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Reference</em>'.
	 * @generated
	 */
	GoalReference createGoalReference();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	GoalPackage getGoalPackage();

} // GoalFactory
