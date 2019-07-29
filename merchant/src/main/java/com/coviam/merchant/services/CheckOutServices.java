package com.coviam.merchant.services;

public interface CheckOutServices {

    Integer checkOut(String pid, String mid, Integer quantity);
    Integer validateCart(String pid, String mid, Integer quantity);
}
