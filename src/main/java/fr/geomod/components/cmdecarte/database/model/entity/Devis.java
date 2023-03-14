/*
 * @(#)Devis.java
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
package fr.geomod.components.cmdecarte.database.model.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;

/**
 * <p><B>Title </B>: Devis.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: Devis.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */

@Builder
@Entity
@Table(name = "devis")
public class Devis {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devis")
    private Long id;
    
    private String numero;

    private Integer validity;
    
    private String titre;
    
    @Column(name = "date_devis")
    private LocalDate dateDevis;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_client")
    private Client client;


    public Devis(Long id, String numero, Integer validity, String titre,
            LocalDate dateDevis, Client client) {
        super();
        this.id = id;
        this.numero = numero;
        this.validity = validity;
        this.titre = titre;
        this.dateDevis = dateDevis;
        this.client = client;
    }

    /**
     * 
     */
    public Devis() {
        super();
    }

    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Returns the numero.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero The numero to set.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return Returns the validity.
     */
    public Integer getValidity() {
        return validity;
    }

    /**
     * @param validity The validity to set.
     */
    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    /**
     * @return Returns the titre.
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre The titre to set.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return Returns the dateDevis.
     */
    public LocalDate getDateDevis() {
        return dateDevis;
    }

    /**
     * @param dateDevis The dateDevis to set.
     */
    public void setDateDevis(LocalDate dateDevis) {
        this.dateDevis = dateDevis;
    }

       /**
     * @return Returns the client.
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client The client to set.
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(client, dateDevis, id, numero, titre,
                validity);
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Devis other)) {
            return false;
        }
        return Objects.equals(client, other.client)
                && Objects.equals(dateDevis, other.dateDevis)
                && Objects.equals(id, other.id)
                && Objects.equals(numero, other.numero)
                && Objects.equals(titre, other.titre)
                && Objects.equals(validity, other.validity);
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Devis [id=" + id + ", numero=" + numero + ", validity="
                + validity + ", titre=" + titre + ", dateDevis=" + dateDevis
                +  ", client=" + client + "]";
    }

  
    
}


