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
//    @Override
//    @Query("Select s from Screening s join s.movie where s.movieDate = :date")
//    List<ScreeningWithMovieTitleView> findByDate(@Param("date") LocalDate date);
    @Override
    @Query("Select new com.example.ticketbooking.screening.ScreeningWithMovieTitleViewDTO(s.movie.title, s.movieDate, s.movieStartTime) from Screening s join s.movie where s.movieDate = :date")
    List<ScreeningWithMovieTitleViewDTO> findByDate(@Param("date") LocalDate date);

    @Override
    @Query("Select s from Screening s join s.movie where s.movieDate = :date and s.movieStartTime between :startTime and :endTime")
    List<ScreeningWithMovieTitleView> findByDateAndTimeInterval(@Param("date") LocalDate date, @Param("startTime") String startTime, @Param("endTime") String endTime);

//    @Override
//    @Query("Select new com.example.ticketbooking.screening.ScreeningWithRoomAndSeatsDTO(s.movie.title, s.movieDate, s.movieStartTime, s.rooms.roomNumber, s.rooms.seats) " +
//            "from Screening s join s.movie join s.rooms where s.movieDate = :date and s.movie.title = :title and s.movieStartTime = :time " +
//            "and s.room_id = s.rooms.id")
//    @Override
//    @Query("Select new com.example.ticketbooking.screening.ScreeningWithRoomAndSeatsDTO(s.movie.title, s.movieDate, s.movieStartTime, r.roomNumber, " +
//            "seat.seatRow, seat.seatNumber, seat.availability) " +
//            "from Screening s JOIN s.rooms r JOIN r.seats seat where s.movie.title = :title AND s.movieDate = :date AND s.movieStartTime = :time")
//    List<ScreeningWithRoomAndSeatsDTO> findByTitleAndDateAndTime(@Param("title") String title, @Param("date") LocalDate date, @Param("time") String time);

//    @Override
//    @Query("Select s, r FROM Screening s JOIN s.rooms r where s.movie.title = 'Batman'")
//    @Query("Select new com.example.ticketbooking.screening.ScreeningWithRoomAndSeatsDTO(" +
//            "s.movie.title, s.movieDate, s.movieStartTime, r.roomNumber, seats) " +
//            "from Screening s " +
//            "JOIN s.rooms r " +
//            "JOIN r.seats seats")
//    @Query("Select s FROM Screening s JOIN s.rooms r where s.room_id = s.r.id")
//    @Query("Select s FROM Screening s JOIN s.rooms r on sr.room_id = r.id " +
//            "JOIN screeningRoom sr on s.id = sr.screening_id")
//    List<ScreeningWithRoomAndSeatsDTO> test();


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
