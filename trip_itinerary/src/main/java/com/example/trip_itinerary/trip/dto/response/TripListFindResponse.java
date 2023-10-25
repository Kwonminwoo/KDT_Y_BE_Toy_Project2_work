package com.example.trip_itinerary.trip.dto.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripListFindResponse {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isDomestic;
    private List<String> itineraryNameList;
}
