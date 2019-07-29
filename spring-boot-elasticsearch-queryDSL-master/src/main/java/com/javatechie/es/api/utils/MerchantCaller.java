package com.javatechie.es.api.utils;

import org.springframework.web.client.RestTemplate;

public class MerchantCaller {

    public static Integer getMerchantFor(String pid) {
        RestTemplate restTemplate = new RestTemplate();

        Integer merchantCount = restTemplate.getForObject("http://172.16.20.95:8081/countMerchantForProduct/" + pid,
                Integer.class);


        return merchantCount;
    }
}
