package com.coviam.product.service.impl;

import com.coviam.product.dto.ProductMinDto;
import com.coviam.product.entity.Product;
import com.coviam.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInventoryServiceImpl implements com.coviam.product.service.ProductInventoryService {

    @Autowired
    private ProductService productService;

    @Override
    public ProductMinDto getMinProductByPid(String pid) {
        Product fullProduct = productService.getProductById(pid);


        ProductMinDto productMinDto = new ProductMinDto();
        productMinDto.setName(fullProduct.getName());
        productMinDto.setPicUrl(fullProduct.getPic_url());
        productMinDto.setpId(fullProduct.getpId());
        productMinDto.setPicUrl(fullProduct.getPic_url());
        productMinDto.setCategoryName(fullProduct.getCategoryName());
        return productMinDto;
    }
}
