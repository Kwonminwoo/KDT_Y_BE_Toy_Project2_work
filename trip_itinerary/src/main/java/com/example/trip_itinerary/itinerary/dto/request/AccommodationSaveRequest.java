package com.example.trip_itinerary.itinerary.dto.request;

import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.trip.domain.Trip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class AccommodationSaveRequest extends ItinerarySaveRequest{
    private String accommodationName;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Accommodation toEntity(Trip trip) {
        return Accommodation.of(super.getName(), trip, accommodationName, checkIn, checkOut);
    }
}
