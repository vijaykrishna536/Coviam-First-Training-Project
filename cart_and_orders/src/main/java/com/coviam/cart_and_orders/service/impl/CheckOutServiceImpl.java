package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.entity.CartItem;
import com.coviam.cart_and_orders.entity.OrderHistory;
import com.coviam.cart_and_orders.repository.CartItemRepository;
import com.coviam.cart_and_orders.repository.OrderHistoryRepository;
import com.coviam.cart_and_orders.service.CartItemService;
import com.coviam.cart_and_orders.service.CartService;
import com.coviam.cart_and_orders.service.CheckOutService;
import com.coviam.cart_and_orders.service.OrderHistoryService;
import com.coviam.cart_and_orders.utils.CartValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckOutServiceImpl implements CheckOutService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private OrderHistoryService orderHistoryService;


    @Override
    public Integer checkOut(Long customerId) {
        List<CartItem> cartItemList = cartItemRepository.findByCustomerId(customerId);
        // todo validate stock

        for (CartItem cartItem : cartItemList) {
            Integer validateStatus = CartValidate.validateCart(cartItem.getProductId(),
                    cartItem.getMerchantId(),
                    cartItem.getQuantity());

            cartItemRepository.save(cartItem);
            if (validateStatus == -1) {
                System.out.println("**************************Stock < Quantity*******************");
                return -1;
            }
        }
        for (CartItem cartItem : cartItemList) {
            Integer checkOutStatus = CartValidate.checkOutFromInventory(cartItem.getProductId(),
                    cartItem.getMerchantId(),
                    cartItem.getQuantity());

            orderHistoryService.addToHistory(customerId);
            cartItemService.deleteAllCartItems(customerId);
            if (checkOutStatus == -1 || checkOutStatus == -2) return checkOutStatus;
        }

//        cartService.getCartDetail(customerId);
        return 1;
    }

}
