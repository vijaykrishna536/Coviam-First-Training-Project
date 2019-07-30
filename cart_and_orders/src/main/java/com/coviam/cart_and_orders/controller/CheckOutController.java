package com.coviam.cart_and_orders.controller;


import com.coviam.cart_and_orders.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@CrossOrigin
@RestController
public class CheckOutController {


    @Autowired
    private CheckOutService checkOutService;


    @Transactional
    @PutMapping("/checkOutCart/{customerId}")
    public ResponseEntity<?> checkOutCart(@PathVariable(name = "customerId") Long customerId) {

        Integer checkOutStatus = checkOutService.checkOut(customerId);

        return new ResponseEntity<Integer>(checkOutStatus, HttpStatus.OK);

    }


}
