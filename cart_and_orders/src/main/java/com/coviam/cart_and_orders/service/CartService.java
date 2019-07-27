package com.coviam.cart_and_orders.service;

import com.coviam.cart_and_orders.dto.CartDto;
import com.coviam.cart_and_orders.dto.CartItemDto;
import com.coviam.cart_and_orders.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {

    CartDto addCart(Long customerId);
    CartDto getCartDetail();
}
