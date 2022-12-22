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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;
import fr.geomod.components.cmdecarte.basket.model.BasketComparison;
import fr.geomod.components.cmdecarte.basket.model.helper.BasketHelperImpl;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketCellImpl;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketJaxbImpl;

/**
 * <p>
 * <B>Title </B>: BasketTest.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2022.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: BasketTest.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 * 
 * @author GEOMOD
 * @since 2022
 */
@Testable
public class BasketTests {
    private static final String BASKET_DIR = "./data";
    private static final String BASKET_DIR_OUTPUT = "./data_generated";
    private static final String BASKET1 = BASKET_DIR + "/basket1.xml";
    private static final String BASKET2 = BASKET_DIR_OUTPUT + "/basket3.xml";
    private static final String BASKET3 = BASKET_DIR_OUTPUT + "/basket4.xml";
    private static final String BASKET1_PLUS_1_CELL = BASKET_DIR
            + "/basket1_withGB301366.xml";
    private static final String BASKET1_MINUS_1_CELL = BASKET_DIR
            + "/basket1_withoutGB303648.xml";
    private static final String BASKET1_WITH_DIFFS = BASKET_DIR
            + "/basket1_GB104209_edt2.xml";
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
     * 
     * @throws Exception
     */
    @Test
    public void testBasketGetCells() throws Exception {
        File basket1File = new File(BASKET1);
        this.basket.loadBasket(basket1File);

        final String[] cellIds = { "GB303648", "GB301364", "GB301365",
                "GB104209", "FR373840", "FR271860" };

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
                fail("Expected cell " + cellId
                        + " was not found in basket list of cells.");
            }
        }

        // check that no other cell is found
        for (BasketCell cell : this.basket.getCells()) {
            found = false;
            for (String cellId : cellIds) {
                if (cell.getCellId().equalsIgnoreCase(cellId)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                fail("Cell " + cell.getCellId()
                        + " was found in basket list of cells but was not expected.");
            }
        }
    }

    /**
     * Check the creation of a basket from a file
     * 
     * @throws Exception
     */
    @Test
    public void testBasketCreationFromFile() throws Exception {
        File basket1File = new File(BASKET1);
        try {
            this.basket.loadBasket(basket1File);
        } catch (Exception e) {
            fail();
        }
        assertNotNull(this.basket);
        assertNotNull(this.basket.getCells());
        assertEquals(6, this.basket.getCells().size());

        assertTrue(this.basket.getCells().get(0) instanceof BasketCell);
    }

    /**
     * Check the save of a basket
     * 
     * @throws Exception
     */
    @Test
    public void testBasketSaveToFile() throws Exception {
        // lire un panier
        File basket1File = new File(BASKET1);
        try {
            this.basket.loadBasket(basket1File);
        } catch (Exception e) {
            fail();
        }

        // le sauvegarder sous un fichier different,
        File basket2File = new File(BASKET2);
        try {
            this.basket.saveBasket(basket2File);
        } catch (Exception e) {
            fail();
        }

        // verifier que le fichier n'est pas vide,
        assertTrue(basket2File.exists());
        assertTrue(basket2File.length() > 0);

        // Créer un nouveau basket
        BasketJaxbImpl basketNew = new BasketJaxbImpl();
        // Charger dans se basket le fichier basket2
        basketNew.loadBasket(basket2File);

        // Vérifier que l'on a le même nombre de cellule que this.basket.

        assertEquals(this.basket.getCells().size(),
                basketNew.getCells().size());

        // Vérifier que l'on à les mêmes cellules (sans utiliser le compare)
        boolean found = false;
        for (BasketCell cell : this.basket.getCells()) {
            found = false;
            for (BasketCell cell2 : basketNew.getCells()) {
                if (cell.getCellId().equalsIgnoreCase(cell2.getCellId())
                        && cell.getCellEdtn() == cell2.getCellEdtn()
                        && cell.getCellService() == cell2.getCellService()) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                fail("Expected cell " + cell.getCellId()
                        + " was not found in basket list of cells.");
            }
        }

        // Charge un panier XML

        this.basket.loadBasket(basket1File);

        // modifier la cellule FR373840 et modifier cellEdtn à 2
        BasketCellImpl basketCell = (BasketCellImpl) this.basket
                .getCellById("FR373840");
        basketCell.setCellEdtn(2);

        // sauvegarder mon panier
        File basket3File = new File(BASKET3);
        try {
            this.basket.saveBasket(basket3File);
        } catch (Exception e) {
            fail();
        }

        // relire le fichier xml dans un nouveau panier
        BasketJaxbImpl basketnotequal = new BasketJaxbImpl();

        try {
            basketnotequal.loadBasket(basket3File);
        } catch (Exception e) {
            fail();
        }

        // Verifier que les deux panier on la cellule FR373840 identique mais
        // l'EDNT est différente et simplement celle là.

        BasketCell cellOriginal = basketNew.getCellById("FR373840");
        BasketCell cellModifiade = basketnotequal.getCellById("FR373840");

        assertEquals(cellOriginal.getCellId(), cellModifiade.getCellId());
        assertNotEquals(cellOriginal.getCellEdtn(),
                cellModifiade.getCellEdtn());
        assertEquals(cellOriginal.getCellService(),
                cellModifiade.getCellService());

    }

    /**
     * Test method for
     * {@link fr.geomod.components.cmdecarte.basket.model.BasketComparison#getNewCells()}.
     */
    @Test
    public void testGetNewCells() {
        // Lire les paniers
        File basketRef = new File(BASKET1);
        File baskePlusCell = new File(BASKET1_PLUS_1_CELL);
        // Créer un nouveau basket
        BasketJaxbImpl basketReference = new BasketJaxbImpl();
        BasketJaxbImpl basketPlusCellFile = new BasketJaxbImpl();
        // Charger dans le basket
        basketReference.loadBasket(basketRef);
        basketPlusCellFile.loadBasket(baskePlusCell);

        // check that the basket is not null
        assertNotNull("BasketReference should not be null", basketReference);
        assertNotNull("BasketPlusCellFile should not be null",
                basketPlusCellFile);

        // comparison of the two basket
        BasketComparison result = BasketHelperImpl.compare(basketReference,
                basketPlusCellFile);
        // check that the variable result is not null
        assertNotNull("result should not be null", result);
        // check that getNewcells is not null
        assertNotNull("No new Cells found", result.getNewCells());
        // check that there are no less cells
        assertNull("deleted cell found", result.getDeletedCells());
        // check that there is no different cell
        assertNull("modified cell found", result.getCellsWithDifferences());

        // Check that only one cell has been added
        assertEquals("More than one cell different", 1,
                result.getNewCells().size());

        BasketCell newCell = result.getNewCells().get(0);

        assertEquals("this is not the expected cell", "GB301366",
                newCell.getCellId());

        assertNull("Should be null",
                basketReference.getCellById(newCell.getCellId()));

    }

    /**
     * Test method for
     * {@link fr.geomod.components.cmdecarte.basket.model.BasketComparison#getDeletedCells()}.
     */
    @Test
    public void testGetDeletedCells() {
        // Lire les paniers
        File basketRef = new File(BASKET1);
        File baskeMinusCell = new File(BASKET1_MINUS_1_CELL);
        // Créer un nouveau basket
        BasketJaxbImpl basketReference = new BasketJaxbImpl();
        BasketJaxbImpl basketMinusCellFile = new BasketJaxbImpl();
        // Charger dans le basket
        basketReference.loadBasket(basketRef);
        basketMinusCellFile.loadBasket(baskeMinusCell);

        // check that the basket is not null
        assertNotNull("BasketReference should not be null", basketReference);
        assertNotNull("BasketMinusCellFile should not be null",
                basketMinusCellFile);
        // comparison of the two basket
        BasketComparison result = BasketHelperImpl.compare(basketReference,
                basketMinusCellFile);

        // check that the variable result is not null
        assertNotNull("result should not be null", result);
        // check that getDeletedcells is not null
        assertNotNull("No deleted cell found", result.getDeletedCells());
        // check that there are no less cells
        assertNull("New cell found", result.getNewCells());
        // check that there is no different cell
        assertNull("modified cell found", result.getCellsWithDifferences());

        // Check that only one cell has been deleted
        assertEquals("More than one cell has been deleted", 1,
                result.getDeletedCells().size());

        BasketCell deletedCell = result.getDeletedCells().get(0);

        assertEquals("this is not the expected cell", "GB303648",
                deletedCell.getCellId());
        assertNull("Should be null",
                basketMinusCellFile.getCellById("GB303648"));
    }

    /**
     * Test method for
     * {@link fr.geomod.components.cmdecarte.basket.model.BasketComparison#getCellsWithDifferences()}.
     */
    @Test
    public void testGetCellsWithDifferences() {
        // Lire les paniers
        File basketRef = new File(BASKET1);
        File baskeWithDiffsCell = new File(BASKET1_WITH_DIFFS);
        // Créer un nouveau basket
        BasketJaxbImpl basketReference = new BasketJaxbImpl();
        BasketJaxbImpl basketWithDiffsCellFile = new BasketJaxbImpl();
        // Charger dans le basket
        basketReference.loadBasket(basketRef);
        basketWithDiffsCellFile.loadBasket(baskeWithDiffsCell);

        assertNotNull("BasketReference should not be null", basketReference);
        assertNotNull("BasketWithDiffsCellFile should not be null",
                basketWithDiffsCellFile);
        BasketComparison result = BasketHelperImpl.compare(basketReference,
                basketWithDiffsCellFile);

        assertNotNull("Result should not be null", result);
        assertNotNull("No modified cell", result.getCellsWithDifferences());
        assertNull("New celle found", result.getNewCells());
        assertNull("deleted cell found", result.getDeletedCells());

        assertEquals("More than one cell has been modified", 1,
                result.getCellsWithDifferences().size());

        BasketCell modifiedCell = result.getCellsWithDifferences().get(0);

        assertEquals("this is not the expected cell", "GB104209",
                modifiedCell.getCellId());

        BasketCell referenceCell = basketReference
                .getCellById(modifiedCell.getCellId());

        assertEquals("Service cell is different",
                referenceCell.getCellService(), modifiedCell.getCellService());
        assertNotEquals("Edition cell is equal", referenceCell.getCellEdtn(),
                modifiedCell.getCellEdtn());
        assertEquals("Edition Cell is different", 2,
                modifiedCell.getCellEdtn());

    }

}
