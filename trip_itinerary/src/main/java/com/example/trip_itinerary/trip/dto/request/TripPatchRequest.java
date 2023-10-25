package com.example.trip_itinerary.trip.dto.request;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripPatchRequest {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isDomestic;
}
