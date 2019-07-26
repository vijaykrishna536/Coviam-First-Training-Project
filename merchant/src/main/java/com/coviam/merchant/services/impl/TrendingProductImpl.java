package com.coviam.merchant.services.impl;

import com.coviam.merchant.MerchantApplication;
import com.coviam.merchant.dto.ProductMinDto;
import com.coviam.merchant.dto.TrendingProductDTO;
import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.TrendingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrendingProductImpl implements TrendingProductService {

    @Autowired
    private InventoryServices inventoryServices;


    // todo refine this method
    public ProductMinDto getMinProductDtoByPid(String pid) {
        RestTemplate restTemplate = new RestTemplate();
        final String productMSURL
                = "http://" +
                MerchantApplication.IP_NUPUR +
                ":"
                +
                MerchantApplication.PORT_NUPUR +
                "/getMinProductByPid/";

        System.out.println("******************************");
        System.out.println(productMSURL + pid);
        System.out.println("*******************************");

        ProductMinDto productMinDto
                = restTemplate.getForObject("http://localhost:8083/getMinProductByPid/" + pid
                , ProductMinDto.class);


        return productMinDto;
    }

    // todo add trending product algo to return top 6 trending products
    // todo problem: if Pid is not in mongo product db then i will get an http error
    @Override
    public List<TrendingProductDTO> getTrendingProducts() {

        List<Inventory> inventoryList = inventoryServices.findAll();
        List<TrendingProductDTO> trendingProductDTOS = new ArrayList<>();

        final int limit = 3;
        int i = 1;
        for (Inventory inventory : inventoryList) {

            if (i>limit) break;
            i++;

            TrendingProductDTO trendingProductDTO = new TrendingProductDTO();
            trendingProductDTO.setProductId(inventory.getProductId());
            trendingProductDTO.setName(inventory.getProductName());
            System.out.println(inventory.getProductName());

            ProductMinDto productMinDto = this.getMinProductDtoByPid(inventory.getProductId());
            trendingProductDTO.setPicUrl(productMinDto.getPicUrl());
            trendingProductDTO.setCategoryName(inventory.getCategoryName());

            trendingProductDTOS.add(trendingProductDTO);


        }

        return trendingProductDTOS;
    }
}
/*

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
                ProductDto product = mapper.readValue(jsonString, ProductDto.class);
        System.out.println(product);
        } catch (Exception e) {
        e.printStackTrace();
        }
*/
