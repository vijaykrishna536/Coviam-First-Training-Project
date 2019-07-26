package com.coviam.merchant.services.impl;

import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.repository.InventoryRepository;
import com.coviam.merchant.repository.MerchantRepository;
import com.coviam.merchant.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryServices {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private MerchantRepository merchantRepository;


    // count merchants selling pid
    @Override
    public Integer countMerchantForProduct(String productId) {

        return this.fetchMerchantsForProduct(productId).size();
    }

    // get stock for pid
    @Override
    public Integer getStockOf(String pid) {
        List<Inventory> inventoryList = inventoryRepository.findByProductId(pid);
        int stock = 0;
        for (Inventory inventory : inventoryList) {
            stock += inventory.getStock();
        }
        return Integer.valueOf(stock);
    }


    // returns list of merchants selling pid
    @Override
    public List<Merchant> fetchMerchantsForProduct(String pid) {

        List<Inventory> inventoryList = inventoryRepository.findByProductId(pid);
        List<Merchant> merchantList = new ArrayList<>();
        for (Inventory inventory : inventoryList) {
            Merchant merchant = merchantRepository.findOne(inventory.getMerchantId());
            merchantList.add(merchant);
        }
        return merchantList;
    }

    // get best price for pid
    @Override
    public Double getBestPrice(String pid) {
        List<Inventory> inventoryList = inventoryRepository.findByProductId(pid);

        Double minPrice = Double.valueOf(0);
        for (Inventory inventory : inventoryList) {
            minPrice = Math.min(minPrice, inventory.getPrice());
        }
        return minPrice;
    }

    // fetch inventory for pid
    @Override
    public List<Inventory> fetchInventoryForPid(String pid) {
        return null;
    }


    // trust me...Ignore this function for now
    @Override
    public void insert() {
        Inventory inventory = new Inventory();
        inventory.setId(String.valueOf(2));
        inventory.setProductId(String.valueOf(23));


        inventoryRepository.insert(inventory);
    }

    @Override
    public List<Inventory> findAll() {
        return this.inventoryRepository.findAll();
    }


    @Override
    public List<Inventory> findAllLimit(int limit) {
        return inventoryRepository.findAllLimit(limit);
    }
}
