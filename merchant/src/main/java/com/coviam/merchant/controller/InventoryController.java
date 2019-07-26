package com.coviam.merchant.controller;

import com.coviam.merchant.dto.Product;
import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.MerchantServices;
import com.coviam.merchant.services.ProductService;
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

    @Autowired
    private ProductService productService;

    // count merchant for pid
    @GetMapping(value = "/test1/{pid}")
    public Integer getCountById(@PathVariable(name = "pid") String pid) {
        System.out.println("Inside test1");
        if (pid != null)
            return (inventoryServices.countMerchantForProduct(pid));

        System.out.println("Pid is null");
        return null;
    }


    // This method will talk to Nupur's product Microservices
    @GetMapping(value = "getProductByPid/{pid}")
    public Product getProductByPid(@PathVariable(name = "pid") String pid) {
        return productService.getProductByPid(pid);
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
