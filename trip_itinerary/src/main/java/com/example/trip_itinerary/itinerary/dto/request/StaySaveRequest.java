package com.example.trip_itinerary.itinerary.dto.request;

import com.example.trip_itinerary.itinerary.domain.Stay;
import com.example.trip_itinerary.trip.domain.Trip;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class StaySaveRequest extends ItinerarySaveRequest{
    @NotBlank(message = "체류 장소를 입력해주세요.")
    @Size(max = 30, message = "체류 장소는 최대 30자입니다.")
    private String location;

    @NotNull(message = "체류 장소 도착 시간을 입력해주세요.")
    private LocalDateTime endDate;

    @NotNull(message = "체류 장소에서 떠날 시간을 입력해주세요.")
    private LocalDateTime startDate;

    public Stay toEntity(Trip trip) {
        return Stay.of(super.getName(),null, location, startDate, endDate);
    }
}
