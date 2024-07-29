package com.example.Indigo.Services;

import com.example.Indigo.Models.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MockDataService {
    public List<Flight> getMockFlights() {
        // Generate mock flight data
        return List.of(
                new Flight(1L, "AA123", "On Time", "Gate 10", LocalDateTime.now().plusHours(2)),
                new Flight(2L, "BB456", "Delayed", "Gate 15", LocalDateTime.now().plusHours(3))
        );
    }
}
