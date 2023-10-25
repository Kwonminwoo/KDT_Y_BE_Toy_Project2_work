package com.example.trip_itinerary.itinerary.domain;

import com.example.trip_itinerary.trip.domain.Trip;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@DiscriminatorValue("accommodation")
public class Accommodation extends Itinerary {
    @Column(name = "accommodation_name", nullable = false, length = 20)
    private String accommodationName;

    @Column(name = "check_in",nullable = false, length = 20)
    private LocalDateTime checkIn;

    @Column(name = "check_out", nullable = false, length = 20)
    private LocalDateTime checkOut;

    protected Accommodation() {
    }

    private Accommodation(String name, Trip trip, String accommodationName, LocalDateTime checkIn, LocalDateTime checkOut) {
        super(null, name, trip);
        this.accommodationName = accommodationName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public static Accommodation of(String name, Trip trip, String accommodationName, LocalDateTime checkIn, LocalDateTime checkOut) {
        return new Accommodation(name, trip, accommodationName, checkIn, checkOut);
    }

    public void updateAccommodation(String name, String accommodationName, LocalDateTime checkIn, LocalDateTime checkOut) {
        super.updateItinerary(name);
        this.accommodationName = accommodationName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}
