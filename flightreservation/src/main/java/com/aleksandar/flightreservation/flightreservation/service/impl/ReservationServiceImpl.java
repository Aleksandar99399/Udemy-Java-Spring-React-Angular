package com.aleksandar.flightreservation.flightreservation.service.impl;

import com.aleksandar.flightreservation.flightreservation.controllers.ReservationController;
import com.aleksandar.flightreservation.flightreservation.dto.ReservationRequest;
import com.aleksandar.flightreservation.flightreservation.entities.Flight;
import com.aleksandar.flightreservation.flightreservation.entities.Passenger;
import com.aleksandar.flightreservation.flightreservation.entities.Reservation;
import com.aleksandar.flightreservation.flightreservation.repos.FlightRepository;
import com.aleksandar.flightreservation.flightreservation.repos.PassengerRepository;
import com.aleksandar.flightreservation.flightreservation.repos.ReservationRepository;
import com.aleksandar.flightreservation.flightreservation.service.ReservationService;
import com.aleksandar.flightreservation.flightreservation.util.EmailUtil;
import com.aleksandar.flightreservation.flightreservation.util.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Value("${com.aleksandar.flightreservation.itinerary.dirpath}")
    private String ITINERARY_DIR;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);


    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest request) {

        LOGGER.info("Inside bookFlight()" + request);
        //Make Payment

        Long flightId = request.getFlightId();
        LOGGER.info("Fetching flight for flight id: " + flightId);
        Flight flight = flightRepository.findById(flightId).get();

        LOGGER.info("Inside bookFlight()" + request);

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());
        LOGGER.info("Saving the passenger: "+ passenger);
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        LOGGER.info("Saving the reservation" + reservation);

        Reservation savedReservation= reservationRepository.save(reservation);

        String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";
        LOGGER.info("Generating the itinerary");
        pdfGenerator.generateItinerary(savedReservation, filePath);

        LOGGER.info("Emailing the Itinerary");
        emailUtil.sendItinerary(passenger.getEmail(),filePath);
        return savedReservation;
    }
}
