package com.coviam.cart_and_orders.controller;

import com.coviam.cart_and_orders.dto.CartDto;
import com.coviam.cart_and_orders.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController

public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/addCart/{customerId}")
    public String addCart(@PathVariable("customerId") Long customerId) {
        CartDto cartDto = cartService.addCart(customerId);
        return cartDto.getId();
    }

    @GetMapping("/getCartDetail/{customerId}")
    public CartDto getCartDetail(@PathVariable Long customerId) {
        CartDto cartDto = cartService.getCartDetail(customerId);
        return cartDto;
    }





/*    @GetMapping("/checkout/{customerId}")
    public Integer checkout(@PathVariable Long customerId){
        CartDto cartDto = cartService.getCartDetail(customerId);


        List<CartItemDto> cartItemDtoList = cartDto.getCartItemDtoList();

        for (CartItemDto cartDto1:cartItemDtoList ) {
            OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
            orderHistoryDto.setCustomerId(cartDto.getCustomerId());


            orderHistoryDto.setQuantity(cartDto1.getQuantity();
            orderHistoryDto.setPrice(cartDto1.getTotalPrice());
            orderHistoryDto.setMerchantId(cartDto1.getMerchantId());
            orderHistoryDto.setProductId(cartDto1.getProductId());

            RestTemplate restTemplate = new RestTemplate();
            Integer message = restTemplate("http://");

        }


        return null;
    }*/
}
