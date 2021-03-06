/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.startup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;

/**
 * Validates the serverspace in three different ways. First it resolves all proxies, then checks whether all ME have ids
 * and it is checked whether the changes generate the corret projectstate.
 * 
 * @author wesendon
 */
public class EmfStoreValidator {

	private final ServerSpace serverSpace;

	private List<String> excludedProjects;

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace serverspace
	 */
	public EmfStoreValidator(ServerSpace serverSpace) {
		this.serverSpace = serverSpace;
		excludedProjects = new ArrayList<String>();
	}

	/**
	 * Option for resolving all proxies. The validation therefore uses
	 * {@link EcoreUtil#resolveAll(org.eclipse.emf.ecore.EObject)}
	 */
	public static final int RESOLVEALL = 1;

	/**
	 * Option for checking all modelelement ids in projecstate and changes. Every modelelement and changeoperation has
	 * to have a modelelement id.
	 */
	public static final int MODELELEMENTID = 2;

	/**
	 * Option for the change test. The initial projecstate is loaded and all changes are applied, until the next
	 * projecstate is reached. Then the calculated state and the saved state are comparesd.
	 */
	public static final int PROJECTGENERATION = 4;

	private long timeMillis;

	/**
	 * Runs the validation. You can configure the validation by a bitmask, therefore use the value: {@link #RESOLVEALL},
	 * {@link #MODELELEMENTID} and {@link #PROJECTGENERATION}.
	 * 
	 * @param options options
	 * @param throwException allows you to prevent that an exception is thrown if validation failes
	 * @throws FatalEmfStoreException in case of failure
	 */
	public void validate(int options, boolean throwException) throws FatalEmfStoreException {
		boolean errors = true;
		if ((options & RESOLVEALL) == RESOLVEALL) {
			errors = validateResolveAll() && errors;
		}
		if ((options & MODELELEMENTID) == MODELELEMENTID) {
			errors = validateModelelementId() && errors;
		}
		if ((options & PROJECTGENERATION) == PROJECTGENERATION) {
			errors = validateProjectGeneration() && errors;
		}

		if (!errors && throwException) {
			throw new FatalEmfStoreException("Validation failed.");
		}
	}

	/**
	 * Runs the validation. You can configure the validation by a bitmask, therefore use the value: {@link #RESOLVEALL},
	 * {@link #MODELELEMENTID} and {@link #PROJECTGENERATION}.
	 * 
	 * @param options options
	 * @throws FatalEmfStoreException in case of failure
	 */
	public void validate(int options) throws FatalEmfStoreException {
		validate(options, true);
	}

	/**
	 * {@link #RESOLVEALL}.
	 */
	private boolean validateResolveAll() {
		start("Resolving all elements...");
		EcoreUtil.resolveAll(serverSpace.eResource().getResourceSet());
		EList<Diagnostic> errors = new BasicEList<Diagnostic>();
		EList<Resource> resources = serverSpace.eResource().getResourceSet().getResources();
		for (Resource currentResource : resources) {
			errors.addAll(currentResource.getErrors());
		}
		errors(errors);
		stop();
		return errors.size() == 0;
	}

	/**
	 * {@link #MODELELEMENTID}.
	 */
	private boolean validateModelelementId() {
		start("Checking ModelElementIds...");
		List<String> errors = new ArrayList<String>();
		for (ProjectHistory projectHistory : serverSpace.getProjects()) {
			if (isExcluded(projectHistory)) {
				continue;
			}
			System.out.println("Checking project: " + projectHistory.getProjectId().getId());
			for (Version version : projectHistory.getVersions()) {
				if (version.getChanges() != null) {
					for (AbstractOperation ao : version.getChanges().getOperations()) {
						if (!(ao instanceof CompositeOperation)
							&& (ao.getModelElementId() == null || ao.getModelElementId().getId() == null)) {
							errors.add("ChangeOperation has no ModelElementId in project: "
								+ projectHistory.getProjectId() + " version: "
								+ version.getPrimarySpec().getIdentifier());
						}
					}
				}
				if (version.getProjectState() != null) {
					for (ModelElement me : version.getProjectState().getAllModelElements()) {
						if (me.getModelElementId() == null || me.getModelElementId().getId() == null) {
							errors.add("ModelElement has no ModelElementId in project: "
								+ projectHistory.getProjectId() + " version: "
								+ version.getPrimarySpec().getIdentifier());
						}
					}
				}
			}
		}
		errors(errors);
		stop();
		return errors.size() == 0;
	}

