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

import java.util.List;

import fr.geomod.components.cmdecarte.basket.model.BasketCell;
import fr.geomod.components.cmdecarte.basket.model.BasketComparison;

/**
 * <p><B>Title </B>: BasketComparisonImpl.</p>
 * <p><B>Copyright </B>: Copyright (c) 2022. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: BasketComparisonImpl.java</p>
 * <p><B>Description </B>: Default implementation of {@link BasketComparison} </p>
 * @author GEOMOD
 * @since 2022
 */
public class BasketComparisonImpl implements BasketComparison {

    /**
     * {@inheritDoc}
     * @see fr.geomod.components.cmdecarte.basket.model.BasketComparison#getNewCells()
     */
    public List<BasketCell> getNewCells() {
        // TODO Youssef
        return null;
    }

    /**
     * {@inheritDoc}
     * @see fr.geomod.components.cmdecarte.basket.model.BasketComparison#getDeletedCells()
     */
    public List<BasketCell> getDeletedCells() {
        // TODO Youssef
        return null;
    }

    /**
     * {@inheritDoc}
     * @see fr.geomod.components.cmdecarte.basket.model.BasketComparison#getCellsWithDifferences()
     */
    public List<BasketCell> getCellsWithDifferences() {
        // TODO Youssef
        return null;
    }

}


