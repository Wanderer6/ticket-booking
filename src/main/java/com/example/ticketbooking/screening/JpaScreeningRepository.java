package com.example.ticketbooking.screening;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JpaScreeningRepository extends ScreeningRepository, JpaRepository<Screening, Integer> {

    @Override
    @Query("Select distinct(s.movieDate) from Screening s")
    List<LocalDate> findDates();

    @Override
    @Query("Select s from Screening s")
    List<ScreeningWithMovieTitleView> findScreenings();

    @Override
    @Query("Select new com.example.ticketbooking.screening.ScreeningWithMovieTitleViewDTO(s.movie.title, s.movieDate, s.movieStartTime) from Screening s join s.movie where s.movieDate = :date")
    List<ScreeningWithMovieTitleViewDTO> findByDate(@Param("date") LocalDate date);

    @Override
    @Query("Select s from Screening s join s.movie where s.movieDate = :date and s.movieStartTime between :startTime and :endTime ORDER BY s.movieStartTime, s.movie.title")
    List<ScreeningWithMovieTitleView> findByDateAndTimeInterval(@Param("date") LocalDate date, @Param("startTime") String startTime, @Param("endTime") String endTime);

    @Override
    @Query("Select s from Screening s " +
            "join s.rooms r " +
            "join s.movie m " +
            "where m.title = :title and s.movieDate = :date and s.movieStartTime = :time")
    List<ScreeningWithRoomAndSeatsView> findByTitleAndDateAndTime(@RequestParam String title, @RequestParam LocalDate date, @RequestParam String time);

    @Override
    @Query("SELECT s from Screening s " +
            "join s.rooms r " +
            "where r.roomNumber = 1")
    List<ScreeningWithRoomAndSeatsView> test2();
}
