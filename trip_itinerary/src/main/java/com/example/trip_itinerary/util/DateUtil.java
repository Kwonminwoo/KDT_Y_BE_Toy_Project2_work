package com.example.trip_itinerary.util;

import com.example.trip_itinerary.itinerary.exception.InvalidDateTimeFormatException;
import com.example.trip_itinerary.itinerary.exception.ItineraryErrorCode;
import com.example.trip_itinerary.trip.exception.InvalidDateFormatException;
import com.example.trip_itinerary.trip.exception.TripErrorCode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public abstract class DateUtil {

    public static LocalDate toLocalDate(String date) throws InvalidDateFormatException{
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException e){
            throw new InvalidDateFormatException(TripErrorCode.INVALID_DATE_FORMAT);
        }
    }

    public static LocalDateTime toLocalDateTime(String dateTime) throws InvalidDateTimeFormatException{
        try {
            return LocalDateTime.parse(dateTime);
        } catch (DateTimeParseException e){
            throw new InvalidDateTimeFormatException(ItineraryErrorCode.INVALID_DATE_TIME_FORMAT);
        }
    }
    private DateUtil(){
    }

}
