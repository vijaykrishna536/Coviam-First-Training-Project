package com.coviam.product.controller;

import com.coviam.product.entity.Category;
import com.coviam.product.entity.Product;
import com.coviam.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAllProducts/{categoryName}/")
    public List<Product> getAllProductByCategory(@PathVariable String categoryName) {
        return null;
    }

    @GetMapping("/getAProduct/{productID}")
    public Product getAProduct(@PathVariable Long productId) {
        return null;
    }

    @PostMapping(value = "/addCategory")
    public Category addCategory(@RequestBody Category category) {

        return productService.addCategory(category);

    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {

        return productService.addProduct(product);
    }

    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories() {

        return productService.getAllCategories();
    }


}
