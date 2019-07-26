package com.coviam.cart_and_orders.service;

import org.springframework.stereotype.Service;


public interface CartService {

    Long getCartByCCId(Long ccId);
}
