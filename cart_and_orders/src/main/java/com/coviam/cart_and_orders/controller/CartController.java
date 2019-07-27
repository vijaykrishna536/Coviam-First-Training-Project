package com.coviam.cart_and_orders.controller;

import com.coviam.cart_and_orders.dto.CartDto;
import com.coviam.cart_and_orders.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addCart/{customerId}")
    public String addCart(@PathVariable("customerId") Long customerId){
        CartDto cartDto=cartService.addCart(customerId);
        return cartDto.getId();
    }

    @GetMapping("/getCartDetail/{customerId}")
    public CartDto getCartDetail(@PathVariable Long customerId){
        return cartService.getCartDetail(customerId);
    }

}
