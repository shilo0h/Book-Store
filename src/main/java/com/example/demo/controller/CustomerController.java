package com.example.demo.controller;

import com.example.demo.entities.Book;
import com.example.demo.entities.Customer;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;
    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        log.info("CustomerController.getAllCustomer()started at{}", Instant.now());
        List<Customer>list=null;
        try {
            list=service.getAllCustomer();
            log.info("CustomerController.getAllCustomer() ended request in{}",Instant.now());
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.info("CustomerController.getAllCustomer()Ended error request in{}",Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/getCustomerById")
    public ResponseEntity<Customer> getCustomerById(@RequestParam("customer_id")Integer customerId){
        log.info("CustomerController.getCustomerById()started request at{}",Instant.now());
        Customer customer=null;
        try {
            customer=service.getCustomerById(customerId);
            log.info("CustomerController.getCustomerById() Ended Request at {}", Instant.now());
            return ResponseEntity.ok(customer);
        }catch (Exception e){
            log.info("CustomerController.getCustomerById()Error at{}",Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/save")
    public ResponseEntity<String>saveCustomer(@RequestBody Customer customer){
        log.info("Started saveCustomer() at {}  request body: {}", Instant.now(), customer);
        service.saveCustomer(customer);
        log.info("Ended saveCustomer()at{}", Instant.now());
        return ResponseEntity.ok("Customer saved successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<String>updateCustomer(@RequestBody Customer customer){
        try {
            service.updateCustomer(customer);
            log.info("UpdateCustomer()ended request at{}",Instant.now());
            return ResponseEntity.ok("Customer updated successfully");
        }catch (Exception e){
            log.error("Error,Customer not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String>deleteCustomer(@RequestParam("customer_id")Integer customerId){
        service.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
