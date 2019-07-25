package com.coviam.product.service;

import com.coviam.product.entity.Category;
import com.coviam.product.entity.Product;

import java.util.List;


public interface ProductService {

    Product getProductById(Long Id);

    List<Product> getAllProducts();

    List<Product> getProductByCategory(String categoryName);

    List<Category> getAllCategories();

    Product addProduct(Product product);

    Category addCategory(Category category);

    void deleteProduct();

    Product updateProduct();

}
