package com.coviam.merchant.services.impl;

import com.coviam.merchant.dto.Product;
import com.coviam.merchant.dto.TrendingProductDTO;
import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.TrendingProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TrendingProductImpl implements TrendingProductService {
    private final int limit = 20;
    @Autowired
    private InventoryServices inventoryServices;


    // todo refine this method
    @Override
    public List<TrendingProductDTO> getTrendingProducts() {

        List<Inventory> inventoryList = inventoryServices.findAllLimit(limit);
        List<TrendingProductDTO> productDTOS = new ArrayList<>();
        for (Inventory inventory : inventoryList) {
            TrendingProductDTO product = new TrendingProductDTO();
            product.setpId(inventory.getProductId());
            product.setName(inventory.getProductName());


            productDTOS.add(product);
        }

        return productDTOS;
    }
}
