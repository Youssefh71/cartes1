/*
 * @(#)BasketHelperImpl.java
 *
 * Copyright (c) 2022 GEOMOD SA. All rights reserved.
 * GEOMOD PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 *
 * This file, together  with  its accompanying  software product  and
 * documentation, is  protected by the  intellectual  property rights
 * in  France  and  other  countries, any  applicable  copyrights  or
 * patent rights, and international treaty provisions. No part may be
 * reproduced  in  any  form  by  any  mean  without   prior  written
 * authorization of GEOMOD.
 */
package fr.geomod.components.cmdecarte.basket.model.helper;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketComparisonImpl;

/**
 * <p>
 * <B>Title </B>: BasketHelperImpl.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2022.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: BasketHelperImpl.java
 * </p>
 * <p>
 * <B>Description </B>: A helper class with static methods
 * </p>
 * 
 * @author GEOMOD
 * @since 2022
 */
public class BasketHelperImpl {

    /**
     * Default constructor
     */
    private BasketHelperImpl() {
        // empty private constructor to avoid instantiation
    }

    /**
     * Compares 2 baskets.
     * 
     * @param basket1
     *            original basket (reference)
     * @param basket2
     *            new basket.
     * @return The difference between the given baskets, null if baskets are
     *         identical.
     */
    public static BasketComparisonImpl compare(Basket basket1, Basket basket2) {
        BasketComparisonImpl result = null;
        // itérer sur les cellules du basket1,
        for (BasketCell cellBasket1 : basket1.getCells()) {

            // Pour chaque cellule du basket1 je vérifie son existence dans le
            // basket 2
            BasketCell cellBasket2 = basket2
                    .getCellById(cellBasket1.getCellId());

            // Si elle n'existe pas alors ajout à la liste des supprimer
            if (cellBasket2 == null) {
                if (result == null) {
                    result = new BasketComparisonImpl();
                }
                result.addDeletedCells(cellBasket1);
                continue;
            }
            // Si la cellule du basket1 est différente de la cellulle du basket2
            if (!cellBasket1.equals(cellBasket2)) {
                if (result == null) {
                    result = new BasketComparisonImpl();
                }
                // alors je l'ajoute à la liste différentes
                result.addCellsWithDifferences(cellBasket2);
                
            }
        }

        // itérer sur les cellules du basket2,
        for (BasketCell cellBasket2 : basket2.getCells()) {
            // Pour chaque cellule du basket2 je vérifie son existence dans le basket 1
            BasketCell cellBasket1 = basket1
                    .getCellById(cellBasket2.getCellId());
            // Si elle n'existe pas alors ajout à la liste des new
            if (cellBasket1 == null) {
                if (result == null) {
                    result = new BasketComparisonImpl();
                }
                result.addNewCells(cellBasket2);
            }
        }
        return result;
    }
}
