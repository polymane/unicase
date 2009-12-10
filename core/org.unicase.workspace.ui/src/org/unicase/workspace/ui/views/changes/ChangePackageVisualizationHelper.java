/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.UnkownFeatureException;
import org.unicase.emfstore.esmodel.versioning.operations.provider.AbstractOperationItemProvider;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.util.UiUtil;

/**
 * A helper class for the visualization of change packages.
 * 
 * @author koegel
 * @author shterev
 */
public class ChangePackageVisualizationHelper {

	private static final int MAX_NAME_SIZE = 30;
	private Project project;
	private Map<ModelElementId, ModelElement> modelElementMap;
	private static final String UNKOWN_ELEMENT = "(Unkown Element)";
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider;

	/**
	 * Constructor.
	 * 
	 * @param changePackages
	 *            a list of change packages
	 * @param project
	 *            a project
	 */
	public ChangePackageVisualizationHelper(List<ChangePackage> changePackages,
			Project project) {
		this.modelElementMap = new HashMap<ModelElementId, ModelElement>();
		for (ChangePackage changePackage : changePackages) {
			initModelElementMap(changePackage);
		}
		this.project = project;
		adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	private void initModelElementMap(ChangePackage changePackage) {
		List<AbstractOperation> operations = changePackage.getLeafOperations();
		for (AbstractOperation abstractOperation : operations) {
			if (abstractOperation instanceof CreateDeleteOperation) {
				ModelElement modelElement = ((CreateDeleteOperation) abstractOperation)
						.getModelElement();
				modelElementMap.put(modelElement.getModelElementId(),
						modelElement);
				for (ModelElement sibling : modelElement
						.getAllContainedModelElements()) {
					modelElementMap.put(sibling.getModelElementId(), sibling);
				}
			}
		}
	}

	/**
	 * Get a model element instance from the project for the given id.
	 * 
	 * @param modelElementId
	 *            the id
	 * @return the model element instance
	 */
	public ModelElement getModelElement(ModelElementId modelElementId) {
		if (modelElementId == null) {
			return null;
		} else if (project.contains(modelElementId)) {
			return project.getModelElement(modelElementId);
		} else {
			return modelElementMap.get(modelElementId);
		}
	}

	/**
	 * Get the overlay image for an operation.
	 * 
	 * @param operation
	 *            the operation
	 * @return the ImageDescriptor
	 */
	public ImageDescriptor getOverlayImage(AbstractOperation operation) {
		String overlay = null;
		if (operation instanceof CreateDeleteOperation) {
			CreateDeleteOperation op = (CreateDeleteOperation) operation;
			if (op.isDelete()) {
				overlay = "icons/delete_overlay.png";
			} else {
				overlay = "icons/add_overlay.png";
			}
		} else if (operation instanceof AttributeOperation) {
			AttributeOperation op = (AttributeOperation) operation;
			if (op.getNewValue() == null) {
				overlay = "icons/delete_overlay.png";
			} else if (op.getOldValue() == null) {
				overlay = "icons/add_overlay.png";
			} else {
				overlay = "icons/modify_overlay.png";
			}
		} else if (operation instanceof SingleReferenceOperation) {
			SingleReferenceOperation op = (SingleReferenceOperation) operation;
			if (op.getNewValue() == null) {
				overlay = "icons/delete_overlay.png";
			} else {
				overlay = "icons/link_overlay.png";
			}
		} else if (operation instanceof MultiReferenceOperation) {
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			if (op.getReferencedModelElements().size() > 0) {
				overlay = "icons/link_overlay.png";
			}
		} else if (operation instanceof MultiReferenceMoveOperation) {
			overlay = "icons/link_overlay.png";
		} else {
			overlay = "icons/modify_overlay.png";
		}

		ImageDescriptor overlayDescriptor = org.unicase.ui.common.Activator
				.getImageDescriptor(overlay);
		return overlayDescriptor;
	}

	/**
	 * Get an image for the operation.
	 * 
	 * @param emfProvider
	 *            the label provider
	 * @param operation
	 *            the operation
	 * @return an image
	 */
	public Image getImage(ILabelProvider emfProvider,
			AbstractOperation operation) {
		Image image = null;
		if (operation instanceof CreateDeleteOperation) {
			CreateDeleteOperation op = (CreateDeleteOperation) operation;
			image = emfProvider.getImage(op.getModelElement());
		} else if (operation instanceof AttributeOperation) {
			image = emfProvider.getImage(null);
		} else if (operation instanceof SingleReferenceOperation) {
			SingleReferenceOperation op = (SingleReferenceOperation) operation;
			if (op.getNewValue() == null) {
				image = emfProvider.getImage(op.getOldValue());
			} else if (op.getOldValue() == null) {
				image = emfProvider.getImage(op.getNewValue());
			} else {
				image = emfProvider.getImage(op.getNewValue());
			}
		} else if (operation instanceof MultiReferenceOperation) {
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			if (op.getReferencedModelElements().size() > 0) {
				image = emfProvider.getImage(op.getReferencedModelElements()
						.get(0));
			}
		} else if (operation instanceof MultiReferenceMoveOperation) {
			MultiReferenceMoveOperation op = (MultiReferenceMoveOperation) operation;
			image = emfProvider.getImage(op.getReferencedModelElementId());
		}
		return image;
	}

	/**
	 * @param op
	 *            the operation to generate a description for
	 * @return the description for given operation
	 */
	public String getDescription(AbstractOperation op) {
		if (op instanceof SingleReferenceOperation) {
			return getDescriptionSingleReferenceOperation((SingleReferenceOperation) op);
		}
		if (op instanceof MultiReferenceOperation) {
			return getDescriptionMultiReferenceOperation((MultiReferenceOperation) op);
		}
		if (op instanceof CreateDeleteOperation) {
			return getDescriptionCreateDeleteOperation((CreateDeleteOperation) op);
		}
		if (op instanceof MultiReferenceMoveOperation) {
			return getDescriptionMultiReferenceMoveOperation((MultiReferenceMoveOperation) op);
		}
		if (op instanceof CompositeOperation) {
			CompositeOperation compositeOperation = (CompositeOperation) op;
			// artificial composite because of opposite ref, take description of
			// mainoperation
			if (compositeOperation.getMainOperation() != null) {
				return getDescription(compositeOperation.getMainOperation());
			}
		}
		return resolveIds(adapterFactoryLabelProvider.getText(op));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.provider.ChangePackageVisualizationContext#resolveIds(java.lang.String)
	 */
	public String resolveIds(String unresolvedString) {
		String namesResolved = resolveIds(unresolvedString,
				AbstractOperationItemProvider.NAME_TAG__SEPARATOR);
		String allResolved = resolveIds(namesResolved,
				AbstractOperationItemProvider.NAME_CLASS_TAG_SEPARATOR);
		return allResolved;
	}

	private String resolveIds(String unresolvedString, String devider) {
		String[] strings = unresolvedString.split(devider);
		if (strings.length < 3) {
			return unresolvedString;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			if (i % 2 == 1) {
				ModelElementId modelElementId = MetamodelFactory.eINSTANCE
						.createModelElementId();
				modelElementId.setId(strings[i]);
				if (devider
						.equals(AbstractOperationItemProvider.NAME_CLASS_TAG_SEPARATOR)) {
					stringBuilder
							.append(getModelElementClassAndName(modelElementId));
				} else {
					stringBuilder.append(getModelElementName(modelElementId));
				}
			} else {
				stringBuilder.append(strings[i]);
			}
		}
		return stringBuilder.toString();
	}

	private String getModelElementName(ModelElementId modelElementId) {
		ModelElement modelElement = getModelElement(modelElementId);
		if (modelElement == null) {
			return UNKOWN_ELEMENT;
		}
		return adapterFactoryLabelProvider.getText(modelElement);
	}

	private String getDescriptionMultiReferenceMoveOperation(
			MultiReferenceMoveOperation op) {

		String elementName = getModelElementClassAndName(op.getModelElementId());
		String movedElementName = getModelElementClassAndName(op
				.getReferencedModelElementId());
		return "Reordered " + op.getFeatureName() + " in " + elementName
				+ ", moved " + movedElementName + " from position "
				+ op.getOldIndex() + " to " + op.getNewIndex();
	}

	private String getDescriptionCreateDeleteOperation(CreateDeleteOperation op) {

		ModelElement modelElement = op.getModelElement();
		int childrenCount = modelElement.getAllContainedModelElements().size();
		String description;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(modelElement.eClass().getName());
		stringBuilder.append(" \"");
		stringBuilder.append(UiUtil.getNameForModelElement(modelElement));
		stringBuilder.append("\" ");
		String elementClassAndName = stringBuilder.toString();
		if (op.isDelete()) {
			description = "Deleted " + elementClassAndName;
		} else {
			description = "Created " + elementClassAndName;
		}
		if (childrenCount > 0) {
			description += " including " + childrenCount + " sibling(s)";
		}

		EList<ReferenceOperation> subOperations = op.getSubOperations();
		int subOperationCount = subOperations.size();
		if (op.isDelete() && subOperationCount > 0) {
			ReferenceOperation referenceOperation = subOperations
					.get(subOperationCount - 1);
			ModelElement parentElement = getModelElement(referenceOperation
					.getModelElementId());
			try {
				if (parentElement != null
						&& ((EReference) referenceOperation
								.getFeature(parentElement)).isContainment()) {
					description += " from its parent "
							+ getModelElementClassAndName(parentElement);
				}
			} catch (UnkownFeatureException e) {
				// silently skip part about parent
			}
		}
		return description;

	}

	private String getDescriptionMultiReferenceOperation(
			MultiReferenceOperation op) {

		ModelElement modelElement = getModelElement(op.getModelElementId());
		if (modelElement == null) {
			String elemNames = getModelElementClassesAndNames(op
					.getReferencedModelElements(), "element");
			if (op.isAdd()) {
				return "Added " + elemNames + " to " + op.getFeatureName()
						+ " of (unkown element)";
			} else {
				return "Removed " + elemNames + " from " + op.getFeatureName()
						+ " of (unkown element)";
			}
		}

		boolean containment;
		String featureType;
		EReference feature;
		try {
			feature = (EReference) op.getFeature(modelElement);
			containment = feature.isContainment();
			featureType = feature.getEType().getName();
		} catch (UnkownFeatureException e) {
			containment = false;
			featureType = "element";
		}

		String elemNames = getModelElementClassesAndNames(op
				.getReferencedModelElements(), featureType);
		String elementNameAndClass = getModelElementClassAndName(modelElement);
		String children = op.getReferencedModelElements().size() > 1 ? "children"
				: "child";
		if (op.isAdd()) {
			if (containment) {
				return "Added " + elemNames + " as " + children + " in "
						+ elementNameAndClass;
			} else {
				return "Added " + elemNames + " to " + op.getFeatureName()
						+ " in " + elementNameAndClass;
			}
		} else {
			if (containment) {
				return "Removed " + elemNames + " as " + children + " in "
						+ elementNameAndClass;
			} else {
				return "Removed " + elemNames + " from " + op.getFeatureName()
						+ " in " + elementNameAndClass;
			}
		}

	}

	private String getDescriptionSingleReferenceOperation(
			SingleReferenceOperation op) {

		ModelElement oldElement = getModelElement(op.getOldValue());
		ModelElement newElement = getModelElement(op.getNewValue());
		String oldName = getModelElementClassAndName(oldElement);
		String newName = getModelElementClassAndName(newElement);
		ModelElement elem = getModelElement(op.getModelElementId());
		String elementName = getModelElementClassAndName(elem);

		boolean isContainer;
		try {
			isContainer = ((EReference) op.getFeature(elem)).isContainer();
		} catch (UnkownFeatureException e) {
			isContainer = false;
		}
		// changing containment means relocating the item
		if (isContainer && oldElement != null && newElement != null) {
			return "Moved " + elementName + " from " + oldName + " to "
					+ newName;
		} else if (isContainer && newElement != null) {
			return "Moved " + elementName + " to " + newName;
		} else {
			return resolveIds(adapterFactoryLabelProvider.getText(op));
		}

	}

	private String trim(Object object, boolean isName) {
		if (object == null) {
			return isName ? "(no name)" : "(null)";
		}
		String string = object.toString();
		String result = string.trim();
		if (result.length() > MAX_NAME_SIZE) {
			return result.substring(0, MAX_NAME_SIZE) + "...";
		}
		if (result.length() == 0) {
			return "(empty)";
		}
		return result;
	}

	/**
	 * Returns a comma separated list of class names and model names. {id1, id2}
	 * will become "Comment 'some comment', LeafSection 'section title'"
	 * 
	 * @param idList
	 *            the list of model element IDs to return the names for
	 * @return
	 */
	private String getModelElementClassesAndNames(EList<ModelElementId> idList,
			String typeName) {

		StringBuilder sb = new StringBuilder();

		if (idList.size() > 2) {
			return idList.size() + " " + typeName + "s";
		}

		for (int i = 0; i < idList.size(); i++) {
			if (i > 0 && i == idList.size() - 1) {
				sb.append(" and ");
			} else if (i > 0) {
				sb.append(", ");
			}
			ModelElementId id = idList.get(i);
			sb.append(getModelElementClassAndName(id));

		}
		return sb.toString();
	}

	private String getModelElementClassAndName(ModelElementId modelElementId) {
		if (modelElementId == null) {
			return UNKOWN_ELEMENT;
		}
		return getModelElementClassAndName(getModelElement(modelElementId));
	}

	private String getModelElementClassAndName(ModelElement modelElement) {
		if (modelElement == null) {
			return UNKOWN_ELEMENT;
		}
		return modelElement.eClass().getName() + " \""
				+ trim(UiUtil.getNameForModelElement(modelElement), true)
				+ "\"";
	}

	public <T extends Collection<ModelElement>, S extends Collection<ModelElementId>> T getModelElements(
			S modelElementIds, T resultCollection) {
		for (ModelElementId modelElementId : modelElementIds) {
			ModelElement modelElement = getModelElement(modelElementId);
			if (modelElement != null) {
				resultCollection.add(modelElement);
			}
		}
		return resultCollection;
	}
}
