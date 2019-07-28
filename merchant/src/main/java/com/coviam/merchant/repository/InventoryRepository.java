package com.coviam.merchant.repository;

import com.coviam.merchant.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {

    List<Inventory> findByProductId(String productId);

    List<Inventory> findByCategoryName(String categoryName);

    Inventory findByProductIdAndMerchantId(String pid, String mid);

    //List<Inventory> findAllLimit(int limit);



}
