package com.rustam.warehouse.repository;

import com.rustam.warehouse.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
