package org.unicase.ui.urmlDiagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.hazard.HazardPackage;
import org.unicase.model.requirement.RequirementPackage;

/**
 * @generated
 */
public class ModelElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private ModelElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType MEDiagram_66 = getElementType("org.unicase.ui.urmlDiagram.MEDiagram_66"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType HazardCause_2001 = getElementType("org.unicase.ui.urmlDiagram.HazardCause_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Mitigation_2002 = getElementType("org.unicase.ui.urmlDiagram.Mitigation_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Hazard_2003 = getElementType("org.unicase.ui.urmlDiagram.Hazard_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Actor_2004 = getElementType("org.unicase.ui.urmlDiagram.Actor_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UseCase_2005 = getElementType("org.unicase.ui.urmlDiagram.UseCase_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FunctionalRequirement_2006 = getElementType("org.unicase.ui.urmlDiagram.FunctionalRequirement_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ActorParticipatedUseCases_4001 = getElementType("org.unicase.ui.urmlDiagram.ActorParticipatedUseCases_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ActorInitiatedUseCases_4012 = getElementType("org.unicase.ui.urmlDiagram.ActorInitiatedUseCases_4012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UseCaseIncludedUseCases_4003 = getElementType("org.unicase.ui.urmlDiagram.UseCaseIncludedUseCases_4003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType UseCaseExtendedUseCases_4004 = getElementType("org.unicase.ui.urmlDiagram.UseCaseExtendedUseCases_4004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MitigationHazards_4013 = getElementType("org.unicase.ui.urmlDiagram.MitigationHazards_4013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MitigationCauses_4014 = getElementType("org.unicase.ui.urmlDiagram.MitigationCauses_4014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FunctionalRequirementRefinedRequirement_4015 = getElementType("org.unicase.ui.urmlDiagram.FunctionalRequirementRefinedRequirement_4015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FunctionalRequirementMitigations_4008 = getElementType("org.unicase.ui.urmlDiagram.FunctionalRequirementMitigations_4008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ActorHazards_4010 = getElementType("org.unicase.ui.urmlDiagram.ActorHazards_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType HazardCauseHazards_4016 = getElementType("org.unicase.ui.urmlDiagram.HazardCauseHazards_4016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
						.getInstance().getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(MEDiagram_66, DiagramPackage.eINSTANCE.getMEDiagram());

			elements.put(HazardCause_2001, HazardPackage.eINSTANCE
					.getHazardCause());

			elements.put(Mitigation_2002, HazardPackage.eINSTANCE
					.getMitigation());

			elements.put(Hazard_2003, HazardPackage.eINSTANCE.getHazard());

			elements.put(Actor_2004, RequirementPackage.eINSTANCE.getActor());

			elements.put(UseCase_2005, RequirementPackage.eINSTANCE
					.getUseCase());

			elements.put(FunctionalRequirement_2006,
					RequirementPackage.eINSTANCE.getFunctionalRequirement());

			elements.put(ActorParticipatedUseCases_4001,
					RequirementPackage.eINSTANCE
							.getActor_ParticipatedUseCases());

			elements.put(ActorInitiatedUseCases_4012,
					RequirementPackage.eINSTANCE.getActor_InitiatedUseCases());

			elements.put(UseCaseIncludedUseCases_4003,
					RequirementPackage.eINSTANCE.getUseCase_IncludedUseCases());

			elements.put(UseCaseExtendedUseCases_4004,
					RequirementPackage.eINSTANCE.getUseCase_ExtendedUseCases());

			elements.put(MitigationHazards_4013, HazardPackage.eINSTANCE
					.getMitigation_Hazards());

			elements.put(MitigationCauses_4014, HazardPackage.eINSTANCE
					.getMitigation_Causes());

			elements.put(FunctionalRequirementRefinedRequirement_4015,
					RequirementPackage.eINSTANCE
							.getFunctionalRequirement_RefinedRequirement());

			elements.put(FunctionalRequirementMitigations_4008,
					RequirementPackage.eINSTANCE
							.getFunctionalRequirement_Mitigations());

			elements.put(ActorHazards_4010, RequirementPackage.eINSTANCE
					.getActor_Hazards());

			elements.put(HazardCauseHazards_4016, HazardPackage.eINSTANCE
					.getHazardCause_Hazards());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(MEDiagram_66);
			KNOWN_ELEMENT_TYPES.add(HazardCause_2001);
			KNOWN_ELEMENT_TYPES.add(Mitigation_2002);
			KNOWN_ELEMENT_TYPES.add(Hazard_2003);
			KNOWN_ELEMENT_TYPES.add(Actor_2004);
			KNOWN_ELEMENT_TYPES.add(UseCase_2005);
			KNOWN_ELEMENT_TYPES.add(FunctionalRequirement_2006);
			KNOWN_ELEMENT_TYPES.add(ActorParticipatedUseCases_4001);
			KNOWN_ELEMENT_TYPES.add(ActorInitiatedUseCases_4012);
			KNOWN_ELEMENT_TYPES.add(UseCaseIncludedUseCases_4003);
			KNOWN_ELEMENT_TYPES.add(UseCaseExtendedUseCases_4004);
			KNOWN_ELEMENT_TYPES.add(MitigationHazards_4013);
			KNOWN_ELEMENT_TYPES.add(MitigationCauses_4014);
			KNOWN_ELEMENT_TYPES
					.add(FunctionalRequirementRefinedRequirement_4015);
			KNOWN_ELEMENT_TYPES.add(FunctionalRequirementMitigations_4008);
			KNOWN_ELEMENT_TYPES.add(ActorHazards_4010);
			KNOWN_ELEMENT_TYPES.add(HazardCauseHazards_4016);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
