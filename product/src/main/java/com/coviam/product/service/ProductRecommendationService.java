package com.coviam.product.service;

import com.coviam.product.entity.Product;

import java.util.List;

public interface ProductRecommendationService {

    List<Product> getProductByCategory(String categoryName);

}
