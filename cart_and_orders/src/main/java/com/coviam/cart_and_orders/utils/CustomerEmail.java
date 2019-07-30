package com.coviam.cart_and_orders.utils;

import org.springframework.web.client.RestTemplate;

public class CustomerEmail {

    public static String getCustomerEmail(Long customerId) {

        RestTemplate restTemplate = new RestTemplate();

        String email = restTemplate.getForObject(
                "http://172.16.20.100:8082/Customer/getCustomerEmail" +
                        "/" + customerId,
                String.class);

        return email;
    }
}
