package com.stackroute.c2.sp2.sprint21.respository;

import com.stackroute.c2.sp2.sprint21.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Movie_Respoitory extends JpaRepository<Movie,String> {

    public List<Movie> findByGenre(String genre);
    // @Query("select * from Book x where x.subject=?1 and x.authorName=?2") or
    //    ////    public List<Book> getBookBySubAuthor(String a,String b);
    public List<Movie> findByMoviename(String name);
    //or @Query("select * from Book x where x.subject=?1 and x.authorName=?2") or
    ////    public List<Book> getBookBySubAuthor(String a,String b);



}
