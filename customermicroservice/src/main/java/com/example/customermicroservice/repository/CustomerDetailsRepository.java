package com.example.customermicroservice.repository;

import com.example.customermicroservice.entity.CustomerCredentials;
import com.example.customermicroservice.entity.CustomerDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDetailsRepository extends CrudRepository<CustomerDetail, Long> {

    @Query(value = "Select * from Customer_Details where customer_credentials_id=?1", nativeQuery = true)
    CustomerDetail getCustomerDetails(Long customerId);
}
