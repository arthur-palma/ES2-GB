package com.project.gb.infrastructure.repositories;

import com.project.gb.application.port.ProductRepository;
import com.project.gb.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long>, ProductRepository {
}
