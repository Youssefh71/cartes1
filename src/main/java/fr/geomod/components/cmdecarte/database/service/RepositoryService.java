/*
 * @(#)DevisService.java
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
package fr.geomod.components.cmdecarte.database.service;

import java.util.Optional;

import fr.geomod.components.cmdecarte.database.model.entity.Banque;
import fr.geomod.components.cmdecarte.database.model.entity.Client;
import fr.geomod.components.cmdecarte.database.model.entity.Contact;
import fr.geomod.components.cmdecarte.database.repository.BanqueRepository;
import fr.geomod.components.cmdecarte.database.repository.ClientRepository;
import fr.geomod.components.cmdecarte.database.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.geomod.components.cmdecarte.database.model.entity.Devis;

import fr.geomod.components.cmdecarte.database.repository.DevisRepository;

/**
 * <p><B>Title </B>: DevisService.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: DevisService.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */

@Service
public class RepositoryService {
    
    @Autowired
    private DevisRepository devisRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BanqueRepository banqueRepository;

    @Autowired
    private ContactRepository contactRepository;


    //Devis
    public Optional<Devis> getDevisById(Long id) {
        return devisRepository.findById(id);
    }
    
    public Iterable<Devis> getAllDevis() {
        return devisRepository.findAll();
    }

    //Client
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    //Banque
    public Optional<Banque> getBanqueById(Long id){return banqueRepository.findById(id);}

    //Contact

    public Optional<Contact> getContactById(Long id){ return contactRepository.findById(id);}

}


