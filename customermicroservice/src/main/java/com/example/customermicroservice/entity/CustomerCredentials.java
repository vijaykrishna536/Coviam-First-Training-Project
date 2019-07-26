package com.example.customermicroservice.entity;


import javax.persistence.*;

@Entity
@Table(name = CustomerCredentials.TABLE_NAME)
public class CustomerCredentials {

    public static final String TABLE_NAME = "CUSTOMER_CREDENTIALS";
    private static final String ID_COLUMN = "ID";


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", updatable = false, nullable = false)
//    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CustomerCredentials.ID_COLUMN, updatable = false, nullable = false)
    private Long customerId;

    private String email;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
