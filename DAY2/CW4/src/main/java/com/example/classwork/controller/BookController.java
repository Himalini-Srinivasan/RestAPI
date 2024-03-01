package com.example.classwork.controller;


import java.util.Date;
import org.springframework.web.bind.annotation.RestController;

import com.example.classwork.model.Book;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookController {
    @GetMapping("/book")
    public Book getBook() {
        Book book = new Book("The Great Soldier", "G. Gyan", new Date());
        return book;
    }
}