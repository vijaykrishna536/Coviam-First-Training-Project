package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.dto.CartItemDto;
import com.coviam.cart_and_orders.entity.Cart;
import com.coviam.cart_and_orders.entity.CartItem;
import com.coviam.cart_and_orders.repository.CartItemRepository;
import com.coviam.cart_and_orders.repository.CartRepository;
import com.coviam.cart_and_orders.service.CartItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public Integer addToCart(CartItem cartItem) {

        if (cartItem != null) {

            CartItem cartItem1=cartItemRepository.findByCustomerProductMerchantId(cartItem.getCustomerId(),cartItem.getProductId(),cartItem.getMerchantId());

            if(cartItem1!=null){
                return 0;
            }

            Cart cart = cartRepository.findByCustomerId(cartItem.getCustomerId());
            cartItem.setCartId(cart);
            cartItemRepository.save(cartItem);
            return 1;
        }
        return 0;
    }

//    @Override
//    public Integer deleteAnItem(CartItem cartItem) {
//
//        String productId = cartItem.getProductId();
//        String merchantId = cartItem.getMerchantId();
//
//        cartItemRepository.deleteCartItem(productId, merchantId);
//
////        if(cartItemRepository.findExist(productId,merchantId)==0)
////            return 1;
////
////        return 0;
//        return 1;
//    }

    @Override
    public Integer deleteAllCartItems(Long customerId) {

        //TODO: add exception handling
        List<CartItem> cartItems =cartItemRepository.findByCustomerId(customerId);

        if(cartItems.isEmpty())
            return 0;

        cartItemRepository.deleteByCustomerId(customerId);

        return 1;
    }

    @Override
    public Integer updateAnItem(CartItem cartItem) {

        if (cartItem != null) {

            String productId = cartItem.getProductId();
            String merchantId = cartItem.getMerchantId();
            Integer quantity = cartItem.getQuantity();
            Long customerId=cartItem.getCustomerId();

            if(quantity>getStockFromInventory(productId,merchantId)){

                return 0;
            }

            cartItemRepository.updateCartItem(quantity, productId, merchantId,customerId);

            return 1;
        }
        return 0;
    }

    public Integer getStockFromInventory(String productId,String merchantId){

        RestTemplate restTemplate = new RestTemplate();
        Integer quantity
                = restTemplate.getForObject("http://172.16.20.95:8081/getStockByPidAndMid/" + productId + "/" + merchantId
                , Integer.class);

        return quantity;
    }

    @Override
    public List<CartItemDto> getAllCartItems() {

        List<CartItemDto> cartItemDtoList = new ArrayList<>();
        Iterable<CartItem> cartItemList = cartItemRepository.findAll();

        for (CartItem cartItem : cartItemList) {

            CartItemDto cartItemDto = new CartItemDto();
            BeanUtils.copyProperties(cartItem, cartItemDto);
            cartItemDto.calTotalPrice(getPriceFromInventory(cartItem.getProductId(), cartItem.getMerchantId()));
            cartItemDtoList.add(cartItemDto);
        }

        return cartItemDtoList;
    }

    @Override
    public List<CartItemDto> getCartItemsByCustomerId(Long customerId) {

        List<CartItem> cartItemList = cartItemRepository.findByCustomerId(customerId);
        List<CartItemDto> cartItemDtoList = new ArrayList<>();

        for (CartItem cartItem : cartItemList) {
            CartItemDto cartItemDto = new CartItemDto();
            BeanUtils.copyProperties(cartItem, cartItemDto);
            cartItemDto.calTotalPrice(getPriceFromInventory(cartItem.getProductId(), cartItem.getMerchantId()));
            cartItemDtoList.add(cartItemDto);
        }

        return cartItemDtoList;

    }

    @Override
    public Double getPriceFromInventory(String productId, String merchantId) {

        RestTemplate restTemplate = new RestTemplate();
        Double price
                = restTemplate.getForObject("http://172.16.20.95:8081/getPriceFromInventory/" + productId + "/" + merchantId
                , Double.class);
        return price;
    }

    @Override
    public Integer deleteAnItem(String cartItemId) {
        cartItemRepository.deleteById(cartItemId);
        Optional<CartItem> cartItem = cartItemRepository.findById(cartItemId);
        if(cartItem!=null)
            return 1;
        return 0;
    }
}
