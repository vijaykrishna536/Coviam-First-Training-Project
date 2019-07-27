package com.example.customermicroservice.entity;


import javax.persistence.*;

@Entity
@Table(name = CustomerDetail.TABLE_NAME)
public class CustomerDetail {

    public static final String TABLE_NAME = "CUSTOMER_DETAILS";
    private static final String ID_COLUMN = "ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CustomerDetail.ID_COLUMN, updatable = false, nullable = false)
    private Long customerId;

    private String name;
    private Long phoneNumber;
    private String shippingAddress;
    private String billingAddress;
    @OneToOne
    @JoinColumn(columnDefinition = "id")
    private CustomerCredentials customerCredentials;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public CustomerCredentials getCustomerCredentials() {
        return customerCredentials;
    }

    public void setCustomerCredentials(CustomerCredentials customerCredentials) {
        this.customerCredentials = customerCredentials;
    }

}
