/*
 * @(#)Basket.java
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

import java.io.File;
import java.util.List;


/**
 * <p><B>Title </B>: Basket.</p>
 * <p><B>Copyright </B>: Copyright (c) 2022. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: Basket.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2022
 */
public interface Basket {
    /**
     * Load a fr.geomod.components.cmdecarte.basket from a xml file.
     * @param basketFile a fr.geomod.components.cmdecarte.basket xml file.
     */
    public void loadBasket(File basketFile);
    
    /**
     * Save a fr.geomod.components.cmdecarte.basket to a xml file.
     * @param basketFile a fr.geomod.components.cmdecarte.basket xml file for this fr.geomod.components.cmdecarte.basket to be saved to.
     */
    public void saveBasket(File basketFile);
    
    /**
     * Get the list of cell for this fr.geomod.components.cmdecarte.basket.
     * @return The list of cells.
     */
    public List<BasketCell> getCells();
    
    /**
     * Get a cell by its Id.
     * @param cellId The cell id to look for
     * @return The cell if in the basket, null else.
     */
    public BasketCell getCellById(String cellId);
    
    /**
     * Get a string representation for this fr.geomod.components.cmdecarte.basket
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString();
}


