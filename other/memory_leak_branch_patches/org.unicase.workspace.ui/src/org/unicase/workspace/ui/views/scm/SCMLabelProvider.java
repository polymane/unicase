/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.scm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.util.UiUtil;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.Activator;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;

/**
 * Label provider for the scm views.
 * 
 * @author Shterev
 */
public class SCMLabelProvider extends ColumnLabelProvider {

	private Project project;
	private List<OperationId> highlighted;
	private static final String ELEMENT_NOT_FOUND = "There is no sufficient information to display this element";
	private static final String LOCAL_REVISION = "Local revision";

	/**
	 * Default constructor.
	 * 
	 * @param project the project.
	 */
	public SCMLabelProvider(Project project) {
		super();
		this.project = project;
		this.highlighted = new ArrayList<OperationId>();

		baseRevision = Activator.getImageDescriptor("icons/HistoryInfo_base.png").createImage();
		currentRevision = Activator.getImageDescriptor("icons/HistoryInfo_current.png").createImage();
		headRevision = Activator.getImageDescriptor("icons/HistoryInfo_head.png").createImage();
	}

	private ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
		ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	private AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
		composedAdapterFactory);
	// jc: done
	private ChangePackageVisualizationHelper changePackageVisualizationHelper;
	private Image baseRevision;
	private Image currentRevision;
	private Image headRevision;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof TreeNode) {
			Object value = ((TreeNode) element).getValue();
			String ret = null;
			if (value instanceof HistoryInfo) {
				HistoryInfo historyInfo = (HistoryInfo) value;
				return getText(historyInfo);
			} else if (value instanceof AbstractOperation && changePackageVisualizationHelper != null) {
				ret = changePackageVisualizationHelper.getDescription((AbstractOperation) value);
			} else if (value instanceof ModelElementId && changePackageVisualizationHelper != null) {
				EObject modelElement = changePackageVisualizationHelper.getModelElement((ModelElementId) value);
				if (modelElement != null) {
					ret = UiUtil.getNameForModelElement(modelElement);
				} else {
					return ELEMENT_NOT_FOUND;
				}
			} else if (value instanceof ChangePackage) {
				ChangePackage changePackage = (ChangePackage) value;
				return getText(changePackage);
			} else if (value instanceof EObject) {
				ret = UiUtil.getNameForModelElement(((EObject) value));
			} else {
				ret = value.toString();
			}
			return ret;
		}
		return super.getText(element);
	}

	private String getText(ChangePackage changePackage) {
		StringBuilder builder = new StringBuilder();
		builder.append("Change Package");
		if (changePackage.getLogMessage() != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
			LogMessage logMessage = changePackage.getLogMessage();
			builder.append(" [");
			builder.append(logMessage.getAuthor());
			Date clientDate = logMessage.getClientDate();
			if (clientDate != null) {
				builder.append(" @ ");
				builder.append(dateFormat.format(clientDate));
			}
			builder.append("] ");
			builder.append(logMessage.getMessage());
		}
		return builder.toString();
	}

	private String getText(HistoryInfo historyInfo) {
		if (historyInfo.getPrimerySpec() != null && historyInfo.getPrimerySpec().getIdentifier() == -1) {
			return LOCAL_REVISION;
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
		String baseVersion = "";
		if (historyInfo.getPrimerySpec().getIdentifier() == WorkspaceManager.getProjectSpace(project).getBaseVersion()
			.getIdentifier()) {
			baseVersion = "*";
		}
		StringBuilder builder = new StringBuilder();

		if (!historyInfo.getTagSpecs().isEmpty()) {
			builder.append("[");
			for (TagVersionSpec versionSpec : historyInfo.getTagSpecs()) {
				builder.append(versionSpec.getName());
				builder.append(",");
			}
			builder.replace(builder.length() - 1, builder.length(), "] ");
		}

		builder.append(baseVersion);
		builder.append("Version ");
		builder.append(historyInfo.getPrimerySpec().getIdentifier());
		LogMessage logMessage = null;

		if (historyInfo.getLogMessage() != null) {
			logMessage = historyInfo.getLogMessage();
		} else if (historyInfo.getChangePackage() != null && historyInfo.getChangePackage().getLogMessage() != null) {
			logMessage = historyInfo.getChangePackage().getLogMessage();
		}
		if (logMessage != null) {
			builder.append(" [");
			builder.append(logMessage.getAuthor());
			Date clientDate = logMessage.getClientDate();
			if (clientDate != null) {
				builder.append(" @ ");
				builder.append(dateFormat.format(clientDate));
			}
			builder.append("] ");
			builder.append(logMessage.getMessage());
		}
		return builder.toString();
	}

	private TreeNode findTopParent(TreeNode node) {
		TreeNode n = node;
		while (n.getParent() != null) {
			n = n.getParent();
		}
		return n;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getForeground(Object element) {
		if (element instanceof TreeNode) {
			TreeNode node = (TreeNode) element;
			if (node.getValue() instanceof AbstractOperation) {
				AbstractOperation operation = (AbstractOperation) node.getValue();
				if (highlighted.contains(operation.getOperationId())) {
					return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
				}
			}
		}
		return super.getForeground(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Font getFont(Object element) {
		if (!(element instanceof TreeNode)) {
			return null;
		}
		Object value = ((TreeNode) element).getValue();

		Font italic = JFaceResources.getFontRegistry().getItalic(JFaceResources.DIALOG_FONT);
		Font bold = JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT);

		// if (getText(findTopParent((TreeNode)
		// element)).equals(LOCAL_REVISION)) {
		// return italic;
		// }
		String text = getText(element);
		if (text == null) {
			text = "";
		}
		if (value instanceof HistoryInfo) {
			if (text.equals(LOCAL_REVISION)) {
				return italic;
			}
			HistoryInfo historyInfo = (HistoryInfo) value;
			if (historyInfo.getPrimerySpec().getIdentifier() == WorkspaceManager.getProjectSpace(project)
				.getBaseVersion().getIdentifier()) {
				return bold;
			}
		} else if (value instanceof ModelElementId) {
			if (text.equals(ELEMENT_NOT_FOUND)) {
				return italic;
			}
		}
		if (((TreeNode) element).getParent() != null
			&& ((TreeNode) element).getParent().getValue() instanceof AbstractOperation) {
			AbstractOperation op = (AbstractOperation) ((TreeNode) element).getParent().getValue();
			if ((value instanceof ModelElementId && value.equals(op.getModelElementId()))) {
				return bold;
			}

			if (value instanceof EObject) {
				EObject modelElement = (EObject) value;
				Project project = ModelUtil.getProject(modelElement);
				if (project != null && project.getModelElementId(modelElement).equals(op.getModelElementId())) {
					return bold;
				}
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {

		if (element instanceof TreeNode) {
			Object value = ((TreeNode) element).getValue();
			if (value instanceof ModelElementId) {
				return adapterFactoryLabelProvider.getImage(changePackageVisualizationHelper
					.getModelElement((ModelElementId) value));
			} else if (value instanceof HistoryInfo) {
				String text = getText(element);
				if (text.equals(LOCAL_REVISION)) {
					return currentRevision;
				}
				if (text.matches("\\[.*BASE.*\\].*")) {
					return baseRevision;
				}
				if (text.matches("\\[.*HEAD.*\\].*")) {
					return headRevision;
				}
			}
			if (value instanceof CompositeOperation && ((CompositeOperation) value).getMainOperation() != null) {
				return changePackageVisualizationHelper.getImage(adapterFactoryLabelProvider,
					((CompositeOperation) value).getMainOperation());
			}

			if (value instanceof AbstractOperation) {
				return changePackageVisualizationHelper
					.getImage(adapterFactoryLabelProvider, (AbstractOperation) value);
			}
			return adapterFactoryLabelProvider.getImage(value);

		}

		return super.getImage(element);
	}

	/**
	 * @param changePackageVisualizationHelper the changePackageVisualizationHelper to set
	 */
	public void setChangePackageVisualizationHelper(ChangePackageVisualizationHelper changePackageVisualizationHelper) {
		this.changePackageVisualizationHelper = changePackageVisualizationHelper;
	}

	/**
	 * @return the changePackageVisualizationHelper
	 */
	public ChangePackageVisualizationHelper getChangePackageVisualizationHelper() {
		return changePackageVisualizationHelper;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getToolTipText(Object element) {
		TreeNode historyNode = findTopParent((TreeNode) element);
		return getText((HistoryInfo) historyNode.getValue());
	}

	/**
	 * @return the highlighted elements list.
	 */
	public List<OperationId> getHighlighted() {
		return highlighted;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		adapterFactoryLabelProvider.dispose();
		composedAdapterFactory.dispose();
		super.dispose();
		headRevision.dispose();
		currentRevision.dispose();
		baseRevision.dispose();

	}
}
