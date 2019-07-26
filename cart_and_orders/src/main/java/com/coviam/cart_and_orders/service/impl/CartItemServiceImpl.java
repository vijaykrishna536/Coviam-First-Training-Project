package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.entity.Cart;
import com.coviam.cart_and_orders.entity.CartItem;
import com.coviam.cart_and_orders.repository.CartItemRepository;
import com.coviam.cart_and_orders.repository.CartRepository;
import com.coviam.cart_and_orders.service.CartItemService;
import com.coviam.cart_and_orders.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public CartItem addToCart(CartItem cartItem) {

        if(cartItem!=null) {

            Cart cart = cartRepository.findByCustomerId(cartItem.getCustomerId());
            cartItem.setCartId(cart);
            return cartItemRepository.save(cartItem);
//            return 1;
        }

        return null;
//        return 0;
    }

    @Override
    public Integer deleteAnItem(CartItem cartItem) {

        Cart cart=cartItem.getCartId();
        Long cartId=cart.getId();
        String productId=cartItem.getProductId();
        String merchantId=cartItem.getMerchantId();

        cartItemRepository.deleteCartItem(productId,cartId,merchantId);

        return cartItemRepository.findExist(productId,cartId,merchantId);
    }
}
