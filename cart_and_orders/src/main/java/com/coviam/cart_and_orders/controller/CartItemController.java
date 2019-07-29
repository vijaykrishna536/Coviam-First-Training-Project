package com.coviam.cart_and_orders.controller;

import com.coviam.cart_and_orders.dto.CartItemDto;
import com.coviam.cart_and_orders.entity.CartItem;
import com.coviam.cart_and_orders.service.CartItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/addToCart")
    public ResponseEntity<Integer> addToCart(@RequestBody CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();
        BeanUtils.copyProperties(cartItemDto, cartItem);
        //TODO: check all fields for null
        return new ResponseEntity<Integer>(cartItemService.addToCart(cartItem), HttpStatus.OK);
    }

    //    @DeleteMapping("/deleteAnItem")
//    public ResponseEntity<Integer> deleteAnItem(@RequestBody CartItemDto cartItemDto) {
//        CartItem cartItem = new CartItem();
//        BeanUtils.copyProperties(cartItemDto, cartItem);
//        return new ResponseEntity<Integer>(cartItemService.deleteAnItem(cartItem), HttpStatus.OK);
//    }
    @DeleteMapping("/deleteAnItem/{id}")
    public ResponseEntity<Integer> deleteAnItem(@PathVariable String id) {

        return new ResponseEntity<Integer>(cartItemService.deleteAnItem(id), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllItem/{customerId}")
    public ResponseEntity<Integer> deleteAllCartItems(@PathVariable Long customerId) {
        return new ResponseEntity<Integer>(cartItemService.deleteAllCartItems(customerId), HttpStatus.OK);
    }

    @PutMapping("/updateItem")
    public ResponseEntity<Integer> updateItem(@RequestBody CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();
        BeanUtils.copyProperties(cartItemDto, cartItem);
        return new ResponseEntity<Integer>(cartItemService.updateAnItem(cartItem), HttpStatus.OK);
    }

    /*@PostMapping("/checkOut/{cid}")
    public ResponseEntity<Integer> checkOut(@PathVariable(name = "cid") Long cid) {


        return null;
    }*/


}
