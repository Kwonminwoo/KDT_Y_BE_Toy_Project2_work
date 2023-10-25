package com.example.trip_itinerary.itinerary.dto.request.update;

import com.example.trip_itinerary.itinerary.domain.Transport;
import com.example.trip_itinerary.itinerary.dto.request.ItinerarySaveRequest;
import com.example.trip_itinerary.trip.domain.Trip;
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
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public TransportPatchRequest(String name, String transportation, String startLocation, String endLocation, LocalDateTime startDate, LocalDateTime endDate) {
        super(name);
        this.transportation = transportation;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Transport toEntity(Trip trip) {
        return Transport.of(super.getName(), trip, transportation, startLocation, endLocation, startDate, endDate);
    }

}
