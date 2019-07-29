package com.coviam.merchant.services.impl;

import com.coviam.merchant.MerchantApplication;
import com.coviam.merchant.dto.ProductMinDto;
import com.coviam.merchant.dto.TrendingProductDTO;
import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.repository.InventoryRepository;
import com.coviam.merchant.services.TrendingProductService;
import com.coviam.merchant.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TrendingProductImpl implements TrendingProductService {
    private int limit = 7;

    @Autowired
    private InventoryRepository inventoryRepository;


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

    // do not use this algo
    @Override
    public List<TrendingProductDTO> getTrendingProducts() {

        List<Inventory> inventoryList = inventoryRepository.findAll();
        List<TrendingProductDTO> trendingProductDTOS = new ArrayList<>();

        final int limit = 3;
        int i = 1;
        for (Inventory inventory : inventoryList) {

            if (i > limit) break;
            i++;

            TrendingProductDTO trendingProductDTO = new TrendingProductDTO();
            trendingProductDTO.setProductId(inventory.getProductId());
            trendingProductDTO.setName(inventory.getProductName());
            System.out.println(inventory.getProductName());

            ProductMinDto productMinDto = Utility.getMinProductDtoByPid(inventory.getProductId());
            trendingProductDTO.setPicUrl(productMinDto.getPicUrl());
            trendingProductDTO.setCategoryName(inventory.getCategoryName());

            trendingProductDTOS.add(trendingProductDTO);


        }
        return trendingProductDTOS;
    }


    // todo add trending product algo to return top 6 trending products
    // todo problem: if Pid is not in mongo product db then i will get an http error
    // working: use this algo
    public List<TrendingProductDTO> fetchTrendingProducts() {

        List<ProductMinDto> productMinDtoList = Utility.getAllMinProducts();
        List<TrendingProductDTO> trendingProductDTOList = new ArrayList<>();

        // this was not working due to type cast error
        for (ProductMinDto productMinDto : productMinDtoList) {
            TrendingProductDTO trendingProductDTO = new TrendingProductDTO();
            System.out.println("*******************TrendingProduct");
            List<Inventory> inventoryList = inventoryRepository.findByProductId(productMinDto.getpId());

            Integer sold = 0;
            Integer stock = 0;

            System.out.println("*****************updating for product: " + productMinDto.getName());
            // this is working
            for (Inventory inventory : inventoryList) {

                System.out.println("getSold: " + inventory.getSold());

                sold = Math.addExact(sold, inventory.getSold());
                stock = Math.addExact(stock, inventory.getStock());
            }
            System.out.println("*******************SOLD updated : " + sold);

            trendingProductDTO.setSold(sold);
            trendingProductDTO.setStock(stock);
            trendingProductDTO.setProductId(productMinDto.getpId());
            trendingProductDTO.setCategoryName(productMinDto.getCategoryName());
            trendingProductDTO.setName(productMinDto.getName());
            trendingProductDTO.setPicUrl(productMinDto.getPicUrl());


            trendingProductDTOList.add(trendingProductDTO);
        }
        // Merchant list for Product pid has been fetched
        /*Collections.sort(trendingProductDTOList, (a, b) -> {
            return a.getSold().compareTo(b.getSold());
        });*/
//        Collections.sort(trendingProductDTOList, Comparator.comparing(TrendingProductDTO::getSold));

        Collections.sort(trendingProductDTOList, Collections.reverseOrder());

        return trendingProductDTOList.subList(0, limit);
    }

}