package com.example.customermicroservice.repository;

import com.example.customermicroservice.entity.CustomerCredentials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCredentialRepository extends CrudRepository<CustomerCredentials, Long> {

    @Query(value = "Select * from Customer_Credentials where email_id=?1", nativeQuery = true)
    CustomerCredentials checkLogin(String emailId);

    @Query(value = "Select * from Customer_Credentials where email_id=?", nativeQuery = true)
    CustomerCredentials findEmail(String emailId);
}
