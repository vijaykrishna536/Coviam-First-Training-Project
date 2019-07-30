package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.entity.CartItem;
import com.coviam.cart_and_orders.repository.CartItemRepository;
import com.coviam.cart_and_orders.service.*;
import com.coviam.cart_and_orders.utils.CartValidate;
import com.coviam.cart_and_orders.utils.CustomerEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckOutServiceImpl implements CheckOutService {

    @Autowired
    NotificationService notificationService;
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
        //validated

        // generating mail

        String message = "";
        for (CartItem cartItem : cartItemList) {
            Integer checkOutStatus = CartValidate.checkOutFromInventory(cartItem.getProductId(),
                    cartItem.getMerchantId(),
                    cartItem.getQuantity());

            message = message + "-> Product Name: " + cartItem.getProductName() + "\t Quantity : " + cartItem.getQuantity() + "\tMerchant: " +
                    cartItem.getMerchantId() +
                    "\n";

            orderHistoryService.addToHistory(customerId);


            String email = CustomerEmail.getCustomerEmail(customerId);
            notificationService.sendNotifcation(email, "Order Confirm for customer : " + customerId,
                    "Cart Details: \n\n" + message + " Your Order has been Successfully Placed." +
                            " \n Thank you for choosing SmartBuy \n \n\n Regards,\n Customer Support");


            cartItemService.deleteAllCartItems(customerId);


            if (checkOutStatus == -1 || checkOutStatus == -2) return checkOutStatus;
        }

//        cartService.getCartDetail(customerId);
        return 1;
    }

}
