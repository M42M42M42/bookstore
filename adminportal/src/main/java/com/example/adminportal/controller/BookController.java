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
public class BookController {

    static final int start = 0;
    static final int size = 10;
    @Autowired
    private BookServiceImpl bookService;

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
        int [] checkedId = {};
        modelAndView.addObject("checkedId", checkedId);
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
        int i = 0;
        try {
            i = bookService.add(book);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        return i == 1 ? "success" : "error";
    }

    @GetMapping("/update")
    public String toUpdate(Model model,
                           @Param(value = "id") int id) {
        Book book = bookService.queryById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }


    @PostMapping("/update")
    public String update (@ModelAttribute Book book) {
        int i = 0;
        try {
            i = bookService.update(book);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        return i == 1 ? "success" : "error";
    }

    @PostMapping("/delete")
    public String delete (@Param(value = "checkedId") int[] checkedId) {
        int i = 1;
        for(int id : checkedId) {
            try {
                bookService.delete(id);
            } catch (Exception e) {
                e.printStackTrace();
                i = -1;
            }
        }
        return i == 1 ? "success" : "error";
    }
}
