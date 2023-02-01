/*
 * @(#)TvaRepositoryTest.java
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
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import fr.geomod.components.cmdecarte.basket.model.entity.Tva;

/**
 * <p>
 * <B>Title </B>: TvaRepositoryTest.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: TvaRepositoryTest.java
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
public class TvaRepositoryTest {

    @Autowired
    private TvaRepository repository;

    @Autowired
    private EntityManager em;

    private static final LocalDate DATE_TVA = LocalDate.now();

    private static final float MONTANT = (float) 5.5;

    private Tva tva = Tva.builder().dateTva(DATE_TVA).montant(MONTANT).build();
    
    private Tva tvaSave;

    @Before
    public void setUp() throws Exception {
        em.persist(tva);

    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Commit permet
     */
    @Test
    @Transactional
    @Commit
    public void testSave() {
              
        tvaSave=   repository.save(tva);
        
        assertThat(tvaSave.getMontant()).isEqualTo(5.5f);
        assertThat(tvaSave.getDateTva()).isEqualTo(LocalDate.now());
        System.out.println(tvaSave);
    }

    @Test
    @Transactional
    public void findById() {

        assertThat(repository.findById(tva.getId()))
                .isEqualTo(Optional.of(tva));

    }
    
    @Test
    @Transactional
    public void deleteById() {
        
        repository.deleteById(tva.getId());

        assertThat(repository.findById(tva.getId())).isEmpty();

    }
}
