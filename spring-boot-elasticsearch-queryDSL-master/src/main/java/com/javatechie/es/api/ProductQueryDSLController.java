package com.javatechie.es.api;


import com.javatechie.es.api.model.Product;
import com.javatechie.es.api.service.ProductDSLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ProductQueryDSLController {

    @Autowired
    private ProductDSLService productDSLService;


    @GetMapping("/productSearch/{name}")
    public List<Product> search(@PathVariable String  name) {
        return productDSLService.getProductSearchData(name);
    }


    @DeleteMapping("/product/deleteAll")
    public boolean delete()
    {
        return productDSLService.delete();
    }
}
