package com.coviam.merchant.repository;

import com.coviam.merchant.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, Long> {

    List<Inventory> findByProductId(Long productId);
}
