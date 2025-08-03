package com.rustam.warehouse.repository;

import com.rustam.warehouse.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategotyRepository extends JpaRepository<Category, Long> {
}
