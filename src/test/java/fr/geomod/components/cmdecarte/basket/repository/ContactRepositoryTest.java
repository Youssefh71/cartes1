/*
 * @(#)ContactRepositoryTest.java
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

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.geomod.components.cmdecarte.basket.model.entity.Contact;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/**
 * <p>
 * <B>Title </B>: ContactRepositoryTest.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: ContactRepositoryTest.java
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
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository repository;

    @Autowired
    private EntityManager em;

    private static final String MAIL = "primar-enc@geomod.fr";

    private static final String PHONE = "+33(0)2.98.05.55.91";

    private Contact contact = Contact.builder().mail(MAIL).phone(PHONE).build();

    private Contact contactSave;

    @Before
    public void setUp() throws Exception {

        em.persist(contact);
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

        contactSave = repository.save(contact);

        assertThat(contactSave.getMail()).isEqualTo("primar-enc@geomod.fr");
        assertThat(contactSave.getPhone()).isEqualTo("+33(0)2.98.05.55.91");
        assertThat(contactSave.getMail()).isNotEqualTo("primar-enc@geomod");
        assertThat(contactSave.getPhone()).isNotEqualTo("+33()2.98.05.55.91");
    }

    /**
     * checks if the entity with the given id was found
     */
    @Test
    @Transactional
    public void testFindById() {

        contactSave = repository.save(contact);

        assertThat(repository.findById(contact.getId()))
                .isEqualTo(Optional.of(contact));

    }

    /**
     * checks if the entity with the given id has been deleted
     */
    @Test
    @Transactional
    public void testDeleteById() {

        contactSave = repository.save(contact);

        repository.deleteById(contact.getId());

        assertThat(repository.findById(contact.getId())).isEmpty();

    }

}
