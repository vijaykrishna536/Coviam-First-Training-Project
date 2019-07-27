package com.coviam.merchant.utils;

import com.coviam.merchant.MerchantApplication;
import com.coviam.merchant.dto.ProductMinDto;
import org.springframework.web.client.RestTemplate;

public class Utility {

    public static ProductMinDto getMinProductDtoByPid(String pid) {
        RestTemplate restTemplate = new RestTemplate();
        /*final String productMSURL
                = "http://" +
                MerchantApplication.IP_NUPUR +
                ":"
                +
                MerchantApplication.PORT_NUPUR +
                "/getMinProductByPid/";*/

        //System.out.println("*******************************");
        //System.out.println("Retrieving ProductMinDto for " + pid + "from:");
        //System.out.println(productMSURL + pid);
        //System.out.println("*******************************");

        ProductMinDto productMinDto
                = restTemplate.getForObject("http://localhost:8083/getMinProductByPid/" + pid
                , ProductMinDto.class);


        return productMinDto;
    }
}
