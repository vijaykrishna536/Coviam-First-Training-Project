package com.coviam.product.service;

import com.coviam.product.dto.ProductMinDto;

public interface ProductInventoryService {


    // returns min product details to caller
    ProductMinDto getMinProductByPid(String pid);

}
