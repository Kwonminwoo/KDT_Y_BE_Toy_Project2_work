package com.example.trip_itinerary.itinerary.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
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

    protected Transport() {}

    private Transport(Long id, String transportation, String startLocation, String endLocation,
                     LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.transportation = transportation;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Transport of(Long id, String transportation, String startLocation, String endLocation,
                               LocalDateTime startDate, LocalDateTime endDate) {
        return new Transport(id, transportation, startLocation, endLocation, startDate, endDate);
    }
}
