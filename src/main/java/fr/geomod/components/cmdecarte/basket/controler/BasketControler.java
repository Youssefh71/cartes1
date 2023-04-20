/*
 * @(#)BasketControler.java
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
package fr.geomod.components.cmdecarte.basket.controler;

import java.io.File;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;
import fr.geomod.components.cmdecarte.basket.model.BasketComparison;
import fr.geomod.components.cmdecarte.basket.model.helper.BasketHelperImpl;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketJaxbImpl;

/**
 * <p><B>Title </B>: BasketControler.</p>
 * <p><B>Copyright </B>: Copyright (c) 2022. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: BasketControler.java</p>
 * <p><B>Description </B>: Classe temporaire pour tester les différentes actions sur les baskets.  </p>
 * @author GEOMOD
 * @since 2022
 */
public class BasketControler {
    private Basket basketReference;
    private Basket basketNew;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        BasketControler controler = new BasketControler();
        controler.loadJaxbBaskets();
        BasketComparison diffs = controler.compareBaskets();
        controler.showDiffs(diffs);
    }

    /**
     * Output the differences found between baskets
     * @param diffs The differences
     */
    private void showDiffs(BasketComparison diffs) {
        System.out.println("-- Diffs --");
        if (null == diffs) {
            System.out.println("No difference found.");
        } else {
            System.out.println("Nb new cells: " +diffs.getNewCells().size());
            for(BasketCell cell: diffs.getNewCells()) {
               System.out.println(cell.getCellId());   
            }
            System.out.println("Nb deleted cells: " +diffs.getDeletedCells().size());
            for(BasketCell cell: diffs.getDeletedCells()) {
                System.out.println(cell.getCellId());   
             }
            System.out.println("Nb different cells: "+diffs.getCellsWithDifferences().size()/2);
            for(BasketCell cell: diffs.getCellsWithDifferences()) {
                System.out.println("cells Id: "+cell.getCellId()); 
                System.out.println("cells Edtn: "+cell.getCellEdtn());
                System.out.println("cells service: "+cell.getCellService());
             }
            
        }
    }

    /**
     * Compare internal baskets
     * @return The differences between internal baskets
     */
    private BasketComparison compareBaskets() {
        BasketComparison result = null;
        if (null != this.basketReference && null != this.basketNew) {
            result = BasketHelperImpl.compare(basketReference, basketNew);
        }
        
        return result;
    }

    /**
     * Loads internal baskets
     */
    private void loadJaxbBaskets() {
        File basketRef = new File("./data/basket1.xml");
        File basketNew = new File("./data/basket2.xml");
        
        this.basketReference = new BasketJaxbImpl();
        this.basketReference.loadBasket(basketRef);
        
        this.basketNew = new BasketJaxbImpl();
        this.basketNew.loadBasket(basketNew);
    }
}


