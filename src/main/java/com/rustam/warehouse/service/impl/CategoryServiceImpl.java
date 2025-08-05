package com.rustam.warehouse.service.impl;

import com.rustam.warehouse.entities.Category;
import com.rustam.warehouse.entities.Order;
import com.rustam.warehouse.entities.OrderItem;
import com.rustam.warehouse.entities.Product;
import com.rustam.warehouse.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public List<Product> getProductByCategory(Category category) {
        return List.of();
    }

    @Override
    public Map<Category, List<OrderItem>> splitOrdersByCategory(List<Order> orders) {
        return Map.of();
    }
}
