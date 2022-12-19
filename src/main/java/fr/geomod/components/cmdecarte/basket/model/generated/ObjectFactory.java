//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.0 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2022.10.25 à 02:20:39 PM CEST 
//


package fr.geomod.components.cmdecarte.basket.model.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * fr.geomod.components.cmdecarte.basket.model.generated in the fr.geomod.components.cmdecarte.basket.model.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    @Override
	public String toString() {
		return "ObjectFactory [createOrderType()=" + createOrderType() + ", createOrderHeaderType()="
				+ createOrderHeaderType() + ", createCellType()=" + createCellType() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private final static QName _Order_QNAME = new QName("", "order");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.geomod.components.cmdecarte.basket.model.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderType }
     * @return OrderType
     * 
     */
    public OrderType createOrderType() {
        return new OrderType();
    }

    /**
     * Create an instance of {@link OrderHeaderType }
     * @return OrderHeaderType
     * 
     */
    public OrderHeaderType createOrderHeaderType() {
        return new OrderHeaderType();
    }

    /**
     * Create an instance of {@link CellType }
     * @return CellType
     * 
     */
    public CellType createCellType() {
        return new CellType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrderType }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "order")
    public JAXBElement<OrderType> createOrder(OrderType value) {
        return new JAXBElement<OrderType>(_Order_QNAME, OrderType.class, null, value);
    }

}
