package com.coviam.merchant.controller;

import com.coviam.merchant.dto.TrendingProductDTO;
import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.TrendingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TestController {


    @Autowired
    private TrendingProductService trendingProductService;

    @Autowired
    private InventoryServices inventoryServices;

    @GetMapping("/testing")
    public List<TrendingProductDTO> testUtility() {
        return trendingProductService.fetchTrendingProducts();
    }

    @GetMapping("/saveAll")
    public List<Inventory> saveAll(@RequestBody List<Inventory> inventories) {
        return inventoryServices.saveAll(inventories);

    }

    @GetMapping("/test/{pid}")
    public List<Inventory> findByProductId(@PathVariable(name = "pid") String pid) {
        return inventoryServices.findByProductId(pid);
    }

}
