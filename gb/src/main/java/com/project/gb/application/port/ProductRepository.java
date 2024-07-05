package com.project.gb.application.port;


import com.project.gb.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long productId);
    List<Product> findAll();
    Product save(Product product);
    void deleteById(Long productId);

    boolean existsById(Long productId);
}