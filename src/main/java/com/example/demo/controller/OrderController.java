package com.example.demo.controller;

import com.example.demo.entities.Book;
import com.example.demo.entities.Order;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService service;
    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getAllOrder(){
        log.info("OrderController.getAllOrder()started at{}", Instant.now());
        List<Order>list=null;
        try {
            list=service.getAllOrder();
            log.info("OrderController.getAllOrder() ended request in{}",Instant.now());
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.info("OrderController.getAllOrder()Ended error request in{}",Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/getOrderById")
    public ResponseEntity<Order>getOrderById(@RequestParam("order_id")Integer orderId){
        log.info("OrderController.getOrderById()started request at{}",Instant.now());
        Order order=null;
        try {
            order=service.getOrderById(orderId);
            log.info("OrderController.getOrderById() Ended Request at {}", Instant.now());
            return ResponseEntity.ok(order);
        }catch (Exception e){
            log.info("OrderController.getOrderById()Error at{}",Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/save")
    public ResponseEntity<String>saveOrder(@RequestBody Order order){
        log.info("Started saveOrder() at {}  request body: {}", Instant.now(), order);
        service.saveOrder(order);
        log.info("Ended saveOrder()at{}", Instant.now());
        return ResponseEntity.ok("Order saved successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<String>updateOrder(@RequestBody Order order){
        try {
            service.updateOrder(order);
            log.info("UpdateOrder()ended request at{}",Instant.now());
            return ResponseEntity.ok("Order updated successfully");
        }catch (Exception e){
            log.error("Error,Order not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String>deleteOrder(@RequestParam("order_id")Integer orderId){
        service.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted successfully");
    }
}
