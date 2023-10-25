package com.example.trip_itinerary.trip.dto.request;


import com.example.trip_itinerary.trip.domain.Trip;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripSaveRequest {
    @NotBlank(message = "여행 이름을 입력해주세요.")
    @Size(max = 30, message = "여행 이름은 최대 30자입니다.")
    private String name;

    @NotNull(message = "여행의 시작 날짜를 입력해주세요.")
    private LocalDate startDate;

    @NotNull(message = "여행의 종료 날짜를 입력해주세요.")
    private LocalDate endDate;

    @NotNull(message = "여행의 국내/국외 타입을 입력해주세요.")
    private Boolean isDomestic;
    // ToDo: 타입체크는 따로 로직으로

    public Trip toEntity(){
        return Trip.of(null, name, startDate, endDate, isDomestic);
    }
}
