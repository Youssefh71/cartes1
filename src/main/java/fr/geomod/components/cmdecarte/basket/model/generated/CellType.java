//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2023.04.27 à 01:36:08 PM CEST 
//


package fr.geomod.components.cmdecarte.basket.model.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour cellType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="cellType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cell_name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cell_edtn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="service_type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cellType", propOrder = {
    "cellName",
    "cellEdtn",
    "serviceType"
})
public class CellType {

    @XmlElement(name = "cell_name", required = true)
    protected String cellName;
    @XmlElement(name = "cell_edtn", required = true)
    protected String cellEdtn;
    @XmlElement(name = "service_type", required = true)
    protected String serviceType;

    /**
     * Obtient la valeur de la propriété cellName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellName() {
        return cellName;
    }

    /**
     * Définit la valeur de la propriété cellName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellName(String value) {
        this.cellName = value;
    }

    /**
     * Obtient la valeur de la propriété cellEdtn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellEdtn() {
        return cellEdtn;
    }

    /**
     * Définit la valeur de la propriété cellEdtn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellEdtn(String value) {
        this.cellEdtn = value;
    }

    /**
     * Obtient la valeur de la propriété serviceType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Définit la valeur de la propriété serviceType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

}
