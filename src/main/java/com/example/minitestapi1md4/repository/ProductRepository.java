package com.example.minitestapi1md4.repository;

import com.example.minitestapi1md4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findAllByCategoryId(Long id);

    Iterable<Product> findAllByCategoryName(String name);

    Iterable<Product> findAllByPriceBetween(int from, int to);
}
