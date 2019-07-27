package com.coviam.product.controller;


import com.coviam.product.dto.ProductMinDto;
import com.coviam.product.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DELETEProductInventoryController {

    @Autowired
    private ProductInventoryService productInventoryService;


    // Get min product by pid with different merchants
    @GetMapping("/getMinProductByPid/{pid}")
    public ProductMinDto getMinProductByPid(@PathVariable(name = "pid") String pid) {
        return productInventoryService.getMinProductByPid(pid);
    }
}
