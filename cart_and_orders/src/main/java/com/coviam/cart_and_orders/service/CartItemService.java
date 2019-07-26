package com.coviam.cart_and_orders.service;

import com.coviam.cart_and_orders.entity.CartItem;

public interface CartItemService {

    Integer addToCart(CartItem cartItem);
}
