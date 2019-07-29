package com.coviam.merchant.controller;

import com.coviam.merchant.dto.TrendingProductDTO;
import com.coviam.merchant.services.TrendingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TrendingProductController {

    @Autowired
    private TrendingProductService trendingProductService;

    @GetMapping(value = "/getTrendingProducts")
    public List<TrendingProductDTO> getTrendingProducts() {
        return trendingProductService.fetchTrendingProducts();
    }


}
