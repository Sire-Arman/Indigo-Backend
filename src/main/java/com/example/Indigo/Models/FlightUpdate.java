package com.example.Indigo.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FlightUpdate {
    @Id
    private Long id;
    private String flightNumber;
    private String status;
    private String gate;

    // Getters, setters, and constructors
}
