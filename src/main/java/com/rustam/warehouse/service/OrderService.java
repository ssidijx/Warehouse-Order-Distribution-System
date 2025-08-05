package com.rustam.warehouse.service;

import com.rustam.warehouse.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrdersForDay();
    List<Order> quantizeOrders(List<Order> orders);
    List<Order> filterSmallOrders(List<Order> orders);
    void validateAndSaveOrder(Order order);
}
