package com.coviam.merchant.repository;

import com.coviam.merchant.entity.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends MongoRepository<Merchant, Long> {

    List<Merchant> findById(Long mid);

}
