package com.example.adminportal.service;

import com.example.adminportal.model.Book;

import java.util.List;

public interface BookService {

    Book queryById(long id);

    List<Book> queryAll();

    int delete(long id);

    int add(Book book);
}
