package com.example.Indigo.Controllers;

import com.example.Indigo.Models.Flight;
import com.example.Indigo.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/{flightNumber}")
    public ResponseEntity<Flight> getFlight(@PathVariable String flightNumber) {
        return flightService.getFlightByNumber(flightNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.updateFlightStatus(flight));
    }
}
