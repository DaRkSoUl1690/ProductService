package com.example.ProductService.command.api.repository;

import com.example.ProductService.command.api.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
