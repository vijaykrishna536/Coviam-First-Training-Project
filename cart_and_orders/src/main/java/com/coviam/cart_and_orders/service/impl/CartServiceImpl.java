package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.dto.CartDto;
import com.coviam.cart_and_orders.dto.CartItemDto;
import com.coviam.cart_and_orders.entity.Cart;
import com.coviam.cart_and_orders.repository.CartItemRepository;
import com.coviam.cart_and_orders.repository.CartRepository;
import com.coviam.cart_and_orders.service.CartItemService;
import com.coviam.cart_and_orders.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartItemService cartItemService;




    @Override
    public CartDto addCart(Long customerId) {
        Cart cart = new Cart();
        cart.setCustomerId(customerId);
        cartRepository.save(cart);
        CartDto cartDto = new CartDto();
        BeanUtils.copyProperties(cart, cartDto);
        return cartDto;
    }

    @Override
    public CartDto getCartDetail(Long customerId) {

        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            return null;
        }

        CartDto cartDto = new CartDto();
        BeanUtils.copyProperties(cart, cartDto);
        List<CartItemDto> cartItemDtoList = cartItemService.getCartItemsByCustomerId(customerId);
        cartDto.setCartItemDtoList(cartItemDtoList);
        cartDto.getTotalUtil();
        //System.out.println("************************* done");
        return cartDto;
    }

}
