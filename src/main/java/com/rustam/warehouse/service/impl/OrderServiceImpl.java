package com.rustam.warehouse.service.impl;

import com.rustam.warehouse.entities.Order;
import com.rustam.warehouse.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> getAllOrdersForDay() {
        return List.of();
    }

    @Override
    public List<Order> quantizeOrders(List<Order> orders) {
        return List.of();
    }

    @Override
    public List<Order> filterSmallOrders(List<Order> orders) {
        return List.of();
    }

    @Override
    public void validateAndSaveOrder(Order order) {

    }
}
