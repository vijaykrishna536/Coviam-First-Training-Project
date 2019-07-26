package com.coviam.merchant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MerchantApplication {

    public static final int PORT_NUPUR = 8083;
    public static final String IP_NUPUR = "localhost";

    public static void main(String[] args) {

        SpringApplication.run(MerchantApplication.class, args);
    }

}
