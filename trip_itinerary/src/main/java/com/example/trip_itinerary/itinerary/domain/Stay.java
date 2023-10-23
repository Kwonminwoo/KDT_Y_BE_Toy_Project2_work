package com.example.trip_itinerary.itinerary.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@DiscriminatorValue("stay")
public class Stay extends Itinerary{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String location;

    @Column(nullable = false, name = "start_date")
    private LocalDateTime startDate;

    @Column(nullable = false, name = "end_date")
    private LocalDateTime endDate;

    protected Stay() {}

    private Stay(Long id, String location, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Stay of(Long id, String location, LocalDateTime startDate, LocalDateTime endDate) {
        return new Stay(id, location, startDate, endDate);
    }
}
