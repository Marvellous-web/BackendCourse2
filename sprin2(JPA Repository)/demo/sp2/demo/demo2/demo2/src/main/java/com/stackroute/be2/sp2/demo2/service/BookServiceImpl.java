package com.stackroute.be2.sp2.demo2.service;

import com.stackroute.be2.sp2.demo2.domain.Book;
import com.stackroute.be2.sp2.demo2.reposit.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(String bid) {
        bookRepository.deleteById(bid);
    }

    @Override
    public Book getBookById(String bid) {
        if(bookRepository.findById(bid).isPresent())
        {
            return bookRepository.findById(bid).get();
        }

        else
        return null;
    }

    @Override
    public List<Book> getBookByAuthorAndSubject(String asub, String author) {
        return bookRepository.getBookByAuthorAndSubject(asub,author);
    }
}
