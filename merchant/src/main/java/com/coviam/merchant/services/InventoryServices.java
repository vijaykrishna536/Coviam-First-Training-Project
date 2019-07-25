package com.coviam.merchant.services;

import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.entity.Merchant;

import java.util.List;

public interface InventoryServices {

    // returns count of merchant selling pid
    Integer countMerchantForProduct(Long productId);

    // get stock for pid
    Integer getStockOf(Long pid);

    // returns bets price for pid
    Double getBestPrice(Long pid);

    // returns list of merchants selling pid
    List<Merchant> fetchMerchantsForProduct(Long pid);

    // fetch inventory for pid
    List<Inventory> fetchInventoryForPid(Long pid);

    // trust me...Ignore this function for now
    void insert();
}
