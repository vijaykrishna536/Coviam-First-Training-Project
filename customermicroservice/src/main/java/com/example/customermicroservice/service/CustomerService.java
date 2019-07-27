package com.example.customermicroservice.service;

import com.example.customermicroservice.entity.CustomerCredentials;
import com.example.customermicroservice.entity.CustomerDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerService {

    CustomerCredentials checkLogin(String email, String password);

    Integer addCustomer(CustomerCredentials customerCredentials);

    Integer updateCustomer(CustomerCredentials customerCredentials);

    boolean checkRegisteredCustomer(String email);

    CustomerDetail getCustomerDetails(Long customerId);

    String addCustomerDetails(CustomerDetail customerDetail);

    CustomerCredentials authenticateEmail(String email);
}
