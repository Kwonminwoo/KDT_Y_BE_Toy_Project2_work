package com.example.trip_itinerary.itinerary.dto.request.update;

import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.util.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class AccommodationPatchRequest extends ItineraryPatchRequest {
    private String accommodationName;
    private String checkIn;
    private String checkOut;

    public Accommodation toEntity(Trip trip) {
        return Accommodation.of(super.getName(), trip, accommodationName, DateUtil.toLocalDateTime(checkIn), DateUtil.toLocalDateTime(checkOut));
    }
}
