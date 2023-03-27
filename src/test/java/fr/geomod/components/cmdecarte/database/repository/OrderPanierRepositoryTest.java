/*
 * @(#)OrderPanierRepositoryTest.java
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
import fr.geomod.components.cmdecarte.persistence.entity.OrderPanier;
import fr.geomod.components.cmdecarte.persistence.repository.OrderPanierRepository;
import jakarta.transaction.Transactional;

/**
 * <p>
 * <B>Title </B>: OrderPanierRepositoryTest.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: OrderPanierRepositoryTest.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 *
 * @author GEOMOD
 * @since 2023
 */


@SpringBootTest
public class OrderPanierRepositoryTest {

    /**
     * Automatically inject dependencies of OrderPanierRepository
     */
    @Autowired
    private OrderPanierRepository repository;
    private OrderPanier panier = OrderPanier.builder().build();
    private OrderPanier orderPanierSave;

    /**
     * checks if the entity has been saved
     */
    @Test
    @Transactional
    public void testSave() {
        orderPanierSave = repository.save(panier);

        assertThat(orderPanierSave.getId()).isNotNull();
    }

    /**
     * checks if the entity with the given id was found
     */
    @Test
    @Transactional
    public void testFindById() {

        orderPanierSave = repository.save(panier);

        assertThat(repository.findById(orderPanierSave.getId()))
                .isEqualTo(Optional.of(panier));
    }

    /**
     * checks if the entity with the given id has been deleted
     */
    @Test
    @Transactional
    public void testDeleteById() {

        orderPanierSave = repository.save(panier);

        repository.deleteById(orderPanierSave.getId());

        assertThat(repository.findById(orderPanierSave.getId())).isEmpty();
    }
}
