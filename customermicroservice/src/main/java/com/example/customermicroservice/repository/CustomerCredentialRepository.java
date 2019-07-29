package com.example.customermicroservice.repository;

import com.example.customermicroservice.entity.CustomerCredentials;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerCredentialRepository extends CrudRepository<CustomerCredentials, Long> {

    @Query(value = "Select * from Customer_Credentials where email = ?1", nativeQuery = true)
    CustomerCredentials checkLogin(String email);

    @Query(value = "Select * from Customer_Credentials where email = ?1", nativeQuery = true)
    CustomerCredentials findEmail(String email);

    @Query(value = "Select * from Customer_Credentials where id = ?1", nativeQuery = true)
    CustomerCredentials findEmailFromId(Long customerId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customer_credentials SET cart_id= :cartId WHERE id= :id",nativeQuery = true)
    Integer updateDetail(@Param(value = "cartId") String cartId,@Param(value = "id") Long id);
}
