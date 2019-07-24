package com.coviam.merchant.services;

import com.coviam.merchant.entity.Merchant;

import java.util.List;

public interface MerchantServices {

    Integer countMerchantForProduct(Long productId);

    List<Merchant> getMerchantRankListForProduct(Long productId);
}
