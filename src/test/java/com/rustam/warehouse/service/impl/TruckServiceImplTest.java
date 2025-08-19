package com.rustam.warehouse.service.impl;

import com.rustam.warehouse.entities.Order;
import com.rustam.warehouse.entities.OrderItem;
import com.rustam.warehouse.entities.Truck;
import com.rustam.warehouse.repository.OrderRepository;
import com.rustam.warehouse.repository.TruckRepository;
import com.rustam.warehouse.service.TruckService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Transactional
public class TruckServiceImplTest {
    @Autowired
    private TruckService service;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private TruckRepository truckRepository;


    @Test
    void planTrucksTest() {
        List<Order> orders = orderRepository.findAll();
        List<Truck> trucks = service.planTrucks(orders);
        assertThat(trucks).isNotNull();
    }

    @Test
    void distributeOrdersToTrucksTest(){
        List<Order> orders = orderRepository.findAll();
        Map<Truck, List<OrderItem>> distribution = service.distributeOrdersToTrucks(orders);
        assertThat(distribution).isNotNull();
    }

}
