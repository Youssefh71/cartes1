/*
 * @(#)BanqueRepositoryTest.java
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

import fr.geomod.components.cmdecarte.persistence.repository.BanqueRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fr.geomod.components.cmdecarte.persistence.entity.Banque;
import jakarta.transaction.Transactional;

/**
 * <p><B>Title </B>: BanqueRepositoryTest.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: BanqueRepositoryTest.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */


@SpringBootTest
public class BanqueRepositoryTest {
    
    /**
     * Automatically inject dependencies of BanqueRepository
     */
    @Autowired
    private BanqueRepository repository;
    private static final LocalDate DATE_Banque = LocalDate.now();
    private static final String NAME = "BNP Paribas";
    private static final String IBAN = "FR76.3000.4001.6500.0100.3001.538";
    private static final String BIC = "BNPAFRPPVBE";
    private final Banque banque = Banque.builder().name(NAME).iban(IBAN).bic(BIC).dateBanque(DATE_Banque).build();
    
    private Banque banqueSave;

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * checks if the entity has been saved
     */
    @Test
    @Transactional
    public void testSave() {
        banqueSave = repository.save(banque);
        
        assertThat(banqueSave.getBic()).isEqualTo("BNPAFRPPVBE");
        assertThat(banqueSave.getIban()).isEqualTo("FR76.3000.4001.6500.0100.3001.538");
        assertThat(banqueSave.getName()).isEqualTo("BNP Paribas");
        assertThat(banqueSave.getDateBanque()).isEqualTo(LocalDate.now());
    }
    
    /**
     * checks if the entity with the given id was found
     */
    @Test
    @Transactional
    public void testFindById() {
        
        banqueSave = repository.save(banque);

        assertThat(repository.findById(banqueSave.getId()))
                .isEqualTo(Optional.of(banque));
    }
    
    /**
     * checks if the entity with the given id has been deleted
     */
    @Test
    @Transactional
    public void testDeleteById() {
        
        banqueSave = repository.save(banque);
        
        repository.deleteById(banqueSave.getId());

        assertThat(repository.findById(banqueSave.getId())).isEmpty();
    }

}


