package com.coviam.cart_and_orders.controller;

import com.coviam.cart_and_orders.dto.CartDto;
import com.coviam.cart_and_orders.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController

public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/addCart/{customerId}")
    public String addCart(@PathVariable("customerId") Long customerId){
        CartDto cartDto=cartService.addCart(customerId);
        return cartDto.getId();
    }

    @GetMapping("/getCartDetail/{customerId}")
    public CartDto getCartDetail(@PathVariable Long customerId){
        return cartService.getCartDetail(customerId);
    }

}
