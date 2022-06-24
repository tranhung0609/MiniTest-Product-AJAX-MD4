package com.example.minitestapi1md4.repository;

import com.example.minitestapi1md4.model.Order;
import com.example.minitestapi1md4.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCreateAtBetween(LocalDateTime from, LocalDateTime to);

    @Query(value = "select p.id, p.name, sum(od.quantity)\n" +
            "from product p\n" +
            "join order_detail od on p.id = od.product_id\n" +
            "join orders o on o.id = od.order_id\n" +
            "where o.create_at between :dateFrom and :dateTo\n" +
            "group by p.id;", nativeQuery = true)
    Iterable<Object[]> reportByCreateTime(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);
}
