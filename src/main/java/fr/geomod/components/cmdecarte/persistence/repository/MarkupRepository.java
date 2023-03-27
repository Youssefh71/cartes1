/*
 * @(#)MarkupRepository.java
 *
 * Copyright (c) 2023 GEOMOD SA. All rights reserved.
 * GEOMOD PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 *
 * This file, together  with  its accompanying  software product  and
 * documentation, is  protected by the  intellectual  property rights
 * in  France  and  other  countries, any  applicable  copyrights  or
 * patent rights, and international treaty provisions. No part may be
 * reproduced  in  any  form  by  any  mean  without   prior  written
 * authorization of GEOMOD.
 */
package fr.geomod.components.cmdecarte.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.geomod.components.cmdecarte.persistence.entity.Markup;

/**
 * <p><B>Title </B>: MarkupRepository.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: MarkupRepository.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */

@Repository
public interface MarkupRepository extends CrudRepository<Markup, Long> {

}


