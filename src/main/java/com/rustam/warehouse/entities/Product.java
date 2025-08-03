package com.rustam.warehouse.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double weight;
    private Double volume;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
