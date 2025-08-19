package com.rustam.warehouse.service.impl;

import com.rustam.warehouse.entities.OrderItem;
import com.rustam.warehouse.entities.Truck;
import com.rustam.warehouse.entities.TruckCargo;
import com.rustam.warehouse.repository.OrderItemRepository;
import com.rustam.warehouse.repository.TruckCargoRepository;
import com.rustam.warehouse.repository.TruckRepository;
import com.rustam.warehouse.service.TruckCargoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
@Transactional
class TruckCargoServiceImplTest {

    @Autowired
    private TruckCargoService service;
    @Autowired
    private TruckRepository truckRepo;
    @Autowired
    private OrderItemRepository orderItemRepo;

    @Test
    void assignCargoToTruckTest() {
        Truck truck = truckRepo.findById(1L).orElseThrow();
        long before = service.getCargoByTrucks(truck).size();

        List<OrderItem> items = orderItemRepo.findAll().stream().limit(3).toList();
        service.assignCargoToTruck(truck, items);

        long after = service.getCargoByTrucks(truck).size();
        assertThat(after).isEqualTo(before + 3);
    }

    @Test
    void getCargoByTrucksTest() {
        Truck truck = truckRepo.findById(1L).orElseThrow();
        List<TruckCargo> cargo = service.getCargoByTrucks(truck);

        assertThat(cargo).extracting(TruckCargo::getTruck)
                .containsExactly(truck);
    }

}