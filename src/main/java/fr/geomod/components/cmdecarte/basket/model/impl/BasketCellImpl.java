/*
 * @(#)BasketCellImpl.java
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

/**
 * <p>
 * <B>Title </B>: BasketCellImpl.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2022.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: BasketCellImpl.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 * 
 * @author GEOMOD
 * @since 2022
 */
/**
 * <p>
 * <B>Title </B>: BasketCellImpl.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2022.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: BasketCellImpl.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 * 
 * @author GEOMOD
 * @since 2022
 */
public class BasketCellImpl implements BasketCell {
    /** Cell Id */
    private String id;

    /** Cell edition */
    private int edtn = -1;

    /** Cell service */
    private int service = -1;

    /**
     * BasketCell constructor
     * 
     * @param identifier
     *            the cell id
     * @param edition
     *            the cell edition
     * @param service
     *            the cell service
     */
    public BasketCellImpl(String identifier, int edition, int service) {
        this.id = identifier;
        this.edtn = edition;
        this.service = service;
    }

    /**
     * BasketCell constructor
     * 
     * @param identifier
     *            the cell id
     * @param edition
     *            the cell edition
     * @param service
     *            the cell service
     */
    public BasketCellImpl(String identifier, String edition, String service) {
        int edtn = -1;
        int serviceInt = -1;
        try {
            edtn = Integer.parseInt(edition);
        } catch (NumberFormatException e) {
            // nothing to do

        }

        try {
            serviceInt = Integer.parseInt(service);
        } catch (NumberFormatException e) {
            // nothong to do
        }

        this.id = identifier;
        this.edtn = edtn;
        this.service = serviceInt;
    }

    /**
     * 
     * {@inheritDoc}
     * 
     * @see fr.geomod.components.cmdecarte.basket.model.BasketCell#getCellId()
     */
    public String getCellId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.geomod.components.cmdecarte.basket.model.BasketCell#getCellEdtn()
     */
    public int getCellEdtn() {
        return this.edtn;
    }

    /**
     * set CellEdtn number
     * 
     * @param edtn
     *            number edition
     */
    public void setCellEdtn(int edtn) {
        this.edtn = edtn;
    }

    /**
     * {@inheritDoc}
     * 
     * @see fr.geomod.components.cmdecarte.basket.model.BasketCell#getCellService()
     */
    public int getCellService() {
        return this.service;
    }

    /**
     * set CellService number
     * 
     * @param service
     *            service number
     */
    public void setCellService(int service) {
        this.service = service;
    }

}
