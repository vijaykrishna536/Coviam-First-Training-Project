package com.coviam.cart_and_orders.utils;

import com.coviam.cart_and_orders.entity.ProductNameAndUrl;
import org.springframework.web.client.RestTemplate;

public class ProductDetail {

    public static ProductNameAndUrl getProductDetail(String productId) {

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("*********************GetProductDetail************");
        System.out.println("172.16.20.95:8083/getProductNameAndPicUrl" + "/" + productId);

        ProductNameAndUrl productNameAndUrl = restTemplate.getForObject(
                "http://172.16.20.95:8083/getProductNameAndPicUrl"+
                "/" + productId,
                ProductNameAndUrl.class);

        return productNameAndUrl;





    }
}
