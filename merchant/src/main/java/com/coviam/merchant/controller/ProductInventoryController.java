package com.coviam.merchant.controller;


import com.coviam.merchant.dto.ProductDto;
import com.coviam.merchant.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Ignore this controller

@CrossOrigin
@RestController
public class ProductInventoryController {


    @Autowired
    private ProductService productService;


    // Not of any use right now
    @GetMapping(value = "/getProductFromInventory/{productId}")
    public ProductDto getProductByPid(@PathVariable(name = "productId") String productId) {
        return productService.getProductFromInventory(productId);
    }
}
