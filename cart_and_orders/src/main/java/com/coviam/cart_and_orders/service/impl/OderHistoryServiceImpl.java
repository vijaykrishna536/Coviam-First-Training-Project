package com.coviam.cart_and_orders.service.impl;

import com.coviam.cart_and_orders.dto.OrderHistoryDisplayDto;
import com.coviam.cart_and_orders.entity.CartItem;
import com.coviam.cart_and_orders.entity.OrderHistory;
import com.coviam.cart_and_orders.entity.ProductNameAndUrl;
import com.coviam.cart_and_orders.repository.CartItemRepository;
import com.coviam.cart_and_orders.repository.OrderHistoryRepository;
import com.coviam.cart_and_orders.service.OrderHistoryService;
import com.coviam.cart_and_orders.utils.ProductDetail;
import com.coviam.cart_and_orders.utils.UniqueStringGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class OderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private CartItemServiceImpl cartItemServiceImpl;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Override
    public Integer addToHistory(Long customerId) {
        final int count = 5;
        String orderId =UniqueStringGenerator.randomAlphaNumeric(count);
        List<CartItem> cartItemList = cartItemRepository.findByCustomerId(customerId);

        for (CartItem cartitem : cartItemList) {
            OrderHistory orderHistory = new OrderHistory();
            //System.out.println(cartitem.getId());
            orderHistory.setCustomerId(cartitem.getCustomerId());
            orderHistory.setCurrentStatus("Order Placed");
            orderHistory.setMerchantId(cartitem.getMerchantId());
            orderHistory.setProductId(cartitem.getProductId());

            orderHistory.setProductId(cartitem.getProductId());
            orderHistory.setProductName(cartitem.getProductName());
            orderHistory.setProductUrl(cartitem.getProductUrl());
            orderHistory.setQuantity(cartitem.getQuantity());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            orderHistory.setOrderDate(dtf.format(now));

            orderHistory.setOrderId(orderId);
            orderHistory.setTotalPrice(cartItemServiceImpl.getPriceFromInventory(cartitem.getProductId(), cartitem.getMerchantId()));

            System.out.println("********************addtoHistory*****************");
            OrderHistory orderHistory1 = orderHistoryRepository.save(orderHistory);
            //System.out.println(orderHistory1.getId());
            System.out.println("*************SUCCESS*******************");
        }

        return 1;
    }

    @Override
    public List<OrderHistory> displayOrderHistory(Long customerId) {

        List<OrderHistory> orderHistoryList = orderHistoryRepository.findByCustomerId(customerId);
//        //hack
//
//        System.out.println("***********" + customerId + "*************");
//
//
//
//        List<OrderHistoryDisplayDto> orderHistoryDisplayDtoList = new ArrayList<>();
//
//        for (OrderHistory orderHistory : orderHistoryList) {
//
//            OrderHistoryDisplayDto orderHistoryDisplayDto = new OrderHistoryDisplayDto();
//            BeanUtils.copyProperties(orderHistory, orderHistoryDisplayDto);
//
//
//            ProductNameAndUrl productNameAndUrl = ProductDetail.getProductDetail(orderHistory.getProductId());
//            orderHistoryDisplayDto.setProductName(productNameAndUrl.getName());
//            orderHistoryDisplayDto.setPicUrl(productNameAndUrl.getPicUrl());
//            System.out.println("****************ProductNameUrlDTO********");
//
//            orderHistoryDisplayDtoList.add(orderHistoryDisplayDto);
//
//        }




        return orderHistoryList;
    }
}
