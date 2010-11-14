package org.unicase.ui.meeditor.multiattribute;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Spinner;

/**
 * Represents a single Integer field for a MultiAttributeItem.
 * 
 * @author Christian Kroemer (christian.kroemer@z-corp-online.de)
 *
 */
class IntegerAttributeControl extends AttributeControl {
	
	// CONSTANTS
	private static int SIZE_LIMIT = 10000000;
	
	// state and references
	protected MultiAttributeController<Integer> dataManipulator;
	protected Spinner widget;
	protected Integer value;
	
	IntegerAttributeControl(MultiAttributeControl parentItem, MultiAttributeController<Integer> dataManipulator, int value) {
		this.parentItem = parentItem;
		this.dataManipulator = dataManipulator;
		this.value = value;
		this.index = parentItem.controlList.size();
		parentItem.controlList.add(this);
		
		// initialize
		createCompositeLayout();
		widget = new Spinner (fieldComposite, parentItem.style | SWT.SINGLE);
		widget.setValues(value, -SIZE_LIMIT, SIZE_LIMIT, 0, 1, 1);
		widget.addModifyListener(this);
		createDeleteButton();
		createUpDownButtons();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true,true).applyTo(widget);
	}
	
	IntegerAttributeControl(MultiAttributeControl parentItem, MultiAttributeController<Integer> dataManipulator) {
		this.parentItem = parentItem;
		this.dataManipulator = dataManipulator;
		this.value = IntegerMultiAttributeControl.EMPTY_VALUE;
		
		// initialize
		createCompositeLayout();
		widget = new Spinner (fieldComposite, parentItem.style | SWT.SINGLE);
		widget.setValues(value, -SIZE_LIMIT, SIZE_LIMIT, 0, 1, 1);
		widget.addModifyListener(this);
		createAddButton();
		createInvisibleUpDownButtons();
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true,true).applyTo(widget);
	}
	
	private IntegerAttributeControl() {
		// hide default constructor
	}

	@Override
	protected boolean swapThisControlWith(int index) {
		if (index >= parentItem.controlList.size() || index < 0) {
			return false;
		}
		// create non-duplicate Integer
		int random = 0;
		while (dataManipulator.contains(random)) {
			random = ((int) (Math.random()*10000));
		}
		// use it for swap
		int thisValue = value;
		int otherValue = ((IntegerAttributeControl) parentItem.controlList.get(index)).value;
		widget.setSelection(random);
		((IntegerAttributeControl) parentItem.controlList.get(index)).widget.setSelection(thisValue);
		widget.setSelection(otherValue);
						
		return true;
	}
	
	@Override
	public void modifyText(ModifyEvent e) { // still duplicated code, but better solution?!
		if (e.getSource().equals(widget)) {
			// first edit? --> new button
			if (index==-1) {
				button.dispose();
				createDeleteButton();
				createUpDownButtons();
			}
			
			final int newValue = widget.getSelection();
			
			// jump over duplicates
			if (!parentItem.allowDuplicates) {
				if (dataManipulator.contains(newValue)) {
					if (newValue > value) {
						widget.setSelection(newValue+1);
					}
					else {
						widget.setSelection(newValue-1);
					}
					return;
				}				
			}
			// end of duplicate handling
			
			if (index!=-1) {
				// was a regular entry before
				dataManipulator.replaceElementAt(index, newValue);
				value = newValue;
			}
			else {
				// was a dummy entry before
				this.index = parentItem.controlList.size();
				parentItem.controlList.add(this);
				dataManipulator.add(newValue);
				value = newValue;
				button.setVisible(true);
				if (!parentItem.isFull()) {
					parentItem.createSingleField();
				}
				fieldComposite.layout();
			}
			
			parentItem.refreshWidget();
		}
	}

	@Override
	public void mouseUp(MouseEvent e) { // still duplicated code, but better solution?!
		if (e.getSource().equals(button)) {
			if (index==-1) {
				// add instead of delete
				
				// duplicate handling
				if (!parentItem.allowDuplicates) {
					while (dataManipulator.contains(value)) {
						value++;
					} 
				}
				// end of duplicate handling
				// automatically added then (ModifyListener!)
				widget.setSelection(value);	
				button.dispose();
				createDeleteButton();
				createUpDownButtons();
			}
			else {
				// delete
				// one will be deleted --> new empty one
				if (parentItem.isFull()) {
					parentItem.createSingleField();
				}
				dataManipulator.removeElementAt(index);
				// accordingly change all other indexes
				for (int i=index+1; i<parentItem.controlList.size(); i++) {
					parentItem.controlList.get(i).index--;
				}
				parentItem.controlList.remove(index);
				
				fieldComposite.dispose();
				
			}
		}
		
		if (e.getSource().equals(up)) {
			swapThisControlWith(index-1);
		}
		
		if (e.getSource().equals(down)) {
			swapThisControlWith(index+1);
		}
		
		parentItem.refreshWidget();
	}
}
