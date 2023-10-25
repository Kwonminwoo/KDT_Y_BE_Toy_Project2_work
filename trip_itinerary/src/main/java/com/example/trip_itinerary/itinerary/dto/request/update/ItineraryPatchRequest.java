package com.example.trip_itinerary.itinerary.dto.request.update;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StayPatchRequest.class, name = "stay"),
        @JsonSubTypes.Type(value = TransportPatchRequest.class, name = "transport"),
        @JsonSubTypes.Type(value = AccommodationPatchRequest.class, name = "accommodation")
})
public class ItineraryPatchRequest {
    private String name;
}
