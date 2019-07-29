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
    public Integer getStockByPid(String pid) {
        List<Inventory> inventoryList = inventoryRepository.findByProductId(pid);
        int stock = 0;
        for (Inventory inventory : inventoryList) {
            stock += inventory.getStock();
        }
        return Integer.valueOf(stock);
    }

    @Override
    public Integer getStockByPidAndMid(String pid, String mid) {
        Inventory inventory = inventoryRepository.findByProductIdAndMerchantId(pid, mid);
        if (inventory == null) return -1;
        return Integer.valueOf(inventory.getStock());
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
    public Double getBestPrice(String productId) {
        List<Inventory> inventoryList = inventoryRepository.findByProductId(productId);

        Double minPrice = Double.MAX_VALUE;
        for (Inventory inventory : inventoryList) {
            System.out.println(minPrice);
            minPrice = Math.min(minPrice, inventory.getPrice());
        }
        return minPrice;
    }

    // fetch inventory for pid
    @Override
    public List<Inventory> fetchInventoryForPid(String productId) {
        return null;
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory findByProductIdAndMerchantId(String pid, String mid) {
        return inventoryRepository.findByProductIdAndMerchantId(pid, mid);
    }

    @Override
    public List<Inventory> findByProductId(String pid) {
        return inventoryRepository.findByProductId(pid);
    }

    @Override
    public List<Inventory> saveAll(List<Inventory> inventories) {

        for (Inventory inventory : inventories) {
            inventoryRepository.save(inventory);
        }
        return inventories;
    }

    public List<Inventory> findByCategoryName(String categoryName) {
        return inventoryRepository.findByCategoryName(categoryName);

    }

    @Override
    public Double getPriceFromInventory(String pid, String mid) {
        Inventory inventory = inventoryRepository.findByProductIdAndMerchantId(pid, mid);
        if (inventory == null)  return null;

        return inventory.getPrice();
    }

/*
    public Double getBestPriceByPid(String productId) {

        List<Inventory> inventoryList = inventoryRepository.findByProductId(productId);
        Double bestPrice = Double.valueOf(0);
        for (Inventory inventory : inventoryList) {
            bestPrice = Math.max(bestPrice, inventory.getPrice());
        }
        return bestPrice;

    }*/


}
