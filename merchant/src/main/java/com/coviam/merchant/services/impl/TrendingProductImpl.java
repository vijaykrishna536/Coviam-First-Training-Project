package com.coviam.merchant.services.impl;

import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.TrendingProductService;
import com.coviam.merchant.utility.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrendingProductImpl implements TrendingProductService {
    @Autowired
    private InventoryServices inventoryServices;

    @Override
    public List<Product> getTrendingProducts() {

        return null;
    }
}
