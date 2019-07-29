package com.coviam.cart_and_orders.repository;

import com.coviam.cart_and_orders.entity.OrderHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends CrudRepository<OrderHistory, Long> {


    List<OrderHistory> findByCustomerId(Long customerId);
    List<OrderHistory> findAll();
}
