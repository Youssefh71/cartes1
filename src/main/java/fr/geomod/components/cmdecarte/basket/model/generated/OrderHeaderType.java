//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2023.04.27 à 10:54:08 AM CEST 
//


package fr.geomod.components.cmdecarte.basket.model.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour order_headerType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="order_headerType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ordering_system" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="order_type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="reference_number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="distributor_id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="distributor_contact" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="optional_delivery_email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="permit_media" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="permit_all" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="language_code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "order_headerType", propOrder = {
    "orderingSystem",
    "orderType",
    "referenceNumber",
    "distributorId",
    "distributorContact",
    "optionalDeliveryEmail",
    "userId",
    "permitMedia",
    "permitAll",
    "languageCode"
})
public class OrderHeaderType {

    @XmlElement(name = "ordering_system", required = true)
    protected String orderingSystem;
    @XmlElement(name = "order_type", required = true)
    protected String orderType;
    @XmlElement(name = "reference_number", required = true)
    protected String referenceNumber;
    @XmlElement(name = "distributor_id", required = true)
    protected String distributorId;
    @XmlElement(name = "distributor_contact", required = true)
    protected String distributorContact;
    @XmlElement(name = "optional_delivery_email", required = true)
    protected String optionalDeliveryEmail;
    @XmlElement(name = "user_id", required = true)
    protected String userId;
    @XmlElement(name = "permit_media", required = true)
    protected String permitMedia;
    @XmlElement(name = "permit_all", required = true)
    protected String permitAll;
    @XmlElement(name = "language_code", required = true)
    protected String languageCode;

    /**
     * Obtient la valeur de la propriété orderingSystem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderingSystem() {
        return orderingSystem;
    }

    /**
     * Définit la valeur de la propriété orderingSystem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderingSystem(String value) {
        this.orderingSystem = value;
    }

    /**
     * Obtient la valeur de la propriété orderType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Définit la valeur de la propriété orderType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    /**
     * Obtient la valeur de la propriété referenceNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Définit la valeur de la propriété referenceNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNumber(String value) {
        this.referenceNumber = value;
    }

    /**
     * Obtient la valeur de la propriété distributorId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistributorId() {
        return distributorId;
    }

    /**
     * Définit la valeur de la propriété distributorId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistributorId(String value) {
        this.distributorId = value;
    }

    /**
     * Obtient la valeur de la propriété distributorContact.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistributorContact() {
        return distributorContact;
    }

    /**
     * Définit la valeur de la propriété distributorContact.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistributorContact(String value) {
        this.distributorContact = value;
    }

    /**
     * Obtient la valeur de la propriété optionalDeliveryEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionalDeliveryEmail() {
        return optionalDeliveryEmail;
    }

    /**
     * Définit la valeur de la propriété optionalDeliveryEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionalDeliveryEmail(String value) {
        this.optionalDeliveryEmail = value;
    }

    /**
     * Obtient la valeur de la propriété userId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Définit la valeur de la propriété userId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Obtient la valeur de la propriété permitMedia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermitMedia() {
        return permitMedia;
    }

    /**
     * Définit la valeur de la propriété permitMedia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermitMedia(String value) {
        this.permitMedia = value;
    }

    /**
     * Obtient la valeur de la propriété permitAll.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermitAll() {
        return permitAll;
    }

    /**
     * Définit la valeur de la propriété permitAll.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermitAll(String value) {
        this.permitAll = value;
    }

    /**
     * Obtient la valeur de la propriété languageCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * Définit la valeur de la propriété languageCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageCode(String value) {
        this.languageCode = value;
    }

}
