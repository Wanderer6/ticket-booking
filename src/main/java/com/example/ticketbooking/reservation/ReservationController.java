package com.example.ticketbooking.reservation;

import com.example.ticketbooking.exceptions.ResourceException;
import com.example.ticketbooking.screening.JpaScreeningRepository;
import com.example.ticketbooking.screening.Screening;
import com.example.ticketbooking.seat.JpaSeatRepository;
import com.example.ticketbooking.seat.Seat;
import com.example.ticketbooking.user.JpaUserRepository;
import com.example.ticketbooking.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ReservationController {

    private final JpaReservationRepository reservationRepository;
    private final JpaScreeningRepository screeningRepository;
    private final JpaSeatRepository seatRepository;
    private final JpaUserRepository userRepository;

    public ReservationController(JpaReservationRepository reservationRepository, JpaScreeningRepository screeningRepository, JpaSeatRepository seatRepository, JpaUserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/reservation")
    ReservationResponseDTO saveReservation(@RequestBody ReservationRequestDTO reservationRequest) {

        int screeningId = reservationRequest.getScreeningId();
        List<Integer> seatIds = reservationRequest.getSeatIds();

        if (seatIds == null || seatIds.isEmpty() ) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "No seats chosen, please choose at least one seat");
        }

        Screening screening = screeningRepository.findById(screeningId).orElseThrow(() -> new ResourceException(HttpStatus.NOT_FOUND, "Wrong screening id or no screening chosen"));

        Set<Seat> seats = new HashSet<>(seatRepository.findAllById(seatIds));
        List<Integer> reservedSeatIds = seats.stream().filter(seat -> !seat.isAvailability()).map(Seat::getId).toList();

        if (!reservedSeatIds.isEmpty()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Seats with IDs " + reservedSeatIds.toString() + " are already reserved");
        }
        List<Integer> invalidSeatIds = seatIds.stream()
                .filter(id -> seats.stream().noneMatch(s -> s.getId() == id)).toList();
        if (!invalidSeatIds.isEmpty()) {
            String errorMessage = "Did not find seat IDs: " + invalidSeatIds.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            throw new ResourceException(HttpStatus.NOT_FOUND, errorMessage);
        }

        String ticketType = reservationRequest.getTicketType();

        Reservation newReservation = new Reservation();

        double ticketCost = calculateTicketCost(newReservation, ticketType);

        User newUser = new User();
        newUser.setName(reservationRequest.getName());
        newUser.setSurname(reservationRequest.getSurname());
        userRepository.save(newUser);

        newReservation.setTicketType(reservationRequest.getTicketType());
        newReservation.setScreening(screening);
        newReservation.setUser(newUser);
        newReservation.setSeats(seats);
        reservationRepository.save(newReservation);
        seats.forEach(seat -> {
            seat.setReservation(newReservation);
            seat.setAvailability(false);
            seatRepository.save(seat);
        });

        List<SeatInfo> seatInfoList = new ArrayList<>();
        seats.forEach( seat -> {
            seatInfoList.add(new SeatInfo(seat.getSeatRow(), seat.getSeatNumber()));
        });

        ReservationResponseDTO responseDTO = new ReservationResponseDTO(
                newReservation.getTicketType(),
                ticketCost,
                newUser.getName(),
                newUser.getSurname(),
                seatInfoList);

        return responseDTO;
    }

    private double calculateTicketCost(Reservation reservation, String ticketType) {
        double cost;
//        String ticketType = reservation.getTicketType();
        switch(ticketType.toLowerCase()) {
            case "adult":
                cost = 25.0;
                break;
            case "student":
                cost = 18.0;
                break;
            case "child":
                cost = 12.5;
                break;
            default:
                throw new ResourceException(HttpStatus.NOT_FOUND, "Did not find ticket type = " + ticketType + ". Available ticket types are: Adult, Student and Child");
        }

        Set<Seat> seats = new HashSet<>(reservation.getSeats());
        int numberOfSeats = seats.size();

        cost = cost*numberOfSeats;
        return cost;
    }
}

