package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.entity.Cart;
import com.coviam.cart_and_orders.entity.CartItem;
import com.coviam.cart_and_orders.repository.CartItemRepository;
import com.coviam.cart_and_orders.repository.CartRepository;
import com.coviam.cart_and_orders.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public Integer addToCart(CartItem cartItem) {

        if(cartItem!=null) {

            Cart cart = cartRepository.findByCustomerId(cartItem.getCustomerId());
            cartItem.setCartId(cart);
            cartItemRepository.save(cartItem);
            return 1;
        }
        return 0;
    }

    @Override
    public Integer deleteAnItem(CartItem cartItem) {

        String productId=cartItem.getProductId();
        String merchantId=cartItem.getMerchantId();

        cartItemRepository.deleteCartItem(productId,merchantId);

//        if(cartItemRepository.findExist(productId,merchantId)==0)
//            return 1;
//
//        return 0;
        return 1;
    }

    @Override
    public Integer deleteAllCartItems() {

        //TODO: add exception handling

        cartItemRepository.deleteAll();

        return 1;
    }

    @Override
    public Integer updateAnItem(CartItem cartItem) {

        if(cartItem!=null){

            String productId=cartItem.getProductId();
            String merchantId=cartItem.getMerchantId();
            Integer quantity=cartItem.getQuantity();

            cartItemRepository.updateCartItem(quantity,productId,merchantId);

            return 1;
        }
        return 0;
    }
}
