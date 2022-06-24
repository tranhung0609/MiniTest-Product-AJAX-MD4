package com.example.minitestapi1md4.service.impl;

import com.example.minitestapi1md4.model.Product;
import com.example.minitestapi1md4.repository.ProductRepository;
import com.example.minitestapi1md4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }

    @Override
    public Iterable<Product> findAllByPriceGreaterThan300(){
        return productRepository.findAllByPriceGreaterThan300();
    }
    @Override
    public Iterable<Product> findAllByNameContaining(String name){
        return productRepository.findAllByNameContaining(name);
    }

}
