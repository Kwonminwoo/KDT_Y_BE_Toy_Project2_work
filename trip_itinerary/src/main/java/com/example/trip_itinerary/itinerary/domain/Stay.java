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

    @Column(nullable = false, name = "start_date_time")
    private LocalDateTime startDateTime;

    @Column(nullable = false, name = "end_date_time")
    private LocalDateTime endDateTime;

    protected Stay() {}

    private Stay(String name, Trip trip, String location, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        super(null, name, trip);
        this.location = location;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public static Stay of(String name, Trip trip, String location, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return new Stay(name, trip, location, startDateTime, endDateTime);
    }

    public void updateStay(String name, String location, LocalDateTime startDateTime, LocalDateTime endDateTime){
        super.updateItinerary(name);
        this.location = location;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
