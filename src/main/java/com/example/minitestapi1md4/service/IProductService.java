package com.example.minitestapi1md4.service;

import com.example.minitestapi1md4.model.Product;

import java.util.List;

public interface IProductService extends IService<Product>{
    Iterable<Product> findAllByPriceGreaterThan300();

    Iterable<Product> findAllByNameContaining(String name);
}
