package com.example.customermicroservice.service;

import com.example.customermicroservice.entity.CustomerCredentials;
import com.example.customermicroservice.entity.CustomerDetail;
import com.example.customermicroservice.repository.CustomerCredentialRepository;
import com.example.customermicroservice.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utility.PasswordEncrupt;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerCredentialRepository customerCredentialRepository;

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Override
    public CustomerCredentials checkLogin(String emailId, String password) {
        CustomerCredentials customerCredentials = customerCredentialRepository.checkLogin(emailId);
        if(customerCredentials != null)
        {
            PasswordEncrupt passwordEncrupt=new PasswordEncrupt();
            if(passwordEncrupt.checkPass(password,customerCredentials.getPassword()))

            return (customerCredentials);
        }
        return null;
    }

    @Override
    public String addCustomer(CustomerCredentials customerCredentials) {
        final String message1="Customer Already Exits";
        final String message2="Account Successfully Created";
        final String message3="Sorry please retry";
        if (customerCredentials != null) {
            if(checkRegisteredCustomer(customerCredentials.getEmailId())) {
                return message1;
            }
            else {
                customerCredentialRepository.save(customerCredentials);
                return message2;
            }
        }
        return message3;
    }

    @Override
    public String addCustomerDetails(CustomerDetail customerDetail)
    {
        final String message1="Details Saved";
        final String message2="Something went wrong enter again";
        if(customerDetail!=null)
        {
            customerDetailsRepository.save(customerDetail);
            return message1;
        }
        return message2;
    }

    @Override
    public boolean checkRegisteredCustomer(String emailId)
    {
       CustomerCredentials customerCredentials=customerCredentialRepository.findEmail(emailId);
       if(customerCredentials!=null)
           return true;
       return false;
    }

    @Override
    public CustomerDetail getCustomerDetails(Long customerId) {
        return customerDetailsRepository.getCustomerDetails(customerId);
    }

    @Override
    public CustomerCredentials authenticateEmail(String emailId) {
        CustomerCredentials customerCredentials = customerCredentialRepository.findEmail(emailId);
        return customerCredentials;
    }
}
