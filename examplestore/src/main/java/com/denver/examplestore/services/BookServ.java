package com.denver.examplestore.services;

import com.denver.examplestore.models.Book;
import com.denver.examplestore.repositories.BookRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServ {

    private final BookRep bookRep;

    public List<Book> bookList(String title){
        if (title != null) return bookRep.findByTitle(title);
        return bookRep.findAll();
    }

    public void addBook(String title, String author,int page, double price){
        Book book = new Book(title,author,page,price);
        bookRep.save(book);
    }

    public void deleteBook(Long id){
        bookRep.deleteById(id);
    }

    public void updateBook(String title, String author,int page, double price, Long id){
        Book book = bookRep.findById(id).orElseThrow();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPage(page);
        book.setPrice(price);
        bookRep.save(book);
    }



}
