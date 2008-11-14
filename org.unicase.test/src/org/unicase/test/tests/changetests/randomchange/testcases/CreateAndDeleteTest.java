package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.util.ModelUtil;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;


/**
 * 
 * This is a change package test.
 * It creates randomly a model element, changes one of its non-containment references,
 * and deletes this ME. 
 * The expected change package should contain no operations.
 * 
 * @author Hodaie
 *
 */
public class CreateAndDeleteTest extends RandomChangeTestCase {

	public CreateAndDeleteTest(String testName, long randomSeed) {
		super(testName, randomSeed);

	}

	@Override
	public void runTest() {
		final ModelElement me = ChangeTestHelper.createRandomME();
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					getTestProject().getModelElements().add(me);
					changeSimpleRef(me);
					deleteME(me);
				}

			});
		
		

	}

	
	private void changeSimpleRef(ModelElement me) {
		
		List<EReference> nonContainmentRefs = new ArrayList<EReference>();
		for (EReference ref : me.eClass().getEAllReferences()) {
			if (!ref.isContainment()) {
				nonContainmentRefs.add(ref);
			}
		}
		
		EReference ref = nonContainmentRefs.get(getRandom().nextInt(
				nonContainmentRefs.size() - 1));
		EClass refType = ref.getEReferenceType();
		List<ModelElement> refTypeMEs = getTestProject()
				.getAllModelElementsbyClass(refType,
						new BasicEList<ModelElement>());
		
		ModelElement toBeReferencedME = refTypeMEs.get(getRandom().nextInt(refTypeMEs.size() - 1));
		
		Object object = me.eGet(ref);
		EList<EObject> eList = (EList<EObject>) object;
		eList.add(toBeReferencedME);

	}
	
	
	protected void deleteME(ModelElement me) {
		//EcoreUtil.delete(me, true);
		EcoreUtil.delete(me);
	}


}
