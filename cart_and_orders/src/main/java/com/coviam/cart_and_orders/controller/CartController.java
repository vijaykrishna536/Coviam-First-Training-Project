package com.coviam.cart_and_orders.controller;

import com.coviam.cart_and_orders.service.CartItemService;
import com.coviam.cart_and_orders.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    CartService cartService;


    @GetMapping(value = "/getCartIdByCCId/{ccId}")
    public Long getCartByCCId(@PathVariable Long ccId){
        return cartService.getCartByCCId(ccId);
    }
}