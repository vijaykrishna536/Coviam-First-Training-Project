package com.coviam.merchant.services.impl;

import com.coviam.merchant.dto.Rank;
import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.repository.InventoryRepository;
import com.coviam.merchant.repository.MerchantRepository;
import com.coviam.merchant.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RankingServiceImpl implements RankingService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private MerchantRepository merchantRepository;


    // todo apply ranking algorithm
    //Returns ranklist
    @Override
    public List<Rank> fetchRankListForProduct(String pid) {
        List<Rank> rankList = new ArrayList<>();
        List<Inventory> inventoryList = inventoryRepository.findByProductId(pid);

        for (Inventory inventory : inventoryList) {

            String merchantId = inventory.getMerchantId();
            Merchant merchant = merchantRepository.findOne(merchantId);
            Rank rank = new Rank();
            rank.setPrice(inventory.getPrice());
            rank.setStock(inventory.getStock());
            rank.setSold(inventory.getSold());
            rank.setMerchantName(merchant.getName());
            rank.setRating(merchant.getRating());

            rankList.add(rank);
        }

        return rankList;
    }
}
