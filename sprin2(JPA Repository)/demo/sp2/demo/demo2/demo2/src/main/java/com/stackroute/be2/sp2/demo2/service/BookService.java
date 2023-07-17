package com.stackroute.be2.sp2.demo2.service;

import com.stackroute.be2.sp2.demo2.domain.Book;

import java.util.List;

public interface BookService {
    public abstract Book addBook(Book book);
    public abstract List<Book> getAllBook();
    public abstract Book updateBook(Book book);
    public abstract void deleteBook(String bid);
    public abstract Book getBookById(String bid);

    public abstract List<Book> getBookByAuthorAndSubject(String asub,String author);
}
