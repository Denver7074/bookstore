package com.denver.examplestore.repositories;

import com.denver.examplestore.models.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRep extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
}
