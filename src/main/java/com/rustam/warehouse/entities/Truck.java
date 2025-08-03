package com.rustam.warehouse.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "trucks")
@Data
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "max_weight")
    private Double maxWeight;

    @Column(name = "max_volume")
    private Double maxVolume;

    private String route;
}
