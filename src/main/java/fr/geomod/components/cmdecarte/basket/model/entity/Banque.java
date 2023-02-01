/*
 * @(#)Banque.java
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
 * <p><B>Title </B>: Banque.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: Banque.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */

@Builder
@Entity
@Table(name = "banque")
public class Banque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banque")
    private Long id;
    
    private String name;
    
    private String iban;
    
    private String bic;
    
    private LocalDate dateBanque;

    /**
     * @param id
     * @param name
     * @param iban
     * @param bic
     * @param dateBanque
     */
    public Banque(Long id, String name, String iban, String bic,
            LocalDate dateBanque) {
        super();
        this.id = id;
        this.name = name;
        this.iban = iban;
        this.bic = bic;
        this.dateBanque = dateBanque;
    }

    /**
     * 
     */
    public Banque() {
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
     * @return Returns the iban.
     */
    public String getIban() {
        return iban;
    }

    /**
     * @param iban The iban to set.
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * @return Returns the bic.
     */
    public String getBic() {
        return bic;
    }

    /**
     * @param bic The bic to set.
     */
    public void setBic(String bic) {
        this.bic = bic;
    }

    /**
     * @return Returns the dateBanque.
     */
    public LocalDate getDateBanque() {
        return dateBanque;
    }

    /**
     * @param dateBanque The dateBanque to set.
     */
    public void setDateBanque(LocalDate dateBanque) {
        this.dateBanque = dateBanque;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(bic, dateBanque, iban, id, name);
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
        if (!(obj instanceof Banque)) {
            return false;
        }
        Banque other = (Banque) obj;
        return Objects.equals(bic, other.bic)
                && Objects.equals(dateBanque, other.dateBanque)
                && Objects.equals(iban, other.iban)
                && Objects.equals(id, other.id)
                && Objects.equals(name, other.name);
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Banque [id=" + id + ", name=" + name + ", iban=" + iban
                + ", bic=" + bic + ", dateBanque=" + dateBanque + "]";
    }

}


