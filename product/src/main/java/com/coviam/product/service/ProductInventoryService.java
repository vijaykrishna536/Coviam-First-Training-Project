package com.coviam.product.service;

import com.coviam.product.dto.ProductMinDto;

import java.util.List;

public interface ProductInventoryService {


    // returns min product details to caller
    List<ProductMinDto> getMinProductByPid(String pid);

}
