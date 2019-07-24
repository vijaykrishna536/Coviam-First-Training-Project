package com.coviam.merchant.services.impl;

import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.repository.InventoryRepository;
import com.coviam.merchant.repository.MerchantRepository;
import com.coviam.merchant.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantServices {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Integer countMerchantForProduct(Long productId) {

        List<Merchant> merchantList = inventoryRepository.getMerchantIdByProductId(productId);


        return merchantList.size();
    }

    @Override
    public List<Merchant> getMerchantRankListForProduct(Long productId) {

        List<Merchant> merchantList = inventoryRepository.getMerchantIdByProductId(productId);


        return null;
    }
}