package com.rustam.warehouse.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "truck_cargos")
@Data
public class TruckCargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @ManyToOne
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    @Column(name = "loaded_weight")
    private Double loadedWeight;

    @Column(name = "loaded_volume")
    private Double loadedVolume;
}


