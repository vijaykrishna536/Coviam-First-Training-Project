package com.coviam.product.controller;

import com.coviam.product.entity.Category;
import com.coviam.product.entity.Product;
import com.coviam.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    RestTemplate restTemplate;

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return new HttpEntity<String>(headers);
    }

    @GetMapping("/getAllProducts/{categoryName}")
    public List<Product> getAllProductByCategory(@PathVariable String categoryName) {
        return productService.getProductByCategory(categoryName);
    }

    @GetMapping("/getProductByPid/{productId}")
    public Product getProductByProductId(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @PostMapping(value = "/addCategory")
    public Category addCategory(@RequestBody Category category) {

        return productService.addCategory(category);

    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {

        return productService.addProduct(product);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories() {

        return productService.getAllCategories();
    }

}
