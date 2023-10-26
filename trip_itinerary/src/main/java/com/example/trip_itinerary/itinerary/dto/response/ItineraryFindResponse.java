package com.example.trip_itinerary.itinerary.dto.response;


import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.itinerary.domain.Itinerary;
import com.example.trip_itinerary.itinerary.domain.Stay;
import com.example.trip_itinerary.itinerary.domain.Transport;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Stack;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItineraryFindResponse {
    private String name;
    private String transportation;
    private String startLocation;
    private String endLocation;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String accommodationName;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String location;


    public static ItineraryFindResponse fromEntity(Transport transport){
        return ItineraryFindResponse.builder()
                .name(transport.getName())
                .transportation(transport.getTransportation())
                .startLocation(transport.getStartLocation())
                .endLocation(transport.getEndLocation())
                .startDateTime(transport.getStartDateTime())
                .startDateTime(transport.getEndDateTime())
                .build();
    }
    public static ItineraryFindResponse fromEntity(Accommodation accommodation){
        return ItineraryFindResponse.builder()
                .name(accommodation.getName())
                .accommodationName(accommodation.getName())
                .checkIn(accommodation.getCheckIn())
                .checkOut(accommodation.getCheckOut())
                .build();
    }

    public static ItineraryFindResponse fromEntity(Stay stay){
        return ItineraryFindResponse.builder()
                .name(stay.getName())
                .location(stay.getLocation())
                .endDateTime(stay.getEndDateTime())
                .startDateTime(stay.getStartDateTime())
                .build();
    }
}
