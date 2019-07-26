package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.repository.CartRepository;
import com.coviam.cart_and_orders.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Long getCartByCCId(Long ccId) {
        return cartRepository.findIdByCustomerId(ccId);
    }
}
