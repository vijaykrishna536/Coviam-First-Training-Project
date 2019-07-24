package com.coviam.merchant.repository;

import com.coviam.merchant.entity.Inventory;
import com.coviam.merchant.entity.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, Long> {

    List<Merchant> getMerchantIdByProductId(Long productId);
}
