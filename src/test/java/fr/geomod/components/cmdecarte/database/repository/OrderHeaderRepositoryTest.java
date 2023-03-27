/*
 * @(#)OrderHeaderRepositoryTest.java
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
package fr.geomod.components.cmdecarte.database.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fr.geomod.components.cmdecarte.persistence.entity.OrderHeader;
import fr.geomod.components.cmdecarte.persistence.repository.OrderHeaderRepository;
import jakarta.transaction.Transactional;

/**
 * <p>
 * <B>Title </B>: OrderHeaderRepositoryTest.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: OrderHeaderRepositoryTest.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 * 
 * @author GEOMOD
 * @since 2023
 */
@SpringBootTest
public class OrderHeaderRepositoryTest {
    /**
     * Automatically inject dependencies of OrderHeaderRepository
     */
    @Autowired
    private OrderHeaderRepository repository;

    private static final Integer ORDERING_SYSTEM = 1;
    private static final String LANGUAGE_CODE = "en";
    private OrderHeader orderHeader = OrderHeader.builder()
            .orderingSystem(ORDERING_SYSTEM).languageCode(LANGUAGE_CODE)
            .build();
    private OrderHeader orderHeaderSave;

    /**
     * checks if the entity has been saved
     */
    @Test
    @Transactional
    public void testSave() {
        orderHeaderSave = repository.save(orderHeader);

        assertThat(orderHeaderSave.getId()).isNotNull();
    }

    /**
     * checks if the entity with the given id was found
     */
    @Test
    @Transactional
    public void testFindById() {

        orderHeaderSave = repository.save(orderHeader);

        assertThat(repository.findById(orderHeaderSave.getId()))
                .isEqualTo(Optional.of(orderHeader));
    }

    /**
     * checks if the entity with the given id has been deleted
     */
    @Test
    @Transactional
    public void testDeleteById() {

        orderHeaderSave = repository.save(orderHeader);

        repository.deleteById(orderHeaderSave.getId());

        assertThat(repository.findById(orderHeaderSave.getId())).isEmpty();
    }

}
