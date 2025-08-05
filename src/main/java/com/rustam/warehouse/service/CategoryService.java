package com.rustam.warehouse.service;

import com.rustam.warehouse.entities.Category;
import com.rustam.warehouse.entities.Order;
import com.rustam.warehouse.entities.OrderItem;
import com.rustam.warehouse.entities.Product;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<Category> getAllCategories();
    List<Product> getProductByCategory(Category category);
    Map<Category, List<OrderItem>> splitOrdersByCategory(List<Order> orders);
}
