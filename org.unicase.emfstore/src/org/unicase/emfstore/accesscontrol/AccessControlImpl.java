package org.unicase.emfstore.accesscontrol;

import java.util.Set;

import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.model.ModelElement;

public class AccessControlImpl implements AuthenticationControl, AuthorizationControl {

	public SessionId logIn(String username, String password)
			throws AccessControlException {
		return EsmodelFactory.eINSTANCE.createSessionId();
	}

	public void checkReadAccess(SessionId sessionId, ProjectId projectId) {
		// TODO Auto-generated method stub
		
	}

	public void checkSession(SessionId sessionId) {
		// TODO Auto-generated method stub
		
	}

	public void checkWriteAccess(SessionId sessionId, ProjectId projectId,
			Set<ModelElement> modelElements) {
		// TODO Auto-generated method stub
		
	}

	public Role getRole(SessionId sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
