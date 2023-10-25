package com.example.trip_itinerary.trip.dto.request;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripPatchRequest {
    private String name;

    @NotNull(message = "여행의 시작 날짜를 입력해주세요.")
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isDomestic;
}
