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
package fr.geomod.components.cmdecarte.persistence.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;

    private String langue;

    private String destinataire;
    private String name;
    private String adresse;
    private String adresse2;

    private String adresse3;
    private String ville;

    private String boite_postal;

    private String cedex;

    private String cs;
    @Column(name = "zip_code")
    private String zipCode;
    private String pays;

    @OneToMany(mappedBy = "client")
    private List<Licensee> licensee;

    @OneToMany(mappedBy = "client")
    private List<Devis> devis;
    
    @OneToMany(mappedBy = "client")
    private List<OrderPanier> paniers;

}
