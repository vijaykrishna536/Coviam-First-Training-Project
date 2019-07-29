package com.coviam.cart_and_orders.dto;

import java.util.List;

public class CartDto {
    private String id;
    private Long customerId;
    private List<CartItemDto> cartItemDtoList;
    private Double grandTotalPrice;
    private Integer totalQuantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<CartItemDto> getCartItemDtoList() {
        return cartItemDtoList;
    }

    public void setCartItemDtoList(List<CartItemDto> cartItemDtoList) {
        this.cartItemDtoList = cartItemDtoList;
    }

    public Double getGrandTotalPrice() {
        return grandTotalPrice;
    }

    public void setGrandTotalPrice(Double grandTotalPrice) {
        this.grandTotalPrice = grandTotalPrice;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void getTotalUtil() {

        Double sum = 0.0;
        Integer totalQuant = 0;

        if (cartItemDtoList == null) return;

        for (CartItemDto cartItemDto : this.cartItemDtoList) {
            sum = sum + cartItemDto.getTotalPrice();
            totalQuant = totalQuant + cartItemDto.getQuantity();
        }
        this.setGrandTotalPrice(sum);
        this.setTotalQuantity(totalQuant);
    }

}
