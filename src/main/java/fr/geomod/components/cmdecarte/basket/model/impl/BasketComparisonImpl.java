/*
 * @(#)BasketComparisonImpl.java
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
package fr.geomod.components.cmdecarte.basket.model.impl;

import fr.geomod.components.cmdecarte.basket.model.BasketCell;
import fr.geomod.components.cmdecarte.basket.model.BasketComparison;

import java.util.ArrayList;
import java.util.List;

/**
 * <p><B>Title </B>: BasketComparisonImpl.</p>
 * <p><B>Copyright </B>: Copyright (c) 2022. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: BasketComparisonImpl.java</p>
 * <p><B>Description </B>: Default implementation of {@link BasketComparison} </p>
 *
 * @author GEOMOD
 * @since 2022
 */
public class BasketComparisonImpl implements BasketComparison {

    /**
     * List of new Cells
     */
    private List<BasketCell> newCells;

    /**
     * List of deleted Cells
     */
    private List<BasketCell> deletedCells;

    /**
     * List of cells with differences
     */
    private List<BasketCell> cellsWithDifferences;


    /**
     * {@inheritDoc}
     *
     * @see fr.geomod.components.cmdecarte.basket.model.BasketComparison#getNewCells()
     */
    public List<BasketCell> getNewCells() {
        return this.newCells;
    }

    /**
     * {@inheritDoc}
     *
     * @see fr.geomod.components.cmdecarte.basket.model.BasketComparison#getDeletedCells()
     */
    public List<BasketCell> getDeletedCells() {
        return this.deletedCells;
    }

    /**
     * {@inheritDoc}
     *
     * @see fr.geomod.components.cmdecarte.basket.model.BasketComparison#getCellsWithDifferences()
     */
    public List<BasketCell> getCellsWithDifferences() {
        return this.cellsWithDifferences;
    }

    /**
     * Add deleted cell to list
     *
     * @param cell cell to add
     */
    public void addDeletedCells(BasketCell cell) {
        // Créer une list vide
        if (this.deletedCells == null) {
            this.deletedCells = new ArrayList<>();
        }
        //Ajouter la cellule à ma nouvelle liste
        this.deletedCells.add(cell);
    }

    /**
     * Add differences cell to list
     *
     * @param cell cell to add
     */
    public void addCellsWithDifferences(BasketCell cell) {
        // Créer une list vide
        if (this.cellsWithDifferences == null) {
            this.cellsWithDifferences = new ArrayList<>();
        }
        //Ajouter la cellule à ma nouvelle liste
        this.cellsWithDifferences.add(cell);
    }

    /**
     * Add new cell to list
     *
     * @param cell cell to add
     */
    public void addNewCells(BasketCell cell) {
        // Créer une list vide
        if (this.newCells == null) {
            this.newCells = new ArrayList<>();
        }
        //Ajouter la cellule à ma nouvelle liste
        this.newCells.add(cell);
    }
}


