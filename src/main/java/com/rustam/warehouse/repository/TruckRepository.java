package com.rustam.warehouse.repository;

import com.rustam.warehouse.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
}
