package com.coviam.cart_and_orders.service;

import com.coviam.cart_and_orders.dto.CartItemDto;
import com.coviam.cart_and_orders.entity.CartItem;

import java.util.List;

public interface CartItemService {

    Integer addToCart(CartItem cartItem);

    //Integer deleteAnItem(CartItem cartItem);

    Integer deleteAnItem(String cartItemId);

    //Integer deleteAllCartItems();

    Integer deleteAllCartItems(Long customerId);

    Integer updateAnItem(CartItem cartItem);

    List<CartItemDto> getAllCartItems();

    List<CartItemDto> getCartItemsByCustomerId(Long customerId);

    Double getPriceFromInventory(String productId, String merchantId);
}
