package com.rustam.warehouse.service;

import com.rustam.warehouse.entities.Product;

public interface ProductService {
    Product getProductById(Long id);
    double getProductVolume(Long id);
    double getProductWeight(Long id);
}
