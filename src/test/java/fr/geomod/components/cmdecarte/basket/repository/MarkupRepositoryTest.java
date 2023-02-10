/*
 * @(#)MarkupRepositoryTest.java
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
package fr.geomod.components.cmdecarte.basket.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import fr.geomod.components.cmdecarte.basket.model.entity.Markup;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/**
 * <p>
 * <B>Title </B>: MarkupRepositoryTest.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: MarkupRepositoryTest.java
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
public class MarkupRepositoryTest {

    @Autowired
    private MarkupRepository repository;

    @Autowired
    private EntityManager em;

    private static final LocalDate DATE_MARKUP = LocalDate.now();

    private static final float MONTANT = (float) 150;

    private Markup markup = Markup.builder().dateMarkup(DATE_MARKUP)
            .montant(MONTANT).build();

    private Markup markupSave;

    @Before
    public void setUp() throws Exception {
        em.persist(markup);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * checks if the entity has been saved
     */
    @Test
    @Transactional
    /**
     * Commit is a test annotation that is used to save in de bdd
     */
    @Commit
    public void testSave() {

        markupSave = repository.save(markup);

        assertThat(markupSave.getMontant()).isEqualTo(150f);
        assertThat(markupSave.getDateMarkup()).isEqualTo(LocalDate.now());

    }

    /**
     * checks if the entity with the given id was found
     */
    @Test
    @Transactional
    public void findById() {

        assertThat(repository.findById(markup.getId()))
                .isEqualTo(Optional.of(markup));

    }

    /**
     * checks if the entity with the given id has been deleted
     */
    @Test
    @Transactional
    public void deleteById() {

        repository.deleteById(markup.getId());

        assertThat(repository.findById(markup.getId())).isEmpty();

    }

}
