/**
 * UserManagementServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.geomod.components.cmdecarte.primar.UserManagementService;

import org.apache.axis.AxisFault;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.URL;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;


public class UserManagementServiceServiceLocator extends Service implements UserManagementServiceService {

    public UserManagementServiceServiceLocator() {
    }


    public UserManagementServiceServiceLocator(EngineConfiguration config) {
        super(config);
    }

    public UserManagementServiceServiceLocator(String wsdlLoc, QName sName) throws ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UserManagementService
    private String UserManagementService_address = "https://qaprimar.ecc.no/qaprimar/services_basic/UserManagementService";

    public String getUserManagementServiceAddress() {
        return UserManagementService_address;
    }

    // The WSDD service name defaults to the port name.
    private String UserManagementServiceWSDDServiceName = "UserManagementService";

    public String getUserManagementServiceWSDDServiceName() {
        return UserManagementServiceWSDDServiceName;
    }

    public void setUserManagementServiceWSDDServiceName(String name) {
        UserManagementServiceWSDDServiceName = name;
    }

    public UserManagementService getUserManagementService() throws ServiceException {
       URL endpoint;
        try {
            endpoint = new URL(UserManagementService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new ServiceException(e);
        }
        return getUserManagementService(endpoint);
    }

    public UserManagementService getUserManagementService(URL portAddress) throws ServiceException {
        try {
            UserManagementServiceSoapBindingStub _stub = new UserManagementServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getUserManagementServiceWSDDServiceName());
            return _stub;
        }
        catch (AxisFault e) {
            return null;
        }
    }

    public void setUserManagementServiceEndpointAddress(String address) {
        UserManagementService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
        try {
            if (UserManagementService.class.isAssignableFrom(serviceEndpointInterface)) {
                UserManagementServiceSoapBindingStub _stub = new UserManagementServiceSoapBindingStub(new URL(UserManagementService_address), this);
                _stub.setPortName(getUserManagementServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new ServiceException(t);
        }
        throw new ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public Remote getPort(QName portName, Class serviceEndpointInterface) throws ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("UserManagementService".equals(inputPortName)) {
            return getUserManagementService();
        }
        else  {
            Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public QName getServiceName() {
        return new QName("https://qaprimar.ecc.no/qaprimar/services_basic/UserManagementService", "UserManagementServiceService");
    }

    private HashSet ports = null;

    public Iterator getPorts() {
        if (ports == null) {
            ports = new HashSet();
            ports.add(new QName("https://qaprimar.ecc.no/qaprimar/services_basic/UserManagementService", "UserManagementService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws ServiceException {
        
if ("UserManagementService".equals(portName)) {
            setUserManagementServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(QName portName, String address) throws ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
