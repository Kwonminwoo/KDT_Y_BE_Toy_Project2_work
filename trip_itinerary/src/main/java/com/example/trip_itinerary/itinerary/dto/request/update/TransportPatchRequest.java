package com.example.trip_itinerary.itinerary.dto.request.update;

import com.example.trip_itinerary.itinerary.domain.Transport;
import com.example.trip_itinerary.itinerary.dto.request.ItinerarySaveRequest;
import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.util.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransportPatchRequest extends ItineraryPatchRequest {
    private String transportation;
    private String startLocation;
    private String endLocation;
    private String startDate;
    private String endDate;

    public TransportPatchRequest(String name, String transportation, String startLocation, String endLocation, String startDate, String endDate) {
        super(name);
        this.transportation = transportation;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Transport toEntity(Trip trip) {
        return Transport.of(super.getName(), trip, transportation, startLocation, endLocation, DateUtil.toLocalDateTime(startDate), DateUtil.toLocalDateTime(endDate));
    }

}
