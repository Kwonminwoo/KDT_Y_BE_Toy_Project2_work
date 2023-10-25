package com.example.trip_itinerary.itinerary.dto.request;

import com.example.trip_itinerary.itinerary.domain.Itinerary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItinerarySaveRequest {
    private Long id;
    private String name;
    private String type;
    private Long tripId;

    public Itinerary toEntity() {
        return Itinerary.of(null, name, null);
    }
}
