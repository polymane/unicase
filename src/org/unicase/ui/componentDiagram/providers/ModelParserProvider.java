package org.unicase.ui.componentDiagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelPackage;

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser componentServiceName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getComponentServiceName_4001Parser() {
		if (componentServiceName_4001Parser == null) {
			componentServiceName_4001Parser = createComponentServiceName_4001Parser();
		}
		return componentServiceName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createComponentServiceName_4001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.componentDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.componentDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_4002Parser() {
		if (componentName_4002Parser == null) {
			componentName_4002Parser = createComponentName_4002Parser();
		}
		return componentName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createComponentName_4002Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.componentDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.componentDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.ui.componentDiagram.edit.parts.ComponentNameEditPart.VISUAL_ID:
			return getComponentServiceName_4001Parser();
		case org.unicase.ui.componentDiagram.edit.parts.ComponentName2EditPart.VISUAL_ID:
			return getComponentName_4002Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.unicase.ui.componentDiagram.part.ModelVisualIDRegistry
					.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (org.unicase.ui.componentDiagram.providers.ModelElementTypes
					.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
