package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.test.tests.changetests.ChangeTestHelper;
import org.unicase.test.tests.changetests.randomchange.IChangePackageTest;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;

/**
 * This is a ChangePackageTest.
 * This test takes a random ME A.
 * Change A.someSimpleAttribute = a
 * Change A.someSimpleAttribute = b
 * Change A.someSimpleAttribute = c
 * The expected change package should contain only one 
 * operation: value of A.someSimpleAttribute changed from a to c
 * 
 * 
 * @author Hodaie
 *
 */
public class TransitivelyChangeAttributeTest extends RandomChangeTestCase implements IChangePackageTest{

	private static final int EXPECTED_NUM_OF_CHANGES = 1;
	
	

	public TransitivelyChangeAttributeTest(String testName, TestProjectParmeters testProjParams) {
		super(testName, testProjParams);

		
	}
	
	
	@Override
	public void runTest() {
		
		
		final ModelElement me = ChangeTestHelper.getRandomME(getTestProject());

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {

				@Override
				protected void doExecute() {
					changeSimpleAttribute(me);
				
				}

			});
		
		

	}


	protected void changeSimpleAttribute(ModelElement me) {
		List<EAttribute> attributes = new ArrayList<EAttribute>();
		for (EAttribute attr : me.eClass().getEAllAttributes()) {
			if (attr.isChangeable() && attr.getFeatureID() != ModelPackage.MODEL_ELEMENT__IDENTIFIER) {
				attributes.add(attr);
			}
		}
	
		EAttribute attribute = attributes.size() == 1 ? attributes.get(0)
				: attributes.get(getRandom().nextInt(attributes.size() - 1));

		
		
		//attribute = a (initialization)
		if(!me.eIsSet(attribute)){
			changeAttribute(me, attribute);
		}
		
		//attribute = b
		changeAttribute(me, attribute);
		//attribute = c
		changeAttribute(me, attribute);
	}


	private void changeAttribute(ModelElement me, EAttribute attribute) {
		
		if (attribute.getEType().getInstanceClass().equals(String.class)) {
			String oldValue = (String) me.eGet(attribute);
			String newValue = "changed-" + oldValue;
			me.eSet(attribute, newValue);

		} else if (attribute.getEType().getInstanceClass()
				.equals(boolean.class)) {
			me.eSet(attribute, !((Boolean) me.eGet(attribute)));

		} else if (attribute.getEType().getInstanceClass().equals(int.class)) {
			me.eSet(attribute, getRandom().nextInt());

		} else if (attribute.getEType().getInstanceClass().equals(Date.class)) {
			me.eSet(attribute, getRandomDate());

		}
		if (attribute.getEType().getInstanceClass().equals(EEnum.class)) {
			EEnum en = (EEnum) attribute;
			int index = getRandom().nextInt(en.getELiterals().size());
			EEnumLiteral value = en.getELiterals().get(index);
			me.eSet(attribute, value);
		}

			
	}
	
	
	private Date getRandomDate() {
		return new Date();
	}


	public int getExpectedNumOfChanges() {
		
		return EXPECTED_NUM_OF_CHANGES;
	}


	public boolean isSuccessful() {
		//temp impl
		return EXPECTED_NUM_OF_CHANGES == 2;
	}
	
	
	public ChangePackage getChangePackage() {
		return ChangeTestHelper.getChangePackage(getTestProjectSpace()
				.getOperations(), true, true);

	}

}
