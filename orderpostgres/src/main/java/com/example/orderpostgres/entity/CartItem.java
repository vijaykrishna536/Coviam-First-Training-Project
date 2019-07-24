package com.example.orderpostgres.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name=CartItem.TABLE_NAME)
@Data
public class CartItem {
    public static final String TABLE_NAME= "CART_ITEM";
    private static final String ID_COLUMN="CART_ITEM_ID";

    @Id
    @Column(name=CartItem.ID_COLUMN)
    private long cartItemId;
    private int quantity;
    @ManyToOne
    @JoinColumn(columnDefinition = "cart_Id")
    private Cart cart;


}
