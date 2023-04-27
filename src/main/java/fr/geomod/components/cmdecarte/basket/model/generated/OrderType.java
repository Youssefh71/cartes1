//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2023.04.27 à 01:21:54 PM CEST 
//


package fr.geomod.components.cmdecarte.basket.model.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour orderType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="orderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="order_header" type="{}order_headerType"/&gt;
 *         &lt;element name="cell" type="{}cellType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderType", propOrder = {
    "orderHeader",
    "cell"
})
public class OrderType {

    @XmlElement(name = "order_header", required = true)
    protected OrderHeaderType orderHeader;
    protected List<CellType> cell;

    /**
     * Obtient la valeur de la propriété orderHeader.
     * 
     * @return
     *     possible object is
     *     {@link OrderHeaderType }
     *     
     */
    public OrderHeaderType getOrderHeader() {
        return orderHeader;
    }

    /**
     * Définit la valeur de la propriété orderHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderHeaderType }
     *     
     */
    public void setOrderHeader(OrderHeaderType value) {
        this.orderHeader = value;
    }

    /**
     * Gets the value of the cell property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cell property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCell().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CellType }
     * 
     * 
     */
    public List<CellType> getCell() {
        if (cell == null) {
            cell = new ArrayList<CellType>();
        }
        return this.cell;
    }

}
