/**
 * OrderServiceV2SoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.geomod.components.cmdecarte.primar.orderService.OrderServiceV2;

import fr.geomod.components.cmdecarte.primar.orderService.BeanService.OrderProductReport;
import fr.geomod.components.cmdecarte.primar.orderService.BeanService.OrderProductRequest;
import fr.geomod.components.cmdecarte.primar.orderService.BeanService.OrderReport;
import fr.geomod.components.cmdecarte.primar.orderService.BeanService.OrderRequest;
import fr.geomod.components.cmdecarte.primar.orderService.BeanService.PermitEndDateRequest;
import org.apache.axis.client.Stub;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.DeserializerFactory;
import org.apache.axis.encoding.SerializerFactory;
import org.apache.axis.encoding.ser.ArrayDeserializerFactory;
import org.apache.axis.encoding.ser.ArraySerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.encoding.ser.EnumDeserializerFactory;
import org.apache.axis.encoding.ser.EnumSerializerFactory;
import org.apache.axis.encoding.ser.SimpleDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListSerializerFactory;
import org.apache.axis.encoding.ser.SimpleSerializerFactory;


import javax.xml.namespace.QName;
import java.math.BigDecimal;

public class OrderServiceV2SoapBindingStub extends Stub implements OrderServiceV2 {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static OperationDesc[] _operations;

    static {
        _operations = new OperationDesc[9];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        OperationDesc oper;
        ParameterDesc param;
        oper = new OperationDesc();
        oper.setName("updateOrderReportDistMargin");
        param = new ParameterDesc(new QName("", "orderId"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Integer.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("", "percent"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"), BigDecimal.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new QName("", "updateOrderReportDistMarginReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new OperationDesc();
        oper.setName("placeOrderSENC");
        param = new ParameterDesc(new QName("", "orderRequest"), ParameterDesc.IN, new QName("urn:BeanService", "OrderRequest"), OrderRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new QName("", "placeOrderSENCReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new OperationDesc();
        oper.setName("activateOrderAndSendPermitsByMail");
        param = new ParameterDesc(new QName("", "orderId"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Integer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new QName("", "activateOrderAndSendPermitsByMailReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new OperationDesc();
        oper.setName("activateOrderAndSendPermitsByMailForYearAndWeek");
        param = new ParameterDesc(new QName("", "orderId"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Integer.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("", "year"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("", "week"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new QName("", "activateOrderAndSendPermitsByMailForYearAndWeekReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new OperationDesc();
        oper.setName("placeOrder");
        param = new ParameterDesc(new QName("", "orderRequest"), ParameterDesc.IN, new QName("urn:BeanService", "OrderRequest"), OrderRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new QName("", "placeOrderReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new OperationDesc();
        oper.setName("activateOrder");
        param = new ParameterDesc(new QName("", "orderId"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Integer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new QName("", "activateOrderReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new OperationDesc();
        oper.setName("cancelOrder");
        param = new ParameterDesc(new QName("", "orderId"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Integer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new QName("", "cancelOrderReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new OperationDesc();
        oper.setName("getOrderReport");
        param = new ParameterDesc(new QName("", "orderId"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Integer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("urn:BeanService", "OrderReport"));
        oper.setReturnClass(OrderReport.class);
        oper.setReturnQName(new QName("", "getOrderReportReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new OperationDesc();
        oper.setName("getIsQuotation");
        param = new ParameterDesc(new QName("", "orderId"), ParameterDesc.IN, new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Integer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new QName("", "getIsQuotationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

    }

    public OrderServiceV2SoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public OrderServiceV2SoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public OrderServiceV2SoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new QName("https://qaprimar.ecc.no/qaprimar/services_basic/OrderServiceV2", "ArrayOf_tns1_OrderProductReport");
            cachedSerQNames.add(qName);
            cls = OrderProductReport[].class;
            cachedSerClasses.add(cls);
            qName = new QName("urn:BeanService", "OrderProductReport");
            qName2 = null;
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("https://qaprimar.ecc.no/qaprimar/services_basic/OrderServiceV2", "ArrayOf_tns1_OrderProductRequest");
            cachedSerQNames.add(qName);
            cls = OrderProductRequest[].class;
            cachedSerClasses.add(cls);
            qName = new QName("urn:BeanService", "OrderProductRequest");
            qName2 = null;
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("https://qaprimar.ecc.no/qaprimar/services_basic/OrderServiceV2", "ArrayOf_tns1_PermitEndDateRequest");
            cachedSerQNames.add(qName);
            cls = PermitEndDateRequest[].class;
            cachedSerClasses.add(cls);
            qName = new QName("urn:BeanService", "PermitEndDateRequest");
            qName2 = null;
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("urn:BeanService", "OrderProductReport");
            cachedSerQNames.add(qName);
            cls = OrderProductReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("urn:BeanService", "OrderProductRequest");
            cachedSerQNames.add(qName);
            cls = OrderProductRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("urn:BeanService", "OrderReport");
            cachedSerQNames.add(qName);
            cls = OrderReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("urn:BeanService", "OrderRequest");
            cachedSerQNames.add(qName);
            cls = OrderRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("urn:BeanService", "PermitEndDateRequest");
            cachedSerQNames.add(qName);
            cls = PermitEndDateRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
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
            java.util.Enumeration keys = super.cachedProperties.keys();
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
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            SerializerFactory sf = (SerializerFactory)
                                 cachedSerFactories.get(i);
                            DeserializerFactory df = (DeserializerFactory)
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

    public boolean updateOrderReportDistMargin(Integer orderId, BigDecimal percent) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "updateOrderReportDistMargin"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {orderId, percent});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Boolean) _resp).booleanValue();
            } catch (Exception _exception) {
                return ((Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int placeOrderSENC(OrderRequest orderRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "placeOrderSENC"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {orderRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Integer) _resp).intValue();
            } catch (Exception _exception) {
                return ((Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean activateOrderAndSendPermitsByMail(Integer orderId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "activateOrderAndSendPermitsByMail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {orderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Boolean) _resp).booleanValue();
            } catch (Exception _exception) {
                return ((Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean activateOrderAndSendPermitsByMailForYearAndWeek(Integer orderId, int year, int week) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "activateOrderAndSendPermitsByMailForYearAndWeek"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {orderId, new Integer(year), new Integer(week)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Boolean) _resp).booleanValue();
            } catch (Exception _exception) {
                return ((Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int placeOrder(OrderRequest orderRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "placeOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {orderRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Integer) _resp).intValue();
            } catch (Exception _exception) {
                return ((Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean activateOrder(Integer orderId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "activateOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {orderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Boolean) _resp).booleanValue();
            } catch (Exception _exception) {
                return ((Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean cancelOrder(Integer orderId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "cancelOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {orderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Boolean) _resp).booleanValue();
            } catch (Exception _exception) {
                return ((Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public OrderReport getOrderReport(Integer orderId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "getOrderReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {orderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (OrderReport) _resp;
            } catch (Exception _exception) {
                return (OrderReport) org.apache.axis.utils.JavaUtils.convert(_resp, OrderReport.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean getIsQuotation(Integer orderId) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://ws.gds.ecc.no", "getIsQuotation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {orderId});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((Boolean) _resp).booleanValue();
            } catch (Exception _exception) {
                return ((Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
