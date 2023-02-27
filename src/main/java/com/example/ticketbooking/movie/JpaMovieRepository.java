package com.example.ticketbooking.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaMovieRepository extends MovieRepository, JpaRepository<Movie, String> {

    @Override
    @Query("select m From Movie m")
    List<MovieView> findInter();

//    @Override
//    @Query("select m from Movie m join m.movieStarts ms where ms.movieDate = :date")
//    List<MovieView> findAllMoviesByDate(@Param("date") LocalDate date);
//
//    @Override
//    @Query(nativeQuery = true, value = "SELECT m.title, ms.start_time FROM Movies m RIGHT JOIN Movie_Start ms ON m.ID=ms.Movie_Id where ms.movie_date like %:date%")
//    List<MovieView> findInterByDate(@Param("date") String date);

    @Override
//    @Query("select movie.title as title, startView.movieDate as date, startView.startTime as time " +
//            "from Movie movie left join movie.movieStart as startView")
//    @Query("select m.title as title, s as start from Movie m left join MovieStart as s on m.id=s.movie.id")
//    @Query("select m.title as title, s as start from Movie m left join MovieStart as s on m.id=s.movie.id")
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
