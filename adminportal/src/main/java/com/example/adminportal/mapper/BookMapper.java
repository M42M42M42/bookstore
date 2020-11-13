package com.example.adminportal.mapper;

import com.example.adminportal.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    /*
    @Results({
            //@Result(property = "id", column = "id"),
            @Result(property = "active", column = "active"),
            @Result(property = "author", column = "author"),
            @Result(property = "category", column = "category"),
            @Result(property = "description", column = "description"),
            @Result(property = "format", column = "format"),
            @Result(property = "in_stock_number", column = "in_stock_number"),
            @Result(property = "isbn, language", column = "isbn, language"),
            @Result(property = "list_price", column = "list_price"),
            @Result(property = "number_of_pages", column = "number_of_pages"),
            @Result(property = "our_price", column = "our_price"),
            @Result(property = "publication_date", column = "publication_date"),
            @Result(property = "publisher", column = "publisher"),
            @Result(property = "shipping_weight", column = "shipping_weight"),
            @Result(property = "title", column = "title")
    })*/
    @Select("SELECT * FROM book WHERE id = #{id}")
    Book queryById(@Param("id") long id);

    @Select("SELECT * FROM book")
    List<Book> queryAll();

    @Delete("DELETE FROM book WHERE id = #{id}")
    int delete(@Param("id") long id);

    @Insert("INSERT INTO book(active, author, category, description, format, in_stock_number," +
            "isbn, language, list_price, number_of_pages, our_price, publication_date, publisher," +
            "shipping_weight, title) VALUES (#{book.active}, #{book.author}, #{book.category}, #{book.description}, " +
            "#{book.format}, #{book.in_stock_number}, #{book.isbn}, #{book.language}, #{book.list_price}, #{book.number_of_pages}, " +
            "#{book.our_price}, #{book.publication_date}, #{book.publisher}, #{book.shipping_weight}, #{book.title})")
    int add(@Param("book") Book book);

    @Update("UPDATE book SET active=#{book.active}, author=#{book.author}, category=#{book.category}, description=#{book.description}," +
            "format=#{book.format}, in_stock_number=#{book.in_stock_number}," +
            "isbn=#{book.isbn}, language=#{book.language}, list_price=#{book.list_price}, number_of_pages=#{book.number_of_pages}, " +
            "our_price=#{book.our_price}, publication_date=#{book.publication_date}, publisher=#{book.publisher}, " +
            "shipping_weight=#{book.shipping_weight}, title=#{book.title} WHERE id=#{book.id}")
    int update(@Param("book") Book book);
}
