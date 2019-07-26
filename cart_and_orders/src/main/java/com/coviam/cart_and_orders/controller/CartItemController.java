package com.coviam.cart_and_orders.controller;

import com.coviam.cart_and_orders.dto.CartItemDto;
import com.coviam.cart_and_orders.entity.CartItem;
import com.coviam.cart_and_orders.service.CartItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @PostMapping("/addToCart")
    public CartItem addToCart(@RequestBody CartItemDto cartItemDto){
        CartItem cartItem = new CartItem();
        BeanUtils.copyProperties(cartItemDto,cartItem);
//        return new ResponseEntity<Integer>(cartItemService.addToCart(cartItem), HttpStatus.OK);
        return cartItemService.addToCart(cartItem);
    }

    @DeleteMapping("/deleteAnItem")
    public ResponseEntity<Integer> deleteAnItem(@RequestBody CartItemDto cartItemDto){
        CartItem cartItem = new CartItem();
        BeanUtils.copyProperties(cartItemDto,cartItem);
        return new ResponseEntity<Integer>(cartItemService.deleteAnItem(cartItem),HttpStatus.OK);
    }

}
