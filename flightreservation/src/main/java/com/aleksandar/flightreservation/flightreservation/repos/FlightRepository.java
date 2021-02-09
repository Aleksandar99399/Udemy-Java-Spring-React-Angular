package com.aleksandar.flightreservation.flightreservation.repos;

import com.aleksandar.flightreservation.flightreservation.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")

    List<Flight> findAllFlights(@Param("departureCity") String from,
                                @Param("arrivalCity")String to,
                                @Param("dateOfDeparture") LocalDate departureDate);
}
