package com.coviam.merchant.controller;


import com.coviam.merchant.dto.Product;
import com.coviam.merchant.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private InventoryServices inventoryServices;


}
