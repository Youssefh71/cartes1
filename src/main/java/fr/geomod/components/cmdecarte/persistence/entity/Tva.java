/*
 * @(#)TauxDeConversion.java
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
package fr.geomod.components.cmdecarte.persistence.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

import lombok.*;

/**
 * <p>
 * <B>Title </B>: TauxDeTva.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: TauxDeTva.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 * 
 * @author GEOMOD
 * @since 2023
 */

@Builder
@Entity
@Table(name = "tva")
public class Tva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tva")
    private Long id;

    private float montant;

    private LocalDate dateTva;

    public Tva(Long id, float montant, LocalDate dateTva) {
        super();
        this.id = id;
        this.montant = montant;
        this.dateTva = dateTva;
    }

    /**
     * Tva constructor
     */
    public Tva() {

    }

    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            The id to set.
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
     * @param montant
     *            The montant to set.
     */
    public void setMontant(float montant) {
        this.montant = montant;
    }

    /**
     * @return Returns the dateTva.
     */
    public LocalDate getDateTva() {
        return dateTva;
    }

    /**
     * @param dateTva
     *            The dateTva to set.
     */
    public void setDateTva(LocalDate dateTva) {
        this.dateTva = dateTva;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Tva [id=" + id + ", montant=" + montant + ", dateTva=" + dateTva
                + "]";
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(dateTva, id, montant);
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tva other)) {
            return false;
        }
        return Objects.equals(dateTva, other.dateTva)
                && Objects.equals(id, other.id)
                && Objects.equals(montant, other.montant);
    }

}
