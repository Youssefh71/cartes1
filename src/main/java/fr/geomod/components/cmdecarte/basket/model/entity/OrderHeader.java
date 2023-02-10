/*
 * @(#)OrderHeader.java
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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <p><B>Title </B>: OrderHeader.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: OrderHeader.java</p>
 * <p><B>Description </B>:  </p>
 * @author GEOMOD
 * @since 2023
 */



@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "order_header")
public class OrderHeader {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orderheader")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_order")
    private OrderPanier panier;
    
    @Column(name = "ordering_system")
    private Integer orderingSystem;
    
    @Column(name = "order_type")
    private Integer orderType;
    
    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "distributor_id")
    private Integer distributorId;

    @Column(name = "distributor_contact ")
    private String distributorContact ;

    @Column(name = "optional_delivery_email ")
    private String email ;
       
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "permit_media ")
    private String permitMedia  ;
    
    @Column(name = "permit_all ")
    private String permitAll  ;

    @Column(name = "language_code ")
    private String languageCode ;


}


