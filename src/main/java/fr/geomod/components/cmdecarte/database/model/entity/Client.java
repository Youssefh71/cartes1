/*
 * @(#)Client.java
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

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

/**
 * <p>
 * <B>Title </B>: Client.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: Client.java
 * </p>
 * <p>
 * <B>Description </B>:
 * </p>
 * 
 * @author GEOMOD
 * @since 2023
 */

@Builder
@ToString
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;

    private String name;

    private String adresse;
    
    private String adresse2;

    private String ville;

    @Column(name = "zip_code")
    private String zipCode;

    private String pays;

    @OneToMany(mappedBy = "client")
    private List<Licensee> licensee;

    @OneToMany(mappedBy = "client")
    private List<Devis> devis;
    
    @OneToMany(mappedBy = "client")
    private List<OrderPanier> paniers;
    

    public Client(Long id, String name, String adresse, String adresse2,
            String ville, String zipCode, String pays, List<Licensee> licensee,
            List<Devis> devis, List<OrderPanier> paniers) {
        super();
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.adresse2 = adresse2;
        this.ville = ville;
        this.zipCode = zipCode;
        this.pays = pays;
        this.licensee = licensee;
        this.devis = devis;
        this.paniers = paniers;
    }


    /**
     * 
     */
    public Client() {
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
     * @return Returns the adresse.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse The adresse to set.
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return Returns the adresse2.
     */
    public String getAdresse2() {
        return adresse2;
    }

    /**
     * @param adresse2 The adresse2 to set.
     */
    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    /**
     * @return Returns the ville.
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville The ville to set.
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return Returns the zipCode.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode The zipCode to set.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return Returns the pays.
     */
    public String getPays() {
        return pays;
    }

    /**
     * @param pays The pays to set.
     */
    public void setPays(String pays) {
        this.pays = pays;
    }

    /**
     * @return Returns the licensee.
     */
    public List<Licensee> getLicensee() {
        return licensee;
    }

    /**
     * @param licensee The licensee to set.
     */
    public void setLicensee(List<Licensee> licensee) {
        this.licensee = licensee;
    }

    /**
     * @return Returns the devis.
     */
    public List<Devis> getDevis() {
        return devis;
    }

    /**
     * @param devis The devis to set.
     */
    public void setDevis(List<Devis> devis) {
        this.devis = devis;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(adresse, adresse2, devis, id, licensee, name, pays,
                ville, zipCode);
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
        if (!(obj instanceof Client)) {
            return false;
        }
        Client other = (Client) obj;
        return Objects.equals(adresse, other.adresse)
                && Objects.equals(adresse2, other.adresse2)
                && Objects.equals(devis, other.devis)
                && Objects.equals(id, other.id)
                && Objects.equals(licensee, other.licensee)
                && Objects.equals(name, other.name)
                && Objects.equals(pays, other.pays)
                && Objects.equals(ville, other.ville)
                && Objects.equals(zipCode, other.zipCode);
    }




    /**
     * @return Returns the paniers.
     */
    public List<OrderPanier> getPaniers() {
        return paniers;
    }


    /**
     * @param paniers The paniers to set.
     */
    public void setPaniers(List<OrderPanier> paniers) {
        this.paniers = paniers;
    }


}
