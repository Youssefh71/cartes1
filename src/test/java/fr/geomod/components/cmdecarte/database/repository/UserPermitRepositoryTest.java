/*
 * @(#)UserPermitRepositoryTest.java
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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.geomod.components.cmdecarte.database.model.entity.UserPermit;
import fr.geomod.components.cmdecarte.database.repository.UserPermitRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/**
 * <p>
 * <B>Title </B>: UserPermitRepositoryTest.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: UserPermitRepositoryTest.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 * 
 * @author GEOMOD
 * @since 2023
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPermitRepositoryTest {

    @Autowired
    private UserPermitRepository repository;

    @Autowired
    private EntityManager em;

    private static final String NAME = "GECDIS 50";
    private static final String NUMERO = "(43E57713A647056EC52652BA3833)";

    private UserPermit userPermit = UserPermit.builder().name(NAME)
            .numero(NUMERO).build();

    private UserPermit userPermitSave;

    @Before
    public void setUp() throws Exception {
        em.persist(userPermit);

    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * checks if the entity has been saved
     */
    @Test
    @Transactional
    public void testSave() {

        userPermitSave = repository.save(userPermit);

        assertThat(userPermitSave.getName()).isEqualTo("GECDIS 50");
        assertThat(userPermitSave.getNumero())
                .isEqualTo("(43E57713A647056EC52652BA3833)");

    }
    
    /**
     * checks if the entity with the given id was found
     */
    @Test
    @Transactional
    public void testFindById() {

        userPermitSave = repository.save(userPermit);

        assertThat( repository.findById(userPermit.getId()))
                .isEqualTo(Optional.of(userPermit));

    }

    /**
     * checks if the entity with the given id has been deleted
     */
    @Test
    @Transactional
    public void testDeleteById() {

        userPermitSave = repository.save(userPermit);

        repository.deleteById(userPermitSave.getId());

        assertThat(repository.findById(userPermitSave.getId())).isEmpty();

    }

}
