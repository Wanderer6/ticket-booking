package com.example.ticketbooking.reservation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping("/reservation")
    ReservationResponseDTO saveReservation(@RequestBody ReservationRequestDTO reservationRequest) {
        return service.saveReservation(reservationRequest);
    }
}

