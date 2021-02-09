package com.aleksandar.flightreservation.flightreservation.controllers.restControllers;

import com.aleksandar.flightreservation.flightreservation.dto.ReservationUpdateRequest;
import com.aleksandar.flightreservation.flightreservation.entities.Reservation;
import com.aleksandar.flightreservation.flightreservation.repos.ReservationRepository;
import com.aleksandar.flightreservation.flightreservation.util.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationRESTController {

    @Autowired
    ReservationRepository reservationRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);


    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
        LOGGER.info("Inside findReservation() for id:"+ id);
        return reservationRepository.findById(id).get();
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        LOGGER.info("Inside updateReservation() for "+request);
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
        LOGGER.info("Saving reservation ");
        return reservationRepository.save(reservation);
    }
}
