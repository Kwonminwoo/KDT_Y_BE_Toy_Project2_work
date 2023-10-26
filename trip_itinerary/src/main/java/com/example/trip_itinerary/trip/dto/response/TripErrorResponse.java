package com.example.trip_itinerary.trip.dto.response;

import com.example.trip_itinerary.trip.exception.TripErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TripErrorResponse {
    private String errorCode;
    private String message;
    private int status;

    public static TripErrorResponse from(TripErrorCode tripErrorCode) {
        return TripErrorResponse.builder()
                .errorCode(tripErrorCode.name())
                .message(tripErrorCode.getMessage())
                .status(tripErrorCode.getStatus())
                .build();
    }
}
