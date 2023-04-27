/**
 * PermitEndDateRequest.java
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
import java.util.Calendar;

public class PermitEndDateRequest  implements Serializable {
    private Calendar requestedEndDate;

    private Integer subscriptionTypeId;

    public PermitEndDateRequest() {
    }

    public PermitEndDateRequest(
           Calendar requestedEndDate,
           Integer subscriptionTypeId) {
           this.requestedEndDate = requestedEndDate;
           this.subscriptionTypeId = subscriptionTypeId;
    }


    /**
     * Gets the requestedEndDate value for this PermitEndDateRequest.
     * 
     * @return requestedEndDate
     */
    public Calendar getRequestedEndDate() {
        return requestedEndDate;
    }


    /**
     * Sets the requestedEndDate value for this PermitEndDateRequest.
     * 
     * @param requestedEndDate
     */
    public void setRequestedEndDate(Calendar requestedEndDate) {
        this.requestedEndDate = requestedEndDate;
    }


    /**
     * Gets the subscriptionTypeId value for this PermitEndDateRequest.
     * 
     * @return subscriptionTypeId
     */
    public Integer getSubscriptionTypeId() {
        return subscriptionTypeId;
    }


    /**
     * Sets the subscriptionTypeId value for this PermitEndDateRequest.
     * 
     * @param subscriptionTypeId
     */
    public void setSubscriptionTypeId(Integer subscriptionTypeId) {
        this.subscriptionTypeId = subscriptionTypeId;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof PermitEndDateRequest)) return false;
        PermitEndDateRequest other = (PermitEndDateRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.requestedEndDate==null && other.getRequestedEndDate()==null) || 
             (this.requestedEndDate!=null &&
              this.requestedEndDate.equals(other.getRequestedEndDate()))) &&
            ((this.subscriptionTypeId==null && other.getSubscriptionTypeId()==null) || 
             (this.subscriptionTypeId!=null &&
              this.subscriptionTypeId.equals(other.getSubscriptionTypeId())));
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
        if (getRequestedEndDate() != null) {
            _hashCode += getRequestedEndDate().hashCode();
        }
        if (getSubscriptionTypeId() != null) {
            _hashCode += getSubscriptionTypeId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(PermitEndDateRequest.class, true);

    static {
        typeDesc.setXmlType(new QName("urn:BeanService", "PermitEndDateRequest"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("requestedEndDate");
        elemField.setXmlName(new QName("", "requestedEndDate"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("subscriptionTypeId");
        elemField.setXmlName(new QName("", "subscriptionTypeId"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
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
