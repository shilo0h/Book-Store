package com.example.demo.entities;

import lombok.Data;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    @Column
    private String title;
    @Column
    private Integer isbn;
    @Column
    private Integer publication_year;
    @Column
    private Integer price;
    @Column
    private Integer quantity;
}
