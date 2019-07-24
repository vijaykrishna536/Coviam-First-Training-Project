package com.coviam.merchant.services.impl;

import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.repository.InventoryRepository;
import com.coviam.merchant.repository.MerchantRepository;
import com.coviam.merchant.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantServices {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private InventoryRepository inventoryRepository;


    // trust me...Ignore this function for now
    @Override
    public void insert() {
        Merchant merchant = new Merchant();
        merchant.setName("Ekartt");
        merchant.setId(Long.valueOf(2));
        merchantRepository.insert(merchant);
    }
}