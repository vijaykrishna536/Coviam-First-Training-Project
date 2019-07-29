package com.coviam.merchant.services;

import com.coviam.merchant.dto.TrendingProductDTO;

import java.util.List;

public interface TrendingProductService {

    List<TrendingProductDTO> getTrendingProducts();

    List<TrendingProductDTO> fetchTrendingProducts();


}
