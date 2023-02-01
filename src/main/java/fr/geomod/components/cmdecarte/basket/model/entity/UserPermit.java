/*
 * @(#)UserPermit.java
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
package fr.geomod.components.cmdecarte.basket.model.entity;

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
 * <p><B>Title </B>: UserPermit.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: UserPermit.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */

@Builder
@Entity
@Table(name = "user_Permit")
public class UserPermit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permit")
    private Long id;
    
    private String name;
    
    private String numero;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_licensee")
    private Licensee licensee;

    /**
     * @param id
     * @param name
     * @param numero
     * @param licensee
     */
    public UserPermit(Long id, String name, String numero, Licensee licensee) {
        super();
        this.id = id;
        this.name = name;
        this.numero = numero;
        this.licensee = licensee;
    }

    /**
     * 
     */
    public UserPermit() {
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
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
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
     * @return Returns the licensee.
     */
    public Licensee getLicensee() {
        return licensee;
    }

    /**
     * @param licensee The licensee to set.
     */
    public void setLicensee(Licensee licensee) {
        this.licensee = licensee;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, licensee, name, numero);
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
        if (!(obj instanceof UserPermit)) {
            return false;
        }
        UserPermit other = (UserPermit) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(licensee, other.licensee)
                && Objects.equals(name, other.name)
                && Objects.equals(numero, other.numero);
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserPermit [id=" + id + ", name=" + name + ", numero=" + numero
                + ", licensee=" + licensee + "]";
    }

}


