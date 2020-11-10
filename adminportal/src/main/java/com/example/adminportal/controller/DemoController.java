package com.example.adminportal.controller;

import com.example.adminportal.model.Book;
import com.example.adminportal.service.impl.BookServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class DemoController {

    static final int start = 0;
    static final int size = 10;
    @Autowired
    private BookServiceImpl bookService;
/*
    @RequestMapping("/")
    public String listCategory (Model m,
                               @RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "20") int size) {


        PageHelper.startPage(start, size, "id desc");
        List<Book> list = bookService.queryAll();
        PageInfo<Book> pageInfo = new PageInfo<>(list);


        m.addAttribute("pageInfo", pageInfo);

        return "index";
    }*/

    /*
    @RequestMapping("/querybyid")
    Book queryById(long id) {
        return bookService.queryById(id);
    }*/

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/booklist")
    public ModelAndView bookList () {


        //PageHelper.startPage(start, size, "id desc");
        List<Book> list = bookService.queryAll();
        //PageInfo<Book> pageInfo = new PageInfo<>(list);
        ModelAndView modelAndView = new ModelAndView("bookList");
        //modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("bookList", list);
        return modelAndView;
    }


    @GetMapping("/bookinfo")
    public ModelAndView bookInfo (@Param(value = "id") long id) {
        Book book = bookService.queryById(id);
        ModelAndView modelAndView = new ModelAndView("bookInfo");
        modelAndView.addObject("book", book);
        return modelAndView;
    }


    @GetMapping("/add")
    public String toAdd(Model model) {

        model.addAttribute("book", new Book());
        return "addBook";
    }


    @PostMapping("/add")
    public String add (@ModelAttribute Book book) {
        /*
        Book newBook = new Book();
        newBook.setActive(book.isActive());
        newBook.setAuthor(book.getAuthor());
        newBook.setCategory(book.getCategory());
        newBook.setDescription(book.getDescription());
        newBook.setFormat(book.getFormat());
        newBook.setIn_stock_number(book.getIn_stock_number());
        newBook.setIsbn(book.getIsbn());
        newBook.setLanguage(book.getLanguage());
        newBook.setList_price(book.getList_price());
        newBook.setNumber_of_pages(book.getNumber_of_pages());
        newBook.setOur_price(book.getOur_price());
        newBook.setPublication_date(book.getPublication_date());
        newBook.setPublisher(book.getPublisher());
        newBook.setShipping_weight(book.getShipping_weight());
        newBook.setTitle(book.getTitle());*/

        int i = 0;
        try {
            i = bookService.add(book);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        return i == 1 ? "success" : "error";
    }


    @GetMapping("/delete")
    public String delete (@Param(value = "id") long id) {
        int i = 0;
        try {
            i = bookService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        return i == 1 ? "success" : "error";
    }

}
