package com.example.ticketbooking.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaMovieRepository extends MovieRepository, JpaRepository<Movie, String> {

    @Override
    @Query(nativeQuery = true, value = "select * from movies")
    List<Movie> findAll();

    @Override
    @Query(nativeQuery = true, value = "select * from movies m where movie_date like %:date%")
    List<Movie> findAllByDate(@Param("date") String date);

    @Override
    @Query(nativeQuery = true, value = "select * from movies where title = :title")
    List<Movie> findByTitle(@Param("title") String title);

}
