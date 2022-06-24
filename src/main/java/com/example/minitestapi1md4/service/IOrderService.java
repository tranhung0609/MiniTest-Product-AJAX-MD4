package com.example.minitestapi1md4.service;

import com.example.minitestapi1md4.model.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService extends IService<Order>{
    List<Order> findAllByCreateAtBetween(LocalDateTime from, LocalDateTime to);
    Iterable<Object[]> reportByCreateTime(LocalDate from, LocalDate to);
}
