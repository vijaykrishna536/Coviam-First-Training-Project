package com.coviam.cart_and_orders.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = CartItem.TABLE_NAME)
public class CartItem {

    public static final String TABLE_NAME = "CARTITEM";
    private static final String ID_COLUMN = "ID";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = CartItem.ID_COLUMN, updatable = false, nullable = false)
    private String id;

    private Integer quantity;

    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private String merchantId;

    private Long customerId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cartId")
    private Cart cart;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Cart getCartId() { return cart; }

    public void setCartId(Cart cartId) { this.cart = cartId; }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    //    @Transient
//    Double getTotalPrice(Double price){
//        return this.quantity*price;
//    }


}
