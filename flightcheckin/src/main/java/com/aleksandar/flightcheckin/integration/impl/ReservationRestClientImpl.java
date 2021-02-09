package com.aleksandar.flightcheckin.integration.impl;

import com.aleksandar.flightcheckin.dto.Reservation;
import com.aleksandar.flightcheckin.dto.ReservationUpdateRequest;
import com.aleksandar.flightcheckin.integration.ReservationRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    @Value("${com.aleksandar.flightcheckin.url}")
    public String URL;

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate
                .getForObject(URL + id, Reservation.class);

        return reservation;
    }

    @Override
    @Transactional
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(URL,request,Reservation.class);

    }
}
