package fr.geomod.components.cmdecarte.basket.model.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;


/**
 * <p><B>Title </B>: BasketJaxbImpl.</p>
 * <p><B>Copyright </B>: Copyright (c) 2022. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: BasketJaxbImpl.java</p>
 * <p><B>Description </B>: An implementation of {@link Basket} using jaxb </p>
 * @author GEOMOD
 * @since 2022
 */
public class BasketJaxbImpl implements Basket {
    /**
     * Internal list of cells for this basket
     */
    private HashMap<String, BasketCell> cells;
    
    // TODO voir si besoin d'autres attributs génériques

    /**
     * Default basket constructor
     */
    public BasketJaxbImpl() {
        this.cells = new HashMap<>();
    }
    
    /**
     * Load a basket from a xml file.
     * @param basketFile a basket xml file.
//     * @throws ParserConfigurationException 
//     * @throws IOException 
//     * @throws SAXException 
     */
    public void loadBasket(File basketFile) /*throws ParserConfigurationException, SAXException, IOException */  {
        // TODO Youssef : unmarshaller le basketFile et remplir les attributs du basket, liste de cells...
    	
//    	List<?> basketFileList =  new ArrayList<>();
//    	
//    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//    	DocumentBuilder builder = factory.newDocumentBuilder();
//    	Document doc = builder.parse(basketFile);
//    	doc.getDocumentElement().normalize();
//    	
//    	NodeList cellNodeList = doc.getElementsByTagName("cell");
    	
    	
    }
    
    /**
     * Save a basket to a xml file.
     * @param basketFile a basket xml file for this basket to be saved to.
     */
    public void saveBasket(File basketFile) {
        // TODO Youssef : marshaller le basket vers basketFile
        
    }
    
    /**
     * Get a string representation for this basket
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("Basket : " + System.lineSeparator());
        // TODO Youssef : itérer sur les cellules pour les ajouter à la string représentant le panier
        
        return result.toString();
    }

    /**
     * {@inheritDoc}
     * @see fr.geomod.components.cmdecarte.basket.model.Basket#getCells()
     */
    public List<BasketCell> getCells() {
        // TODO Youssef pas optimal : création d'un arrayList à chaque appel, voir si ce ne serait pas mieux de modifier le type de retour de la méthode ?
        return new ArrayList(this.cells.entrySet());
    }

    @Override
    public BasketCell getCellById(String cellId) {
        // TODO Youssef à vérifier
        if (null != this.cells) {
            return this.cells.get(cellId);
        }
        return null;
    }

}
