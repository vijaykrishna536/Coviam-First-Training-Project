package com.coviam.cart_and_orders.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CartItemDto {

    private String id;
    private Integer quantity;
    private String productId;
    private String merchantId;
    private Long customerId;
    private Double totalPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCustomerId() { return customerId; }

    public void setCustomerId(Long customerId) { this.customerId = customerId; }

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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void calTotalPrice(Double price){
        this.totalPrice = price*this.quantity;
    }
    //call inventory micro service for product price

}
