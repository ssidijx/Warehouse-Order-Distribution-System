package com.rustam.warehouse.service;

import com.rustam.warehouse.entities.Category;
import com.rustam.warehouse.entities.Product;
import com.rustam.warehouse.repository.CategoryRepository;
import com.rustam.warehouse.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class ProductServiceImplTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository repo;
    @Autowired
    private CategoryRepository catRepo;

    @BeforeEach
    void setUp(){
        Product p = new Product();
        p.setId(1L);
        p.setName("TV");
        p.setWeight(100.0);
        p.setVolume(2.5);
        Category c = new Category();
        c.setId(1L);
        c.setName("Electronics");
        catRepo.save(c);
        p.setCategory(c);
        repo.save(p);
    }

    @Test
    void testFindProdByID(){
        Product product = productService.getProductById(1L);
        assertThat(product).isNotNull();
        assertThat(product.getWeight()).isEqualTo(100.0);
        assertThat(product.getVolume()).isEqualTo(2.5);
    }
}
