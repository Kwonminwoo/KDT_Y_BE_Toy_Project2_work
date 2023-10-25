package com.example.trip_itinerary.trip.dto.request;


import com.example.trip_itinerary.trip.domain.Trip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripSaveRequest {
    private String name;

    @NotNull(message = "여행의 시작 날짜를 입력해주세요.")
    private LocalDate startDate;

    private LocalDate endDate;
    public Trip toEntity(){
        return Trip.of(null, name, startDate, endDate, isDomestic);
    }
}
