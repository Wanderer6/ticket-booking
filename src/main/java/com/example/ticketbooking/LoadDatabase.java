package com.example.ticketbooking;

import com.example.ticketbooking.movie.Movie;
import com.example.ticketbooking.movie.MovieRepository;
import com.example.ticketbooking.room.JpaRoomRepository;
import com.example.ticketbooking.room.Room;
import com.example.ticketbooking.seat.JpaSeatRepository;
import com.example.ticketbooking.seat.Seat;
import com.example.ticketbooking.user.User;
import com.example.ticketbooking.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Configuration
public class LoadDatabase {

//    private LocalDate now = LocalDate.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//    now.format(formatter)


    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, MovieRepository movieRepository, JpaRoomRepository roomRepository,
                                   JpaSeatRepository seatRepository) {

        return args -> {
            log.info("Preloading " + userRepository.save(new User("Bilbo", "Baggins", "Adult")));
            log.info("Preloading " + userRepository.save(new User("Frodo", "Baggins", "Student")));
            log.info("Preloading " + userRepository.save(new User("Rick", "Johnson", "Student")));

            log.info("Preloading " + movieRepository.save(new Movie("Batman", 101)));
            log.info("Preloading " + movieRepository.save(new Movie("The Northman", 102)));
            log.info("Preloading " + movieRepository.save(new Movie("Batman", 103)));

//            log.info("Preloading " + movieRepository.save(new Movie("Batman",
//                    LocalDateTime.of(2022, 9, now+3, 20, 0), 103)));
//            log.info("Preloading " + movieRepository.save(new Movie("Batman",
//                    LocalDateTime.of(2022, 9, now+4, 20, 0), 103)));

            log.info("Preloading " + roomRepository.save(new Room(1, 105)));
            log.info("Preloading " + seatRepository.save(new Seat(1, 1, 1, true, roomRepository.getById(1))));
            log.info("Preloading " + seatRepository.save(new Seat(2, 1, 2, true, roomRepository.getById(1))));
        };
    }


}
