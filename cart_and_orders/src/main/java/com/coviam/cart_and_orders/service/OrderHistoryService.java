package com.coviam.cart_and_orders.service;

import com.coviam.cart_and_orders.entity.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    Integer addToHistory(Long customerId);

    List<OrderHistory> displayOrderHistory(Long customerId);


}
