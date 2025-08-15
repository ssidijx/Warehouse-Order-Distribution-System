package com.rustam.warehouse;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.rustam.warehouse.entities.Store;
import com.rustam.warehouse.entities.Category;
import com.rustam.warehouse.entities.Product;
import com.rustam.warehouse.entities.Order;
import com.rustam.warehouse.entities.OrderItem;
import com.rustam.warehouse.repository.StoreRepository;
import com.rustam.warehouse.repository.CategoryRepository;
import com.rustam.warehouse.repository.ProductRepository;
import com.rustam.warehouse.repository.OrderRepository;
import com.rustam.warehouse.repository.OrderItemRepository;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        if (storeRepository.count() == 0) {

            loadStores();
            loadCategories();
            loadProducts();
            loadOrders();
            loadOrderItems();

        } else {
            System.err.println("Skip load");
        }
    }

    private void loadStores() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource("data/stores.csv").getFile()))) {
            List<String[]> lines = reader.readAll();
            lines.stream().skip(1).forEach(line -> {
                Store store = new Store();
                store.setName(line[1]);
                store.setLatitude(Double.parseDouble(line[2]));
                store.setLongitude(Double.parseDouble(line[3]));
                storeRepository.save(store);
            });
        }
    }

    private void loadCategories() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource("data/categories.csv").getFile()))) {
            List<String[]> lines = reader.readAll();
            lines.stream().skip(1).forEach(line -> {
                Category category = new Category();
                category.setName(line[1]);
                categoryRepository.save(category);
            });
        }
    }

    private void loadProducts() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource("data/products.csv").getFile()))) {
            List<String[]> lines = reader.readAll();
            lines.stream().skip(1).forEach(line -> {
                Product product = new Product();
                product.setName(line[1]);
                categoryRepository.findById(Long.parseLong(line[2])).ifPresent(product::setCategory);
                product.setWeight(Double.parseDouble(line[3]));
                product.setVolume(Double.parseDouble(line[4]));
                productRepository.save(product);
            });
        }
    }

    private void loadOrders() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource("data/orders.csv").getFile()))) {
            List<String[]> lines = reader.readAll();
            lines.stream().skip(1).forEach(line -> {
                Order order = new Order();
                storeRepository.findById(Long.parseLong(line[1])).ifPresent(order::setStore);
                String dateString = line[2] + "T00:00:00";
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                LocalDateTime orderDate = LocalDateTime.parse(dateString, formatter);
                order.setOrderDate(orderDate);
                orderRepository.save(order);
            });
        }
    }

    private void loadOrderItems() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource("data/order_items.csv").getFile()))) {
            List<String[]> lines = reader.readAll();
            lines.stream().skip(1).forEach(line -> {
                OrderItem orderItem = new OrderItem();
                orderRepository.findById(Long.parseLong(line[1])).ifPresent(orderItem::setOrder);
                productRepository.findById(Long.parseLong(line[2])).ifPresent(orderItem::setProduct);
                orderItem.setQuantity(Long.parseLong(line[3]));
                orderItemRepository.save(orderItem);
            });
        }
    }
}