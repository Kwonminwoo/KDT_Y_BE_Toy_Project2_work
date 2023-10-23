package com.example.trip_itinerary.itinerary.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("transport")
public class Transport extends Itinerary{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String transportation;

    @Column(name = "start_location", nullable = false, length = 30)
    private String startLocation;

    @Column(name = "end_location", nullable = false, length = 30)
    private String endLocation;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;
}
