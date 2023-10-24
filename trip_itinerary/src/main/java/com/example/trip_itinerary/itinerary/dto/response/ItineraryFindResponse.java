package com.example.trip_itinerary.itinerary.dto.response;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItineraryFindResponse {
    private String name;
    private String type;

    private String transportation;
}
