package com.example.trip_itinerary.itinerary.dto.request;

import com.example.trip_itinerary.itinerary.domain.Stay;
import com.example.trip_itinerary.trip.domain.Trip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class StaySaveRequest extends ItinerarySaveRequest{
    private String location;
    private LocalDateTime endDate;
    private LocalDateTime startDate;

    public Stay toEntity(Trip trip) {
        return Stay.of(super.getName(),null, location, startDate, endDate);
    }
}
