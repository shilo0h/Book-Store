package com.example.demo.service;

import com.example.demo.entities.Book;
import com.example.demo.entities.Order;
import com.example.demo.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;
    public List<Order> getAllOrder()throws Exception{
        Optional<List<Order>> list=repository.getAllOrder();
        if (list.isPresent()){
            return list.get();
        }
        throw new Exception("Empty table");
    }
    public Order getOrderById(Integer orderId)throws Exception{
        Optional<Order> order=repository.getOrderById(orderId);
        if (order.isPresent()){
            return order.get();
        }
        throw new Exception("Order not found");
    }
    public void saveOrder(Order order){
        repository.save(order);
    }
    @Transactional//update te nje order sipas id
    public void updateOrder(Order order)throws Exception{
        Optional<Order>order1=repository.findById(order.getOrderId());
        if (order1.isPresent()){
            repository.updateOrder(order.getCustomerId(), order.getOrderDate(),
                    order.getTotalAmount(), order.getOrderId());
        }
        else {
            throw new Exception("Order not found");
        }
    }
    @Transactional//do fshij nje order
    public void deleteOrder(Integer orderID){
        repository.deleteById(orderID);
    }
}
