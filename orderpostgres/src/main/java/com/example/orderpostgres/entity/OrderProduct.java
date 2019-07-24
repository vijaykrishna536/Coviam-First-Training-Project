package com.example.orderpostgres.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name=OrderProduct.TABLE_NAME)
@Data
public class OrderProduct {
    public static final String TABLE_NAME= "ORDERPRODUCT";



}
