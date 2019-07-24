package com.example.orderpostgres.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name=Cart.TABLE_NAME)
@Data
public class Cart {

    public static final String TABLE_NAME= "CART";
    private static final String ID_COLUMN="CART_ID";

    @Id
    @Column(name=Cart.ID_COLUMN)
    private long cartId;

    private double totalPrice;


}
