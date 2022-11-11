/*
 * @(#)BasketHelperImpl.java
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
package fr.geomod.components.cmdecarte.basket.model.helper;

import fr.geomod.components.cmdecarte.basket.model.Basket;
import fr.geomod.components.cmdecarte.basket.model.impl.BasketComparisonImpl;

/**
 * <p><B>Title </B>: BasketHelperImpl.</p>
 * <p><B>Copyright </B>: Copyright (c) 2022. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: BasketHelperImpl.java</p>
 * <p><B>Description </B>: A helper class with static methods </p>
 * @author GEOMOD
 * @since 2022
 */
public class BasketHelperImpl {
    
    /**
     * Default constructor
     */
    private BasketHelperImpl() {
        // empty private constructor to avoid instantiation
    }
    
    /**
     * Compares 2 baskets.
     * @param basket1 original basket (reference)
     * @param basket2 new basket.
     * @return The difference between the given baskets, null if baskets are identical.
     */
    public static BasketComparisonImpl compare(Basket basket1, Basket basket2) {
        BasketComparisonImpl result = null;
        // TODO Youssef, itérer sur les cellules du basket1, voir si elles sont dans le basket2 et si les attributs sont les memes...
        
        return result;
    }

}


