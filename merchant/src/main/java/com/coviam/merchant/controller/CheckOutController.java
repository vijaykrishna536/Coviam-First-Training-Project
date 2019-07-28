package com.coviam.merchant.controller;

import com.coviam.merchant.services.CheckOutServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CheckOutController {

    @Autowired
    private CheckOutServices checkOutServices;


    @Transactional
    @GetMapping("/checkOut/{pid}/{mid}/{quantity}")
    public Integer checkOut(@PathVariable(name = "pid") String pid,
                            @PathVariable(name = "mid") String mid,
                            @PathVariable(name = "quantity") Integer quantity) {
        if (pid == null || mid == null || quantity == null) return -2;
        return checkOutServices.checkOut(pid, mid, quantity);
    }

    @GetMapping("/validateCart/{pid}/{mid}/{quantity}")
    public Integer validateCart(@PathVariable(name = "pid") String pid,
                                @PathVariable(name = "mid") String mid,
                                @PathVariable(name = "quantity") Integer quantity) {
        if (pid == null || mid == null || quantity == null) return -2;
        return checkOutServices.validateCart(pid, mid, quantity);
    }

}
