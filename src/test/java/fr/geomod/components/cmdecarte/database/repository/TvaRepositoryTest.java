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
package fr.geomod.components.cmdecarte.database.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fr.geomod.components.cmdecarte.persistence.entity.Tva;
import fr.geomod.components.cmdecarte.persistence.repository.TvaRepository;
import jakarta.transaction.Transactional;

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


@SpringBootTest
public class TvaRepositoryTest {

    @Autowired
    private TvaRepository repository;
    private static final LocalDate DATE_TVA = LocalDate.now();
    private static final float MONTANT = (float) 5.5;
    private Tva tva = Tva.builder().dateTva(DATE_TVA).montant(MONTANT).build();
    private Tva tvaSave;

    /**
     * checks if the entity has been saved
     */
    @Test
    @Transactional
    public void testSave() {

        tvaSave = repository.save(tva);

        assertThat(tvaSave.getMontant()).isEqualTo(5.5f);
        assertThat(tvaSave.getDateTva()).isEqualTo(LocalDate.now());
        System.out.println(tvaSave);
    }

    /**
     * checks if the entity with the given id was found
     */
    @Test
    @Transactional
    public void findById() {
        tvaSave = repository.save(tva);

        assertThat(repository.findById(tva.getId()))
                .isEqualTo(Optional.of(tva));
    }

    /**
     * checks if the entity with the given id has been deleted
     */
    @Test
    @Transactional
    public void deleteById() {
        tvaSave = repository.save(tva);

        repository.deleteById(tva.getId());

        assertThat(repository.findById(tva.getId())).isEmpty();
    }
}
