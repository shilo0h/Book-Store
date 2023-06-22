package com.example.demo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "order")
@Data
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column
    private Integer customerId;
    @Column
    private Integer orderDate;
    @Column
    private Integer totalAmount;

}
