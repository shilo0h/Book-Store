package com.example.demo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column
    private String name;
    @Column
    private Integer age;
    @Column
    private String email;
    @Column
    private String address;

}
