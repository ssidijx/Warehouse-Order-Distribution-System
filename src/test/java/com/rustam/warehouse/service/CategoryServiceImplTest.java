package com.rustam.warehouse.service;

import com.rustam.warehouse.entities.Product;
import com.rustam.warehouse.repository.ProductRepository;
import com.rustam.warehouse.service.impl.CategoryServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductRepository repo;


}
