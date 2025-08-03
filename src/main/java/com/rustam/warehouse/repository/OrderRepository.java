package com.rustam.warehouse.repository;

import com.rustam.warehouse.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
