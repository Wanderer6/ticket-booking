package com.example.ticketbooking.screening;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {

    private final ScreeningRepository screeningRepository;


    public ScreeningController(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @GetMapping("/dates")
    Map<String, List<LocalDate>> findDates() {
        return Collections.singletonMap("MovieDates", screeningRepository.findDates());
    }

    @GetMapping("/all")
    List<ScreeningWithMovieTitleView> findScreenings() {
        return screeningRepository.findScreenings();
    }

    @GetMapping("/by-date")
    List<ScreeningWithMovieTitleViewDTO> findByDate(@RequestParam String date) {

        LocalDate localDate = LocalDate.parse(date);
        return screeningRepository.findByDate(localDate);
    }

    @GetMapping("/interval")
    List<ScreeningWithMovieTitleView> findByDateAndInterval(@RequestParam String date, @RequestParam String startTime, @RequestParam String endTime) {
        LocalDate localDate = LocalDate.parse(date);
        return screeningRepository.findByDateAndTimeInterval(localDate, startTime, endTime);
    }

    @GetMapping("/room")
    List<ScreeningWithRoomAndSeatsView> findByTitleAndDateAndTime(@RequestParam String title, @RequestParam String date, @RequestParam String time) {
        LocalDate localDate = LocalDate.parse(date);
        return screeningRepository.findByTitleAndDateAndTime(title, localDate, time);
    }

    @GetMapping("/test2")
    List<ScreeningWithRoomAndSeatsView> test2() {
        return screeningRepository.test2();
    }
}
