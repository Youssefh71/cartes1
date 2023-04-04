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
 * <p><B>Title </B>: TauxDeConversion.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: TauxDeConversion.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */


@Builder
@Entity
@Table(name = "conversion")
public class Conversion {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conversion")
    private Long id;
    
    private float taux;
    
    private LocalDate dateConversion;
    
    /**
     *  Conversion constructor
     */
    public Conversion() {
        super();
    }


    public Conversion(Long id, float taux, LocalDate dateConversion) {
        super();
        this.id = id;
        this.taux = taux;
        this.dateConversion = dateConversion;
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
     * @return Returns the taux.
     */
    public float getTaux() {
        return taux;
    }

    /**
     * @param taux The taux to set.
     */
    public void setTaux(float taux) {
        this.taux = taux;
    }

    /**
     * @return Returns the dateConversion.
     */
    public LocalDate  getDateConversion() {
        return dateConversion;
    }

    /**
     * @param dateConversion The dateConversion to set.
     */
    public void setDateConversion(LocalDate dateConversion) {
        this.dateConversion = dateConversion;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(dateConversion, id, taux);
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
        if (!(obj instanceof Conversion other)) {
            return false;
        }
        return Objects.equals(dateConversion, other.dateConversion)
                && Objects.equals(id, other.id)
                && Objects.equals(taux, other.taux);
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Conversion [id=" + id + ", taux=" + taux + ", dateConversion="
                + dateConversion + "]";
    }

}


