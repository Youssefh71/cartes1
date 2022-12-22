package fr.geomod.components.cmdecarte.basket.model.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;
import fr.geomod.components.cmdecarte.basket.model.generated.CellType;
import fr.geomod.components.cmdecarte.basket.model.generated.OrderType;

/**
 * <p>
 * <B>Title </B>: BasketJaxbImpl.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2022.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: BasketJaxbImpl.java
 * </p>
 * <p>
 * <B>Description </B>: An implementation of {@link Basket} using jaxb
 * </p>
 * 
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
     * 
     * @param basketFile
     *            a basket xml file.
     */
    public void loadBasket(File basketFile) {

        // TODO Youssef : unmarshaller le basketFile et remplir les attributs du
        // basket, liste de cells...

        List<CellType> baskeCellList = null;

        try {
            // création d'un contexte JAXB sur la classe OrderType
            JAXBContext jc = JAXBContext.newInstance(OrderType.class);
            // création d'un unmarshaller
            Unmarshaller ums = jc.createUnmarshaller();
            OrderType orderType = (OrderType) ums.unmarshal(basketFile);

            baskeCellList = orderType.getCell();

            // pour chaque cell de baskeCellList
            // creation d'une BasketCellImpl(infos de la cell)
            // ajout de cette BasketCellImpl à this.cells avec son (id,
            // BasketCellImpl)
            // fin pour

            for (CellType jaxbCell : baskeCellList) {

                BasketCellImpl basketCellImpl = new BasketCellImpl(
                        jaxbCell.getCellName(), jaxbCell.getCellEdtn(),
                        jaxbCell.getServiceType());

                this.cells.put(basketCellImpl.getCellId(), basketCellImpl);

            }

            //System.out.println(baskeCellList);
            
        } catch (JAXBException e) {
            // nothing to do
        }

    }

    /**
     * Save a basket to a xml file.
     * 
     * @param basketFile
     *            a basket xml file for this basket to be saved to.
     */
    public void saveBasket(File basketFile) {
        // TODO Youssef : marshaller le basket vers basketFile

        OrderType orderType = new OrderType();
        List<CellType> ordercells = orderType.getCell();

        for (BasketCell basketCell : this.getCells()) {

            CellType cellType = new CellType();
            cellType.setCellEdtn("" + basketCell.getCellEdtn());
            cellType.setCellName(basketCell.getCellId());
            cellType.setServiceType("" + basketCell.getCellService());

            ordercells.add(cellType);
            

        }

        try {
            JAXBContext jc = JAXBContext.newInstance(OrderType.class);
            Marshaller jaxbMarshaller = jc.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(orderType, basketFile);

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

    }

    /**
     * Get a string representation for this basket {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("Basket : " + System.lineSeparator());
        // TODO Youssef : itérer sur les cellules pour les ajouter à la string
        // représentant le panier

        for (Map.Entry<String, BasketCell> cells : this.cells.entrySet()) {
            result.append("Basket id : " + cells.getKey());
            result.append("Basket objet : " + cells.getValue());
        }
        return result.toString();
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.geomod.components.cmdecarte.basket.model.Basket#getCells()
     */
    public List<BasketCell> getCells() {
        // TODO Youssef pas optimal : création d'un arrayList à chaque appel,
        // voir si ce ne serait pas mieux de modifier le type de retour de la
        // méthode ?
        return new ArrayList<BasketCell>(this.cells.values());
    }

    /**
     * 
     * {@inheritDoc}
     * @see fr.geomod.components.cmdecarte.basket.model.Basket#getCellById(java.lang.String)
     */
    @Override
    public BasketCell getCellById(String cellId) {
        // TODO Youssef à vérifier
        if (null != this.cells) {
            return this.cells.get(cellId);
        }
        return null;
    }
}
