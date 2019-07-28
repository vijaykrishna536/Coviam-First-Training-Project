package com.coviam.merchant.controller;

import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.services.InventoryServices;
import com.coviam.merchant.services.MerchantServices;
import com.coviam.merchant.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class InventoryController {

    @Autowired
    private MerchantServices merchantServices;

    @Autowired
    private InventoryServices inventoryServices;

    @Autowired
    private ProductService productService;

    // count merchant for pid
    @GetMapping(value = "/countMerchantForProduct/{productId}")
    public Integer countMerchantForProduct(@PathVariable(name = "productId") String productId) {
        if (productId != null)
            return (inventoryServices.countMerchantForProduct(productId));

        System.out.println("productId is null");
        return -1;
    }

    @GetMapping(value = "/getBestPrice/{pid}")
    public Double getBestPrice(@PathVariable(name = "pid") String pid) {
        if (pid != null)
            return inventoryServices.getBestPrice(pid);
        System.out.println("pid is null");
        return -1.0;
    }


    // just for testing don't release this to final product
    @GetMapping(value = "/getAllInventory")
    public List<Inventory> getAllInventory() {
        List<Inventory> inventoryList = inventoryServices.findAll();
        return inventoryList;
    }


    @GetMapping("/getPriceFromInventory/{pid}/{mid}")
    public Double getPriceFromInventory(@PathVariable(name = "pid") String pid, @PathVariable(name = "mid") String mid) {
        return inventoryServices.getPriceFromInventory(pid, mid);
    }

    @GetMapping("/getStockByPidAndMid/{pid}/{mid}")
    public Integer getStockByPidAndMid(@PathVariable(name = "pid") String pid,
                                       @PathVariable(name = "mid") String mid) {

        if (pid == null || mid == null) return -2;

        return inventoryServices.getStockByPidAndMid(pid, mid);
    }


}
