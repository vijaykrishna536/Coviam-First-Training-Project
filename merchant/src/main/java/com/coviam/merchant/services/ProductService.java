package com.coviam.merchant.services;

import com.coviam.merchant.utility.Product;

public interface ProductService {

    // This method will talk to Nupur's product Microservices
    Product getProductByPid(Long pid);
}
