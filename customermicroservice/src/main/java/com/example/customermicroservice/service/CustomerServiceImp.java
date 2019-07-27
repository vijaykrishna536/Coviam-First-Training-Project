package com.example.customermicroservice.service;

import com.example.customermicroservice.entity.CustomerCredentials;
import com.example.customermicroservice.entity.CustomerDetail;
import com.example.customermicroservice.repository.CustomerCredentialRepository;
import com.example.customermicroservice.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utility.PasswordEncrupt;
import utility.UniqueStringGenerator;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerCredentialRepository customerCredentialRepository;

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Override
    public CustomerCredentials checkLogin(String email, String password) {
        CustomerCredentials customerCredentials = customerCredentialRepository.checkLogin(email);
        if(customerCredentials != null)
        {
            PasswordEncrupt passwordEncrupt=new PasswordEncrupt();
            if(passwordEncrupt.checkPass(password,customerCredentials.getPassword()))

            return (customerCredentials);
        }
        return null;
    }

    @Override
    public Integer addCustomer(CustomerCredentials customerCredentials) {
        //final String message1="Customer Already Exits";
        //final String message2="Account Successfully Created";
        //final String message3="Sorry please retry";
        final int length=5;
        CustomerDetail customerDetail= new CustomerDetail();
        customerDetail.setName(customerCredentials.getName());
        customerDetail.setCustomerId(customerCredentials.getCustomerId());
        customerDetailsRepository.save(customerDetail);
        customerCredentials.setCartId(UniqueStringGenerator.randomAlphaNumeric(length));
        if (customerCredentials != null) {
            if(checkRegisteredCustomer(customerCredentials.getEmail())) {
                return 1;
            }
            else {
                customerCredentialRepository.save(customerCredentials);
                return 0;
            }
        }
        return 2;
    }


    @Override
    public Integer updateCustomer(CustomerCredentials customerCredentials) {
     //   return customerCredentialRepository.updateDetail(customerCredentials.getCartId(),customerCredentials.getCustomerId());
        return 1;
    }

    @Override
    public String addCustomerDetails(CustomerDetail customerDetail)
    {
        final String message1="Details Saved";
        final String message2="Something went wrong enter again";
        if(customerDetail!=null)
        {
            customerDetailsRepository.updateCustomerDetails(customerDetail.getBillingAddress(),
                    customerDetail.getPhoneNumber(),customerDetail.getShippingAddress(),customerDetail.getCustomerId());
            return message1;
        }
        return message2;
    }

    @Override
    public boolean checkRegisteredCustomer(String email)
    {
       CustomerCredentials customerCredentials=customerCredentialRepository.findEmail(email);
       if(customerCredentials!=null)
           return true;
       return false;
    }

    @Override
    public CustomerDetail getCustomerDetails(Long customerId) {
        return customerDetailsRepository.getCustomerDetails(customerId);
    }

    @Override
    public CustomerCredentials authenticateEmail(String email) {
        CustomerCredentials customerCredentials = customerCredentialRepository.findEmail(email);
        return customerCredentials;
    }
}
