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
import fr.geomod.components.cmdecarte.basket.model.entity.Licensee;
import fr.geomod.components.cmdecarte.basket.model.entity.UserPermit;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/**
 * <p><B>Title </B>: UserPermitRepositoryTest.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: UserPermitRepositoryTest.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPermitRepositoryTest {
    
    @Autowired
    private UserPermitRepository  repository;
    
    @Autowired
    private EntityManager em;
    
    private static final String NAME = "GECDIS 50";
    private static final String NUMERO ="(43E57713A647056EC52652BA3833)";
    
    private UserPermit userPermit= UserPermit.builder().name(NAME).numero(NUMERO).build();
    
    
    private static final String NAME1= "BAI SA TEST1";
    private static final String ADRESSE ="Service Comptabilité BP 84";
    private static final String VILLE ="ROSCOFF cedex";
    private static final String ZIP_CODE ="29688";
        
    private Client client = Client.builder().name(NAME1).adresse(ADRESSE).ville(VILLE).zipCode(ZIP_CODE).build();
    
    private static final String NUMERO1 = "2022-Z-549-5";
    private static final Integer VALIDITY =30;
    private static final String TITRE ="BRETAGNE";
    private static final LocalDate DATE_DEVIS = LocalDate.now();
    
    private Devis devis = Devis.builder().numero(NUMERO1).validity(VALIDITY).titre(TITRE).dateDevis(DATE_DEVIS).client(client).build();
    
    private static final String NAME2 = "BRETAGNE";
    
    private Licensee licensee = Licensee.builder().name(NAME2).build();
    
   
    private UserPermit userPermitSave;

    @Before
    public void setUp() throws Exception {
        em.persist(userPermit);
        em.persist(devis);
        em.persist(client);
        em.persist(licensee);
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    @Transactional
    public void testSave() {
        
        userPermitSave = repository.save(userPermit);
        
        assertThat(userPermitSave.getName()).isEqualTo("GECDIS 50");
        assertThat(userPermitSave.getNumero()).isEqualTo("(43E57713A647056EC52652BA3833)");

        
    }

        
    @Test
    @Transactional
    public void testDeleteById() {
        
        userPermitSave = repository.save(userPermit);
        
        repository.deleteById(userPermitSave.getId());

        assertThat(repository.findById(userPermitSave.getId())).isEmpty();

    }

}


