package com.example.demo.repository;

import com.example.demo.entities.Book;
import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(nativeQuery = true,value ="select*from customer")
    Optional<List<Customer>> getAllCustomer();
    //GET /customer/{id}: Retrieve the details of a specific customer
    @Query(nativeQuery = true,value = "Select*from customer c where c.customer_id=:customerId")
    Optional <Customer>getCustomerById(@Param("customerId")Integer customerId);
    @Modifying
    @Query(nativeQuery = true,value = "Update customer " +
            "Set name=:name,age=:age,email=:email " +
            "address=:address,Where customer_id=:customerId")
    void updateCustomer(@Param("name")String name,@Param("age")Integer age,
                    @Param("email")String email,
                    @Param("address")String address,
                    @Param("customerId")Integer customerId);
}
