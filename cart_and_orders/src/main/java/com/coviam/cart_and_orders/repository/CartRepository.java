package com.coviam.cart_and_orders.repository;

import com.coviam.cart_and_orders.entity.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart,Long> {

    @Query(value = "SELECT id FROM CART WHERE customer_id =?1",nativeQuery = true)
    Long findIdByCustomerId(Long ccId);
}
