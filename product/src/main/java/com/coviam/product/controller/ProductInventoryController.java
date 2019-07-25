package com.coviam.product.controller;


import com.coviam.product.dto.ProductMinDto;
import com.coviam.product.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ProductInventoryController {

    @Autowired
    private ProductInventoryService productInventoryService;



    @GetMapping("/getMinProductByPid/{pid}")
    public List<ProductMinDto> getMinProductByPid(@PathVariable(name = "pid") String pid) {
        return productInventoryService.getMinProductByPid(pid);
    }
}
