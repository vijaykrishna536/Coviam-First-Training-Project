package com.coviam.merchant.services;

import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.entity.Merchant;

import java.util.List;

public interface InventoryServices {

    // returns count of merchant selling pid
    Integer countMerchantForProduct(String productId);

    // get stock for pid
    Integer getStockOf(String pid);

    // returns bets price for pid
    Double getBestPrice(String pid);

    // returns list of merchants selling pid
    List<Merchant> fetchMerchantsForProduct(String productId);

    // fetch inventory for pid
    List<Inventory> fetchInventoryForPid(String productId);

    // trust me...Ignore this function for now
    void insert();

    List<Inventory> findByCategoryName(String categoryName);


    List<Inventory> findAll();
}
