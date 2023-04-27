/**
 * OrderReport.java
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
import java.util.Arrays;
import java.util.Calendar;

public class OrderReport  implements Serializable {
    private Integer customerDiscount;

    private String customerName;

    private Integer discountQuantity;

    private Integer distributorDiscount;

    private String distributorDiscountGroupName;

    private BigDecimal distributorMarginPercent;

    private String distributorName;

    private Calendar orderDate;

    private Integer orderId;

    private OrderProductReport[] orderProducts;

    private String referenceNumber;

    private BigDecimal totalDiscountedPrice;

    private BigDecimal totalProductDiscount;

    private BigDecimal totalProductPrice;

    private String vesselName;

    public OrderReport() {
    }

    public OrderReport(
           Integer customerDiscount,
           String customerName,
           Integer discountQuantity,
           Integer distributorDiscount,
           String distributorDiscountGroupName,
           BigDecimal distributorMarginPercent,
           String distributorName,
           Calendar orderDate,
           Integer orderId,
           OrderProductReport[] orderProducts,
           String referenceNumber,
           BigDecimal totalDiscountedPrice,
           BigDecimal totalProductDiscount,
           BigDecimal totalProductPrice,
           String vesselName) {
           this.customerDiscount = customerDiscount;
           this.customerName = customerName;
           this.discountQuantity = discountQuantity;
           this.distributorDiscount = distributorDiscount;
           this.distributorDiscountGroupName = distributorDiscountGroupName;
           this.distributorMarginPercent = distributorMarginPercent;
           this.distributorName = distributorName;
           this.orderDate = orderDate;
           this.orderId = orderId;
           this.orderProducts = orderProducts;
           this.referenceNumber = referenceNumber;
           this.totalDiscountedPrice = totalDiscountedPrice;
           this.totalProductDiscount = totalProductDiscount;
           this.totalProductPrice = totalProductPrice;
           this.vesselName = vesselName;
    }


    /**
     * Gets the customerDiscount value for this OrderReport.
     * 
     * @return customerDiscount
     */
    public Integer getCustomerDiscount() {
        return customerDiscount;
    }


    /**
     * Sets the customerDiscount value for this OrderReport.
     * 
     * @param customerDiscount
     */
    public void setCustomerDiscount(Integer customerDiscount) {
        this.customerDiscount = customerDiscount;
    }


    /**
     * Gets the customerName value for this OrderReport.
     * 
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }


    /**
     * Sets the customerName value for this OrderReport.
     * 
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    /**
     * Gets the discountQuantity value for this OrderReport.
     * 
     * @return discountQuantity
     */
    public Integer getDiscountQuantity() {
        return discountQuantity;
    }


    /**
     * Sets the discountQuantity value for this OrderReport.
     * 
     * @param discountQuantity
     */
    public void setDiscountQuantity(Integer discountQuantity) {
        this.discountQuantity = discountQuantity;
    }


    /**
     * Gets the distributorDiscount value for this OrderReport.
     * 
     * @return distributorDiscount
     */
    public Integer getDistributorDiscount() {
        return distributorDiscount;
    }


    /**
     * Sets the distributorDiscount value for this OrderReport.
     * 
     * @param distributorDiscount
     */
    public void setDistributorDiscount(Integer distributorDiscount) {
        this.distributorDiscount = distributorDiscount;
    }


    /**
     * Gets the distributorDiscountGroupName value for this OrderReport.
     * 
     * @return distributorDiscountGroupName
     */
    public String getDistributorDiscountGroupName() {
        return distributorDiscountGroupName;
    }


    /**
     * Sets the distributorDiscountGroupName value for this OrderReport.
     * 
     * @param distributorDiscountGroupName
     */
    public void setDistributorDiscountGroupName(String distributorDiscountGroupName) {
        this.distributorDiscountGroupName = distributorDiscountGroupName;
    }


    /**
     * Gets the distributorMarginPercent value for this OrderReport.
     * 
     * @return distributorMarginPercent
     */
    public BigDecimal getDistributorMarginPercent() {
        return distributorMarginPercent;
    }


    /**
     * Sets the distributorMarginPercent value for this OrderReport.
     * 
     * @param distributorMarginPercent
     */
    public void setDistributorMarginPercent(BigDecimal distributorMarginPercent) {
        this.distributorMarginPercent = distributorMarginPercent;
    }


    /**
     * Gets the distributorName value for this OrderReport.
     * 
     * @return distributorName
     */
    public String getDistributorName() {
        return distributorName;
    }


    /**
     * Sets the distributorName value for this OrderReport.
     * 
     * @param distributorName
     */
    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }


    /**
     * Gets the orderDate value for this OrderReport.
     * 
     * @return orderDate
     */
    public Calendar getOrderDate() {
        return orderDate;
    }


    /**
     * Sets the orderDate value for this OrderReport.
     * 
     * @param orderDate
     */
    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }


    /**
     * Gets the orderId value for this OrderReport.
     * 
     * @return orderId
     */
    public Integer getOrderId() {
        return orderId;
    }


    /**
     * Sets the orderId value for this OrderReport.
     * 
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    /**
     * Gets the orderProducts value for this OrderReport.
     * 
     * @return orderProducts
     */
    public OrderProductReport[] getOrderProducts() {
        return orderProducts;
    }


    /**
     * Sets the orderProducts value for this OrderReport.
     * 
     * @param orderProducts
     */
    public void setOrderProducts(OrderProductReport[] orderProducts) {
        this.orderProducts = orderProducts;
    }


    /**
     * Gets the referenceNumber value for this OrderReport.
     * 
     * @return referenceNumber
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }


    /**
     * Sets the referenceNumber value for this OrderReport.
     * 
     * @param referenceNumber
     */
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }


    /**
     * Gets the totalDiscountedPrice value for this OrderReport.
     * 
     * @return totalDiscountedPrice
     */
    public BigDecimal getTotalDiscountedPrice() {
        return totalDiscountedPrice;
    }


    /**
     * Sets the totalDiscountedPrice value for this OrderReport.
     * 
     * @param totalDiscountedPrice
     */
    public void setTotalDiscountedPrice(BigDecimal totalDiscountedPrice) {
        this.totalDiscountedPrice = totalDiscountedPrice;
    }


    /**
     * Gets the totalProductDiscount value for this OrderReport.
     * 
     * @return totalProductDiscount
     */
    public BigDecimal getTotalProductDiscount() {
        return totalProductDiscount;
    }


    /**
     * Sets the totalProductDiscount value for this OrderReport.
     * 
     * @param totalProductDiscount
     */
    public void setTotalProductDiscount(BigDecimal totalProductDiscount) {
        this.totalProductDiscount = totalProductDiscount;
    }


    /**
     * Gets the totalProductPrice value for this OrderReport.
     * 
     * @return totalProductPrice
     */
    public BigDecimal getTotalProductPrice() {
        return totalProductPrice;
    }


    /**
     * Sets the totalProductPrice value for this OrderReport.
     * 
     * @param totalProductPrice
     */
    public void setTotalProductPrice(BigDecimal totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }


    /**
     * Gets the vesselName value for this OrderReport.
     * 
     * @return vesselName
     */
    public String getVesselName() {
        return vesselName;
    }


    /**
     * Sets the vesselName value for this OrderReport.
     * 
     * @param vesselName
     */
    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof OrderReport)) return false;
        OrderReport other = (OrderReport) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customerDiscount==null && other.getCustomerDiscount()==null) || 
             (this.customerDiscount!=null &&
              this.customerDiscount.equals(other.getCustomerDiscount()))) &&
            ((this.customerName==null && other.getCustomerName()==null) || 
             (this.customerName!=null &&
              this.customerName.equals(other.getCustomerName()))) &&
            ((this.discountQuantity==null && other.getDiscountQuantity()==null) || 
             (this.discountQuantity!=null &&
              this.discountQuantity.equals(other.getDiscountQuantity()))) &&
            ((this.distributorDiscount==null && other.getDistributorDiscount()==null) || 
             (this.distributorDiscount!=null &&
              this.distributorDiscount.equals(other.getDistributorDiscount()))) &&
            ((this.distributorDiscountGroupName==null && other.getDistributorDiscountGroupName()==null) || 
             (this.distributorDiscountGroupName!=null &&
              this.distributorDiscountGroupName.equals(other.getDistributorDiscountGroupName()))) &&
            ((this.distributorMarginPercent==null && other.getDistributorMarginPercent()==null) || 
             (this.distributorMarginPercent!=null &&
              this.distributorMarginPercent.equals(other.getDistributorMarginPercent()))) &&
            ((this.distributorName==null && other.getDistributorName()==null) || 
             (this.distributorName!=null &&
              this.distributorName.equals(other.getDistributorName()))) &&
            ((this.orderDate==null && other.getOrderDate()==null) || 
             (this.orderDate!=null &&
              this.orderDate.equals(other.getOrderDate()))) &&
            ((this.orderId==null && other.getOrderId()==null) || 
             (this.orderId!=null &&
              this.orderId.equals(other.getOrderId()))) &&
            ((this.orderProducts==null && other.getOrderProducts()==null) || 
             (this.orderProducts!=null &&
              Arrays.equals(this.orderProducts, other.getOrderProducts()))) &&
            ((this.referenceNumber==null && other.getReferenceNumber()==null) || 
             (this.referenceNumber!=null &&
              this.referenceNumber.equals(other.getReferenceNumber()))) &&
            ((this.totalDiscountedPrice==null && other.getTotalDiscountedPrice()==null) || 
             (this.totalDiscountedPrice!=null &&
              this.totalDiscountedPrice.equals(other.getTotalDiscountedPrice()))) &&
            ((this.totalProductDiscount==null && other.getTotalProductDiscount()==null) || 
             (this.totalProductDiscount!=null &&
              this.totalProductDiscount.equals(other.getTotalProductDiscount()))) &&
            ((this.totalProductPrice==null && other.getTotalProductPrice()==null) || 
             (this.totalProductPrice!=null &&
              this.totalProductPrice.equals(other.getTotalProductPrice()))) &&
            ((this.vesselName==null && other.getVesselName()==null) || 
             (this.vesselName!=null &&
              this.vesselName.equals(other.getVesselName())));
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
        if (getCustomerDiscount() != null) {
            _hashCode += getCustomerDiscount().hashCode();
        }
        if (getCustomerName() != null) {
            _hashCode += getCustomerName().hashCode();
        }
        if (getDiscountQuantity() != null) {
            _hashCode += getDiscountQuantity().hashCode();
        }
        if (getDistributorDiscount() != null) {
            _hashCode += getDistributorDiscount().hashCode();
        }
        if (getDistributorDiscountGroupName() != null) {
            _hashCode += getDistributorDiscountGroupName().hashCode();
        }
        if (getDistributorMarginPercent() != null) {
            _hashCode += getDistributorMarginPercent().hashCode();
        }
        if (getDistributorName() != null) {
            _hashCode += getDistributorName().hashCode();
        }
        if (getOrderDate() != null) {
            _hashCode += getOrderDate().hashCode();
        }
        if (getOrderId() != null) {
            _hashCode += getOrderId().hashCode();
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
        if (getReferenceNumber() != null) {
            _hashCode += getReferenceNumber().hashCode();
        }
        if (getTotalDiscountedPrice() != null) {
            _hashCode += getTotalDiscountedPrice().hashCode();
        }
        if (getTotalProductDiscount() != null) {
            _hashCode += getTotalProductDiscount().hashCode();
        }
        if (getTotalProductPrice() != null) {
            _hashCode += getTotalProductPrice().hashCode();
        }
        if (getVesselName() != null) {
            _hashCode += getVesselName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static TypeDesc typeDesc =
        new TypeDesc(OrderReport.class, true);

    static {
        typeDesc.setXmlType(new QName("urn:BeanService", "OrderReport"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("customerDiscount");
        elemField.setXmlName(new QName("", "customerDiscount"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("customerName");
        elemField.setXmlName(new QName("", "customerName"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("discountQuantity");
        elemField.setXmlName(new QName("", "discountQuantity"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("distributorDiscount");
        elemField.setXmlName(new QName("", "distributorDiscount"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("distributorDiscountGroupName");
        elemField.setXmlName(new QName("", "distributorDiscountGroupName"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("distributorMarginPercent");
        elemField.setXmlName(new QName("", "distributorMarginPercent"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("distributorName");
        elemField.setXmlName(new QName("", "distributorName"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("orderDate");
        elemField.setXmlName(new QName("", "orderDate"));
        elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("orderId");
        elemField.setXmlName(new QName("", "orderId"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("orderProducts");
        elemField.setXmlName(new QName("", "orderProducts"));
        elemField.setXmlType(new QName("urn:BeanService", "OrderProductReport"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("referenceNumber");
        elemField.setXmlName(new QName("", "referenceNumber"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("totalDiscountedPrice");
        elemField.setXmlName(new QName("", "totalDiscountedPrice"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("totalProductDiscount");
        elemField.setXmlName(new QName("", "totalProductDiscount"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("totalProductPrice");
        elemField.setXmlName(new QName("", "totalProductPrice"));
        elemField.setXmlType(new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new ElementDesc();
        elemField.setFieldName("vesselName");
        elemField.setXmlName(new QName("", "vesselName"));
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
