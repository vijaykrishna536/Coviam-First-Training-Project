package com.coviam.merchant.controller;

import com.coviam.merchant.dto.Product;
import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.MerchantServices;
import com.coviam.merchant.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private MerchantServices merchantServices;

    @Autowired
    private InventoryServices inventoryServices;

    @Autowired
    private ProductService productService;

    // count merchant for pid
    @GetMapping(value = "/countMerchantForProduct/{productId}")
    public Integer countMerchantForProduct(@PathVariable(name = "productId") String productId) {
        System.out.println("Inside test1");
        if (productId != null)
            return (inventoryServices.countMerchantForProduct(productId));

        System.out.println("productId is null");
        return null;
    }


    @GetMapping(value = "getProductByProductId/{productId}")
    public Product getProductByPid(@PathVariable(name = "productId") String productId) {
        return productService.getProductByProductId(productId);
    }

    @GetMapping(value = "getAllInventory")
    public List<Inventory> getAllInventory() {
        List<Inventory> inventoryList = inventoryServices.findAll();
        return inventoryList;
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
