package com.example.ticketbooking.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JpaMovieRepository extends MovieRepository, JpaRepository<Movie, String> {

    @Override
    @Query("select m From Movie m")
    List<MovieView> findInter();

    @Override
    @Query("select m from Movie m")
    List<MovieView> findTitles();

    @Override
    @Query("SELECT m.title FROM Movie m")
    List<Object[]> getTitle();

    @Override
    @Query("select distinct title from Movie")
    List<String> findAllTitles();

    @Override
    @Query(nativeQuery = true, value = "select id from movies where title = :title")
    List<Movie> findByTitle(@Param("title") String title);

}
