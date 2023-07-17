package com.stackroute.be2.sp2.demo2.controller;

import com.stackroute.be2.sp2.demo2.domain.Book;
import com.stackroute.be2.sp2.demo2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/bookapp/v1")
public class BookController {
    
    @Autowired
    private BookService bookService;

    //http://localhost:8080/bookapp/v1/book

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBook()
    {return new ResponseEntity<List<Book>>(bookService.getAllBook(), HttpStatus.OK);}

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody Book book)
    {
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.OK);
    }
    @PutMapping("/book")
    public ResponseEntity<?> updateBook(@RequestBody Book book)
    {
        return new ResponseEntity<>(bookService.updateBook(book),HttpStatus.OK);
    }

    @GetMapping("/getBookById/{bid}")
    public ResponseEntity<?> getBookById(@PathVariable String bid)
    {
        return new ResponseEntity<>(bookService.getBookById(bid),HttpStatus.OK);
    }

    @DeleteMapping("/book/{bid}")
    public ResponseEntity<?> deleteBook(@PathVariable String bid)

    {
        bookService.deleteBook(bid);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
        //http://localhost:8080/bookapp/v1/getBookBySubjectAndAuthor/Love/Chetan Bhagat
    @GetMapping("/getBookBySubjectAndAuthor/{subject}/{auhtor_name}")
    public ResponseEntity<?> getBookByAuthorAndSubject(@PathVariable String auhtor_name,@PathVariable String subject)
    {
        return new ResponseEntity<>(bookService.getBookByAuthorAndSubject(subject,auhtor_name),HttpStatus.OK);
    }
}
