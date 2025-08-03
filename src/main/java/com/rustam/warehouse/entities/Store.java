package com.rustam.warehouse.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "stores")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long latitude;
    private Long longitude;

    @OneToMany(mappedBy = "store")
    private List<Order> listOfOrders;
}
