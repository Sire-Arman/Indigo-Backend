package com.example.Indigo.Repository;

import com.example.Indigo.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("select c from Flight c where c.flightNumber = :flightNumber")
    Optional<Flight> findByFlightNumber(String flightNumber);

    List<Flight> findByStatus(String status);
}