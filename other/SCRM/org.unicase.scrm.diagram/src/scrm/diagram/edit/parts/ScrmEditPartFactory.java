package scrm.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import scrm.diagram.part.ScrmVisualIDRegistry;

/**
 * @generated
 */
public class ScrmEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (ScrmVisualIDRegistry.getVisualID(view)) {

			case SCRMDiagramEditPart.VISUAL_ID:
				return new SCRMDiagramEditPart(view);

			case ScientificProblemEditPart.VISUAL_ID:
				return new ScientificProblemEditPart(view);

			case ScientificProblemNameEditPart.VISUAL_ID:
				return new ScientificProblemNameEditPart(view);

			case ScientificProblemDescriptionEditPart.VISUAL_ID:
				return new ScientificProblemDescriptionEditPart(view);

			case MathematicalModelEditPart.VISUAL_ID:
				return new MathematicalModelEditPart(view);

			case MathematicalModelNameEditPart.VISUAL_ID:
				return new MathematicalModelNameEditPart(view);

			case MathematicalModelDescriptionEditPart.VISUAL_ID:
				return new MathematicalModelDescriptionEditPart(view);

			case MathematicalModelTheoryEditPart.VISUAL_ID:
				return new MathematicalModelTheoryEditPart(view);

			case MathematicalModelMathematicalExpressionEditPart.VISUAL_ID:
				return new MathematicalModelMathematicalExpressionEditPart(view);

			case NumericalMethodEditPart.VISUAL_ID:
				return new NumericalMethodEditPart(view);

			case NumericalMethodNameEditPart.VISUAL_ID:
				return new NumericalMethodNameEditPart(view);

			case NumericalMethodDescriptionEditPart.VISUAL_ID:
				return new NumericalMethodDescriptionEditPart(view);

			case NumericalMethodTheoryEditPart.VISUAL_ID:
				return new NumericalMethodTheoryEditPart(view);

			case NumericalMethodAlgorithmEditPart.VISUAL_ID:
				return new NumericalMethodAlgorithmEditPart(view);

			case AssumptionEditPart.VISUAL_ID:
				return new AssumptionEditPart(view);

			case AssumptionNameEditPart.VISUAL_ID:
				return new AssumptionNameEditPart(view);

			case AssumptionDescriptionEditPart.VISUAL_ID:
				return new AssumptionDescriptionEditPart(view);

			case FeatureEditPart.VISUAL_ID:
				return new FeatureEditPart(view);

			case FeatureNameEditPart.VISUAL_ID:
				return new FeatureNameEditPart(view);

			case FeatureDescriptionEditPart.VISUAL_ID:
				return new FeatureDescriptionEditPart(view);

			case HardwareEditPart.VISUAL_ID:
				return new HardwareEditPart(view);

			case HardwareNameEditPart.VISUAL_ID:
				return new HardwareNameEditPart(view);

			case HardwareDescriptionEditPart.VISUAL_ID:
				return new HardwareDescriptionEditPart(view);

			case HardwareProcessorEditPart.VISUAL_ID:
				return new HardwareProcessorEditPart(view);

			case HardwarePlatformEditPart.VISUAL_ID:
				return new HardwarePlatformEditPart(view);

