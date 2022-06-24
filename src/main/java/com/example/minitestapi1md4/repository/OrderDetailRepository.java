package com.example.minitestapi1md4.repository;

import com.example.minitestapi1md4.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
