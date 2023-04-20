/**
 * UserManagementServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.geomod.components.cmdecarte.primar.UserManagementService;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.SerializerFactory;
import org.apache.axis.encoding.ser.*;

import javax.xml.namespace.QName;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;

public class UserManagementServiceSoapBindingStub extends Stub implements UserManagementService {
    private Vector cachedSerClasses = new Vector();
    private Vector cachedSerQNames = new Vector();
    private Vector cachedSerFactories = new Vector();
    private Vector cachedDeserFactories = new Vector();

    static OperationDesc[] _operations;

    static {
        _operations = new OperationDesc[8];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        OperationDesc oper;
        ParameterDesc param;
        oper = new OperationDesc();
        oper.setName("getUserFullName");
        param = new ParameterDesc(new QName("", "username"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("", "getUserFullNameReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new OperationDesc();
        oper.setName("getVesselsForUser");
        param = new ParameterDesc(new QName("", "username"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://qaprimar.ecc.no/qaprimar/services_basic/UserManagementService", "ArrayOf_soapenc_int"));
        oper.setReturnClass(Integer[].class);
        oper.setReturnQName(new QName("", "getVesselsForUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new OperationDesc();
        oper.setName("getUsersForVessel");
        param = new ParameterDesc(new QName("", "vesselId"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Integer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("https://qaprimar.ecc.no/qaprimar/services_basic/UserManagementService", "ArrayOf_soapenc_string"));
        oper.setReturnClass(String[].class);
        oper.setReturnQName(new QName("", "getUsersForVesselReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new OperationDesc();
        oper.setName("setUserPassword");
        param = new ParameterDesc(new QName("", "username"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("", "password"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new OperationDesc();
        oper.setName("setUserFullName");
        param = new ParameterDesc(new QName("", "username"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("", "name"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new OperationDesc();
        oper.setName("addUserToVessel");
        param = new ParameterDesc(new QName("", "username"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("", "vesselId"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Integer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new OperationDesc();
        oper.setName("removeUserFromVessel");
        param = new ParameterDesc(new QName("", "username"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("", "vesselId"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Integer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new OperationDesc();
        oper.setName("createUser");
        param = new ParameterDesc(new QName("", "username"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("", "name"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("", "password"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

    }

    public UserManagementServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public UserManagementServiceSoapBindingStub(java.net.URL endpointURL, Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public UserManagementServiceSoapBindingStub(Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            Class cls;
            QName qName;
            QName qName2;
            Class beansf = BeanSerializerFactory.class;
            Class beandf = BeanDeserializerFactory.class;
            Class enumsf = EnumSerializerFactory.class;
            Class enumdf = EnumDeserializerFactory.class;
            Class arraysf = ArraySerializerFactory.class;
            Class arraydf = ArrayDeserializerFactory.class;
            Class simplesf = SimpleSerializerFactory.class;
            Class simpledf = SimpleDeserializerFactory.class;
            Class simplelistsf = SimpleListSerializerFactory.class;
            Class simplelistdf = SimpleListDeserializerFactory.class;
            qName = new QName("https://qaprimar.ecc.no/qaprimar/services_basic/UserManagementService", "ArrayOf_soapenc_int");
            cachedSerQNames.add(qName);
            cls = Integer[].class;
            cachedSerClasses.add(cls);
            qName = new QName("http://schemas.xmlsoap.org/soap/encoding/", "int");
            qName2 = null;
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("https://qaprimar.ecc.no/qaprimar/services_basic/UserManagementService", "ArrayOf_soapenc_string");
            cachedSerQNames.add(qName);
            cls = String[].class;
            cachedSerClasses.add(cls);
            qName = new QName("http://schemas.xmlsoap.org/soap/encoding/", "string");
            qName2 = null;
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

    }

    protected Call createCall() throws RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        Class cls = (Class) cachedSerClasses.get(i);
                        QName qName =
                                (QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public String getUserFullName(String username) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "getUserFullName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {username});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String) _resp;
            } catch (Exception _exception) {
                return (String) org.apache.axis.utils.JavaUtils.convert(_resp, String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public Integer[] getVesselsForUser(String username) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "getVesselsForUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {username});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Integer[]) _resp;
            } catch (Exception _exception) {
                return (Integer[]) org.apache.axis.utils.JavaUtils.convert(_resp, Integer[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public String[] getUsersForVessel(Integer vesselId) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "getUsersForVessel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {vesselId});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String[]) _resp;
            } catch (Exception _exception) {
                return (String[]) org.apache.axis.utils.JavaUtils.convert(_resp, String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void setUserPassword(String username, String password) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "setUserPassword"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {username, password});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void setUserFullName(String username, String name) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "setUserFullName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {username, name});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void addUserToVessel(String username, Integer vesselId) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "addUserToVessel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {username, vesselId});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void removeUserFromVessel(String username, Integer vesselId) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "removeUserFromVessel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {username, vesselId});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void createUser(String username, String name, String password) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "createUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {username, name, password});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
