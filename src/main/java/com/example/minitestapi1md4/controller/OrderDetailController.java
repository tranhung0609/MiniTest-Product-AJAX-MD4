package com.example.minitestapi1md4.controller;

import com.example.minitestapi1md4.model.Order;
import com.example.minitestapi1md4.model.OrderDetail;
import com.example.minitestapi1md4.model.Product;
import com.example.minitestapi1md4.service.IOrderDetailService;
import com.example.minitestapi1md4.service.IOrderService;
import com.example.minitestapi1md4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/order-details")
public class OrderDetailController {

    @Autowired
    IOrderDetailService orderDetailService;
    @Autowired
    IProductService productService;
    @Autowired
    IOrderService orderService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(orderDetailService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody OrderDetail orderDetail) {
        Product product = productService.findById(orderDetail.getProduct().getId()).get();
        Order order = orderService.findById(orderDetail.getOrder().getId()).get();
        product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
        productService.save(product);
        order.setTotalPrice(order.getTotalPrice() + product.getQuantity() * product.getPrice());
        orderService.save(order);
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
