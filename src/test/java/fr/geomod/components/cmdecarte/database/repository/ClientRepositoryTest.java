/*
 * @(#)ClientRepositoryTest.java
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
import fr.geomod.components.cmdecarte.persistence.entity.Client;
import fr.geomod.components.cmdecarte.persistence.entity.Devis;
import fr.geomod.components.cmdecarte.persistence.repository.ClientRepository;
import fr.geomod.components.cmdecarte.persistence.repository.DevisRepository;
import jakarta.transaction.Transactional;

/**
 * <p>
 * <B>Title </B>: ClientRepositoryTest.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: ClientRepositoryTest.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 *
 * @author GEOMOD
 * @since 2023
 */

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository repository;
    private static final String LANGUE = "fr";
    private static final String NAME = "BAI SA TEST1";
    private static final String ADRESSE = "Service Comptabilité";
    private static final String ADRESSE2 = " BP 84";
    private static final String VILLE = "ROSCOFF cedex";
    private static final String ZIP_CODE = "29688";

    private static final String PAYS = "France";

    private Client client = Client.builder().name(NAME).adresse(ADRESSE).adresse2(ADRESSE2)
            .ville(VILLE).zipCode(ZIP_CODE).langue(LANGUE).pays(PAYS).build();

    private static final String NUMERO = "2022-Z-549-5";
    private static final Integer VALIDITY = 30;
    private static final String TITRE = "BRETAGNE";
    private static final LocalDate DATE_DEVIS = LocalDate.now();

    private Client clientSave;

    /**
     * checks if the entity has been saved
     */
    @Test
    @Transactional
    public void testSave() {

        clientSave = repository.save(client);

        assertThat(clientSave.getAdresse())
                .isEqualTo("Service Comptabilité");
        assertThat(clientSave.getName()).isEqualTo("BAI SA TEST1");
        assertThat(clientSave.getVille()).isEqualTo("ROSCOFF cedex");
        assertThat(clientSave.getZipCode()).isEqualTo("29688");
        assertThat(clientSave.getPays()).isEqualTo("France");
        assertThat(clientSave.getLangue()).isEqualTo("fr");
    }

    /**
     * checks if the entity with the given name was found
     */
    @Test
    @Transactional
    public void testFindByName() {

        clientSave = repository.save(client);

        assertThat(repository.findByNameContaining("TEST1")).isEqualTo(client);
        assertThat(repository.findByNameContaining("T")).isEqualTo(client);
        assertThat(repository.findByNameContaining("Z")).isNotEqualTo(client);
    }

//    @Test
//    @Transactional
//    public void testFindByDevis() {
//
//        devisSave = devisRepository.save(devis);
//        clientSave = repository.save(client);
//
//
//
//        System.out.println(clientSave);
//        System.out.println(devisSave);
//        System.out.println(repository.findByDevis("2022-Z-549-5"));
//
//        assertThat(repository.findByDevis("2022-Z-549-5")).isEqualTo(client.getName());
//
//
//    }

    /**
     * checks if the entity with the given id was found
     */
    @Test
    @Transactional
    public void testFindById() {

        clientSave = repository.save(client);

        assertThat(repository.findById(clientSave.getId()))
                .isEqualTo(Optional.of(client));
    }

    /**
     * checks if the entity with the given id has been deleted
     */
    @Test
    @Transactional
    public void testDeleteById() {

        clientSave = repository.save(client);

        repository.deleteById(clientSave.getId());

        assertThat(repository.findById(clientSave.getId())).isEmpty();
    }
}
