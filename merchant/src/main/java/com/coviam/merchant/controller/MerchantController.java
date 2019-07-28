package com.coviam.merchant.controller;


import com.coviam.merchant.dto.MerchantDto;
import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MerchantController {

    @Autowired
    private MerchantServices merchantServices;

    @GetMapping("/getMerchantByMid/{mid}")
    public MerchantDto findByMerchantId(@PathVariable(name = "mid") String merchantId) {
        return merchantServices.findByMerchantId(merchantId);
    }
}
