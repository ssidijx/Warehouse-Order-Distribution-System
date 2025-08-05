package com.rustam.warehouse.service.impl;

import com.rustam.warehouse.entities.Order;
import com.rustam.warehouse.entities.OrderItem;
import com.rustam.warehouse.entities.Truck;
import com.rustam.warehouse.service.TruckService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TruckServiceImpl implements TruckService {
    @Override
    public List<Truck> planTrucks(List<Order> orders) {
        return List.of();
    }

    @Override
    public Map<Truck, List<OrderItem>> distributeOrdersToTrucks(List<Order> orders) {
        return Map.of();
    }

    @Override
    public void calculateRoutes(List<Truck> trucks) {

    }
}
