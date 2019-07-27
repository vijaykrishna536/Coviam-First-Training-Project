package com.coviam.merchant.services.impl;

import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.repository.InventoryRepository;
import com.coviam.merchant.services.CheckOutServices;
import com.coviam.merchant.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckOutServiceImpl implements CheckOutServices {


    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    @Override
    public Integer checkOut(String pid, String mid, Integer quantity) {

        Inventory inventory = inventoryRepository.findByProductIdAndMerchantId(pid, mid);

        if (inventory.getStock() == 0 || inventory.getStock() < quantity) {
            return Integer.valueOf(-1);
        }
        inventory.setStock(inventory.getStock()-quantity);
        inventory.setSold(inventory.getSold()+quantity);

        inventoryRepository.save(inventory);



        return inventory.getStock();
    }
}
