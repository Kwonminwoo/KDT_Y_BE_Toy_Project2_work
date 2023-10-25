package com.example.trip_itinerary.itinerary.domain;

import com.example.trip_itinerary.trip.domain.Trip;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@DiscriminatorValue("stay")
public class Stay extends Itinerary{
    @Column(nullable = false, length = 30)
    private String location;

    @Column(nullable = false, name = "start_date")
    private LocalDateTime startDate;

    @Column(nullable = false, name = "end_date")
    private LocalDateTime endDate;

    protected Stay() {}

    private Stay(String name, Trip trip, String location, LocalDateTime startDate, LocalDateTime endDate) {
        super(null, name, trip);
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Stay of(String name, Trip trip, String location, LocalDateTime startDate, LocalDateTime endDate) {
        return new Stay(name, trip, location, startDate, endDate);
    }

    public void updateStay(String name, String location, LocalDateTime startDate, LocalDateTime endDate){
        super.updateItinerary(name);
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
