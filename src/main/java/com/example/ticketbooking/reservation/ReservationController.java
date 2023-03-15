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

import java.util.*;
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
//        List<Integer> seatIds = reservationRequest.getSeatIds();
        List<Integer> seatIds = reservationRequest.getSeats().stream().map(SeatRequestDTO::getId).toList();
//        List<SeatRequestDTO> tempSeats = reservationRequest.getSeats();
//        List<Integer> seatIds = new ArrayList<>();
//        tempSeats.forEach( seat -> seatIds.add(seat.getId() ));

//        if (seatIds == null || seatIds.isEmpty() ) {
        if (seatIds.isEmpty() ) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "No seats chosen, please choose at least one seat");
        }


        Set<Seat> reservationSeats = new HashSet<>(seatRepository.findAllById(seatIds));
        List<Integer> reservedSeatIds = reservationSeats.stream().filter(seat -> !seat.isAvailability()).map(Seat::getId).toList();

        if (!reservedSeatIds.isEmpty()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Seats with IDs " + reservedSeatIds.toString() + " are already reserved");
        }
        List<Integer> invalidSeatIds = seatIds.stream()
                .filter(id -> reservationSeats.stream().noneMatch(s -> s.getId() == id)).toList();
        if (!invalidSeatIds.isEmpty()) {
            String errorMessage = "Did not find seat IDs: " + invalidSeatIds.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            throw new ResourceException(HttpStatus.NOT_FOUND, errorMessage);
        }

//        String ticketType = reservationRequest.getTicketType();
        List<String> ticketTypes = reservationRequest.getSeats().stream().map(SeatRequestDTO::getTicketType).toList();
        Reservation newReservation = new Reservation();

        double ticketCost = calculateTicketCost(ticketTypes);

        String name = reservationRequest.getName();
        String surname = reservationRequest.getSurname();
        String[] parts = surname.split("-");

        User newUser = new User();

        // Check name and surname conditions then set them
        if (name.length() < 3 || Character.isLowerCase(name.charAt(0))) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Name has to be at least 3 characters long and start with a capital letter");
        } else newUser.setName(name);
        if (surname.length() < 3 || Character.isLowerCase(surname.charAt(0)) || surname.contains(" ") || parts.length > 2 || Character.isLowerCase(parts[1].charAt(0))) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Surname has to be at least 3 characters long and start with a capital letter, if a surname " +
                    "consists of two parts, then parts have to be separated with a single dash and the second part has to start with a capital letter");
        } else newUser.setSurname(surname);

        userRepository.save(newUser);


        Map<Integer, List<Seat>> reservationSeatsByRow = reservationSeats.stream()
                .collect(Collectors.groupingBy(Seat::getSeatRow));
        for (List<Seat> rowSeats : reservationSeatsByRow.values()) {
            // Sort the seats in the row by seat number
            rowSeats.sort(Comparator.comparingInt(Seat::getSeatNumber));
            int row = rowSeats.get(0).getSeatRow();
            int startSeatNumber = rowSeats.get(0).getSeatNumber();
            int endSeatNumber = rowSeats.get(rowSeats.size() - 1).getSeatNumber();
            Seat leftNeighbor = seatRepository.findBySeatRowAndSeatNumber(row, startSeatNumber - 1);
            Seat leftLeftNeighbor = seatRepository.findBySeatRowAndSeatNumber(row, startSeatNumber - 2);
            Seat rightNeighbor = seatRepository.findBySeatRowAndSeatNumber(row, endSeatNumber + 1);
            Seat rightRightNeighbor = seatRepository.findBySeatRowAndSeatNumber(row, endSeatNumber + 2);

            // if left or right is null
            if (leftNeighbor == null || rightNeighbor == null) {
                if (leftNeighbor == null) {
                    if (rightNeighbor.isAvailability() && !rightRightNeighbor.isAvailability())
                        throw new ResourceException(HttpStatus.BAD_REQUEST, "1st. Cannot leave a single available seat");
                }
                    if (rightNeighbor == null) {
                        if (leftNeighbor.isAvailability() && !leftLeftNeighbor.isAvailability())
                            throw new ResourceException(HttpStatus.BAD_REQUEST, "2nd. Cannot leave a single available seat");
                    }
            }
            // if 2 to the left is null or 2 to the right is null
            if (leftLeftNeighbor == null || rightRightNeighbor == null) {
                if ((leftLeftNeighbor == null && leftNeighbor != null) || (rightRightNeighbor == null && rightNeighbor != null)) {
                    throw new ResourceException(HttpStatus.BAD_REQUEST, "3rd. Cannot leave a single available seat");
                }
            }
//            if (leftLeftNeighbor == null || rightRightNeighbor == null) {
            if (leftNeighbor != null && rightNeighbor != null) {
                if ((leftLeftNeighbor.isAvailability() && rightRightNeighbor.isAvailability()) ||
                        (!leftNeighbor.isAvailability() && rightRightNeighbor.isAvailability()) ||
                        (leftLeftNeighbor.isAvailability() && !rightNeighbor.isAvailability()) ||
                        (!leftNeighbor.isAvailability() && !rightNeighbor.isAvailability())) {
                    break;
                } else {
                    throw new ResourceException(HttpStatus.BAD_REQUEST, "4th. Cannot leave a single available seat");
                }
            }
        }



//        newReservation.setTicketType(ticketType);

        Screening screening = screeningRepository.findById(screeningId).orElseThrow(() -> new ResourceException(HttpStatus.NOT_FOUND, "Wrong screening id or no screening chosen"));
        newReservation.setScreening(screening);
        newReservation.setUser(newUser);
        reservationRepository.save(newReservation);
        for (SeatRequestDTO seatRequest : reservationRequest.getSeats()) {
            Seat seat = seatRepository.findById(seatRequest.getId())
                    .orElseThrow(() -> new ResourceException(HttpStatus.NOT_FOUND, "Wrong seat id or no seat chosen"));
            seat.setReservation(newReservation);
            seat.setAvailability(false);
            seat.setTicketType(seatRequest.getTicketType());
            seatRepository.save(seat);

        }

        List<SeatInfo> seatInfoList = new ArrayList<>();
        reservationSeats.forEach( seat -> {
            seatInfoList.add(new SeatInfo(seat.getSeatRow(), seat.getSeatNumber(), seat.getTicketType()));
        });

        ReservationResponseDTO responseDTO = new ReservationResponseDTO(
//                newReservation.getTicketType(),
                ticketCost,
                newUser.getName(),
                newUser.getSurname(),
                seatInfoList);

        return responseDTO;
    }

    private double calculateTicketCost(List<String> ticketTypes) {
        double totalCost = 0.0;
        for (String ticketType : ticketTypes) {
            double cost;
            switch (ticketType.toLowerCase()) {
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
            totalCost += cost;
        }
        return totalCost;
    }
}

