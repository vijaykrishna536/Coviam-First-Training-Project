package com.coviam.merchant.controller;

import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryPilot {

    @Autowired
    private MerchantServices merchantServices;

    @GetMapping(value = "/test1")
    public List<Merchant> getCountById(Long pid) {
        System.out.println("Inside test1");
        return merchantServices.getMerchantRankListForProduct(pid);
    }
}
