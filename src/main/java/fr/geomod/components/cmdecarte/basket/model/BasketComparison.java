/*
 * @(#)BasketComparison.java
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
package fr.geomod.components.cmdecarte.basket.model;

import java.util.List;

/**
 * <p><B>Title </B>: BasketComparison.</p>
 * <p><B>Copyright </B>: Copyright (c) 2022. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: BasketComparison.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2022
 */
public interface BasketComparison {
    /**
     * Get the list of cells that were not in first fr.geomod.components.cmdecarte.basket but that are in second fr.geomod.components.cmdecarte.basket.
     * @return The list of added cells.
     */
    public List<BasketCell> getNewCells();
    /**
     * Get the list of cells that were in first fr.geomod.components.cmdecarte.basket but that are not anymore in second fr.geomod.components.cmdecarte.basket.
     * @return The list of deleted cells.
     */
    public List<BasketCell> getDeletedCells();
    
    /**
     * Get a list of cells that are in both baskets but with different attribute values
     * Les cellules retournés sont les cellules du new Basket.
     * @return The list of cells with different attribute values.
     */
    public List<BasketCell> getCellsWithDifferences();
}


