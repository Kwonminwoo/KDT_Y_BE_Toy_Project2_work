package com.example.trip_itinerary.itinerary.dto.request.update;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
