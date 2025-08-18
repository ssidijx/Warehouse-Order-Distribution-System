package com.rustam.warehouse.service.impl;

import com.rustam.warehouse.entities.Product;
import com.rustam.warehouse.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public double getProductVolume(Long id) {
        return 0;
    }

    @Override
    public double getProductWeight(Long id) {
        return 0;
    }


}
