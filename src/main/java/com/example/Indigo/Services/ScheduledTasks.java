package com.example.Indigo.Services;
import com.example.Indigo.Models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledTasks {
    @Autowired
    private MockDataService mockDataService;

    @Autowired
    private FlightService flightService;

    @Scheduled(fixedRate = 60000) // Every minute
    public void fetchFlightData() {
        List<Flight> flights = mockDataService.getMockFlights();
        flights.forEach(flightService::updateFlightStatus);
    }
}