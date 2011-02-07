/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.modelgenerator.common;

import java.util.LinkedList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.modelgenerator.common.attribute.AttributeHandler;
import org.unicase.modelgenerator.common.attribute.IAttributeSetter;

/**
 * Utility class to generate and change Ecore models.
 * All methods should be accessed in a static way,
 * therefore the constructor is not visible.
 */
public final class ModelGeneratorUtil {

	/**
	 * Set of all EClasses that are contained in EPackages that are
	 * currently registered in the EPackage registry.
	 * 
	 * @see #getAllEClasses()
	 */
	private static Set<EClass> allEClasses;
	
	/**
	 * Set of all EPackages that are currently registered in the 
	 * EPackage registry and not contained in any other package.
	 * 
	 * @see #getAllRootEPackages()
	 */
	private static Set<EPackage> rootModelPackages;
	
	/**
	 * Map that maps EPackages to a set of all their contained EClasses.
	 * 
	 * @see #getAllEClasses(EPackage)
	 */
	private static Map<EPackage, List<EClass>> packageToModelElementEClasses = new LinkedHashMap<EPackage, List<EClass>>();
	
	/**
	 * Map that maps EClasses to all possible EClasses that can be contained by them.
	 * 
	 * @see #getAllEContainments(EClass)
	 */
	private static Map<EClass, List<EClass>> allEContainments = new LinkedHashMap<EClass, List<EClass>>();

	/**
	 * Map that maps EClasses to their subclasses.
	 * 
	 * @see #getAllSubEClasses(EClass)
	 */
	private static Map<EClass, Set<EClass>> eClassToSubEClasses = new LinkedHashMap<EClass, Set<EClass>>();
	
	/**
	 * Private constructor.
	 */
	private ModelGeneratorUtil() {
		// all methods should be accessed in a static way
	}
	
	/**
	 * Returns the EPackage to the specified <code>nsURI</code>.
	 * 
	 * @param nsURI the NsUri of the EPackage to get
	 * @return the EPackage belonging to <code>nsURI</code>
	 * @see Registry#getEPackage(String)
	 */
	public static EPackage getEPackage(String nsURI) { 
		return EPackage.Registry.INSTANCE.getEPackage(nsURI);
	}
	
