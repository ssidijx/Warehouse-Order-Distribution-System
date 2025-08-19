package com.rustam.warehouse.service.impl;

import com.rustam.warehouse.entities.Product;
import com.rustam.warehouse.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProductServiceImplTest {

    @Autowired
    private ProductService service;

    @Test
    void shouldFindById() {
        Product p = service.getProductById(1L);
        assertThat(p).isNotNull();
        assertThat(p.getName()).isEqualTo("Large TV");
        assertThat(p.getWeight()).isEqualTo(100.0);
        assertThat(p.getVolume()).isEqualTo(2.5);
    }
}
