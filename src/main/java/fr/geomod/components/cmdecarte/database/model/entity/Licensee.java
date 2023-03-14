/*
 * @(#)Licensee.java
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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;

/**
 * <p>
 * <B>Title </B>: Licensee.java.
 * </p>
 * <p>
 * <B>Copyright </B>: Copyright (c) 2023.
 * </p>
 * <p>
 * <B>Company </B>: GEOMOD
 * </p>
 * <p>
 * <B>Filename </B>: Licensee.java
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
@Table(name = "licensee")
public class Licensee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_licensee")
    private Long id;

    private String name;

    private String francisation;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_client")
    private Client client;
    
    @OneToMany(mappedBy = "licensee")
    private List<UserPermit> userPermit;


    public Licensee(Long id, String name, String francisation, Client client,
            List<UserPermit> userPermit) {
        super();
        this.id = id;
        this.name = name;
        this.francisation = francisation;
        this.client = client;
        this.userPermit = userPermit;
    }

    /**
     * 
     */
    public Licensee() {
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
     * @return Returns the francisation.
     */
    public String getFrancisation() {
        return francisation;
    }

    /**
     * @param francisation The francisation to set.
     */
    public void setFrancisation(String francisation) {
        this.francisation = francisation;
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
     * @return Returns the userPermit.
     */
    public List<UserPermit> getUserPermit() {
        return userPermit;
    }

    /**
     * @param userPermit The userPermit to set.
     */
    public void setUserPermit(List<UserPermit> userPermit) {
        this.userPermit = userPermit;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(client, francisation, id, name, userPermit);
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
        if (!(obj instanceof Licensee other)) {
            return false;
        }
        return Objects.equals(client, other.client)
                && Objects.equals(francisation, other.francisation)
                && Objects.equals(id, other.id)
                && Objects.equals(name, other.name)
                && Objects.equals(userPermit, other.userPermit);
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Licensee [id=" + id + ", name=" + name + ", francisation="
                + francisation + ", client=" + client + "]";
    }


}
