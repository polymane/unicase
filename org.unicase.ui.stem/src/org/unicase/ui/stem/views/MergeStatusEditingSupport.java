package org.unicase.ui.stem.views;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;



public class MergeStatusEditingSupport extends EditingSupport {

	
	private ComboBoxCellEditor cellEditor;
	private static final String[] MERGE_STATUS_CONSTANTS = {"Accepted", "Rejected"};
	private static final int ACCEPTED = 0;
	private static final int REJECTED = 1;
	private ConflictDetector conflictDetector;
	private ColumnViewer viewer;
	private List<AbstractOperation> myOperations;
	private List<AbstractOperation> theirOperations;
	
	public MergeStatusEditingSupport(ColumnViewer viewer, Composite parent) {
		super(viewer);
		// TODO Auto-generated constructor stub
		this.viewer = viewer;
		cellEditor = new ComboBoxCellEditor(parent, MERGE_STATUS_CONSTANTS , SWT.READ_ONLY);
		conflictDetector = new ConflictDetector();
	
	}
	
		

	@Override
	protected boolean canEdit(Object element) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		// TODO Auto-generated method stub
		return cellEditor;
	}

	@Override
	protected Object getValue(Object element) {
		// TODO Auto-generated method stub
		if(element instanceof AbstractOperation){
			AbstractOperation op = (AbstractOperation)element;
			return op.isAccepted()? ACCEPTED : REJECTED;
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		//if value = rejected, reject all requiring change packages
		//if value = accepted, accept all required change packages
		if(!(element instanceof AbstractOperation)){
			return;
		}
		AbstractOperation selectedOp = (AbstractOperation)element;
		int newValue = ((Integer)value).intValue();
		if(newValue ==ACCEPTED){
			acceptAllRequired(selectedOp);
		}else{
			//test
			selectedOp.setAccepted(false);
			//rejectAllRequiring(chnagePackage);
		}
		
		this.viewer.update(element, null);
	}

	private void acceptAllRequired(AbstractOperation selectedOperation) {
		//accept all required ops on the left side
		List<AbstractOperation> required = conflictDetector.getRequired(myOperations, selectedOperation);
		required.add(selectedOperation);
		for(AbstractOperation op : required){
			op.setAccepted(true);
		}
		
		//reject all conflicting on the right side
		Set<AbstractOperation> conflicting =	conflictDetector.getConflicting(required, theirOperations);
		for(AbstractOperation op : conflicting){
			op.setAccepted(false);
		}
	}

	private void rejectAllRequiring(AbstractOperation selectedOperation) {
			
	}



	public void setMyOperations(List<AbstractOperation> myOperations) {
		this.myOperations = myOperations;
	}



	public List<AbstractOperation> getMyChanges() {
		return myOperations;
	}



	public void setTheirOperations(List<AbstractOperation> theirOperations) {
		this.theirOperations = theirOperations;
	}



	public List<AbstractOperation> getTheirOperations() {
		return theirOperations;
	}


}
