/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.connectionmanager.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcSunHttpTransportFactory;
import org.unicase.emfstore.connection.xmlrpc.util.EObjectTypeFactory;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * Manager for XML RPC server calls.
 * 
 * @author wesendon
 */
public class XmlRpcClientManager {

	/**
	 * Default constructor.
	 * 
	 * @param serverInterface name of interface
	 */
	public XmlRpcClientManager(String serverInterface) {
		this.serverInterface = serverInterface;
	}

	private String serverInterface;
	private XmlRpcClient client;

	/**
	 * Initializes the connection.
	 * 
	 * @param serverInfo server info
	 * @throws EmfStoreException in case of failure
	 */
	public void initConnection(ServerInfo serverInfo) throws EmfStoreException {
		try {
			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			config.setServerURL(createURL(serverInfo));
			config.setEnabledForExceptions(true);
			config.setEnabledForExtensions(true);
			config.setConnectionTimeout(60 * 1000);
			config.setReplyTimeout(60 * 1000);

			client = new XmlRpcClient();
			client.setTypeFactory(new EObjectTypeFactory(client));
			client.setTransportFactory(new XmlRpcSunHttpTransportFactory(client));
			client.setConfig(config);

			// } catch (XmlRpcException e) {
			// throw new ConnectionException("", e);
		} catch (MalformedURLException e) {
			throw new ConnectionException("Malformed Url or Port", e);
		}
	}

	private URL createURL(ServerInfo serverInfo) throws MalformedURLException {
		// TODO Port-Switch
		return new URL("http", serverInfo.getUrl(), 8080, "xmlrpc");
	}

	/**
	 * Executes a server call with return value.
	 * 
	 * @param <T> return type
	 * @param methodName method name
	 * @param returnType return type
	 * @param parameters parameters
	 * @return returned object from server
	 * @throws EmfStoreException in case of failure
	 */
	public <T> T callWithResult(String methodName, Class<T> returnType, Object... parameters) throws EmfStoreException {
		return executeCall(methodName, returnType, parameters);
	}

	/**
	 * Executes a server call with list return value.
	 * 
	 * @param <T> return type
	 * @param methodName method name
	 * @param returnType list return type
	 * @param parameters parameters
	 * @return list return type
	 * @throws EmfStoreException in case of failure
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> callWithListResult(String methodName, Class<T> returnType, Object... parameters)
		throws EmfStoreException {
		List<T> result = new ArrayList<T>();
		Object[] callResult = executeCall(methodName, Object[].class, parameters);
		if (callResult == null) {
			return result;
		}
		for (Object obj : callResult) {
			result.add((T) obj);
		}
		return result;
	}

	/**
	 * Executes a server call without return value.
	 * 
	 * @param methodName method name
	 * @param parameters parameters
	 * @throws EmfStoreException in case of failure
	 */
	public void call(String methodName, Object... parameters) throws EmfStoreException {
		executeCall(methodName, null, parameters);
	}

	@SuppressWarnings("unchecked")
	private <T> T executeCall(String methodName, Class<T> returnType, Object[] params) throws EmfStoreException {
		if (client == null) {
			throw new ConnectionException(ConnectionManager.REMOTE);
		}
		try {
			return (T) client.execute(serverInterface + "." + methodName, params);
		} catch (XmlRpcException e) {
			if (e.getCause() instanceof EmfStoreException) {
				throw ((EmfStoreException) e.getCause());
			} else {
				throw new ConnectionException(ConnectionManager.REMOTE, e);
			}
		}
	}

}