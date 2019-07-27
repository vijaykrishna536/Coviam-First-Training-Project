package com.coviam.merchant.controller;

import com.coviam.merchant.dto.ProductMinDto;
import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ProductCategoryController {

    @Autowired
    private InventoryServices inventoryServices;


    /*@GetMapping("/getAllProductsByCategory/{categoryName}")
    public List<ProductMinDto> getAllProductsByCategory(@PathVariable(name = "categoryName") String categoryName) {

        List<ProductMinDto> productMinDtos = new ArrayList<>();
        List<Inventory> inventoryList = inventoryServices.findByCategoryName(categoryName);
        for (Inventory inventory : inventoryList) {
            ProductMinDto productMinDto = new ProductMinDto();
            productMinDto.setName(inventory.getProductName());
            productMinDto.setpId(inventory.getProductId());
            productMinDto.setPrice(inventory.getPrice());

            ProductMinDto productMinDtoWithURL = Utility.getMinProductDtoByPid(inventory.getProductId());

            productMinDto.setPicUrl(productMinDtoWithURL.getPicUrl());

            productMinDtos.add(productMinDto);

        }
        return productMinDtos;
    }
    */


}
