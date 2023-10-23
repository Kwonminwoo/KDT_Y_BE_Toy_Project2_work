package com.example.trip_itinerary.trip.dto.request;


import com.example.trip_itinerary.trip.domain.Trip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripSaveRequest {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isDomestic;

    public Trip toEntity(){
        return Trip.of(null, name, startDate, endDate, isDomestic);
    }
}
