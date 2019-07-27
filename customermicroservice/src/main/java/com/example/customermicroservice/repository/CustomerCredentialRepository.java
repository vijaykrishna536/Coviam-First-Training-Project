package com.example.customermicroservice.repository;

import com.example.customermicroservice.entity.CustomerCredentials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCredentialRepository extends CrudRepository<CustomerCredentials, Long> {

    @Query(value = "Select * from Customer_Credentials where email = ?1", nativeQuery = true)
    CustomerCredentials checkLogin(String email);

    //TODO: remove repetetive code

    @Query(value = "Select * from Customer_Credentials where email = ?1", nativeQuery = true)
    CustomerCredentials findEmail(String email);
}
