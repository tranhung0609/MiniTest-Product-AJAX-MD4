package com.example.minitestapi1md4.service.impl;

import com.example.minitestapi1md4.model.Order;
import com.example.minitestapi1md4.repository.OrderRepository;
import com.example.minitestapi1md4.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Page<Order> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }

    @Override
    public List<Order> findAllByCreateAtBetween(LocalDateTime from, LocalDateTime to){
        return orderRepository.findAllByCreateAtBetween(from, to);
    }


    public Iterable<Object[]> reportByCreateTime(LocalDate from, LocalDate to) {
        return orderRepository.reportByCreateTime(from, to);
    }
}
