package com.coviam.merchant.services;

import com.coviam.merchant.dto.MerchantDto;
import com.coviam.merchant.entity.Merchant;

public interface MerchantServices {

    //  Done
    MerchantDto findByMerchantId(String mid);
}
