package com.example.minitestapi1md4.service.product;

import com.example.minitestapi1md4.model.Product;
import com.example.minitestapi1md4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
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
    public void remove(Long id) {
        productRepository.deleteById(id);
    }
    public Iterable<Product> findAllByCategoryId(Long id){
        if (id == 0) {
            return productRepository.findAll();
        }
        return productRepository.findAllByCategoryId(id);
    }

    public Iterable<Product> findAllByCategoryName(String name){
        return productRepository.findAllByCategoryName(name);
    }

    public Iterable<Product> findAllByPriceBetween(int from, int to){
        return productRepository.findAllByPriceBetween(from, to);
    }
}
