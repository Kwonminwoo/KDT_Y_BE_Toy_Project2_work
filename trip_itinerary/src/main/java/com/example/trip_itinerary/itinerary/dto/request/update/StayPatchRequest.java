package com.example.trip_itinerary.itinerary.dto.request.update;

import com.example.trip_itinerary.itinerary.domain.Stay;
import com.example.trip_itinerary.itinerary.dto.request.ItinerarySaveRequest;
import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.util.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class StayPatchRequest extends ItineraryPatchRequest {
    private String location;
    private String endDateTime;
    private String startDateTime;

//    public Stay toEntity(Trip trip) {
//        return Stay.of(super.getName(),trip, location, DateUtil.toLocalDateTime(startDateTime), DateUtil.toLocalDateTime(endDateTime));
//    }
}
