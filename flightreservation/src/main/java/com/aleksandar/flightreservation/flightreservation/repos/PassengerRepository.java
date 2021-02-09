package com.aleksandar.flightreservation.flightreservation.repos;

import com.aleksandar.flightreservation.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
