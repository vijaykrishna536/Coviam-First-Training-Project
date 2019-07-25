package com.coviam.product.service.impl;

import com.coviam.product.dto.ProductMinDto;
import com.coviam.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductInventoryServiceImpl implements com.coviam.product.service.ProductInventoryService {

    @Autowired
    private ProductServiceImpl productService;

    @Override
    public List<ProductMinDto> getMinProductByPid(String pid) {
        List<Product> fullProductList = productService.getProductById(pid);
        List<ProductMinDto> productMinDtoList = new ArrayList<>();
        for (Product product : fullProductList) {
            ProductMinDto productMinDto = new ProductMinDto();
            productMinDto.setName(product.getName());
            productMinDto.setPicUrl(product.getPic_url());
            productMinDto.setpId(product.getpId());
            productMinDto.setPicUrl(product.getPic_url());

            productMinDtoList.add(productMinDto);
        }

        return productMinDtoList;
    }
}
