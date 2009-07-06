package org.unicase.ui.usecaseDiagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
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
		paletteRoot.add(createDefault1Group());
	}

	/**
	 * Creates "Default" palette tool group
	 * @generated
	 */
	private PaletteContainer createDefault1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				org.unicase.ui.usecaseDiagram.part.Messages.Default1Group_title);
		paletteContainer
				.setDescription(org.unicase.ui.usecaseDiagram.part.Messages.Default1Group_desc);
		paletteContainer.add(createUseCase1CreationTool());
		paletteContainer.add(createActor2CreationTool());
		paletteContainer.add(createInitiate3CreationTool());
		paletteContainer.add(createParticipate4CreationTool());
		paletteContainer.add(createInclude5CreationTool());
		paletteContainer.add(createExtend6CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUseCase1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCase_1002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.usecaseDiagram.part.Messages.UseCase1CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCase_1002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.Actor_1001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.usecaseDiagram.part.Messages.Actor2CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.Actor_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitiate3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_3002);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.usecaseDiagram.part.Messages.Initiate3CreationTool_title,
				org.unicase.ui.usecaseDiagram.part.Messages.Initiate3CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Initiate.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createParticipate4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_3001);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.usecaseDiagram.part.Messages.Participate4CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Participate.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInclude5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_3003);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.usecaseDiagram.part.Messages.Include5CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Include.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtend6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_3004);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.usecaseDiagram.part.Messages.Extend6CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Extend.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
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
