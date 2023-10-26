package com.example.trip_itinerary.trip.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidDateException extends RuntimeException{
    private TripErrorCode errorCode;

}
