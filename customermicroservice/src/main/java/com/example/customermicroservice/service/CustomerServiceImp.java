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

        final int length=5;

        if (customerCredentials != null) {
            if(checkRegisteredCustomer(customerCredentials.getEmail())) {
                return 1;
            }
            else {
                customerCredentials.setCartId(UniqueStringGenerator.randomAlphaNumeric(length));
                customerCredentialRepository.save(customerCredentials);
                CustomerCredentials customerCredentials1 = customerCredentialRepository.findEmail(customerCredentials.getEmail());
                System.out.println(customerCredentials1.getName());
                CustomerDetail customerDetail= new CustomerDetail();
                customerDetail.setName(customerCredentials1.getName());
                System.out.println(customerCredentials1.getCustomerId());
                System.out.println(customerCredentials1);
                customerDetail.setCustomerCredentials(customerCredentials1);
                System.out.println(customerDetail.getCustomerCredentials());
                customerDetailsRepository.save(customerDetail);



                return 0;
            }
        }
        return 2;
    }





    @Override
    public Integer updateCustomer(CustomerCredentials customerCredentials) {
        return customerCredentialRepository.updateDetail(customerCredentials.getCartId(),customerCredentials.getCustomerId());

    }




    @Override
    public Integer addCustomerDetails(CustomerDetail customerDetail)
    {
        final Integer message1=1;
        final Integer message2=0;
        if(customerDetail!=null)
        {
            Integer alternate =customerDetailsRepository.updateCustomerDetails(customerDetail.getBillingAddress(),
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



    @Override
    public CustomerCredentials findEmailByCustomerId(Long customerId)
    {
        return customerCredentialRepository.findEmailFromId(customerId);
    }
}
