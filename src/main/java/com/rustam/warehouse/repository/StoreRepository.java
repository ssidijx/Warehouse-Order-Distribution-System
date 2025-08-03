package com.rustam.warehouse.repository;

import com.rustam.warehouse.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long > {
}
