package com.coviam.merchant.utils;

import com.coviam.merchant.dto.ProductMinDto;
import com.coviam.merchant.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class Utility {

    @Autowired
    private static InventoryRepository inventoryRepository;

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

    public static List<ProductMinDto> getAllMinProducts() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ProductMinDto[]> response = restTemplate.getForEntity(
                "http://localhost:8083/getAllMinProducts", ProductMinDto[].class);
        List<ProductMinDto> productMinDtoList = Arrays.asList(response.getBody());


        for (ProductMinDto productMinDto : productMinDtoList) {
            System.out.println(productMinDto.getName());
        }
//        System.out.println("*******************utility.getallminproduct");


        return productMinDtoList;

    }
}
