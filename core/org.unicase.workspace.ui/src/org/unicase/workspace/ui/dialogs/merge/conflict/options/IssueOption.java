package org.unicase.workspace.ui.dialogs.merge.conflict.options;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.change.MergingProposal;
import org.unicase.model.document.LeafSection;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.CustomConflictOption;
import org.unicase.workspace.util.UnicaseCommand;

public class IssueOption extends CustomConflictOption {

	private Conflict conflict;

	public IssueOption() {
		super("Enter Name...");
	}

	@Override
	public boolean hasExtraOptionAction() {
		return true;
	}

	@Override
	public boolean optionChosen() {
		String label = getOptionLabel();
		InputDialog inputDialog = new InputDialog(Display.getCurrent()
				.getActiveShell(), "Issue Name",
				"Please enter a name for the issue", (label == null) ? ""
						: label, null);
		inputDialog.setBlockOnOpen(true);
		int open = inputDialog.open();
		if (open == 0) {
			setOptionLabel(inputDialog.getValue());
			return true;
		}
		return false;
	}

	@Override
	public String getOptionPrefix() {
		return "Create Issue: ";
	}

	@Override
	public boolean hasExtraResultAction() {
		return true;
	}

	@Override
	public void callResultAction() {

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				Project project = conflict.getDecisionManager().getProject();
				ConflictOption myOption = conflict
						.getOptionOfType(OptionType.MyOperation);
				List<AbstractOperation> myOperations = myOption.getOperations();
				ConflictOption theirOption = conflict
						.getOptionOfType(OptionType.TheirOperation);
				List<AbstractOperation> theirOptions = theirOption
						.getOperations();

				ProjectSpace projectSpace = WorkspaceManager
						.getProjectSpace(project);
				EObject eContainer = project;
				if (myOperations.size() > 0) {
					ModelElement modelElement = project
							.getModelElement(myOperations.get(0)
									.getModelElementId());
					if (modelElement != null) {
						eContainer = modelElement.eContainer();
					}

				}

				MergingIssue mergeIssue = ChangeFactory.eINSTANCE
						.createMergingIssue();
				addToContainer(mergeIssue, eContainer);
				mergeIssue.setName(getStrippedOptionLabel());
				mergeIssue.setDescription(conflict.getConflictDescription()
						.getResolvedDescription());

				MergingProposal myProposal = ChangeFactory.eINSTANCE
						.createMergingProposal();
				mergeIssue.getProposals().add(myProposal);
				myProposal.setName("My Changes");
				for (AbstractOperation myOp : myOperations) {
					myProposal.getPendingOperations().add(
							(AbstractOperation) EcoreUtil.copy(myOp));
				}

				MergingProposal theirProposal = ChangeFactory.eINSTANCE
						.createMergingProposal();
				mergeIssue.getProposals().add(theirProposal);
				theirProposal.setName("Changes from Repository");
				for (AbstractOperation theirOp : theirOptions) {
					theirProposal.getPendingOperations().add(
							(AbstractOperation) EcoreUtil.copy(theirOp));
				}
			}
		}.run();
	}

	private void addToContainer(UnicaseModelElement modelElement,
			EObject eContainer) {
		if (eContainer == null) {
			throw new IllegalStateException(
					"Couldn't add modelelement to project.");
		}
		if (eContainer instanceof LeafSection) {
			((LeafSection) eContainer).getModelElements().add(modelElement);
		} else if (eContainer instanceof Project) {
			((Project) eContainer).getModelElements().add(modelElement);
		} else {
			addToContainer(modelElement, eContainer.eContainer());
		}
	}

	public void setConflict(Conflict conflict) {
		this.conflict = conflict;
	}
}
