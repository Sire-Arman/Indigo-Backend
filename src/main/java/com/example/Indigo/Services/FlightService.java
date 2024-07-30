package com.example.Indigo.Services;

import com.example.Indigo.Models.Flight;
import com.example.Indigo.Models.FlightUpdate;
import com.example.Indigo.Repository.FlightRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private MockDataService mockDataService;


    public Optional<Flight> getFlightStatus(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getDelayedFlights() {
        return flightRepository.findByStatus("Delayed");
    }
    public List<Flight> getOnTimeFlights() {
        return flightRepository.findByStatus("On Time");
    }

    public List<Flight> getCancelledFlights() {
        return flightRepository.findByStatus("Cancelled");
    }

    @Transactional
    public void updateFlightStatus(FlightUpdate update) {
        Flight flight = flightRepository.findByFlightNumber(update.getFlightNumber())
                .orElseGet(() -> mockDataService.getFlightData(update.getFlightNumber()));
        flight.setStatus(update.getStatus());
        flight.setGate(update.getGate());

        flightRepository.save(flight);
    }
}