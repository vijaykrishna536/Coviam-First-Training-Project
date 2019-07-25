package com.coviam.merchant.controller;

import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @Autowired
    private MerchantServices merchantServices;

    @Autowired
    private InventoryServices inventoryServices;

    // count merchant for pid
    @GetMapping(value = "/test1/{pid}")
    public Integer getCountById(@PathVariable(name = "pid") Long pid) {
        System.out.println("Inside test1");
        if (pid != null)
            return (inventoryServices.countMerchantForProduct(pid));

        System.out.println("Pid is null");
        return null;
    }

    /*@GetMapping(value = "/testAddMerchant")
    public void insertMerchant() {
        merchantServices.insert();
    }

    @GetMapping(value = "/testAddInventory")
    public void insertInventory() {
        inventoryServices.insert();
    }*/
}
