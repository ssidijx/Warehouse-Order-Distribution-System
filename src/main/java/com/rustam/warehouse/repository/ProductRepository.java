package com.rustam.warehouse.repository;

import com.rustam.warehouse.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
