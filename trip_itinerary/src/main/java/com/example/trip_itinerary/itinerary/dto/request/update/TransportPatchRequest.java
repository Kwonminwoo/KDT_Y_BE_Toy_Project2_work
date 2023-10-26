package com.example.trip_itinerary.itinerary.dto.request.update;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransportPatchRequest extends ItineraryPatchRequest {
    private String transportation;
    private String startLocation;
    private String endLocation;
    private String startDateTime;
    private String endDateTime;

//    public TransportPatchRequest(String name, String transportation, String startLocation, String endLocation, String startDateTime, String endDateTime) {
//        super(name);
//        this.transportation = transportation;
//        this.startLocation = startLocation;
//        this.endLocation = endLocation;
//        this.startDateTime = startDateTime;
//        this.endDateTime = endDateTime;
//    }
//    public Transport toEntity(Trip trip) {
//        return Transport.of(super.getName(), trip, transportation, startLocation, endLocation, DateUtil.toLocalDateTime(startDateTime), DateUtil.toLocalDateTime(endDateTime));
//    }

}
