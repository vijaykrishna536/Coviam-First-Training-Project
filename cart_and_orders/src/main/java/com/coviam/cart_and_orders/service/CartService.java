package com.coviam.cart_and_orders.service;

import com.coviam.cart_and_orders.dto.CartDto;


public interface CartService {

    CartDto addCart(Long customerId);
    CartDto getCartDetail(Long customerId);
}
