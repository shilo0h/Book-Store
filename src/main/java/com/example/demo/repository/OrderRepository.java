package com.example.demo.repository;

import com.example.demo.entities.Book;
import com.example.demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.net.Inet4Address;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(nativeQuery = true,value ="SELECT * FROM order")
    Optional<List<Order>> getAllOrder();
    //GET /order/{id}: Retrieve the details of a specific order
    @Query(nativeQuery = true,value = "Select*from order o where o.order_id=:orderId")
    Optional <Order>getOrderById(@Param("orderId")Integer orderId);
    @Modifying
    @Query(nativeQuery = true,value = "Update order " +
            "Set customer_id=:customerId,order_date=:orderDate,total_amount=:totalAmount " +
            " Where order_id=:orderId")
    void updateOrder(@Param("customerId")Integer customerId,@Param("orderDate")Integer orderDate,
                    @Param("totalAmount")Integer totalAmount,
                    @Param("orderId")Integer orderId);
}
