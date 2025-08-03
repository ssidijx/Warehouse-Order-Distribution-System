package com.rustam.warehouse.repository;

import com.rustam.warehouse.entities.TruckCargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckCargoRepository extends JpaRepository<TruckCargo, Long> {
}
