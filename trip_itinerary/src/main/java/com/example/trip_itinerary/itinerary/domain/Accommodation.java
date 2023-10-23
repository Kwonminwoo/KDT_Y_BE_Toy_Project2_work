package com.example.trip_itinerary.itinerary.domain;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("accommodation")
public class Accommodation extends Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name = "check_in",nullable = false, length = 20)
    private String checkIn;

    @Column(name = "check_out", nullable = false, length = 20)
    private String checkOut;

}
