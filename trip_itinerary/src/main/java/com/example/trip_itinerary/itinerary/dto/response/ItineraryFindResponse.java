package com.example.trip_itinerary.itinerary.dto.response;


import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.itinerary.domain.Stay;
import com.example.trip_itinerary.itinerary.domain.Transport;
import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
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
                .checkInTime(accommodation.getCheckInTime())
                .checkOutTime(accommodation.getCheckOutTime())
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
