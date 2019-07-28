package com.coviam.merchant.controller;

import com.coviam.merchant.services.CheckOutServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CheckOutController {

    @Autowired
    private CheckOutServices checkOutServices;


    @GetMapping("/checkOut/{pid}/{mid}/{quantity}")
    public Integer checkOut(@PathVariable(name = "pid") String pid,
                            @PathVariable(name = "mid") String mid,
                            @PathVariable(name = "quantity") Integer quantity) {
        return checkOutServices.checkOut(pid, mid, quantity);
    }
}
