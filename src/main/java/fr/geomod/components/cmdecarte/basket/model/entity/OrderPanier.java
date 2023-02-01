/*
 * @(#)OrderPanier.java
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


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
 * <p><B>Title </B>: OrderPanier.java.</p>
 * <p><B>Copyright </B>: Copyright (c) 2023. </p>
 * <p><B>Company </B>: GEOMOD</p>
 * <p><B>Filename </B>: OrderPanier.java</p>
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
@Table(name = "order_panier")
public class OrderPanier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    
    @OneToMany(mappedBy = "panier")
    @EqualsAndHashCode.Exclude
    private  List<OrderHeader> orderHeader;
    
    @OneToMany(mappedBy = "panier")
    @EqualsAndHashCode.Exclude
    private  List<Cell> cell;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_client")
    private Client client;

}


