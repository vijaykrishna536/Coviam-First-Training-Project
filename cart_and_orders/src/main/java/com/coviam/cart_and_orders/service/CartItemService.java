package com.coviam.cart_and_orders.service;

import com.coviam.cart_and_orders.entity.CartItem;

public interface CartItemService {

    CartItem addToCart(CartItem cartItem);
    Integer deleteAnItem(CartItem cartItem);
}
