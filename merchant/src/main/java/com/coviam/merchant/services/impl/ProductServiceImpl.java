package com.coviam.merchant.services.impl;

import com.coviam.merchant.MerchantApplication;
import com.coviam.merchant.dto.Product;
import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private InventoryServices inventoryServices;

    // This method will talk to Nupur's product Microservices

    @Override
    public Product getProductByPid(String pid) {

        RestTemplate restTemplate = new RestTemplate();
        final String productMSURL
                = "http://" +
                MerchantApplication.IP_NUPUR +
                ":"
                +
                MerchantApplication.PORT_NUPUR +
                "getProductByPid";


        ResponseEntity<String> response
                = restTemplate.getForEntity(productMSURL + "/" + pid, String.class);

        String jsonString = response.getBody();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root;
        try {
            Product product = mapper.readValue(jsonString, Product.class);
            System.out.println(product);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    /*RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl
            = "http://localhost:8080/spring-rest/foos";
    ResponseEntity<String> response
            = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));*/
}
