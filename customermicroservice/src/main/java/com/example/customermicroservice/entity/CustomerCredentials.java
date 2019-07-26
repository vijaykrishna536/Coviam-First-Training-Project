package com.example.customermicroservice.entity;


import javax.persistence.*;

@Entity
@Table(name = CustomerCredentials.TABLE_NAME)
public class CustomerCredentials {

    public static final String TABLE_NAME = "CUSTOMER_CREDENTIALS";
    private static final String ID_COLUMN = "ID";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CustomerCredentials.ID_COLUMN, updatable = false, nullable = false)
    private Long customerId;

    private String password;

    @Column(nullable = false)
    private String emailId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