	/**
	 * Returns all EPackages on the root level that are currently
	 * registered in the registry.
	 * 
	 * @return a Set of all root EPackages
	 * @see Registry
	 */
	public static Set<EPackage> getAllRootEPackages() {
		if(rootModelPackages != null) {
			return rootModelPackages;
		}
		rootModelPackages = new LinkedHashSet<EPackage>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : registry.entrySet()) {
			EPackage model = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
			if (model.getESuperPackage() == null){
				rootModelPackages.add(model);
			}
		}
		return rootModelPackages;
	}
	
	/**
	 * Retrieve all EClasses that are contained in <code>ePackage</code>. 
	 * 
	 * @param ePackage the package to get contained EClasses from
	 * @return a set of EClasses contained in <code>ePackage</code>
	 */
	public static List<EClass> getAllEClasses(EPackage ePackage) {
		if(packageToModelElementEClasses.containsKey(ePackage)) {
			return packageToModelElementEClasses.get(ePackage);
		}
		if(ePackage == null) {
			packageToModelElementEClasses.put(ePackage, new LinkedList<EClass>());
			return packageToModelElementEClasses.get(ePackage);	
		}
		List<EClass> result = new LinkedList<EClass>();
		for(EPackage subPackage : ePackage.getESubpackages()) {
			result.addAll(getAllEClasses(subPackage));
		}
		for(EClassifier classifier : ePackage.getEClassifiers()) {
			if(classifier instanceof EClass) {
				result.add((EClass) classifier);
			}
		}
		packageToModelElementEClasses.put(ePackage, result);
		return result;
	}
	
	/**
	 * Iterates over all registered EPackages in order to retrieve all available 
	 * EClasses, excluding abstract classes and interfaces, and returns them as a Set. 
	 * 
	 * @return a set of all EClasses that are contained in registered EPackages
	 * @see Registry
	 */
	public static Set<EClass> getAllEClasses() {
		if (allEClasses != null) {
			return allEClasses;
		}
		Set<EClass> result = new LinkedHashSet<EClass>();
		Registry registry = EPackage.Registry.INSTANCE;

		for (Entry<String, Object> entry : new LinkedHashSet<Entry<String, Object>>(registry.entrySet())) {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(entry.getKey());
			for(EClass eClass : getAllEClasses(ePackage)) {
				if(canHaveInstance(eClass)) {
					result.add(eClass);
				}
			}
		}
		allEClasses = result;
		return result;
	}
	
	/**
	 * Returns all possible EClasses, excluding abstract classes and interfaces,
	 * that can be contained in <code>eClass</code>.
	 * 
	 * @param eClass the EClass to get containable EClasses for
	 * @return a set of all EClasses that can be contained in <code>eClass</code>
	 */
	public static List<EClass> getAllEContainments(EClass eClass) {
		if(allEContainments.containsKey(eClass)) {
			return allEContainments.get(eClass);
		}
		if(eClass == null) {
			allEContainments.put(eClass, new LinkedList<EClass>());
			return allEContainments.get(eClass);
		}
		List<EClass> result = new LinkedList<EClass>();
		for(EReference reference : eClass.getEAllContainments()) {
			EClass referenceType = reference.getEReferenceType();
			if(canHaveInstance(referenceType)) {
				result.add(referenceType);
			}
			result.addAll(getAllSubEClasses(referenceType));
		}
		allEContainments.put(eClass, result);
		return result;
	}
	
	private static boolean canHaveInstance(EClass eClass) {
		return !eClass.isInterface() && !eClass.isAbstract();
	}

	/**
	 * Returns all subclasses of an EClass, excluding abstract classes
	 * and interfaces.
	 * 
	 * @param eClass the EClass to get subclasses for
	 * @return all subclasses of <code>eClass</code>
	 */
	public static Set<EClass> getAllSubEClasses(EClass eClass) {
		if(eClassToSubEClasses.containsKey(eClass)) {
			return eClassToSubEClasses.get(eClass);
		}
		if(eClass == null) {
			eClassToSubEClasses.put(eClass, new LinkedHashSet<EClass>());
			return eClassToSubEClasses.get(eClass);
		}
		Set<EClass> allEClasses = getAllEClasses();
		if(EcorePackage.eINSTANCE.getEObject().equals(eClass)) {
			return allEClasses;
		}
		Set<EClass> result = new LinkedHashSet<EClass>();
		for (EClass subClass : allEClasses) {
			if (eClass.isSuperTypeOf(subClass) && canHaveInstance(subClass)) {
				result.add(subClass);
			}
		}
		eClassToSubEClasses.put(eClass, result);
		return result;
	}
	
	/**
	 * Returns all containing references where <code>parentClass</code> is 
	 * the container and <code>childClass</code> the containment.
	 * 
	 * @param childClass the EClass which shall be contained
	 * @param parentClass the EClass to get containment references from
	 * @return all possible container-references as a set
	 */
	public static Set<EReference> getAllPossibleContainingReferences(EClass childClass, EClass parentClass) {
		List<EReference> allReferences = parentClass.getEAllContainments();
		Set<EReference> result = new LinkedHashSet<EReference>();
		for(EReference reference : allReferences) {
			EClass referenceType = reference.getEReferenceType();
			if(referenceType == null) {
				continue;
			}
			if(referenceType.equals(childClass)) {
				result.add(reference);
			} else if (referenceType.equals(EcorePackage.eINSTANCE.getEObject())
				|| referenceType.isSuperTypeOf(childClass)) {
				result.add(reference);
			}
		}
		return result;
	}
	
	/**
	 * Returns all direct and indirect contents of <code>rootObject</code> as a map.
	 * All EObjects that appear in these contents are mapped to their corresponding
	 * EClass.
	 *  
	 * @param rootObject the EObject to get contents for
	 * @return all contents as a map from EClass to lists of EObjects
	 */
	public static Map<EClass, List<EObject>> getAllClassesAndObjects(EObject rootObject) {
		Map<EClass, List<EObject>> result = new LinkedHashMap<EClass, List<EObject>>();
		TreeIterator<EObject> allContents = rootObject.eAllContents();
		List<EObject> newList = new LinkedList<EObject>();
		newList.add(rootObject);
		result.put(rootObject.eClass(), newList);
		while(allContents.hasNext()) {
			EObject eObject = allContents.next();
			if(result.containsKey(eObject.eClass())) {
				result.get(eObject.eClass()).add(eObject);
			}
			else {
				newList = new LinkedList<EObject>();
				newList.add(eObject);
				result.put(eObject.eClass(), newList);
			}
		}
		return result;
	}
	
	/**
	 * Returns all valid references for an EObject. This excludes container/containment references.
	 * A reference is valid if it is neither derived nor volatile and if it is changeable and
	 * either many-valued or not already set.
	 * 
	 * @param eObject the EObject to get references for
	 * @return all valid references as a list
	 */
	public static List<EReference> getValidReferences(EObject eObject) {
		List<EReference> result = new LinkedList<EReference>();
		for(EReference reference : eObject.eClass().getEAllReferences()) {
			if(!reference.isContainer() && !reference.isContainment() && isValid(reference, eObject)) {
				result.add(reference);
			}
		}
		return result;
	}
	
	/**
	 * Returns all valid containment references for a parent EObject and a child EClass.
	 * A reference is valid if it is changeable and either many-valued or not already set.
	 * 
	 * @param childClass the EClass that shall be contained
	 * @param parentEObject the EObject that shall be the container
	 * @return all containment references between <code>parentEObject</code> and 
	 * <code>childClass</code> that are valid 
	 */
	public static List<EReference> getValidContainmentReferences(EClass childClass, EObject parentEObject) {
		List<EReference> result = new LinkedList<EReference>();
		for(EReference reference : ModelGeneratorUtil.getAllPossibleContainingReferences(childClass, parentEObject.eClass())) {
			if(isValid(reference, parentEObject)) {
				result.add(reference);
			}
		}
		return result;
	}

	/**
	 * Returns whether an EReference is valid for an EObject or not.
	 * A reference is valid, if it can be set or added to.
	 * 
	 * @param reference the EReference in question
	 * @param eObject the EObject to check the reference for
	 * @return asuohd
	 */
	private static boolean isValid(EReference reference, EObject eObject) {
		return reference.isChangeable() && !reference.isVolatile()&& !reference.isDerived()
			&& (reference.isMany() || !eObject.eIsSet(reference));
	}
	
	/**
	 * Handles <code>exception</code>, meaning it is thrown if <code>ignoreAndLog</code>
	 * is <code>false</code>. Otherwise <code>exception</code> is ignored and added to
	 * <code>exceptionLog</code>.
	 * 
	 * @param exception the exception to handle
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 */
	private static void handle(RuntimeException exception, Set<RuntimeException> exceptionLog,
		boolean ignoreAndLog) {
		if(ignoreAndLog) {
			exceptionLog.add(exception);
		} else {
			throw exception;
		}
	}
	
	/**
	 * Sets a feature between <code>parentEObject</code> and <code>newObject</code>
	 * using a SetCommand. Exceptions are caught if <code>ignoreAndLog</code> is
	 * true, otherwise a RuntimeException might be thrown if the command fails.  
	 * 
	 * @param parentEObject the EObject for which <code>feature</code> shall be set
	 * @param feature the EStructuralFeature that shall be set
	 * @param newObject the Object that shall be set as a feature in <code>parentEObject</code>
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>??
	 * @return <code>newObject</code> if the <code>SetCommand</code> was performed successful
	 * or <code>null</code> if it failed
	 * @see SetCommand
	 */
	public static EObject setPerCommand(EObject parentEObject, EStructuralFeature feature, Object newObject,
		Set<RuntimeException> exceptionLog, boolean ignoreAndLog) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentEObject);
		try {
			new SetCommand(domain, parentEObject, feature, newObject).doExecute();
			if(newObject instanceof EObject) {
				return (EObject) newObject;
			} else {
				return null;
			}
		} catch(RuntimeException e){
			handle(e, exceptionLog, ignoreAndLog);
			return null;
		}
	}

	/**
	 * Adds <code>newObject</code> to the many-valued feature of 
	 * <code>parentEObject</code> using an AddCommand. 
	 * Exceptions are caught if <code>ignoreAndLog</code> is
	 * true, otherwise a RuntimeException might be thrown if the command fails.  
	 * 
	 * @param parentEObject the EObject to which <code>newObject</code> shall be added
	 * @param feature the EStructuralFeature that <code>newObject</code> shall be added to
	 * @param newObject the Object that shall be added to <code>feature</code>
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 * @return <code>newObject</code> if the <code>AddCommand</code> was performed successful
	 * or <code>null</code> if it failed
	 * @see AddCommand#AddCommand(EditingDomain, EObject, EStructuralFeature, Object)
	 */
	public static EObject addPerCommand(EObject parentEObject, EStructuralFeature feature, Object newObject,
		Set<RuntimeException> exceptionLog, boolean ignoreAndLog) {
		if(feature.isUnique() && ((Collection<?>) parentEObject.eGet(feature)).contains(newObject)) {
			return null;
		}
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentEObject);
		try {
			new AddCommand(domain, parentEObject, feature, newObject).doExecute();
			if(newObject instanceof EObject) {
				return (EObject) newObject;
			} else {
				return null;
			}
		} catch(RuntimeException e){
			handle(e, exceptionLog, ignoreAndLog);
			return null;
		}
	}
	
	/**
	 * Adds all <code>objects</code> to the many-valued feature of 
	 * <code>parentEObject</code> using an AddCommand. 
	 * Exceptions are caught if <code>ignoreAndLog</code> is
	 * true, otherwise a RuntimeException might be thrown if the command fails.  
	 * 
	 * @param parentEObject the EObject to which <code>objects</code> shall be added
	 * @param feature the EReference that <code>newEObject</code> shall be added to
	 * @param objects collection of objects that shall be added to <code>feature</code>
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 */
	public static void addPerCommand(EObject parentEObject, EStructuralFeature feature, Collection<?> objects,
		Set<RuntimeException> exceptionLog, boolean ignoreAndLog) {
		for(Object object : objects) {
			if(feature.isUnique() && ((Collection<?>) parentEObject.eGet(feature)).contains(object)) {
				return;
			}
		}
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentEObject);
		try {
			new AddCommand(domain, parentEObject, feature, objects).doExecute();
		} catch(RuntimeException e) {
			handle(e, exceptionLog, ignoreAndLog);
		}
	}
	
	/**
	 * Removes <code>objects</code> from a feature of <code>parentEObject</code>
	 * using a RemoveCommand. Exceptions are caught if <code>ignoreAndLog</code> is
	 * true, otherwise a RuntimeException might be thrown if the command fails.  
	 * 
	 * @param parentEObject the EObject to remove <code>objects</code> from
	 * @param feature the EStructuralFeature <code>object</code> shall be removed from
	 * @param objects collection of Objects that shall be removed
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 * @see RemoveCommand
	 */
	public static void removePerCommand(EObject parentEObject, EStructuralFeature feature, Collection<?> objects,
		Set<RuntimeException> exceptionLog, boolean ignoreAndLog) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentEObject);
		try {
			new RemoveCommand(domain, parentEObject, feature, objects).doExecute();
		} catch(RuntimeException e){
			handle(e, exceptionLog, ignoreAndLog);
		}
	}
	
	/**
	 * Retrieves all EClasses that can possibly be referenced by <code>reference</code>
	 * from <code>allEClasses</code> and returns them as a list.
	 * 
	 * @param reference the EReference to get EClasses for
	 * @param allEClasses set of all possible EClasses
	 * @return list of all EClasses that can be referenced by <code>reference</code>
	 */
	public static List<EClass> getReferenceClasses(EReference reference, Set<EClass> allEClasses) {
		List<EClass> result = new LinkedList<EClass>();
		EClass referenceType = reference.getEReferenceType();
		result.add(referenceType);
		if(referenceType.equals(EcorePackage.eINSTANCE.getEObject())) {
			result.addAll(allEClasses);
			return result;
		}
		for(EClass eClass : allEClasses) {
			if(referenceType.isSuperTypeOf(eClass)) {
				result.add(eClass);
			}
		}
		return result;
	}
	
	/**
	 * Sets or adds to a reference for an EObject with any generated instance
	 * of <code>referenceClass</code> using SetCommand/AddCommand. If the reference is 
	 * not required, <code>random</code> decides whether the reference is set or how 
	 * many EObjects are added to it.
	 *  
	 * @param eObject the EObject to set the reference for
	 * @param referenceClass the EClass all referenced EObject shall be instances of
	 * @param reference the reference to set
	 * @param random the Random-object that randomizes EObjects and their amount
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 * @param allEObjects all existing EObjects mapped to their EClass
	 * 
	 * @see #addPerCommand(EObject, EStructuralFeature, Collection, Set, boolean)
	 * @see #addPerCommand(EObject, EStructuralFeature, Object, Set, boolean)
	 * @see #setPerCommand(EObject, EStructuralFeature, Object, Set, boolean)
	 */
	public static void setReference(EObject eObject, EClass referenceClass, EReference reference,
		Random random, Set<RuntimeException> exceptionLog, boolean ignoreAndLog, Map<EClass, List<EObject>> allEObjects) {
		List<EObject> possibleReferenceObjects = allEObjects.get(referenceClass); 
		Collections.shuffle(possibleReferenceObjects, random);
		if(!possibleReferenceObjects.isEmpty()) {
			int index = 0;
			if(reference.isMany()) {
				int maxObjects = random.nextInt(3);
				if(reference.isRequired()) {
					maxObjects++;
				}
				for(int i = 0; i < maxObjects; i++) {
					ModelGeneratorUtil.addPerCommand(eObject, reference, possibleReferenceObjects.get(index),
						exceptionLog, ignoreAndLog);
					if(++index==possibleReferenceObjects.size()) {
						break;
					}
				}
			} else if (reference.isRequired() || random.nextBoolean()){
				ModelGeneratorUtil.setPerCommand(eObject, reference, possibleReferenceObjects.get(index),
					exceptionLog, ignoreAndLog);
			}
		}
	}

	/**
	 * Sets all possible attributes of known types to random values using {@link IAttributeSetter}
	 * and SetCommands/AddCommands.
	 * 
	 * @param eObject the EObject to set attributes for
	 * @param exceptionLog the current log of exceptions
	 * @param ignoreAndLog should exceptions be ignored and added to <code>exceptionLog</code>?
	 * @see IAttributeSetter
	 * @see AttributeHandler
	 * @see #addPerCommand(EObject, EStructuralFeature, Collection, Set, boolean)
	 * @see #addPerCommand(EObject, EStructuralFeature, Object, Set, boolean)
	 * @see #setPerCommand(EObject, EStructuralFeature, Object, Set, boolean)
	 */
	public static void setEObjectAttributes(EObject eObject, Set<RuntimeException> exceptionLog, boolean ignoreAndLog) {
		Map<EClassifier, IAttributeSetter<?>> attributeSetters = AttributeHandler.getAttributeSetters();
		
		for(EAttribute attribute : eObject.eClass().getEAllAttributes()) {
			EClassifier attributeType = attribute.getEType();
			
			if(!attribute.isChangeable() || attribute.isDerived() || attribute.isVolatile()) {
				continue;
			}
			if (attributeSetters.containsKey(attributeType)) {
				if (attribute.isMany()) {
					addPerCommand(eObject, attribute,
						attributeSetters.get(attributeType).createNewAttributes(), exceptionLog, ignoreAndLog);
				}
				else {
					setPerCommand(eObject, attribute,
						attributeSetters.get(attributeType).createNewAttribute(), exceptionLog, ignoreAndLog);
				}
			}				
		}
	}
}
