package com.javatechie.es.api.service;

import com.javatechie.es.api.dto.ProductDto;
import com.javatechie.es.api.model.Product;
import com.javatechie.es.api.repository.ProductRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDSLService {

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    ProductRepository productRepository;

    public boolean delete()
    {
        productRepository.deleteAll();
        return true;
    }





/*
    public List<ProductDto> getProductSearch(String name) {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder
                .should(QueryBuilders.queryStringQuery(name)
                        .lenient(true)
                        .field("name")
                        .field("description")
                        .field("featureList")
                        .field("categoryName"))
                .should(QueryBuilders.queryStringQuery("*" + name + "*")
                        .lenient(true)
                        .field("name")
                        .field("description")
                        .field("featureList")
                        .field("categoryName"));


        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .build();

        List<Product> products = template.queryForList(searchQuery, Product.class);

        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setCategoryName(product.getCategoryName());
            productDto.setDescription(product.getDescription());
            productDto.setFeatureList(product.getFeatureList());
            productDto.setFeatures(product.getFeatures());
            productDto.setName(product.getName());
            productDto.setPicUrl(product.getPicUrl());
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setRating(product.getRating());

            System.out.println("*********************************" + product.getpId());
            Integer merchantCount = MerchantCaller.getMerchantFor(product.getpId());
            productDto.setMerchantCount(merchantCount);

            productDtos.add(productDto);

        }


        return productDtos;

    }*/

    public List<Product> getProductSearchData(String name) {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder
                .should(QueryBuilders.queryStringQuery(name)
                        .lenient(true)
                        .field("name")
                        .field("description")
                        .field("featureList")
                        .field("categoryName"))
                .should(QueryBuilders.queryStringQuery("*" + name + "*")
                        .lenient(true)
                        .field("name")
                        .field("description")
                        .field("featureList")
                        .field("categoryName"));


        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .build();

        List<Product> products = template.queryForList(searchQuery, Product.class);



        return products;

    }

}
