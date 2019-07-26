package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.dto.CartItemDto;
import com.coviam.cart_and_orders.entity.CartItem;
import com.coviam.cart_and_orders.repository.CartItemRepository;
import com.coviam.cart_and_orders.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public Integer addToCart(CartItem cartItem) {

        if(cartItem!=null) {
            cartItemRepository.save(cartItem);
            return 1;
        }

        return 0;
    }
}
