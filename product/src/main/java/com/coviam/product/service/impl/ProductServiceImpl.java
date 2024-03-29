package com.coviam.product.service.impl;

import com.coviam.product.entity.Category;
import com.coviam.product.entity.Product;
import com.coviam.product.repository.CategoryRepository;
import com.coviam.product.repository.ProductRepository;
import com.coviam.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product getProductById(String pId) {
        //TODO: add exception to handle null products
        if (pId == null) return null;

        Product product =  productRepository.findByPId(pId);


        return  product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategory(String categoryName) {
        if (categoryName == null) return productRepository.findAll();
        return productRepository.findByCategoryName(categoryName);
    }

    @Override
    public List<Category> getAllCategories() {

        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    /*@Override
    public Product addProduct(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.insert(category);
    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public Product updateProduct() {
        return null;
    }*/

    @Override
    public List<Product> saveAll(List<Product> productList) {
        return productRepository.saveAll(productList);
    }


}
