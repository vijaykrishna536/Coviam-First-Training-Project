package com.coviam.merchant.controller;

import com.coviam.merchant.dto.MerchantDto;
import com.coviam.merchant.dto.ProductMinDto;
import com.coviam.merchant.services.MerchantServices;
import com.coviam.merchant.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Test {

    @Autowired
    private MerchantServices merchantServices;

    @GetMapping("testUtility/{pid}")
    public ProductMinDto testUtility(@PathVariable(name = "pid") String pid) {
        return Utility.getMinProductDtoByPid(pid);
    }

}
