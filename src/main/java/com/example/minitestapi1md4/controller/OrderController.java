package com.example.minitestapi1md4.controller;

import com.example.minitestapi1md4.model.Order;
import com.example.minitestapi1md4.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody Order order) {
        orderService.save(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find-all-create-at-between")
    public ResponseEntity findAllByCreateAtBetween(@RequestParam String from, @RequestParam String to) {
        return new ResponseEntity(orderService.findAllByCreateAtBetween(LocalDateTime.parse(from), LocalDateTime.parse(to)), HttpStatus.OK);
    }

    @GetMapping("/find-product-sell-between")
    public ResponseEntity findAllProductSellBetween(@RequestParam String from, @RequestParam String to) {
        return new ResponseEntity(orderService.reportByCreateTime(LocalDate.parse(from), LocalDate.parse(to)), HttpStatus.OK);
    }
}
