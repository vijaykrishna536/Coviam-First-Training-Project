package com.coviam.merchant.services.impl;

import com.coviam.merchant.dto.MerchantDto;
import com.coviam.merchant.dto.Rank;
import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.repository.InventoryRepository;
import com.coviam.merchant.services.MerchantServices;
import com.coviam.merchant.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private MerchantServices merchantServices;


    // todo apply ranking algorithm
    //Returns ranklist
    @Override
    public List<Rank> fetchRankListForProduct(String pid) {
        if (pid == null) return null;

        List<Rank> rankList = new ArrayList<>();
        // fetching all the merchants for product pid
//        List<Inventory> inventoryList = inventoryRepository.findByProductId(pid);
        List<Inventory> inventoryList = inventoryRepository.findByProductIdAndStockGreaterThan(pid, 0);

        for (Inventory inventory : inventoryList) {

            Rank rank = new Rank();
            MerchantDto merchantDto = merchantServices.findByMerchantId(inventory.getMerchantId());

            rank.setMerchantName(merchantDto.getName());
            rank.setPrice(inventory.getPrice());
            rank.setRating(merchantDto.getRating());
            rank.setSold(inventory.getSold());
            rank.setStock(inventory.getStock());
            rank.setMerchantId(inventory.getMerchantId());

            rankList.add(rank);
        }
        // Merchant list for Product pid has been fetched
        Collections.sort(rankList, (a, b) -> {
            return a.getPrice().compareTo(b.getPrice());
        });


        if (rankList.size() == 0)
            return null;

        //rankList.remove(0);

        return rankList;
    }


}
