package com.stackroute.be2.sp2.demo2.reposit;


import com.stackroute.be2.sp2.demo2.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    @Query("select b from Book b where b.subject=?1 and b.auhtor_name=?2")
    public List<Book> getBookByAuthorAndSubject(String a,String b);



}
