package com.coviam.cart_and_orders.controller;

import com.coviam.cart_and_orders.dto.OrderHistoryDisplayDto;
import com.coviam.cart_and_orders.entity.OrderHistory;
import com.coviam.cart_and_orders.entity.ProductNameAndUrl;
import com.coviam.cart_and_orders.service.OrderHistoryService;
import com.coviam.cart_and_orders.utils.ProductDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    @PutMapping(value = "/addToHistory/{customerId}")
    public ResponseEntity<?> addToHistory(@PathVariable Long customerId) {

        Integer response = orderHistoryService.addToHistory(customerId);


        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @GetMapping("/getOrderHistory/{customerId}")
    public ResponseEntity<?> getOrderHistory(@PathVariable(name = "customerId") Long customerId) {

        List<OrderHistory> orderHistoryList =  orderHistoryService.displayOrderHistory(customerId);
        List<OrderHistoryDisplayDto> orderHistoryDisplayDtoList = new ArrayList<>();

        for (OrderHistory orderHistory: orderHistoryList) {
            OrderHistoryDisplayDto orderHistoryDisplayDto = new OrderHistoryDisplayDto();
            BeanUtils.copyProperties(orderHistory,orderHistoryDisplayDto);
            orderHistoryDisplayDtoList.add(orderHistoryDisplayDto);

        }
        return new ResponseEntity<List<OrderHistoryDisplayDto>>(orderHistoryDisplayDtoList, HttpStatus.OK);
    }
}
