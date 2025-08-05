package com.rustam.warehouse.service;


import com.rustam.warehouse.entities.OrderItem;
import com.rustam.warehouse.entities.Truck;
import com.rustam.warehouse.entities.TruckCargo;

import java.util.List;

public interface TruckCargoService {
    void assignCargoToTruck(Truck truck, List<OrderItem> orderItems);
    List<TruckCargo> getCargoByTrucks(Truck truck);
}
