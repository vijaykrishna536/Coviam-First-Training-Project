package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.dto.CartDto;
import com.coviam.cart_and_orders.dto.CartItemDto;
import com.coviam.cart_and_orders.entity.Cart;
import com.coviam.cart_and_orders.entity.CartItem;
import com.coviam.cart_and_orders.repository.CartItemRepository;
import com.coviam.cart_and_orders.repository.CartRepository;
import com.coviam.cart_and_orders.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

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
    public List<CartItemDto> getAllCartItems() {

        List<CartItemDto> cartItemDtoList = new ArrayList<>();
        Iterable<CartItem> cartItemList=cartItemRepository.findAll();

        for (CartItem cartItem: cartItemList) {
            CartItemDto cartItemDto = new CartItemDto();
            BeanUtils.copyProperties(cartItem,cartItemDto);
            cartItemDtoList.add(cartItemDto);
        }

        return cartItemDtoList;
    }

}
