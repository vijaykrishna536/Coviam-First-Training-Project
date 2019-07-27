package com.coviam.cart_and_orders.service;

import com.coviam.cart_and_orders.dto.CartItemDto;
import com.coviam.cart_and_orders.dto.PriceDto;
import com.coviam.cart_and_orders.entity.CartItem;

import java.util.List;

public interface CartItemService {

    Integer addToCart(CartItem cartItem);
    Integer deleteAnItem(CartItem cartItem);
    Integer deleteAllCartItems();
    Integer updateAnItem(CartItem cartItem);
    List<CartItemDto> getAllCartItems();
    Double getPriceFromInventory(String productId,String merchantId);
}
