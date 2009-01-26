/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SpecialRenderersFactoryImpl extends EFactoryImpl implements SpecialRenderersFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SpecialRenderersFactory init() {
		try {
			SpecialRenderersFactory theSpecialRenderersFactory = (SpecialRenderersFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/docExport/exportModel/renderers/specialRenderers");
			if (theSpecialRenderersFactory != null) {
				return theSpecialRenderersFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SpecialRenderersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SpecialRenderersFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case SpecialRenderersPackage.MEETING_RENDERER:
			return createMeetingRenderer();
		case SpecialRenderersPackage.MILESTONE_RENDERER:
			return createMilestoneRenderer();
		case SpecialRenderersPackage.STEPS_ATTRIBUTE_RENDERER:
			return createStepsAttributeRenderer();
		case SpecialRenderersPackage.METHOD_RENDERER:
			return createMethodRenderer();
		case SpecialRenderersPackage.PACKAGE_FLAT_RENDERER:
			return createPackageFlatRenderer();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MeetingRenderer createMeetingRenderer() {
		MeetingRendererImpl meetingRenderer = new MeetingRendererImpl();
		return meetingRenderer;
	}

	/**
	 * @param template the template where this renderer is used
	 * @return a new Meeting renderer
	 * @generated NOT
	 */
	public MeetingRenderer createMeetingRenderer(Template template) {
		MeetingRendererImpl meetingRenderer = new MeetingRendererImpl();
		meetingRenderer.setTemplate(template);
		TextOption workItemTextOption = (TextOption) EcoreUtil.copy(template.getLayoutOptions().getDefaultTextOption());
		workItemTextOption.setName("workItem");
		meetingRenderer.getRendererOptions().add(workItemTextOption);
		return meetingRenderer;
	}

	/**
	 * <!-- begin-user-doc --> . <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MilestoneRenderer createMilestoneRenderer() {
		MilestoneRendererImpl milestoneRenderer = new MilestoneRendererImpl();
		return milestoneRenderer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StepsAttributeRenderer createStepsAttributeRenderer() {
		StepsAttributeRendererImpl stepsAttributeRenderer = new StepsAttributeRendererImpl();
		return stepsAttributeRenderer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MethodRenderer createMethodRenderer() {
		MethodRendererImpl methodRenderer = new MethodRendererImpl();
		return methodRenderer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PackageFlatRenderer createPackageFlatRenderer() {
		PackageFlatRendererImpl packageFlatRenderer = new PackageFlatRendererImpl();
		return packageFlatRenderer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SpecialRenderersPackage getSpecialRenderersPackage() {
		return (SpecialRenderersPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SpecialRenderersPackage getPackage() {
		return SpecialRenderersPackage.eINSTANCE;
	}

} // SpecialRenderersFactoryImpl
