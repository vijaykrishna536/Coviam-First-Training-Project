package com.coviam.merchant.services;

import com.coviam.merchant.dto.ProductDto;

public interface ProductService {

    // This method will talk to Nupur's product Microservices
    ProductDto getProductFromInventory(String productId);
}
