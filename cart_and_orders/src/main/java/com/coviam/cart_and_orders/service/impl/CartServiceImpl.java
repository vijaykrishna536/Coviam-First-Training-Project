package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.dto.CartDto;
import com.coviam.cart_and_orders.entity.Cart;
import com.coviam.cart_and_orders.repository.CartRepository;
import com.coviam.cart_and_orders.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public CartDto addCart(Long customerId) {
        Cart cart = new Cart();
        cart.setCustomerId(customerId);
        cartRepository.save(cart);
        CartDto cartDto = new CartDto();
        BeanUtils.copyProperties(cart,cartDto);
        return cartDto;
    }

    @Override
    public Long getCartByCCId(Long ccId) {
        return cartRepository.findIdByCustomerId(ccId);
    }
}
