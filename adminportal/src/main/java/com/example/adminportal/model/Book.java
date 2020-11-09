package com.example.adminportal.model;

import lombok.Data;

@Data
public class Book {
    private long id;
    private boolean active;
    private String author;
    private String category;
    private String description;
    private String format;
    private int in_stock_number;
    private long isbn;
    private String language;
    private double list_price;
    private int number_of_pages;
    private double our_price;
    private String publication_date;
    private String publisher;
    private double shipping_weight;
    private String title;
}
