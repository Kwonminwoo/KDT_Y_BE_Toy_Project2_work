package com.example.trip_itinerary.itinerary.dto.request;

import com.example.trip_itinerary.itinerary.domain.Accommodation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationSaveRequest extends ItinerarySaveRequest{
    private String name;
    private String checkIn;
    private String checkOut;

    public Accommodation toEntity() {
        return Accommodation.of(null, name, checkIn, checkOut);
    }
}
