/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.usecaseDiagram.providers;

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
	private IParser actorName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getActorName_5001Parser() {
		if (actorName_5001Parser == null) {
			actorName_5001Parser = createActorName_5001Parser();
		}
		return actorName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActorName_5001Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.usecaseDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.usecaseDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser useCaseName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getUseCaseName_5002Parser() {
		if (useCaseName_5002Parser == null) {
			useCaseName_5002Parser = createUseCaseName_5002Parser();
		}
		return useCaseName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createUseCaseName_5002Parser() {
		EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE
				.getModelElement_Name(), };
		org.unicase.ui.usecaseDiagram.parsers.MessageFormatParser parser = new org.unicase.ui.usecaseDiagram.parsers.MessageFormatParser(
				features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case org.unicase.ui.usecaseDiagram.edit.parts.ActorNameEditPart.VISUAL_ID:
			return getActorName_5001Parser();
		case org.unicase.ui.usecaseDiagram.edit.parts.UseCaseNameEditPart.VISUAL_ID:
			return getUseCaseName_5002Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(org.unicase.ui.usecaseDiagram.part.ModelVisualIDRegistry
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
			if (org.unicase.ui.usecaseDiagram.providers.ModelElementTypes
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
		@Override
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
