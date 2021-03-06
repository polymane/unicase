/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption.OptionType;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Main class representing a conflict. it offers all kind of convenience methods
 * and organizes the conflicts initialization. Read the constructor's
 * description for further implemenation details (
 * {@link #Conflict(List, List, DecisionManager)})
 * 
 * @author wesendon
 */
public abstract class Conflict extends Observable {

	private DecisionManager decisionManager;
	private ArrayList<ConflictOption> options;
	private ConflictOption solution;
	private ConflictContext conflictContext;
	private ConflictDescription conflictDescription;

	/**
	 * List of operations.
	 * 
	 * @see #Conflict(List, List, DecisionManager)
	 */
	protected List<AbstractOperation> operationsA;
	protected List<AbstractOperation> operationsB;

	/**
	 * Default constructor for conflicts. Many conflicts only need one operation
	 * for my and their side. But in order to use a suitable upper class for all
	 * conflicts, conflicts requires a list of operations. opsA ~ myOperations,
	 * opsB ~ theirOperations, but again, to keep it general, it's called A and
	 * B. These fields are protected so the implementing Conflict should create
	 * it's own getter method.
	 * 
	 * @param opsA
	 *            first list of operations (often: myOperations)
	 * @param opsB
	 *            second list of operations (often: theirOperations)
	 * @param decisionManager
	 *            decision manager
	 */
	public Conflict(List<AbstractOperation> opsA, List<AbstractOperation> opsB,
			DecisionManager decisionManager) {
		this(opsA, opsB, decisionManager, true);
	}

	/**
	 * Additional constructor, which allows deactivating initialization.
	 * 
	 * @see #Conflict(List, List, DecisionManager)
	 * @param opsA
	 *            first list of operations (often: myOperations)
	 * @param opsB
	 *            second list of operations (often: theirOperations)
	 * @param decisionManager
	 *            decision manager
	 * @param init
	 *            allows to deactivate initialization, has to be done manually
	 *            otherwise.
	 */
	public Conflict(List<AbstractOperation> opsA, List<AbstractOperation> opsB,
			DecisionManager decisionManager, boolean init) {
		this.operationsA = opsA;
		this.operationsB = opsB;
		this.decisionManager = decisionManager;
		if (init) {
			init();
		}
	}

	/**
	 * Initiates the conflict.
	 */
	protected void init() {
		conflictContext = initConflictContext();
		conflictDescription = initConflictDescription();
		options = new ArrayList<ConflictOption>();
		initConflictOptions(options);
		initAdditionalConflictOptions(options);
	}

	private void initAdditionalConflictOptions(
			ArrayList<ConflictOption> options2) {
		if (!allowOtherOptions()) {
			return;
		}
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"org.unicase.workspace.ui.merge.customoption");

		for (IConfigurationElement e : config) {
			try {
				Object object = e.createExecutableExtension("class");
				if (object instanceof CustomConflictOptionFactory) {

					CustomConflictOptionFactory factory = (CustomConflictOptionFactory) object;
					if (factory.isApplicableConflict(this)) {
						CustomConflictOption customConflictOption = factory
								.createCustomConflictOption(this);
						if (customConflictOption != null) {
							options.add(customConflictOption);
						}
					}

				}
			} catch (CoreException e1) {
				WorkspaceUtil.logException(
						"Couldn't load merge option extension point.", e1);
				// fail silently
			}
		}
	}

	/**
	 * Defines whether other option should be allowed via extension. E.g. Issue
	 * option.
	 * 
	 * @return true, if other options are allowed
	 */
	protected boolean allowOtherOptions() {
		return true;
	}

	/**
	 * Is called in order to init the options.
	 * 
	 * @param options
	 *            list of options
	 */
	protected abstract void initConflictOptions(List<ConflictOption> options);

	/**
	 * Init conflict description.
	 * 
	 * @return description
	 */
	protected abstract ConflictDescription initConflictDescription();

	/**
	 * Inits the ConflictContext.
	 * 
	 * @return context.
	 */
	protected abstract ConflictContext initConflictContext();

	/**
	 * Returns the conflict context.
	 * 
	 * @return context.
	 */
	public ConflictContext getConflictContext() {
		return conflictContext;
	}

	/**
	 * Returns the conflict description.
	 * 
	 * @return conflict description
	 */
	public ConflictDescription getConflictDescription() {
		return conflictDescription;
	}

	/**
	 * Returns the list of options.
	 * 
	 * @return list options
	 */
	public List<ConflictOption> getOptions() {
		return options;
	}

	/**
	 * Returns whether this conflict is resolved.
	 * 
	 * @return true if resolved
	 */
	public boolean isResolved() {
		return (solution != null);
	}

	/**
	 * Checks whether the related options have details.
	 * 
	 * @return true, if at least one got details.
	 */
	public boolean hasDetails() {
		for (ConflictOption option : getOptions()) {
			if (option.isDetailsProvider()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sets an options as solution for this conflict.
	 * 
	 * @param conflictOption
	 *            option
	 */
	public void setSolution(ConflictOption conflictOption) {
		solution = conflictOption;
		if (solution != null) {
			getDecisionManager().getEventLogger().optionSelected(this);
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * Returns the {@link DecisionManager}.
	 * 
	 * @return decisionManager
	 */
	public DecisionManager getDecisionManager() {
		return decisionManager;
	}

	/**
	 * Returns the solution.
	 * 
	 * @return solution
	 */
	public ConflictOption getSolution() {
		return solution;
	}

	/**
	 * This method is used by {@link DecisionManager} in order to create the
	 * resulting operations.
	 * 
	 * @return list of ops.
	 */
	public List<AbstractOperation> getRejectedTheirs() {
		if (!isResolved()) {
			throw new IllegalStateException(
					"Can't call this method, unless conflict is resolved.");
		}
		if (solution.getType() == OptionType.TheirOperation) {
			return new ArrayList<AbstractOperation>();
		} else {
			for (ConflictOption options : getOptions()) {
				if (options.getType() == OptionType.TheirOperation) {
					return options.getOperations();
				}
			}
		}
		throw new IllegalStateException("No TheirOperations found.");
		// return new ArrayList<AbstractOperation>();
	}

	/**
	 * This method is used by {@link DecisionManager} in order to create the
	 * resulting operations.
	 * 
	 * @return list of ops
	 */
	public List<AbstractOperation> getAcceptedMine() {
		if (!isResolved()) {
			throw new IllegalStateException(
					"Can't call this method, unless conflict is resolved.");
		}
		if (solution.getType() == OptionType.TheirOperation) {
			return new ArrayList<AbstractOperation>();
		} else {
			return solution.getOperations();
		}
	}

	/**
	 * Get an option by its type.
	 * 
	 * @param type
	 *            type
	 * @return option or null
	 */
	public ConflictOption getOptionOfType(OptionType type) {
		return DecisionUtil.getConflictOptionByType(getOptions(), type);
	}
}
