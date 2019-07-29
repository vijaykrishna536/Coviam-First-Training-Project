package com.javatechie.es.api.repository;

import com.javatechie.es.api.model.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryRepository extends ElasticsearchRepository<Category,String> {
}
