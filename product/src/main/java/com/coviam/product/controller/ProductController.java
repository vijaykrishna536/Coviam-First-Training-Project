package com.coviam.product.controller;

import com.coviam.product.dto.ProductMinDto;
import com.coviam.product.dto.ProductNameAndUrl;
import com.coviam.product.entity.Category;
import com.coviam.product.entity.Product;
import com.coviam.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/getAllProductsByCategory/{categoryName}")
    public List<ProductMinDto> getAllProductsByCategory(@PathVariable String categoryName) {
        if (categoryName == null) return null;

        List<Product> productList = productService.getProductByCategory(categoryName);
        List<ProductMinDto> productMinDtoList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();


        for (Product product : productList) {

            Double price = restTemplate.getForObject("http://localhost:8081/getBestPrice/" + product.getpId()
                    , Double.class);
            /*System.out.println("***************************************");
            System.out.println(price);*/
            ProductMinDto productMinDto = new ProductMinDto();
            productMinDto.setCategoryName(categoryName);
            productMinDto.setPicUrl(product.getPicUrl());
            productMinDto.setpId(product.getpId());
            productMinDto.setName(product.getName());
            productMinDto.setPrice(price);
            productMinDto.setCategoryName(categoryName);

            productMinDtoList.add(productMinDto);

        }
        return productMinDtoList;
    }

    @GetMapping("/getProductByPid/{productId}")
    public Product getProductByProductId(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    /*@PostMapping(value = "/addCategory")
    public Category addCategory(@RequestBody Category category) {

        return productService.addCategory(category);

    }*/

    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> productList) {
        return productService.saveAll(productList);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // working
    @GetMapping("/getAllMinProducts")
    public List<ProductMinDto> getAllMinProducts() {
        List<Product> productList = getAllProducts();
        List<ProductMinDto> productMinDtoList = new ArrayList<>();
        for (Product product : productList) {
            ProductMinDto productMinDto = new ProductMinDto();
            productMinDto.setCategoryName(product.getCategoryName());
            productMinDto.setName(product.getName());
            productMinDto.setpId(product.getpId());
            productMinDto.setPicUrl(product.getPicUrl());

            productMinDtoList.add(productMinDto);
        }
        return productMinDtoList;
    }


    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories() {

        return productService.getAllCategories();
    }

    @GetMapping("/getProductNameAndPicUrl")
    public ResponseEntity<?> getProductNameAndPicUrl(String pid) {
        Product product = productService.getProductById(pid);
        ProductNameAndUrl productNameAndUrl = new ProductNameAndUrl();
        productNameAndUrl.setName(product.getName());
        productNameAndUrl.setPicUrl(product.getPicUrl());

        return new ResponseEntity<ProductNameAndUrl>(productNameAndUrl, HttpStatus.OK);
    }


}
