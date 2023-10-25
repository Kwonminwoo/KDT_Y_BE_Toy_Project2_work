package com.example.trip_itinerary.itinerary.dto.request;

import com.example.trip_itinerary.itinerary.domain.Transport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportSaveRequest  extends ItinerarySaveRequest{
    private Long id;
    private String transportation;
    private String startLocation;
    private String endLocation;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Transport toEntity() {
        return Transport.of(null, transportation, startLocation, endLocation, startDate, endDate);
    }
}
