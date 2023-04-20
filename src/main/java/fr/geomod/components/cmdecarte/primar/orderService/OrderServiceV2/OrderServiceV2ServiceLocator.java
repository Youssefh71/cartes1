/**
 * OrderServiceV2ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.geomod.components.cmdecarte.primar.orderService.OrderServiceV2;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;

public class OrderServiceV2ServiceLocator extends Service implements OrderServiceV2Service {

    public OrderServiceV2ServiceLocator() {
    }


    public OrderServiceV2ServiceLocator(EngineConfiguration config) {
        super(config);
    }

    public OrderServiceV2ServiceLocator(String wsdlLoc, QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OrderServiceV2
    private String OrderServiceV2_address = "https://qaprimar.ecc.no/qaprimar/services_basic/OrderServiceV2";

    public String getOrderServiceV2Address() {
        return OrderServiceV2_address;
    }

    // The WSDD service name defaults to the port name.
    private String OrderServiceV2WSDDServiceName = "OrderServiceV2";

    public String getOrderServiceV2WSDDServiceName() {
        return OrderServiceV2WSDDServiceName;
    }

    public void setOrderServiceV2WSDDServiceName(String name) {
        OrderServiceV2WSDDServiceName = name;
    }

    public OrderServiceV2 getOrderServiceV2() throws ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OrderServiceV2_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new ServiceException(e);
        }
        return getOrderServiceV2(endpoint);
    }

    public OrderServiceV2 getOrderServiceV2(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            OrderServiceV2SoapBindingStub _stub = new OrderServiceV2SoapBindingStub(portAddress, this);
            _stub.setPortName(getOrderServiceV2WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOrderServiceV2EndpointAddress(String address) {
        OrderServiceV2_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (OrderServiceV2.class.isAssignableFrom(serviceEndpointInterface)) {
                OrderServiceV2SoapBindingStub _stub = new OrderServiceV2SoapBindingStub(new java.net.URL(OrderServiceV2_address), this);
                _stub.setPortName(getOrderServiceV2WSDDServiceName());
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
        if ("OrderServiceV2".equals(inputPortName)) {
            return getOrderServiceV2();
        }
        else  {
            Remote _stub = getPort(serviceEndpointInterface);
            ((Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public QName getServiceName() {
        return new QName("https://qaprimar.ecc.no/qaprimar/services_basic/OrderServiceV2", "OrderServiceV2Service");
    }

    private HashSet ports = null;

    public Iterator getPorts() {
        if (ports == null) {
            ports = new HashSet();
            ports.add(new QName("https://qaprimar.ecc.no/qaprimar/services_basic/OrderServiceV2", "OrderServiceV2"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws ServiceException {

if ("OrderServiceV2".equals(portName)) {
            setOrderServiceV2EndpointAddress(address);
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
