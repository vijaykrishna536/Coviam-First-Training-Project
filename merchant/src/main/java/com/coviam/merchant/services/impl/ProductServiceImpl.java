package com.coviam.merchant.services.impl;

import com.coviam.merchant.dto.ProductDto;
import com.coviam.merchant.dto.ProductMinDto;
import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.ProductService;
import com.coviam.merchant.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private InventoryServices inventoryServices;

    // This method will talk to Nupur's product Microservices
    // todo problem not working
    @Override
    public ProductDto getProductFromInventory(String pid) {

        ProductDto productDto = new ProductDto();
        ProductMinDto productWithURL = Utility.getMinProductDtoByPid(pid);
        /*System.out.println("*****************************************");
        System.out.println("ye chal gya");
*/
        productDto.setPicUrl(productWithURL.getPicUrl());
        productDto.setPrice(inventoryServices.getBestPrice(pid));
        productDto.setpId(pid);
        productDto.setStock(inventoryServices.getStockByPid(pid));
        productDto.setCategory(productWithURL.getCategoryName());
        productDto.setName(productWithURL.getName());
        productDto.setStock(inventoryServices.getStockByPid(pid));
        productDto.setStock(inventoryServices.getStockByPid(pid));
        productDto.setMerchantCount(inventoryServices.countMerchantForProduct(pid));

        return productDto;
    }


}
