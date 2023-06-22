package com.example.demo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "author")
@Data
@ToString
public class Author {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @Column
    private String name;
    @Column
    private Integer age;
}
