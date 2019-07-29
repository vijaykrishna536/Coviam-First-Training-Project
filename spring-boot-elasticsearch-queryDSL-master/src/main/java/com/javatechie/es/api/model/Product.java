package com.javatechie.es.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName="javatechie",type="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String pId;
    private String name;
    private String picUrl;
    private List<Feature> features;
    private String description;
    private String categoryName;
    private String featureList;
    private double rating;


}
