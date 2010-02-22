/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict.conflicts;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictContext;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictDescription;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionConfig;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

public class DeletionConflict extends Conflict {

	private final boolean meCausingDelete;

	public DeletionConflict(List<AbstractOperation> deletingOperation,
			List<AbstractOperation> deletedOperations, boolean meCausingDelete,
			DecisionManager decisionManager) {
		super(deletingOperation, deletedOperations, decisionManager, false);
		this.meCausingDelete = meCausingDelete;
		init();
	}

	@Override
	protected ConflictContext initConflictContext() {
		return new ConflictContext(getDecisionManager().getModelElement(
				getDeletingOperation().getModelElementId()), "",
				getDecisionManager().getAuthorForOperation(getTheirOperation()));
	}

	@Override
	protected ConflictDescription initConflictDescription() {
		String description = "";

		if (meCausingDelete) {
			description = "You have deleted the [modelelement]."
					+ " This deletion conflicts with a change on the [firstother]"
					+ " element" + generateOthers()
					+ ". Please choose an option.";
		} else {
			description = "The [modelelement] was deleted on the repository which conflicts with"
					+ " the change on your [firstother]"
					+ generateOthers()
					+ ". Please choose an option.";
		}

		ConflictDescription conflictDescription = new ConflictDescription(
				description);
		conflictDescription.add("modelelement", getDecisionManager()
				.getModelElement(getDeletingOperation().getModelElementId()));
		conflictDescription.add("firstother", getDecisionManager()
				.getModelElement(
						getDeletedOperations().get(0).getModelElementId()));

		conflictDescription.add("otherinvolved", generateOthers());

		conflictDescription.setImage("delete.gif");

		return conflictDescription;
	}

	private String generateOthers() {
		if (getDeletedOperations().size() > 1) {
			return " and " + (getDeletedOperations().size() - 1)
					+ " other elements";
		}
		return "";
	}

	@Override
	protected void initConflictOptions(List<ConflictOption> options) {
		ConflictOption myOption = null;
		ConflictOption theirOption = null;
		if (meCausingDelete) {
			myOption = new ConflictOption(generateDeleteMessage(),
					ConflictOption.OptionType.MyOperation);
			myOption.addOperations(getDeletingOperations());

			theirOption = new ConflictOption(generateKeepMessage(),
					ConflictOption.OptionType.TheirOperation);
			theirOption.addOperations(getDeletedOperations());
			theirOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);
		} else {
			myOption = new ConflictOption(generateKeepMessage(),
					ConflictOption.OptionType.MyOperation);
			myOption.addOperations(getDeletedOperations());
			myOption.setDetailProvider(DecisionConfig.WIDGET_OTHERINVOLVED);

			theirOption = new ConflictOption(generateDeleteMessage(),
					ConflictOption.OptionType.TheirOperation);
			theirOption.addOperations(getDeletingOperations());
		}
		options.add(myOption);
		options.add(theirOption);
	}

	private String generateKeepMessage() {
		ModelElement modelElement = getDecisionManager().getModelElement(
				getDeletedOperations().get(0).getModelElementId());

		String result = "Recover " + DecisionUtil.getClassAndName(modelElement);
		if (getDeletedOperations().size() > 1) {
			result += " and " + (getDeletedOperations().size() - 1)
					+ " other elements";
		}
		return result;
	}

	private String generateDeleteMessage() {
		ModelElement modelElement = getDecisionManager().getModelElement(
				getDeletingOperation().getModelElementId());

		return "Delete " + DecisionUtil.getClassAndName(modelElement);
	}

	private AbstractOperation getDeletingOperation() {
		return operationsA.get(0);
	}

	private List<AbstractOperation> getDeletingOperations() {
		return operationsA;
	}

	private List<AbstractOperation> getDeletedOperations() {
		return operationsB;
	}

	private AbstractOperation getTheirOperation() {
		return (meCausingDelete) ? getDeletedOperations().get(0)
				: getDeletingOperation();
	}
}
