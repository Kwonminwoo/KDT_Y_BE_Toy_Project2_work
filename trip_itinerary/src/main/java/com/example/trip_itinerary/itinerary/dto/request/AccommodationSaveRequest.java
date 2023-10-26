package com.example.trip_itinerary.itinerary.dto.request;

import com.example.trip_itinerary.itinerary.domain.Accommodation;
import com.example.trip_itinerary.trip.domain.Trip;
import com.example.trip_itinerary.util.DateUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class AccommodationSaveRequest extends ItinerarySaveRequest{
    @NotBlank(message = "숙소 이름을 입력해주세요.")
    @Size(max = 30, message = "숙소 이름은 최대 30자입니다.")
    private String accommodationName;

    @NotNull(message = "체크인 시간을 입력해주세요.")
    private String checkInTime;

    @NotNull(message = "체크아웃 시간을 입력해주세요.")
    private String checkOutTime;

    public Accommodation toEntity(Trip trip) {
        return Accommodation.of(super.getName(), trip, accommodationName, DateUtil.toLocalDateTime(checkInTime), DateUtil.toLocalDateTime(checkOutTime));
    }
}
