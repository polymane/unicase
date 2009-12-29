/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.unicaseAnalyzers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.conflictDetection.IndexSensitiveConflictDetectionStrategy;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.UnkownFeatureException;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;

/**
 * @author liya
 */
public class CategoryAnalyzer implements DataAnalyzer {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("Category");
		names.add("Operations Number");
		names.add("Dependency Depth");
		return names;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData) Only check the first
	 *      returned ChangePackage. It's better to set the steplength = 1 for the connecting iterator.
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		List<Integer> dependency;

		int category = 0; // Category number, 4 in total

		int attriCount = 0; // Count for Attribute Operation
		int refCount = 0; // Reference Operation
		int createCount = 0; // CreateDelete Operation

		int opListSize = 0;// operations number for each changePackage
		int leafOpSize = 0;
		int depth = 0; // dependency depth

		ConflictDetector conflictDetector = new ConflictDetector(new IndexSensitiveConflictDetectionStrategy());

		if (data.getChangePackages() != null && data.getChangePackages().size() > 0) {

			dependency = new ArrayList<Integer>();

			for (AbstractOperation op : data.getChangePackages().get(0).getOperations()) {
				if (op instanceof AttributeOperation) {
					attriCount++;
				} else if (op instanceof ReferenceOperation) {
					refCount++;
				} else if (op instanceof CreateDeleteOperation) {
					createCount++;
				}

				// Calculate dependency depth
				dependency.add(conflictDetector.getRequiring(data.getChangePackages().get(0).getOperations(), op)
					.size());
			}

			opListSize = data.getChangePackages().get(0).getOperations().size();

			if (attriCount + refCount == opListSize) {
				category = 1;
			} else if (attriCount + refCount + createCount == opListSize) {
				category = 2;
			} else if (attriCount + refCount + createCount < opListSize) {
				category = 3;
			}

			if (dependency != null && dependency.size() > 0) {
				depth = Collections.max(dependency);
			}
			leafOpSize = data.getChangePackages().get(0).getLeafOperations().size();
		}

		values.add(category);
		values.add(leafOpSize);
		values.add(depth);
		checkForRenameAndMove(data);
		return values;
	}

	private void checkForRenameAndMove(ProjectAnalysisData data) {
		for (ChangePackage changePackage : data.getChangePackages()) {
			Set<ModelElementId> renamedElements = new HashSet<ModelElementId>();
			Set<ModelElementId> containmentChangeElements = new HashSet<ModelElementId>();
			for (AbstractOperation operation : changePackage.getOperations()) {
				if (operation instanceof AttributeOperation) {
					AttributeOperation attributeOperation = (AttributeOperation) operation;
					String featureName = attributeOperation.getFeatureName();
					if (featureName.equals("name")) {
						renamedElements.add(attributeOperation.getModelElementId());
					}
				} else if (operation instanceof ReferenceOperation) {
					ReferenceOperation referenceOperation = (ReferenceOperation) operation;
					try {
						ModelElement modelElement = data.getProjectState().getModelElement(
							operation.getModelElementId());
						if (modelElement == null) {
							continue;
						}
						EReference feature = (EReference) referenceOperation.getFeature(modelElement);
						if (feature.isContainer() || feature.isContainment()) {
							containmentChangeElements.addAll(referenceOperation.getAllInvolvedModelElements());
						}

					} catch (UnkownFeatureException e) {
						continue;
					}
				}
			}
			boolean doIntersect = renamedElements.removeAll(containmentChangeElements);
			if (doIntersect) {
				System.out.println("Possible intersection at revision " + data.getPrimaryVersionSpec());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#isGlobal()
	 */
	public boolean isGlobal() {
		// TODO Auto-generated method stub
		return false;
	}

}
