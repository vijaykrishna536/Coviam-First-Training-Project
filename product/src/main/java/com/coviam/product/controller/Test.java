package com.coviam.product.controller;


import com.coviam.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Test {


    @Autowired
    private ProductService productService;

}
