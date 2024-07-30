package com.example.Indigo.Services;

import com.example.Indigo.Models.Flight;
import com.example.Indigo.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MockDataService {
    @Autowired
    private FlightRepository flightRepository;
    public Flight getFlightData(String flightNumber) {
        // Generate mock flight data
        Flight fl = new Flight();
        fl.setFlightNumber(flightNumber);
        fl.setStatus("On Time");
        fl.setOrigin("Origin");
        fl.setDestination("Destination");
        fl.setGate("Gate A1");
        fl.setScheduledArrival(LocalDateTime.now());
        fl.setScheduledDeparture(LocalDateTime.now().plusHours(2));
        return fl;
    }
    public Flight getFlightByFlightNumber(String flightNumber) {
        Optional<Flight> fl = flightRepository.findByFlightNumber(flightNumber);
        return fl.orElse(null);
    }
}
