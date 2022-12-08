package com.denver.examplestore.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private double price;
    @Column(name = "page")
    private int page;

    public Book(String title, String author, int page, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.page = page;
    }
}
