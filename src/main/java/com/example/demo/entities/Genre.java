package com.example.demo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "genre")
@Data
@ToString
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;
    @Column
    private String name;
}