			case HardwareMemoryEditPart.VISUAL_ID:
				return new HardwareMemoryEditPart(view);

			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);

			case ConstraintNameEditPart.VISUAL_ID:
				return new ConstraintNameEditPart(view);

			case ConstraintDescriptionEditPart.VISUAL_ID:
				return new ConstraintDescriptionEditPart(view);

			case UserInterfaceEditPart.VISUAL_ID:
				return new UserInterfaceEditPart(view);

			case UserInterfaceNameEditPart.VISUAL_ID:
				return new UserInterfaceNameEditPart(view);

			case UserInterfaceDescriptionEditPart.VISUAL_ID:
				return new UserInterfaceDescriptionEditPart(view);

			case SoftwareInterfaceEditPart.VISUAL_ID:
				return new SoftwareInterfaceEditPart(view);

			case SoftwareInterfaceNameEditPart.VISUAL_ID:
				return new SoftwareInterfaceNameEditPart(view);

			case SoftwareInterfaceDescriptionEditPart.VISUAL_ID:
				return new SoftwareInterfaceDescriptionEditPart(view);

			case SoftwareInterfaceDataTypesEditPart.VISUAL_ID:
				return new SoftwareInterfaceDataTypesEditPart(view);

			case ProcessEditPart.VISUAL_ID:
				return new ProcessEditPart(view);

			case ProcessNameEditPart.VISUAL_ID:
				return new ProcessNameEditPart(view);

			case ProcessDescriptionEditPart.VISUAL_ID:
				return new ProcessDescriptionEditPart(view);

			case PerformanceEditPart.VISUAL_ID:
				return new PerformanceEditPart(view);

			case PerformanceNameEditPart.VISUAL_ID:
				return new PerformanceNameEditPart(view);

			case PerformanceDescriptionEditPart.VISUAL_ID:
				return new PerformanceDescriptionEditPart(view);

			case PerformanceProblemSizeEditPart.VISUAL_ID:
				return new PerformanceProblemSizeEditPart(view);

			case DataFlowEditPart.VISUAL_ID:
				return new DataFlowEditPart(view);

			case DataFlowNameEditPart.VISUAL_ID:
				return new DataFlowNameEditPart(view);

			case DataFlowDescriptionEditPart.VISUAL_ID:
				return new DataFlowDescriptionEditPart(view);

			case DataDefinitionEditPart.VISUAL_ID:
				return new DataDefinitionEditPart(view);

			case DataDefinitionNameEditPart.VISUAL_ID:
				return new DataDefinitionNameEditPart(view);

			case DataDefinitionDescriptionEditPart.VISUAL_ID:
				return new DataDefinitionDescriptionEditPart(view);

			case DataDefinitionAccuracyEditPart.VISUAL_ID:
				return new DataDefinitionAccuracyEditPart(view);

			case DataDefinitionFormatEditPart.VISUAL_ID:
				return new DataDefinitionFormatEditPart(view);

			case DataDefinitionRangeEditPart.VISUAL_ID:
				return new DataDefinitionRangeEditPart(view);

			case DataDefinitionDataTypeEditPart.VISUAL_ID:
				return new DataDefinitionDataTypeEditPart(view);

			case InputDataReadingEditPart.VISUAL_ID:
				return new InputDataReadingEditPart(view);

			case InputDataReadingNameEditPart.VISUAL_ID:
				return new InputDataReadingNameEditPart(view);

			case InputDataReadingDescriptionEditPart.VISUAL_ID:
				return new InputDataReadingDescriptionEditPart(view);

			case DataHandlingEditPart.VISUAL_ID:
				return new DataHandlingEditPart(view);

			case DataHandlingNameEditPart.VISUAL_ID:
				return new DataHandlingNameEditPart(view);

			case DataHandlingDescriptionEditPart.VISUAL_ID:
				return new DataHandlingDescriptionEditPart(view);

			case ResultsOutputEditPart.VISUAL_ID:
				return new ResultsOutputEditPart(view);

			case ResultsOutputNameEditPart.VISUAL_ID:
				return new ResultsOutputNameEditPart(view);

			case ResultsOutputDescriptionEditPart.VISUAL_ID:
				return new ResultsOutputDescriptionEditPart(view);

			case ErrorHandlingEditPart.VISUAL_ID:
				return new ErrorHandlingEditPart(view);

			case ErrorHandlingNameEditPart.VISUAL_ID:
				return new ErrorHandlingNameEditPart(view);

			case ErrorHandlingDescriptionEditPart.VISUAL_ID:
				return new ErrorHandlingDescriptionEditPart(view);

			case StatusMonitoringEditPart.VISUAL_ID:
				return new StatusMonitoringEditPart(view);

			case StatusMonitoringNameEditPart.VISUAL_ID:
				return new StatusMonitoringNameEditPart(view);

			case StatusMonitoringDescriptionEditPart.VISUAL_ID:
				return new StatusMonitoringDescriptionEditPart(view);

			case ScientificProblemRepresentingModelEditPart.VISUAL_ID:
				return new ScientificProblemRepresentingModelEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case ScientificProblemSolvingMethodsEditPart.VISUAL_ID:
				return new ScientificProblemSolvingMethodsEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case ScientificProblemInfluencedFeatureEditPart.VISUAL_ID:
				return new ScientificProblemInfluencedFeatureEditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			case MathematicalModel2EditPart.VISUAL_ID:
				return new MathematicalModel2EditPart(view);

			case WrappingLabel4EditPart.VISUAL_ID:
				return new WrappingLabel4EditPart(view);

			case MathematicalModelNumericalMethodsEditPart.VISUAL_ID:
				return new MathematicalModelNumericalMethodsEditPart(view);

			case WrappingLabel5EditPart.VISUAL_ID:
				return new WrappingLabel5EditPart(view);

			case MathematicalModelDependenciesEditPart.VISUAL_ID:
				return new MathematicalModelDependenciesEditPart(view);

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

			case NumericalMethodDependenciesEditPart.VISUAL_ID:
				return new NumericalMethodDependenciesEditPart(view);

			case WrappingLabel7EditPart.VISUAL_ID:
				return new WrappingLabel7EditPart(view);

			case NumericalMethodRealizingRequirementEditPart.VISUAL_ID:
				return new NumericalMethodRealizingRequirementEditPart(view);

			case WrappingLabel8EditPart.VISUAL_ID:
				return new WrappingLabel8EditPart(view);

			case NumericalMethodPerformanceEditPart.VISUAL_ID:
				return new NumericalMethodPerformanceEditPart(view);

			case WrappingLabel9EditPart.VISUAL_ID:
				return new WrappingLabel9EditPart(view);

			case FeatureRequiredInterfacesEditPart.VISUAL_ID:
				return new FeatureRequiredInterfacesEditPart(view);

			case WrappingLabel10EditPart.VISUAL_ID:
				return new WrappingLabel10EditPart(view);

			case FeatureProvidedInterfacesEditPart.VISUAL_ID:
				return new FeatureProvidedInterfacesEditPart(view);

			case WrappingLabel11EditPart.VISUAL_ID:
				return new WrappingLabel11EditPart(view);

			case FeatureConstraintsEditPart.VISUAL_ID:
				return new FeatureConstraintsEditPart(view);

			case WrappingLabel12EditPart.VISUAL_ID:
				return new WrappingLabel12EditPart(view);

			case FeatureDependenciesEditPart.VISUAL_ID:
				return new FeatureDependenciesEditPart(view);

			case WrappingLabel13EditPart.VISUAL_ID:
				return new WrappingLabel13EditPart(view);

			case FeatureDetailedRequirementsEditPart.VISUAL_ID:
				return new FeatureDetailedRequirementsEditPart(view);

			case WrappingLabel14EditPart.VISUAL_ID:
				return new WrappingLabel14EditPart(view);

			case Feature2EditPart.VISUAL_ID:
				return new Feature2EditPart(view);

			case WrappingLabel15EditPart.VISUAL_ID:
				return new WrappingLabel15EditPart(view);

			case FeatureRequiredFeaturesEditPart.VISUAL_ID:
				return new FeatureRequiredFeaturesEditPart(view);

			case WrappingLabel16EditPart.VISUAL_ID:
				return new WrappingLabel16EditPart(view);

			case FeatureExcludedFeaturesEditPart.VISUAL_ID:
				return new FeatureExcludedFeaturesEditPart(view);

			case WrappingLabel17EditPart.VISUAL_ID:
				return new WrappingLabel17EditPart(view);

			case RequirementEditPart.VISUAL_ID:
				return new RequirementEditPart(view);

			case WrappingLabel18EditPart.VISUAL_ID:
				return new WrappingLabel18EditPart(view);

			case RequirementDefiningDataEditPart.VISUAL_ID:
				return new RequirementDefiningDataEditPart(view);

			case WrappingLabel19EditPart.VISUAL_ID:
				return new WrappingLabel19EditPart(view);

			case ProcessDataFlowEditPart.VISUAL_ID:
				return new ProcessDataFlowEditPart(view);

			case WrappingLabel20EditPart.VISUAL_ID:
				return new WrappingLabel20EditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (!text.getFont().isDisposed()) {
				if (getWrapLabel().isTextWrapOn()
						&& getWrapLabel().getText().length() > 0) {
					rect.setSize(new Dimension(text.computeSize(rect.width,
							SWT.DEFAULT)));
				} else {
					int avr = FigureUtilities.getFontMetrics(text.getFont())
							.getAverageCharWidth();
					rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
							SWT.DEFAULT)).expand(avr * 2, 0));
				}
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			if (!text.getFont().isDisposed()) {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
