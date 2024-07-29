package com.example.Indigo.Services;

import com.example.Indigo.Models.Flight;
import com.example.Indigo.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FCMService fcmService;

    public Optional<Flight> getFlightByNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }

    public Flight updateFlightStatus(Flight flight) {
        Flight updatedFlight = flightRepository.save(flight);

        // Send notification if the status has changed
        if (!updatedFlight.getStatus().equals(flight.getStatus())) {
            fcmService.sendNotification("user_fcm_token", "Flight Status Update", "Flight " + flight.getFlightNumber() + " is now " + flight.getStatus());
        }

        return updatedFlight;
    }
}