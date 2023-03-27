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

import java.io.File;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.BasketCell;
import fr.geomod.components.cmdecarte.basket.model.BasketComparison;
import fr.geomod.components.cmdecarte.basket.model.helper.BasketHelperImpl;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketCellImpl;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketJaxbImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;

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
    /**
     * instance to test
     */
    Basket basket;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        // use default jaxb implementation...
        this.basket = new BasketJaxbImpl();
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterEach
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

        final String[] cellIds = {"GB303648", "GB301364", "GB301365",
                "GB104209", "FR373840", "FR271860"};

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
            fail(e.getMessage());
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
        this.basket.loadBasket(basket1File);

        // le sauvegarder sous un fichier different,
        File basket2File = new File(BASKET2);
        this.basket.saveBasket(basket2File);

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
        this.basket.saveBasket(basket3File);

        // relire le fichier xml dans un nouveau panier
        BasketJaxbImpl basketnotequal = new BasketJaxbImpl();

        basketnotequal.loadBasket(basket3File);

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
        assertThat(basketReference).isNotNull();
        assertThat(basketPlusCellFile).isNotNull();

        // comparison of the two basket
        BasketComparison result = BasketHelperImpl.compare(basketReference,
                basketPlusCellFile);
        // check that the variable result is not null
        assertThat(result).isNotNull();
        // check that getNewcells is not null
        assertThat(result.getNewCells()).isNotNull();
        // check that there are no less cells
        assertThat(result.getDeletedCells()).isNull();
        // check that there is no different cell
        assertThat(result.getCellsWithDifferences()).isNull();

        // Check that only one cell has been added
        assertThat(result.getNewCells())
                .hasSize(1);

        BasketCell newCell = result.getNewCells().get(0);

        assertThat(newCell.getCellId()).isEqualTo("GB301366");
        assertThat(basketReference.getCellById(newCell.getCellId())).isNull();

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
        assertThat(basketReference).isNotNull();
        assertThat(basketMinusCellFile).isNotNull();
        // comparison of the two basket
        BasketComparison result = BasketHelperImpl.compare(basketReference,
                basketMinusCellFile);

        // check that the variable result is not null
        assertThat(result).isNotNull();
        // check that getDeletedcells is not null
        assertThat(result.getDeletedCells()).isNotNull();
        // check that there are no less cells
        assertThat(result.getNewCells()).isNull();
        // check that there is no different cell
        assertThat(result.getCellsWithDifferences()).isNull();

        // Check that only one cell has been deleted
        assertThat(result.getDeletedCells()).hasSize(1);
        BasketCell deletedCell = result.getDeletedCells().get(0);

        assertThat(deletedCell.getCellId()).isEqualTo("GB303648");

        assertThat(basketMinusCellFile.getCellById("GB303648")).isNull();
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

        assertThat(basketReference).isNotNull();
        assertThat(basketWithDiffsCellFile).isNotNull();
        BasketComparison result = BasketHelperImpl.compare(basketReference,
                basketWithDiffsCellFile);

        assertThat(result).isNotNull();
        assertThat(result.getCellsWithDifferences()).isNotNull();
        assertThat(result.getNewCells()).isNull();
        assertThat(result.getDeletedCells()).isNull();


        assertThat(result.getCellsWithDifferences()).hasSize(1);

        BasketCell modifiedCell = result.getCellsWithDifferences().get(0);

        assertThat(modifiedCell.getCellId()).isEqualTo("GB104209");

        BasketCell referenceCell = basketReference
                .getCellById(modifiedCell.getCellId());

        assertThat(referenceCell.getCellService()).isEqualTo(modifiedCell.getCellService());
        assertThat(referenceCell.getCellEdtn()).isNotEqualTo(modifiedCell.getCellEdtn());
        assertThat(modifiedCell.getCellEdtn()).isEqualTo(2);

    }

}
