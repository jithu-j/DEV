package com.persproj.orderservice.repository;

import com.persproj.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long> {

}
