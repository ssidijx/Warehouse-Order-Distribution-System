package com.rustam.warehouse.service.impl;

import com.rustam.warehouse.entities.Order;
import com.rustam.warehouse.service.OrderService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.doesNotHave;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
@Transactional
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Test
    void getAllOrdersForDayTest(){
        List<Order> orderList = orderService.getAllOrdersForDay();
        assertThat(orderList).isNotNull();
        assertThat(orderList).hasSize(15);
    }


    @Test
    void filterSmallOrdersTest() {
        List<Order> bef = orderService.getAllOrdersForDay();
        List<Order> sorted = orderService.filterSmallOrders(bef);
        assertThat(sorted).isNotEmpty();
    }

    @Test
    void validateAndSaveTest() {
        Order order = new Order();
        int sizeBefore = orderService.getAllOrdersForDay().size();
        orderService.validateAndSaveOrder(order);
        assertThat(orderService.getAllOrdersForDay().size()).isEqualTo(sizeBefore + 1);
    }
}