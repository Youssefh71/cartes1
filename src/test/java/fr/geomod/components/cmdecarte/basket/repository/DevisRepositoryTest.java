/*
 * @(#)DevisRepositoryTest.java
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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.geomod.components.cmdecarte.basket.model.entity.Client;
import fr.geomod.components.cmdecarte.basket.model.entity.Devis;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/**
 * <p><B>Title </B>: DevisRepositoryTest.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: DevisRepositoryTest.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevisRepositoryTest {
    
    @Autowired
    private ClientRepository repository;
    
    @Autowired
    private DevisRepository devisRepository;
    
    @Autowired
    private EntityManager em;
    
    private static final String NAME = "BAI SA TEST1";
    private static final String ADRESSE ="Service Comptabilité BP 84";
    private static final String VILLE ="ROSCOFF cedex";
    private static final String ZIP_CODE ="29688";
        
    private Client client = Client.builder().name(NAME).adresse(ADRESSE).ville(VILLE).zipCode(ZIP_CODE).build();
    
    private static final String NUMERO = "2022-Z-549-5";
    private static final Integer VALIDITY =30;
    private static final String TITRE ="BRETAGNE";
    private static final LocalDate DATE_DEVIS = LocalDate.now();
    
    private Devis devis = Devis.builder().numero(NUMERO).validity(VALIDITY).titre(TITRE).dateDevis(DATE_DEVIS).client(client).build();
   
    private Devis devisSave;

    @Before
    public void setUp() throws Exception {
        em.persist(devis);
        em.persist(client);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Transactional
    public void testSave() {
        
        devisSave = devisRepository.save(devis);
        
        assertThat(devisSave.getNumero()).isEqualTo("2022-Z-549-5");
        assertThat(devisSave.getDateDevis()).isEqualTo(LocalDate.now());
        assertThat(devisSave.getTitre()).isEqualTo("BRETAGNE");
        assertThat(devisSave.getValidity()).isEqualTo(30);
        
    }
    
    @Test
    @Transactional
    public void testDeleteById() {
        
        devisSave = devisRepository.save(devis);
        
        repository.deleteById(devisSave.getId());

        assertThat(repository.findById(devisSave.getId())).isEmpty();

    }

}


