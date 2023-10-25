package com.example.trip_itinerary.trip.dto.response;


import com.example.trip_itinerary.trip.domain.Trip;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripFindResponse {
    private Long id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isDomestic;
    private String itineraryName;
}
