package com.denver.examplestore.controllers;

import com.denver.examplestore.models.Book;
import com.denver.examplestore.repositories.BookRep;
import com.denver.examplestore.services.BookServ;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookContr {

    private final BookServ bookServ;
    private final BookRep bookRep;

    @GetMapping("/book")
    public String books(@RequestParam(name = "title", required = false) String title, Model model){
        model.addAttribute("books", bookServ.bookList(title));
        return "book";
    }

    @PostMapping("/book/add")
    public String addBook(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam int page,
                          @RequestParam double price){
        bookServ.addBook(title,author,page,price);
        return "redirect:/book";
    }

    @PostMapping("/book/delete/{id}")
    public String remove(@PathVariable(name = "id") Long id){
        bookServ.deleteBook(id);
        return "redirect:/book";
    }

    @GetMapping("/book/{id}/edit")
    public String bookEdit(@PathVariable(value = "id") Long id, Model model){
        if (!bookRep.existsById(id)){
            return "redirect:/book";
        }
        Optional<Book> book = bookRep.findById(id);
        ArrayList<Book> books = new ArrayList<>();
        book.ifPresent(books::add);
        model.addAttribute("books", books);
        return "book-edit";
    }

    @PostMapping("/book/edit/{id}")
    public String resave(@PathVariable(name = "id") Long id,
                         @RequestParam String title,
                         @RequestParam String author,
                         @RequestParam int page,
                         @RequestParam double price){
        bookServ.updateBook(title,author,page,price,id);
        return "redirect:/book";
    }
}
