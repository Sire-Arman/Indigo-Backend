package com.example.Indigo.Controllers;

import com.example.Indigo.Models.Flight;
import com.example.Indigo.Models.FlightUpdate;
import com.example.Indigo.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/{flightNumber}")
    public ResponseEntity<?> getFlightStatus(@PathVariable String flightNumber) {
        Optional<Flight> flightOpt = flightService.getFlightStatus(flightNumber);
        if(flightOpt.isPresent()) {
            return new ResponseEntity<>(flightOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Flight not found", HttpStatus.OK);
    }
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/delayed")
    public List<Flight> getDelayedFlights() {
        return flightService.getDelayedFlights();
    }
    @GetMapping("/on-time")
    public List<Flight> getOnTimeFlights() {
        return flightService.getOnTimeFlights();
    }

    @GetMapping("/cancelled")
    public List<Flight> getCancelledFlights() {
        return flightService.getCancelledFlights();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateFlightStatus(@RequestBody FlightUpdate update) {
        flightService.updateFlightStatus(update);
        return ResponseEntity.ok().build();
    }
}
