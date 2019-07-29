package com.coviam.cart_and_orders.utils;

import org.springframework.web.client.RestTemplate;

public class CartValidate {

    public static Integer validateCart(String pid, String mid, Integer quantity) {

        RestTemplate restTemplate = new RestTemplate();

        Integer validateStatus = restTemplate.getForObject("http://172.16.20.95:8081/validateCart/" +
                pid + "/" + mid + "/" + quantity, Integer.class);

        return validateStatus;
    }

    public static Integer checkOutFromInventory(String pid, String mid, Integer quantity) {

        RestTemplate restTemplate = new RestTemplate();
        System.out.println("*******************CART validate*******************");
        System.out.println("http://172.16.20.95:8081/checkOut/" +
                pid + "/" + mid + "/" + quantity);

        Integer checkOutStatus = restTemplate.getForObject("http://172.16.20.95:8081/checkOut/" +
                pid + "/" + mid + "/" + quantity, Integer.class);

        return checkOutStatus;
    }
}
