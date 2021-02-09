package com.aleksandar.flightcheckin.controllers;

import com.aleksandar.flightcheckin.dto.Reservation;
import com.aleksandar.flightcheckin.dto.ReservationUpdateRequest;
import com.aleksandar.flightcheckin.integration.ReservationRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    ReservationRestClient restClient;

    @RequestMapping("/showStartCheckin")
    public String showStartCheckin(){
        return "startCheckin";
    }

    @RequestMapping("/startCheckin")
    public String startCheckin(@RequestParam("reservationId") Long reservationId, ModelMap modelMap){

        Reservation reservation = restClient.findReservation(reservationId);
        modelMap.addAttribute("reservation",reservation);

        return "displayReservationDetails";
    }

    @RequestMapping("/completeCheckIn")
    @Transactional
    public String completeCheckIn(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfBags") int numberOfBags){
        ReservationUpdateRequest request = new ReservationUpdateRequest();
        request.setId(reservationId);
        request.setCheckedIn(true);
        request.setNumberOfBags(numberOfBags);
        restClient.updateReservation(request);
        return "checkInConfirmation";
    }
}
