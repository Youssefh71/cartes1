/*
 * @(#)BasketTest.java
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
package fr.geomod.components.cmdecarte.basket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketJaxbImpl;

/**
 * <p><B>Title </B>: BasketTest.</p>
 * <p><B>Copyright </B>: Copyright (c) 2022. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: BasketTest.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2022
 */
public class BasketTest {
    private static final String BASKET_DIR = "./data";
    private static final String BASKET1 = BASKET_DIR + "basket1.xml";
    private static final String BASKET1_PLUS_1_CELL = BASKET_DIR + "/basket1_withGB301366.xml";
    private static final String BASKET1_MINUS_1_CELL = BASKET_DIR + "/basket1_withoutGB303648.xml";
    private static final String BASKET1_WITH_DIFFS = BASKET_DIR + "/basket1_GB104209_edt2.xml";
    /** instance to test */
    Basket basket;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // use default jaxb implementation...
        this.basket = new BasketJaxbImpl();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        this.basket = null;
    }

    /**
     * Check that a basket from a predefined file contains expected cells
     */
    @Test
    public void testBasketGetCells() throws Exception {
        File basket1File = new File(BASKET1);
        this.basket.loadBasket(basket1File);
        
        final String[] cellIds = {"GB303648", "GB301364", "GB301365", "GB104209", "FR373840", "FR271860"};

        assertEquals(6, this.basket.getCells().size());

        // check that every expected cell is found
        boolean found = false;
        for (String cellId : cellIds) {
            found = false;
            for (BasketCell cell : this.basket.getCells()) {
                if (cellId.equalsIgnoreCase(cell.getCellId())) {
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                fail("Expected cell "+cellId+" was not found in basket list of cells.");
            }
        }
        
        // check that no other cell is found
        for (BasketCell cell : this.basket.getCells()) {
            found = false;
            for (String cellId : cellIds) {
                // TODO Youssef
            }
            
            if (!found) {
                fail("Cell "+cell.getCellId()+" was found in basket list of cells but was not expected.");
            }
        }
    }
    
    /**
     * Check the creation of a basket from a file
     */
    @Test
    public void testBasketCreationFromFile() throws Exception {
        File basket1File = new File(BASKET1);
        try {
            this.basket.loadBasket(basket1File);
        } catch(Exception e) {
            fail();
        }
        assertNotNull(this.basket);
        assertNotNull(this.basket.getCells());
        assertEquals(6, this.basket.getCells().size());
    }
    
    /**
     * Check the save of a basket
     * @throws Exception
     */
    public void testBasketSaveToFile() throws Exception {
        // TODO Youssef : lire un panier, le sauvegarder sous un fichier different, verifier que le fichier n'est pas vide, charger un nouveau panier a partir de ce fichier, verifier qu'on a le meme nb de cellules et les memes cellules (sans utiliser le compare)
        
    }

}


