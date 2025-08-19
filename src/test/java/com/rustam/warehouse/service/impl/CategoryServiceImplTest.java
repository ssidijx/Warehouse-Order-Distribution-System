package com.rustam.warehouse.service.impl;

import com.rustam.warehouse.entities.Category;
import com.rustam.warehouse.entities.Product;
import com.rustam.warehouse.repository.ProductRepository;
import com.rustam.warehouse.service.CategoryService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Transactional
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    void shouldReturnAllCategories() {
        List<Category> all = categoryService.getAllCategories();
        assertThat(all).hasSize(100);
    }

    @Test
    void shouldReturnProductsOfCategory() {
        Category cat = categoryService.getAllCategories()
                .stream()
                .filter(c -> c.getId().equals(1L))
                .findFirst()
                .orElseThrow();
        List<Product> products = categoryService.getProductByCategory(cat);
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getName()).isEqualTo("Large TV");
    }

}
