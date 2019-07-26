package com.coviam.cart_and_orders.service;

import com.coviam.cart_and_orders.dto.CartDto;
import com.coviam.cart_and_orders.entity.Cart;
import org.springframework.stereotype.Service;


public interface CartService {

    CartDto addCart(Long customerId);
    Long getCartByCCId(Long ccId);
}
