package com.example.adminportal.service.impl;

import com.example.adminportal.mapper.BookMapper;
import com.example.adminportal.model.Book;
import com.example.adminportal.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book queryById(long id) {
        return bookMapper.queryById(id);
    }

    @Override
    public List<Book> queryAll() {
        return bookMapper.queryAll();
    }

    @Override
    public int delete(long id) { return bookMapper.delete(id);}

    @Override
    public int add(Book book) {return bookMapper.add(book);}
}
