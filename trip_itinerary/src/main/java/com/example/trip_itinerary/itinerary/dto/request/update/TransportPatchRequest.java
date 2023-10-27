package com.example.trip_itinerary.itinerary.dto.request.update;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransportPatchRequest extends ItineraryPatchRequest {

    private String transportation;
    private String departureLocation;
    private String arrivalLocation;
    private String departureDateTime;
    private String arrivalDateTime;

}
