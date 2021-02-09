package com.aleksandar.flightreservation.flightreservation.service;

import com.aleksandar.flightreservation.flightreservation.dto.ReservationRequest;
import com.aleksandar.flightreservation.flightreservation.entities.Reservation;

public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);
}
