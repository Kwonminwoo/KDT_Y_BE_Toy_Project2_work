package com.example.trip_itinerary.itinerary.dto.request;

import com.example.trip_itinerary.itinerary.domain.Stay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaySaveRequest {
    private Long id;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Stay toEntity() {
        return Stay.of(null, location, startDate, endDate);
    }
}
