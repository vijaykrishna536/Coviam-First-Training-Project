package com.example.customermicroservice.repository;

import com.example.customermicroservice.entity.CustomerCredentials;
import com.example.customermicroservice.entity.CustomerDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerDetailsRepository extends CrudRepository<CustomerDetail, Long> {

    @Query(value = "Select * from Customer_Details where customer_credentials_id=?1", nativeQuery = true)
    CustomerDetail getCustomerDetails(Long customerId);


    @Query(value = "UPDATE customer_details SET billing_address=?1, phone_number=?2, shipping_address=?3 WHERE customer_credentials_id=?4",nativeQuery = true)
    CustomerDetail updateCustomerDetails(String billingAddress, Long phoneNumber, String shippingAddress, Long cId);
}
