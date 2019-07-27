package com.coviam.product.controller;


import com.coviam.product.entity.Product;
import com.coviam.product.service.ProductService;
import com.coviam.product.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class Test {


    @Autowired
    private ProductService productService;

    @GetMapping("/test/{categoryName}")
    public List<Product> getProductByCategory(@PathVariable(name = "categoryName") String categoryName) {
       return productService.getProductByCategory(categoryName);
    }
}
