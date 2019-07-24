package com.example.orderpostgres.entity;


import com.example.orderpostgres.Utils.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name=Order.TABLE_NAME)
@Data
public class Order {
    public static final String TABLE_NAME= "ORDERDETAILS";
    private static final String ID_COLUMN="ORDER_ID";


    @Id
    @Column(name=Order.ID_COLUMN)
    private long orderId;
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private int totalNoOfProducts;

    @JoinTable(name="OrderProduct")



    private double totalOrderPrice;
   @OneToOne
    @JoinColumn(columnDefinition = "cart_Id")
    private Cart cart;

}
