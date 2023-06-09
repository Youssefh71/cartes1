/*
 * @(#)CellRepositoryTest.java
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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fr.geomod.components.cmdecarte.persistence.entity.Cell;
import fr.geomod.components.cmdecarte.persistence.repository.CellRepository;
import jakarta.transaction.Transactional;

/**
 * <p><B>Title </B>: CellRepositoryTest.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: CellRepositoryTest.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */


@SpringBootTest
public class CellRepositoryTest {
    /**
     * Automatically inject dependencies of OrderHeaderRepository
     */
    @Autowired
    private CellRepository repository;
    private static final String  NAME = "GB30364";
    private static final Integer SERVICE_TYPE= 1;
    private Cell cell = Cell.builder().cellName(NAME).cellEdtn(null).serviceType(SERVICE_TYPE).build();
    private Cell cellSave;
    @BeforeEach
    public void setUp() throws Exception {}

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * checks if the entity has been saved
     */
    @Test
    @Transactional
    public void testSave() {
        cellSave= repository.save(cell);
        assertThat(cellSave.getId()).isNotNull();
    }

    /**
     * checks if the entity with the given id was found
     */
    @Test
    @Transactional
    public void testFindById() {

        cellSave= repository.save(cell);
        assertThat(repository.findById(cellSave.getId()))
                .isEqualTo(Optional.of(cell));
    }

    /**
     * checks if the entity with the given id has been deleted
     */
    @Test
    @Transactional
    public void testDeleteById() {

        cellSave= repository.save(cell);

        repository.deleteById(cellSave.getId());

        assertThat(repository.findById(cellSave.getId())).isEmpty();
    }
}


