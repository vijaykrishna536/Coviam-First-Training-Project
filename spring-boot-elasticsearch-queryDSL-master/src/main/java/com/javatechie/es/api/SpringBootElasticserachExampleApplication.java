package com.javatechie.es.api;

import com.javatechie.es.api.model.Category;
import com.javatechie.es.api.model.Product;
import com.javatechie.es.api.repository.CategoryRepository;
import com.javatechie.es.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootElasticserachExampleApplication {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {

		return productRepository.save(product);
	}
	@PostMapping(value = "/addCategory")
	public Category addCategory(@RequestBody Category category) {

		return categoryRepository.save(category);

	}
	@PostMapping("/addProducts")
	public boolean addProducts(@RequestBody List<Product> productList)
	{
		productRepository.save(productList);
		return true;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticserachExampleApplication.class, args);
	}
}
