package com.aleksandar.flightcheckin.integration;

import com.aleksandar.flightcheckin.dto.Reservation;
import com.aleksandar.flightcheckin.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;

public interface ReservationRestClient {

    public Reservation findReservation(Long id);

    public Reservation updateReservation(ReservationUpdateRequest request);
}
