package com.coviam.merchant.services;

import com.coviam.merchant.dto.Product;

public interface ProductService {

    // This method will talk to Nupur's product Microservices
    Product getProductByProductId(String productId);
}
