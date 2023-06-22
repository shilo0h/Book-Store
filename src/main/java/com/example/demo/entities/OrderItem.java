package com.example.demo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "orderItem")
@Data
@ToString
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;
    @Column
    private Integer orderId;
    @Column
    private Integer bookId;
    @Column
    private Integer quantity;
}
