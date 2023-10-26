package com.example.trip_itinerary.itinerary.dto.response;

import com.example.trip_itinerary.itinerary.exception.ItineraryErrorCode;
import com.example.trip_itinerary.trip.dto.response.TripErrorResponse;
import com.example.trip_itinerary.trip.exception.TripErrorCode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItineraryErrorResponse {
    private String errorCode;
    private String message;
    private int status;

    public static ItineraryErrorResponse from(ItineraryErrorCode itineraryErrorCode) {
        return ItineraryErrorResponse.builder()
                .errorCode(itineraryErrorCode.name())
                .message(itineraryErrorCode.getMessage())
                .status(itineraryErrorCode.getStatus())
                .build();
    }
}