	/**
	 * {@value #PROJECTGENERATION}.
	 */
	private boolean validateProjectGeneration() {
		start("Project generation compare ...");
		List<String> errors = new ArrayList<String>();
		for (ProjectHistory history : serverSpace.getProjects()) {
			if (isExcluded(history)) {
				continue;
			}
			System.out.println("Checking project: " + history.getProjectId().getId());
			history = (ProjectHistory) EcoreUtil.copy(history);
			Project state = null;

			for (Version version : history.getVersions()) {
				if (version.getProjectState() != null && state == null) {
					state = (Project) EcoreUtil.copy(version.getProjectState());
				} else {

					version.getChanges().apply(state, true);

					if (version.getProjectState() != null) {
						int[] compare = linearCompare(version.getProjectState(), state);
						if (compare[0] == 0) {
							errors.add("project compare of project " + history.getProjectId().getId()
								+ " not equal in version " + version.getPrimarySpec().getIdentifier());
							// debug(history, state, version);
						}
						state = (Project) EcoreUtil.copy(version.getProjectState());
					}
				}
			}
		}
		errors(errors);
		stop();
		return errors.size() == 0;
	}

	// private void debug(ProjectHistory history, Project state, Version version) {
	// try {
	//
	// String pre = history.getProjectId().getId() + "_" + version.getPrimarySpec().getIdentifier() + "_";
	//
	// File file = new File(System.getProperty("user.home") + "/Desktop/compares/" + pre + "generated.txt");
	// if (!file.exists())
	// file.createNewFile();
	// FileWriter fileWriter = new FileWriter(file, false);
	// fileWriter.write(SerializationUtil.eObjectToString(version.getProjectState()));
	// fileWriter.close();
	//
	// File file2 = new File(System.getProperty("user.home") + "/Desktop/compares/" + pre + "state.txt");
	// if (!file2.exists())
	// file2.createNewFile();
	//
	// FileWriter fileWriter2 = new FileWriter(file2, false);
	// fileWriter2.write(SerializationUtil.eObjectToString(state));
	// fileWriter2.close();
	//
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (EmfStoreException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	/**
	 * Allows to exclude projects from validation aside from {@link #RESOLVEALL}.
	 * 
	 * @param excludedProjects list of project id as string
	 */
	public void setExcludedProjects(List<String> excludedProjects) {
		if (excludedProjects != null) {
			this.excludedProjects = excludedProjects;
		}
	}

	private boolean isExcluded(ProjectHistory projectHistory) {
		return excludedProjects.contains(projectHistory.getProjectId().getId());
	}

	private void start(String str) {
		timeMillis = System.currentTimeMillis();
		System.out.println("Validation: " + str);
	}

	private void stop() {
		System.out.println("Validation took: " + (System.currentTimeMillis() - timeMillis) + " ms\n");
	}

	private void errors(Collection<? extends Object> errorList) {
		System.out.println("Errors: " + errorList.size());
		for (Object obj : errorList) {
			System.out.println(obj);
		}
	}

	private static int[] linearCompare(Project projectA, Project projectB) {
		int[] result = new int[5];
		final int areEqual = 0;
		final int differencePosition = 1;
		final int character = 2;
		final int lineNum = 3;
		final int colNum = 4;
		result[areEqual] = 1;
		String stringA = "";
		String stringB = "";

		try {
			stringA = SerializationUtil.eObjectToString(projectA);
			stringB = SerializationUtil.eObjectToString(projectB);
		} catch (RMISerializationException e) {
			e.printStackTrace();
		}

		int length = Math.min(stringA.length(), stringB.length());
		for (int index = 0; index < length; index++) {
			if (stringA.charAt(index) != stringB.charAt(index)) {
				result[areEqual] = 0;
				result[differencePosition] = index;
				result[character] = stringA.charAt(index);
				int lineNumber = getLineNum(stringA, index);
				result[lineNum] = lineNumber;
				result[colNum] = getColNum(stringA, index);
				break;
			}
		}
		return result;
	}

	private static int getColNum(String stringA, int index) {
		int lineNum = 1;
		int pos = index;
		int j = 0;
		for (int i = 0; i < index; i++) {
			j++;
			if (stringA.charAt(i) == '\n') {
				lineNum++;
				pos -= j;
				j = 0;
			}
		}
		return pos;
	}

	private static int getLineNum(String stringA, int index) {
		int lineNum = 1;
		for (int i = 0; i < index; i++) {
			if (stringA.charAt(i) == '\n') {
				lineNum++;
			}
		}
		return lineNum;
	}

}
