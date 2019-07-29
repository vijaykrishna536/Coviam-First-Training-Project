package com.javatechie.es.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@Document(indexName="javatechie",type = "category")
public class Category {

    @Id
    private String id;
    private String name;
}
