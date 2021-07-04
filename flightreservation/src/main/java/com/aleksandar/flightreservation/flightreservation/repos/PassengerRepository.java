package com.aleksandar.flightreservation.flightreservation.repos;

import com.aleksandar.flightreservation.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
