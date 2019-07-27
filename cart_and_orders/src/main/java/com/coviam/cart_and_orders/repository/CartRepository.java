package com.coviam.cart_and_orders.repository;

import com.coviam.cart_and_orders.entity.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart,Long> {

    Cart findByCustomerId(Long customerId);


}
