/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict;

import java.util.ArrayList;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

/**
 * This class represents an option/solution for a conflict. A conflict may have
 * several options.
 * 
 * @author wesendon
 */
public class ConflictOption {

	private String option;
	private OptionType type;
	private String detailProvider;
	private List<AbstractOperation> operations;

	/**
	 * Type of options.
	 * 
	 * @author wesendon
	 */
	public enum OptionType {
		/**
		 * 
		 */
		MyOperation, TheirOperation, MergeText, Custom
	};

	/**
	 * Default constructor.
	 * 
	 * @param option
	 *            name of option
	 * @param type
	 *            type
	 */
	public ConflictOption(String option, OptionType type) {
		this.option = option;
		this.type = type;
		operations = new ArrayList<AbstractOperation>();
	}

	/**
	 * Returns the option's label.
	 * 
	 * @return text
	 */
	public String getOptionLabel() {
		return option;
	}

	/**
	 * Sets the option's label.
	 * 
	 * @param option
	 *            text
	 */
	public void setOptionLabel(String option) {
		this.option = option;
	}

	/**
	 * Returns the Option's label with new line characters removed.
	 * 
	 * @return text
	 */
	public String getStrippedOptionLabel() {
		return DecisionUtil.stripNewLine(getOptionLabel());
	}

	/**
	 * Returns the complete option label.
	 * 
	 * @return text
	 */
	public String getFullOptionLabel() {
		return option;
	}

	/**
	 * Returns the type.
	 * 
	 * @return type
	 */
	public OptionType getType() {
		return type;
	}

	/**
	 * Adds the change operations, which will be applied in case, that this
	 * option is selected as solution.
	 * 
	 * @param ops
	 *            operations
	 */
	public void addOperations(List<AbstractOperation> ops) {
		operations.addAll(ops);
	}

	/**
	 * Returns the operations, stored in this option.
	 * 
	 * @return list of operations
	 */
	public List<AbstractOperation> getOperations() {
		return operations;
	}

	/**
	 * Tells whehter option provides details.
	 * 
	 * @return true, if so
	 */
	public boolean isDetailsProvider() {
		return getDetailProvider() != null;
	}

	/**
	 * Sets a detailprovider.
	 * 
	 * @see org.unicase.workspace.ui.dialogs.merge.ui.components.DetailsComponent
	 * 
	 * @param detailProvider
	 *            identifying string
	 */
	public void setDetailProvider(String detailProvider) {
		this.detailProvider = detailProvider;
	}

	/**
	 * Returns detailprovider string.
	 * 
	 * @return detail provider identifier
	 */
	public String getDetailProvider() {
		return detailProvider;
	}

	/**
	 * Returns whether option should be called ({@link #optionChosen()}), if
	 * selected.
	 * 
	 * @return true or false
	 */
	public boolean hasExtraOptionAction() {
		return false;
	}

	/**
	 * Called if Option is chosen in the UI.
	 * 
	 * @return if true, Option will be updated
	 */
	public boolean optionChosen() {
		return false;
	}
}
