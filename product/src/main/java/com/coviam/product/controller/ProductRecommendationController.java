package com.coviam.product.controller;

import com.coviam.product.entity.Product;
import com.coviam.product.service.ProductRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ProductRecommendationController {

    @Autowired
    ProductRecommendationService productRecommendationService;

    @GetMapping("getRecommendations/{customerName}")
    public List<Product> getRecommendation(@PathVariable(value = "customerName")String customerName){
        return productRecommendationService.getProductByCategory(customerName);
    }
}
