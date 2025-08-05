package com.rustam.warehouse.service;

import com.rustam.warehouse.entities.Order;
import com.rustam.warehouse.entities.OrderItem;
import com.rustam.warehouse.entities.Truck;

import java.util.List;
import java.util.Map;

public interface TruckService {
    List<Truck> planTrucks(List<Order> orders);
    Map<Truck, List<OrderItem>> distributeOrdersToTrucks(List<Order> orders);
    void calculateRoutes(List<Truck> trucks);
}
