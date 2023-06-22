package com.example.demo.service;

import com.example.demo.entities.Book;
import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;
    public List<Customer> getAllCustomer()throws Exception{
        Optional<List<Customer>> list=repository.getAllCustomer();
        if (list.isPresent()){
            return list.get();
        }
        throw new Exception("Empty table");
    }
    public Customer getCustomerById(Integer customerId)throws Exception{
        Optional<Customer> customer=repository.getCustomerById(customerId);
        if (customer.isPresent()){
            return customer.get();
        }
        throw new Exception("Customer not found");
    }
    public void saveCustomer(Customer customer){
        repository.save(customer);
    }
    @Transactional//update te nje customer sipas id
    public void updateCustomer(Customer customer)throws Exception{
        Optional<Customer>customer1=repository.findById(customer.getCustomerId());
        if (customer1.isPresent()){
            repository.updateCustomer(customer.getName(), customer.getAge(),customer.getEmail(),
                    customer.getAddress(),customer.getCustomerId());
        }
        else {
            throw new Exception("Customer not found");
        }
    }
    @Transactional//do fshij nje Customer
    public void deleteCustomer(Integer customerId){
        repository.deleteById(customerId);
    }
}
