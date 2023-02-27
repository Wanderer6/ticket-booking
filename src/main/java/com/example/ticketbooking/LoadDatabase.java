package com.example.ticketbooking;

import com.example.ticketbooking.movie.Movie;
import com.example.ticketbooking.movie.MovieRepository;
import com.example.ticketbooking.reservation.JpaReservationRepository;
import com.example.ticketbooking.reservation.Reservation;
import com.example.ticketbooking.room.JpaRoomRepository;
import com.example.ticketbooking.room.Room;
import com.example.ticketbooking.screening.JpaScreeningRepository;
import com.example.ticketbooking.screening.Screening;
import com.example.ticketbooking.seat.JpaSeatRepository;
import com.example.ticketbooking.seat.Seat;
import com.example.ticketbooking.user.User;
import com.example.ticketbooking.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
public class LoadDatabase {

//    private LocalDate now = LocalDate.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//    now.format(formatter)

//    LocalDate date = LocalDate.of(2022, 10, 30);
//
//
//
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


//    @Bean
//    CommandLineRunner initDatabase(UserRepository userRepository, MovieRepository movieRepository, JpaRoomRepository roomRepository,
//                                   JpaSeatRepository seatRepository, JpaMovieStartRepository movieStartRepository, JpaReservationRepository reservationRepository,
//                                   JpaScreeningRepository screeningRepository) {
//
//        return args -> {
//            log.info("Preloading " + userRepository.save(new User("Bilbo", "Baggins")));
//            log.info("Preloading " + userRepository.save(new User("Frodo", "Baggins")));
//            log.info("Preloading " + userRepository.save(new User("Rick", "Johnson")));
//
//            log.info("Preloading " + movieRepository.save(new Movie(1, "Batman1")));
//            log.info("Preloading " + movieRepository.save(new Movie(2, "The Northman2")));
//            log.info("Preloading " + movieRepository.save(new Movie(3, "Batman3")));
//
////            log.info("Preloading " + movieStartRepository.save(new MovieStart("13-07-2022", "15:00", movieRepository.getById(1))));
////            log.info("Preloading " + movieStartRepository.save(new MovieStart(date, "15:00", movieRepository.getById(1))));
//            log.info("Preloading " + movieStartRepository.save(new MovieStart(LocalDate.of(2022,10,30), "15:00", movieRepository.getById(1))));
//            log.info("Preloading " + movieStartRepository.save(new MovieStart(LocalDate.of(2022,11,1), "15:00", movieRepository.getById(2))));
//
//            log.info("Preloading " + roomRepository.save(new Room(1, 105)));
//            log.info("Preloading " + roomRepository.save(new Room(2, 106)));
//
//            log.info("Preloading " + seatRepository.save(new Seat(1, 1, 1, true, roomRepository.getById(1))));
//            log.info("Preloading " + seatRepository.save(new Seat(2, 1, 2, true, roomRepository.getById(1))));
//
//            log.info("Preloading " + screeningRepository.save(new Screening(movieRepository.getById(1), roomRepository.findRoomsByIdIn(List.of(1,2)))));
////            Set.of(roomRepository.getById(1))
//            log.info("Preloading " + reservationRepository.save(new Reservation("Batman", "14:30 15-07-2022", "adult", 105,
//                    1, userRepository.getById(1), screeningRepository.getById(1))));
//
////            log.info("Preloading " + movieRepository.save(new Movie("Batman",
////                    LocalDateTime.of(2022, 9, now+3, 20, 0), 103)));
////            log.info("Preloading " + movieRepository.save(new Movie("Batman",
////                    LocalDateTime.of(2022, 9, now+4, 20, 0), 103)));
//
//
//        };
//    }


}
