/*
 * @(#)Markup.java
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
import jakarta.persistence.Table;
import lombok.Builder;

/**
 * <p><B>Title </B>: Markup.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: Markup.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */

@Builder
@Entity
@Table(name = "markup")
public class Markup {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_markup")
    private Long id;

    private float montant;

    @Column(name = "date_markup")
    private LocalDate dateMarkup;
    
    /**
     * 
     */
    public Markup() {
        super();
    }

    /**
     * @param id
     * @param montant
     * @param dateMarkup
     */
    public Markup(Long id, float montant, LocalDate dateMarkup) {
        super();
        this.id = id;
        this.montant = montant;
        this.dateMarkup = dateMarkup;
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
     * @return Returns the montant.
     */
    public float getMontant() {
        return montant;
    }

    /**
     * @param montant The montant to set.
     */
    public void setMontant(float montant) {
        this.montant = montant;
    }

    /**
     * @return Returns the dateMarkup.
     */
    public LocalDate getDateMarkup() {
        return dateMarkup;
    }

    /**
     * @param dateMarkup The dateMarkup to set.
     */
    public void setDateMarkup(LocalDate dateMarkup) {
        this.dateMarkup = dateMarkup;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(dateMarkup, id, montant);
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
        if (!(obj instanceof Markup)) {
            return false;
        }
        Markup other = (Markup) obj;
        return Objects.equals(dateMarkup, other.dateMarkup)
                && Objects.equals(id, other.id)
                && Float.floatToIntBits(montant) == Float
                        .floatToIntBits(other.montant);
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Markup [id=" + id + ", montant=" + montant + ", dateMarkup="
                + dateMarkup + "]";
    }
}


