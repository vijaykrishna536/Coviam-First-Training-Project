package com.coviam.product.controller;

import com.coviam.product.dto.ProductMinDto;
import com.coviam.product.entity.Category;
import com.coviam.product.entity.Product;
import com.coviam.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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

    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {

        return productService.addProduct(product);
    }
*/
    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories() {

        return productService.getAllCategories();
    }


}
