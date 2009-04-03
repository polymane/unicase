package org.unicase.emfstore.core.subinterfaces;

import org.unicase.emfstore.core.AbstractEmfstoreInterface;
import org.unicase.emfstore.core.AbstractSubEmfstoreInterface;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

public class VersionSubInterfaceImpl extends AbstractSubEmfstoreInterface {

	public VersionSubInterfaceImpl(AbstractEmfstoreInterface parentInterface) throws FatalEmfStoreException {
		super(parentInterface);
	}

}
