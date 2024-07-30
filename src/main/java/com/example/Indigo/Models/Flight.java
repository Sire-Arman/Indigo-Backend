package com.example.Indigo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String flightNumber;
    private LocalDateTime scheduledArrival;
    @Column(nullable = false)
    private String origin;
    @Column(nullable = false)
    private LocalDateTime scheduledDeparture;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String gate;
    @Column(nullable = false)
    private String destination;




    // Getters, setters, and constructors
}