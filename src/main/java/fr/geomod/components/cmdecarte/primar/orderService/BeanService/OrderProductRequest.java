/**
 * OrderProductRequest.java
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

public class OrderProductRequest  implements Serializable {
    private String productId;

    private Integer quantity;

    private Integer subscriptionTypeId;

    public OrderProductRequest() {
    }

    public OrderProductRequest(
           String productId,
           Integer quantity,
           Integer subscriptionTypeId) {
           this.productId = productId;
           this.quantity = quantity;
           this.subscriptionTypeId = subscriptionTypeId;
    }


    /**
     * Gets the productId value for this OrderProductRequest.
     * 
     * @return productId
     */
    public String getProductId() {
        return productId;
    }


    /**
     * Sets the productId value for this OrderProductRequest.
     * 
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }


    /**
     * Gets the quantity value for this OrderProductRequest.
     * 
     * @return quantity
     */
    public Integer getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this OrderProductRequest.
     * 
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the subscriptionTypeId value for this OrderProductRequest.
     * 
     * @return subscriptionTypeId
     */
    public Integer getSubscriptionTypeId() {
        return subscriptionTypeId;
    }


    /**
     * Sets the subscriptionTypeId value for this OrderProductRequest.
     * 
     * @param subscriptionTypeId
     */
    public void setSubscriptionTypeId(Integer subscriptionTypeId) {
        this.subscriptionTypeId = subscriptionTypeId;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof OrderProductRequest)) return false;
        OrderProductRequest other = (OrderProductRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.productId==null && other.getProductId()==null) || 
             (this.productId!=null &&
              this.productId.equals(other.getProductId()))) &&
            ((this.quantity==null && other.getQuantity()==null) || 
             (this.quantity!=null &&
              this.quantity.equals(other.getQuantity()))) &&
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
        if (getProductId() != null) {
            _hashCode += getProductId().hashCode();
        }
        if (getQuantity() != null) {
            _hashCode += getQuantity().hashCode();
        }
        if (getSubscriptionTypeId() != null) {
            _hashCode += getSubscriptionTypeId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(OrderProductRequest.class, true);

    static {
        typeDesc.setXmlType(new QName("urn:BeanService", "OrderProductRequest"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("productId");
        elemField.setXmlName(new QName("", "productId"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("quantity");
        elemField.setXmlName(new QName("", "quantity"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
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
