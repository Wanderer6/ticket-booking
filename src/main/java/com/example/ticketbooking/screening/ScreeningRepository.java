package com.example.ticketbooking.screening;


import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface ScreeningRepository {

    List<LocalDate> findDates();
    List<ScreeningWithMovieTitleView> findScreenings();
    List<ScreeningWithMovieTitleViewDTO> findByDate(@Param("date") LocalDate date);
    List<ScreeningWithMovieTitleView> findByDateAndTimeInterval(@Param("date") LocalDate date, @Param("startTime") String startTime, @Param("endTime") String endTime);
//    List<ScreeningWithRoomAndSeatsDTO> findByTitleAndDateAndTime(@Param("title") String title, @Param("date") LocalDate date, @Param("time") String time);

//    List<ScreeningWithRoomAndSeatsDTO> test();
    List<ScreeningWithRoomAndSeatsView> test2();
    List<ScreeningWithRoomAndSeatsView> findByTitleAndDateAndTime(@RequestParam String title, @RequestParam LocalDate date, @RequestParam String time);

}
