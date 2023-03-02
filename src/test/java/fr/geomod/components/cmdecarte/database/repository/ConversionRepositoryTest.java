/*
 * @(#)ConversionRepositoryTest.java
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

import java.time.LocalDate;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.geomod.components.cmdecarte.database.model.entity.Conversion;
import fr.geomod.components.cmdecarte.database.repository.ConversionRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/**
 * <p>
 * <B>Title </B>: ConversionRepositoryTest.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: ConversionRepositoryTest.java
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
public class ConversionRepositoryTest {

    @Autowired
    private ConversionRepository repository;

    @Autowired
    private EntityManager em;

    private static final LocalDate DATE_CONVERSION = LocalDate.now();

    private static final float TAUX = (float) 1.1;

    private Conversion taux = Conversion.builder()
            .dateConversion(DATE_CONVERSION).taux(TAUX).build();

    private Conversion conversionSave;

    @Before
    public void setUp() throws Exception {
        em.persist(taux);

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

        conversionSave = repository.save(taux);

        assertThat(conversionSave.getTaux()).isEqualTo(1.1f);
        assertThat(conversionSave.getDateConversion())
                .isEqualTo(LocalDate.now());

    }

    /**
     * checks if the entity with the given id was found
     */
    @Test
    @Transactional
    public void testFindById() {

        conversionSave = repository.save(taux);

        assertThat(repository.findById(taux.getId()))
                .isEqualTo(Optional.of(taux));

    }

    /**
     * checks if the entity with the given id has been deleted
     */
    @Test
    @Transactional
    public void testDeleteById() {

        conversionSave = repository.save(taux);

        repository.deleteById(taux.getId());

        assertThat(repository.findById(taux.getId())).isEmpty();

    }

}
