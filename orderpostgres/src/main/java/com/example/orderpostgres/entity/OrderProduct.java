package com.example.orderpostgres.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name=OrderProduct.TABLE_NAME)
@Data
public class OrderProduct {
    public static final String TABLE_NAME= "ORDER_PRODUCT";


    private static final String ID_COLUMN="ORDER_PRODUCT_ID";

    @Id
    @Column(name=OrderProduct.ID_COLUMN)
    private long orderProductId;
    private int quantity;


}
