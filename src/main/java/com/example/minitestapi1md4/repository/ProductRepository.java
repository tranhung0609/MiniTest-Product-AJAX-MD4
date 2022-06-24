package com.example.minitestapi1md4.repository;

import com.example.minitestapi1md4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Iterable<Product> findAllByNameContaining(String name);

    @Query(value = "select * from product where price> 300" , nativeQuery = true)
    Iterable<Product> findAllByPriceGreaterThan300();

    List<Product> findAllByOrderByPriceDesc();



}
