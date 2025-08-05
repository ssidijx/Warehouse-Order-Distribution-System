package com.rustam.warehouse.service.impl;

import com.rustam.warehouse.entities.OrderItem;
import com.rustam.warehouse.entities.Truck;
import com.rustam.warehouse.entities.TruckCargo;
import com.rustam.warehouse.service.TruckCargoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckCargoServiceImpl implements TruckCargoService {
    @Override
    public void assignCargoToTruck(Truck truck, List<OrderItem> orderItems) {

    }

    @Override
    public List<TruckCargo> getCargoByTrucks(Truck truck) {
        return List.of();
    }
}
