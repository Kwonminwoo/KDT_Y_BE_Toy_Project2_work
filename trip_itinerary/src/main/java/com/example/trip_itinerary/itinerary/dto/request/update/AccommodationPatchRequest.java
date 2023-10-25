package com.example.trip_itinerary.itinerary.dto.request.update;

import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.itinerary.dto.request.ItinerarySaveRequest;
import com.example.trip_itinerary.trip.domain.Trip;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AccommodationPatchRequest extends ItineraryPatchRequest {
    private String accommodationName;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Accommodation toEntity(Trip trip) {
        return Accommodation.of(super.getName(), trip, accommodationName, checkIn, checkOut);
    }
}
