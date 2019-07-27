package com.coviam.merchant.services.impl;

import com.coviam.merchant.dto.MerchantDto;
import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.repository.MerchantRepository;
import com.coviam.merchant.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantServices {


    @Autowired
    private MerchantRepository merchantRepository;


    // Done
    @Override
    public MerchantDto findByMerchantId(String mid) {

        List<Merchant> merchantList = merchantRepository.findAll();
        MerchantDto resultMerchant = new MerchantDto();
        for (Merchant merchant : merchantList) {
            if (merchant.getMerchantId().equals(mid)) {
                resultMerchant.setName(merchant.getName());
                resultMerchant.setId(merchant.getId());
                resultMerchant.setMerchantId(mid);
                resultMerchant.setRating(merchant.getRating());
            }
        }
        return resultMerchant;
    }
}