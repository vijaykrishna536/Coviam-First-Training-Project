package com.coviam.product.service.impl;

import com.coviam.product.entity.Product;
import com.coviam.product.repository.CategoryRepository;
import com.coviam.product.repository.ProductRepository;
import com.coviam.product.service.ProductRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductRecommendationServiceImpl implements ProductRecommendationService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProductByCategory(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    List<Product> getProductsByMostSold(List<Product> productList){
        return null;
    }

}
