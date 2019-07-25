package com.coviam.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@Document(collection = "product")
public class Product implements Serializable {

    @Id
    String id;
    String pId;
    String name;
    String pic_url;
    List<Feature> features;
    String description;
    String categoryName;

    @DBRef
    private Category category;

}
