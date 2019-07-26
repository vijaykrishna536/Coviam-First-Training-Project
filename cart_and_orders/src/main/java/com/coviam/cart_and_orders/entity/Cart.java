package com.coviam.cart_and_orders.entity;

import javax.persistence.*;
import java.beans.Transient;

@Entity
@Table(name = Cart.TABLE_NAME)
public class Cart {

    public static final String TABLE_NAME = "CART";
    private static final String ID_COLUMN = "ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Cart.ID_COLUMN, updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

//    @Transient
//    Double getTotalPrice(){
//        return null;
//    }
//
//    @Transient
//    Integer getTotalQuantity(){
//        return null;
//    }


}
