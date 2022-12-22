/*
 * @(#)BasketCell.java
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

/**
 * <p><B>Title </B>: BasketCell.</p>
 * <p><B>Copyright </B>: Copyright (c) 2022. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: BasketCell.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2022
 */
public interface BasketCell {
    
    /**
     * Get the cell identifier
     * @return The cell id
     */
    public String getCellId();
    
    /**
     * Get the cell edition
     * @return The cell edition (-1 if not defined)
     */
    public int getCellEdtn();
    
    /**
     * Get the cell service
     * @return The cell service (-1 if not defined)
     */
    public int getCellService();


}


