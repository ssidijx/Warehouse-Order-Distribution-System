package com.rustam.warehouse.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Long quantity;

    @OneToMany(mappedBy = "orderItem")
    private List<TruckCargo> truckLoads;
}
