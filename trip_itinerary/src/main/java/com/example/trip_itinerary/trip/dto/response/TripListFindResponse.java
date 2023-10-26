package com.example.trip_itinerary.trip.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripListFindResponse {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isDomestic;
    private List<String> itineraryNameList;
}
