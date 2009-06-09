/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classDiagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class ModelPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				org.unicase.model.classDiagram.part.Messages.Nodes1Group_title);
		paletteContainer.add(createClass1CreationTool());
		paletteContainer.add(createAttribute2CreationTool());
		paletteContainer.add(createMethod3CreationTool());
		paletteContainer.add(createPackage4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				org.unicase.model.classDiagram.part.Messages.Connections2Group_title);
		paletteContainer
				.setDescription(org.unicase.model.classDiagram.part.Messages.Connections2Group_desc);
		paletteContainer.add(createGeneralization1CreationTool());
		paletteContainer.add(createUndirectedAssociation2CreationTool());
		paletteContainer.add(createDirectedAssociation3CreationTool());
		paletteContainer.add(createAggregation4CreationTool());
		paletteContainer.add(createComposition5CreationTool());
		paletteContainer.add(createDependency6CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.model.classDiagram.part.Messages.Class1CreationTool_title,
				org.unicase.model.classDiagram.part.Messages.Class1CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAttribute2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Attribute_3001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.model.classDiagram.part.Messages.Attribute2CreationTool_title,
				org.unicase.model.classDiagram.part.Messages.Attribute2CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.model.classDiagram.providers.ModelElementTypes.Attribute_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMethod3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Method_3002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.model.classDiagram.part.Messages.Method3CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.model.classDiagram.providers.ModelElementTypes.Method_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackage4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Package_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.model.classDiagram.part.Messages.Package4CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.model.classDiagram.providers.ModelElementTypes.Package_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSuperClasses_4007);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.model.classDiagram.part.Messages.Generalization1CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Generalization.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Generalization.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUndirectedAssociation2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4001);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.model.classDiagram.part.Messages.UndirectedAssociation2CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Association.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Association.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDirectedAssociation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4004);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.model.classDiagram.part.Messages.DirectedAssociation3CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Directed_Association.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Directed_Association.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAggregation4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4002);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.model.classDiagram.part.Messages.Aggregation4CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Aggregation.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Aggregation.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComposition5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_4003);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.model.classDiagram.part.Messages.Composition5CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Composition.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Composition.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Dependency_4006);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.model.classDiagram.part.Messages.Dependency6CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Dependency.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(org.unicase.model.classDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Dependency.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
