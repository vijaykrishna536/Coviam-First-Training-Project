package com.example.orderpostgres.repository;

import com.example.orderpostgres.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
}
