package com.coviam.merchant.services.impl;

import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.ProductService;
import com.coviam.merchant.utility.Product;
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
    public Product getProductByPid(Long pid) {

        RestTemplate restTemplate = new RestTemplate();
        final String productMSURL
                = "http://10.177.68.85:8080/getAProduct";


        ResponseEntity<String> response
                = restTemplate.getForEntity(productMSURL + "/" + pid, String.class);


        ObjectMapper mapper = new ObjectMapper();
        JsonNode root, name;
        try {
            root = mapper.readTree(response.getBody());
            name = root.path("name");
            System.out.println(root);

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
