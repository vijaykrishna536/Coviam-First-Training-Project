package com.coviam.merchant.services.impl;

import com.coviam.merchant.dto.MerchantDto;
import com.coviam.merchant.dto.Rank;
import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.repository.InventoryRepository;
import com.coviam.merchant.repository.MerchantRepository;
import com.coviam.merchant.services.MerchantServices;
import com.coviam.merchant.services.RankingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
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
        List<Rank> rankList = new ArrayList<>();
        List<Inventory> inventoryList = inventoryRepository.findByProductId(pid);

        for (Inventory inventory : inventoryList) {

            Rank rank = new Rank();
            MerchantDto merchantDto = merchantServices.findByMerchantId(inventory.getMerchantId());

            // merchantDto = new MerchantDto();
            //BeanUtils.copyProperties(merchant, merchantDto);

            rank.setMerchantName(merchantDto.getName());
            rank.setPrice(inventory.getPrice());
            rank.setRating(merchantDto.getRating());
            rank.setSold(inventory.getSold());
            rank.setStock(inventory.getStock());

            rankList.add(rank);
            }

        //rankList.remove(0);

        return rankList;
    }





}
