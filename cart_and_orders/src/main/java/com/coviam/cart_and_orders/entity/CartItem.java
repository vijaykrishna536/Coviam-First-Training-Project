package com.coviam.cart_and_orders.entity;

import javax.persistence.*;
import java.beans.Transient;

@Entity
@Table(name = CartItem.TABLE_NAME)
public class CartItem {

    public static final String TABLE_NAME = "CARTITEM";
    private static final String ID_COLUMN = "ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CartItem.ID_COLUMN, updatable = false, nullable = false)
    private Long id;
    private Integer quantity;
    @Column(nullable = false)
    private String productId;
    @Column(nullable = false)
    private String merchantId;
    @OneToOne
    @JoinColumn(columnDefinition = "id")
    private Cart cartId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    @Transient
    Double getTotalPrice(Double price){
        return this.quantity*price;
    }


}
