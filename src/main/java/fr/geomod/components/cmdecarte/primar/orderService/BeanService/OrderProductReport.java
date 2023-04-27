/**
 * OrderProductReport.java
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
import java.math.BigDecimal;
import java.util.Calendar;

public class OrderProductReport  implements Serializable {
    private Integer countryId;

    private BigDecimal discountedPrice;

    private BigDecimal distributorRetailPrice;

    private Calendar permitEndDate;

    private String priceBandName;

    private BigDecimal productDiscount;

    private String productId;

    private BigDecimal productPrice;

    private String productTypeName;

    private Integer quantity;

    private String subscriptionTypeName;

    public OrderProductReport() {
    }

    public OrderProductReport(
           Integer countryId,
           BigDecimal discountedPrice,
           BigDecimal distributorRetailPrice,
           Calendar permitEndDate,
           String priceBandName,
           BigDecimal productDiscount,
           String productId,
           BigDecimal productPrice,
           String productTypeName,
           Integer quantity,
           String subscriptionTypeName) {
           this.countryId = countryId;
           this.discountedPrice = discountedPrice;
           this.distributorRetailPrice = distributorRetailPrice;
           this.permitEndDate = permitEndDate;
           this.priceBandName = priceBandName;
           this.productDiscount = productDiscount;
           this.productId = productId;
           this.productPrice = productPrice;
           this.productTypeName = productTypeName;
           this.quantity = quantity;
           this.subscriptionTypeName = subscriptionTypeName;
    }


    /**
     * Gets the countryId value for this OrderProductReport.
     * 
     * @return countryId
     */
    public Integer getCountryId() {
        return countryId;
    }


    /**
     * Sets the countryId value for this OrderProductReport.
     * 
     * @param countryId
     */
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }


    /**
     * Gets the discountedPrice value for this OrderProductReport.
     * 
     * @return discountedPrice
     */
    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }


    /**
     * Sets the discountedPrice value for this OrderProductReport.
     * 
     * @param discountedPrice
     */
    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }


    /**
     * Gets the distributorRetailPrice value for this OrderProductReport.
     * 
     * @return distributorRetailPrice
     */
    public BigDecimal getDistributorRetailPrice() {
        return distributorRetailPrice;
    }


    /**
     * Sets the distributorRetailPrice value for this OrderProductReport.
     * 
     * @param distributorRetailPrice
     */
    public void setDistributorRetailPrice(BigDecimal distributorRetailPrice) {
        this.distributorRetailPrice = distributorRetailPrice;
    }


    /**
     * Gets the permitEndDate value for this OrderProductReport.
     * 
     * @return permitEndDate
     */
    public Calendar getPermitEndDate() {
        return permitEndDate;
    }


    /**
     * Sets the permitEndDate value for this OrderProductReport.
     * 
     * @param permitEndDate
     */
    public void setPermitEndDate(Calendar permitEndDate) {
        this.permitEndDate = permitEndDate;
    }


    /**
     * Gets the priceBandName value for this OrderProductReport.
     * 
     * @return priceBandName
     */
    public String getPriceBandName() {
        return priceBandName;
    }


    /**
     * Sets the priceBandName value for this OrderProductReport.
     * 
     * @param priceBandName
     */
    public void setPriceBandName(String priceBandName) {
        this.priceBandName = priceBandName;
    }


    /**
     * Gets the productDiscount value for this OrderProductReport.
     * 
     * @return productDiscount
     */
    public BigDecimal getProductDiscount() {
        return productDiscount;
    }


    /**
     * Sets the productDiscount value for this OrderProductReport.
     * 
     * @param productDiscount
     */
    public void setProductDiscount(BigDecimal productDiscount) {
        this.productDiscount = productDiscount;
    }


    /**
     * Gets the productId value for this OrderProductReport.
     * 
     * @return productId
     */
    public String getProductId() {
        return productId;
    }


    /**
     * Sets the productId value for this OrderProductReport.
     * 
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }


    /**
     * Gets the productPrice value for this OrderProductReport.
     * 
     * @return productPrice
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }


    /**
     * Sets the productPrice value for this OrderProductReport.
     * 
     * @param productPrice
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }


    /**
     * Gets the productTypeName value for this OrderProductReport.
     * 
     * @return productTypeName
     */
    public String getProductTypeName() {
        return productTypeName;
    }


    /**
     * Sets the productTypeName value for this OrderProductReport.
     * 
     * @param productTypeName
     */
    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }


    /**
     * Gets the quantity value for this OrderProductReport.
     * 
     * @return quantity
     */
    public Integer getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this OrderProductReport.
     * 
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the subscriptionTypeName value for this OrderProductReport.
     * 
     * @return subscriptionTypeName
     */
    public String getSubscriptionTypeName() {
        return subscriptionTypeName;
    }


    /**
     * Sets the subscriptionTypeName value for this OrderProductReport.
     * 
     * @param subscriptionTypeName
     */
    public void setSubscriptionTypeName(String subscriptionTypeName) {
        this.subscriptionTypeName = subscriptionTypeName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof OrderProductReport)) return false;
        OrderProductReport other = (OrderProductReport) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.countryId==null && other.getCountryId()==null) || 
             (this.countryId!=null &&
              this.countryId.equals(other.getCountryId()))) &&
            ((this.discountedPrice==null && other.getDiscountedPrice()==null) || 
             (this.discountedPrice!=null &&
              this.discountedPrice.equals(other.getDiscountedPrice()))) &&
            ((this.distributorRetailPrice==null && other.getDistributorRetailPrice()==null) || 
             (this.distributorRetailPrice!=null &&
              this.distributorRetailPrice.equals(other.getDistributorRetailPrice()))) &&
            ((this.permitEndDate==null && other.getPermitEndDate()==null) || 
             (this.permitEndDate!=null &&
              this.permitEndDate.equals(other.getPermitEndDate()))) &&
            ((this.priceBandName==null && other.getPriceBandName()==null) || 
             (this.priceBandName!=null &&
              this.priceBandName.equals(other.getPriceBandName()))) &&
            ((this.productDiscount==null && other.getProductDiscount()==null) || 
             (this.productDiscount!=null &&
              this.productDiscount.equals(other.getProductDiscount()))) &&
            ((this.productId==null && other.getProductId()==null) || 
             (this.productId!=null &&
              this.productId.equals(other.getProductId()))) &&
            ((this.productPrice==null && other.getProductPrice()==null) || 
             (this.productPrice!=null &&
              this.productPrice.equals(other.getProductPrice()))) &&
            ((this.productTypeName==null && other.getProductTypeName()==null) || 
             (this.productTypeName!=null &&
              this.productTypeName.equals(other.getProductTypeName()))) &&
            ((this.quantity==null && other.getQuantity()==null) || 
             (this.quantity!=null &&
              this.quantity.equals(other.getQuantity()))) &&
            ((this.subscriptionTypeName==null && other.getSubscriptionTypeName()==null) || 
             (this.subscriptionTypeName!=null &&
              this.subscriptionTypeName.equals(other.getSubscriptionTypeName())));
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
        if (getCountryId() != null) {
            _hashCode += getCountryId().hashCode();
        }
        if (getDiscountedPrice() != null) {
            _hashCode += getDiscountedPrice().hashCode();
        }
        if (getDistributorRetailPrice() != null) {
            _hashCode += getDistributorRetailPrice().hashCode();
        }
        if (getPermitEndDate() != null) {
            _hashCode += getPermitEndDate().hashCode();
        }
        if (getPriceBandName() != null) {
            _hashCode += getPriceBandName().hashCode();
        }
        if (getProductDiscount() != null) {
            _hashCode += getProductDiscount().hashCode();
        }
        if (getProductId() != null) {
            _hashCode += getProductId().hashCode();
        }
        if (getProductPrice() != null) {
            _hashCode += getProductPrice().hashCode();
        }
        if (getProductTypeName() != null) {
            _hashCode += getProductTypeName().hashCode();
        }
        if (getQuantity() != null) {
            _hashCode += getQuantity().hashCode();
        }
        if (getSubscriptionTypeName() != null) {
            _hashCode += getSubscriptionTypeName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(OrderProductReport.class, true);

    static {
        typeDesc.setXmlType(new QName("urn:BeanService", "OrderProductReport"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("countryId");
        elemField.setXmlName(new QName("", "countryId"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("discountedPrice");
        elemField.setXmlName(new QName("", "discountedPrice"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("distributorRetailPrice");
        elemField.setXmlName(new QName("", "distributorRetailPrice"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("permitEndDate");
        elemField.setXmlName(new QName("", "permitEndDate"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("priceBandName");
        elemField.setXmlName(new QName("", "priceBandName"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("productDiscount");
        elemField.setXmlName(new QName("", "productDiscount"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("productId");
        elemField.setXmlName(new QName("", "productId"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("productPrice");
        elemField.setXmlName(new QName("", "productPrice"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("productTypeName");
        elemField.setXmlName(new QName("", "productTypeName"));
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
        elemField.setFieldName("subscriptionTypeName");
        elemField.setXmlName(new QName("", "subscriptionTypeName"));
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
