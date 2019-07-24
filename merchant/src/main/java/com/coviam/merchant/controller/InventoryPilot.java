package com.coviam.merchant.controller;

import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryPilot {

    @Autowired
    private MerchantServices merchantServices;

    @Autowired
    private InventoryServices inventoryServices;

    @GetMapping(value = "/test1/{pid}")
    public Integer getCountById(@PathVariable(name = "pid") Long pid) {
        System.out.println("Inside test1");
        return (inventoryServices.countMerchantForProduct(pid));
    }

    @GetMapping(value = "/testAddMerchant")
    public void insertMerchant() {
        merchantServices.insert();
    }

    @GetMapping(value = "/testAddInventory")
    public void insertInventory() {
        inventoryServices.insert();
    }
}
