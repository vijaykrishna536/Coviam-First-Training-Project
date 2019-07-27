package com.coviam.merchant.controller;

import com.coviam.merchant.dto.MerchantDto;
import com.coviam.merchant.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    private MerchantServices merchantServices;

    @GetMapping("testMerchant/{mid}")
    public MerchantDto findMerchantByMerchantId(@PathVariable(name = "mid") String mid) {
        return  merchantServices.findByMerchantId(mid);
    }

}
