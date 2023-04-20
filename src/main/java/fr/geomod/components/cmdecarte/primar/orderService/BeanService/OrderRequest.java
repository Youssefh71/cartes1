/**
 * OrderRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.geomod.components.cmdecarte.primar.orderService.BeanService;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.Arrays;

public class OrderRequest  implements Serializable {
    private String additionalEmail;

    private OrderProductRequest[] orderProducts;

    private PermitEndDateRequest[] permitEndDateRequests;

    private String referenceNumber;

    private String userId;

    public OrderRequest() {
    }

    public OrderRequest(
           String additionalEmail,
           OrderProductRequest[] orderProducts,
           PermitEndDateRequest[] permitEndDateRequests,
           String referenceNumber,
           String userId) {
           this.additionalEmail = additionalEmail;
           this.orderProducts = orderProducts;
           this.permitEndDateRequests = permitEndDateRequests;
           this.referenceNumber = referenceNumber;
           this.userId = userId;
    }


    /**
     * Gets the additionalEmail value for this OrderRequest.
     * 
     * @return additionalEmail
     */
    public String getAdditionalEmail() {
        return additionalEmail;
    }


    /**
     * Sets the additionalEmail value for this OrderRequest.
     * 
     * @param additionalEmail
     */
    public void setAdditionalEmail(String additionalEmail) {
        this.additionalEmail = additionalEmail;
    }


    /**
     * Gets the orderProducts value for this OrderRequest.
     * 
     * @return orderProducts
     */
    public OrderProductRequest[] getOrderProducts() {
        return orderProducts;
    }


    /**
     * Sets the orderProducts value for this OrderRequest.
     * 
     * @param orderProducts
     */
    public void setOrderProducts(OrderProductRequest[] orderProducts) {
        this.orderProducts = orderProducts;
    }


    /**
     * Gets the permitEndDateRequests value for this OrderRequest.
     * 
     * @return permitEndDateRequests
     */
    public PermitEndDateRequest[] getPermitEndDateRequests() {
        return permitEndDateRequests;
    }


    /**
     * Sets the permitEndDateRequests value for this OrderRequest.
     * 
     * @param permitEndDateRequests
     */
    public void setPermitEndDateRequests(PermitEndDateRequest[] permitEndDateRequests) {
        this.permitEndDateRequests = permitEndDateRequests;
    }


    /**
     * Gets the referenceNumber value for this OrderRequest.
     * 
     * @return referenceNumber
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }


    /**
     * Sets the referenceNumber value for this OrderRequest.
     * 
     * @param referenceNumber
     */
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }


    /**
     * Gets the userId value for this OrderRequest.
     * 
     * @return userId
     */
    public String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this OrderRequest.
     * 
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof OrderRequest)) return false;
        OrderRequest other = (OrderRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.additionalEmail==null && other.getAdditionalEmail()==null) || 
             (this.additionalEmail!=null &&
              this.additionalEmail.equals(other.getAdditionalEmail()))) &&
            ((this.orderProducts==null && other.getOrderProducts()==null) || 
             (this.orderProducts!=null &&
              Arrays.equals(this.orderProducts, other.getOrderProducts()))) &&
            ((this.permitEndDateRequests==null && other.getPermitEndDateRequests()==null) || 
             (this.permitEndDateRequests!=null &&
              Arrays.equals(this.permitEndDateRequests, other.getPermitEndDateRequests()))) &&
            ((this.referenceNumber==null && other.getReferenceNumber()==null) || 
             (this.referenceNumber!=null &&
              this.referenceNumber.equals(other.getReferenceNumber()))) &&
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAdditionalEmail() != null) {
            _hashCode += getAdditionalEmail().hashCode();
        }
        if (getOrderProducts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrderProducts());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getOrderProducts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPermitEndDateRequests() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPermitEndDateRequests());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getPermitEndDateRequests(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReferenceNumber() != null) {
            _hashCode += getReferenceNumber().hashCode();
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(OrderRequest.class, true);

    static {
        typeDesc.setXmlType(new QName("urn:BeanService", "OrderRequest"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("additionalEmail");
        elemField.setXmlName(new QName("", "additionalEmail"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("orderProducts");
        elemField.setXmlName(new QName("", "orderProducts"));
        elemField.setXmlType(new QName("urn:BeanService", "OrderProductRequest"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("permitEndDateRequests");
        elemField.setXmlName(new QName("", "permitEndDateRequests"));
        elemField.setXmlType(new QName("urn:BeanService", "PermitEndDateRequest"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("referenceNumber");
        elemField.setXmlName(new QName("", "referenceNumber"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new QName("", "userId"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static Serializer getSerializer(
           String mechType,
           Class _javaType,
           QName _xmlType) {
        return 
          new BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           QName _xmlType) {
        return 
          new BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
