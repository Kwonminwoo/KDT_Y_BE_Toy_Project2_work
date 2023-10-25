package com.example.trip_itinerary.itinerary.dto.request;

import com.example.trip_itinerary.itinerary.domain.Transport;
import com.example.trip_itinerary.trip.domain.Trip;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransportSaveRequest  extends ItinerarySaveRequest{
    @NotBlank(message = "이동 방법을 입력해주세요.")
    @Size(max = 30, message = "이동 방법은 최대 30자입니다.")
    private String transportation;

    @NotBlank(message = "출발 장소를 입력해주세요.")
    @Size(max = 30, message = "출발 장소는 최대 30자입니다.")
    private String startLocation;

    @NotBlank(message = "도착 장소를 입력해주세요.")
    @Size(max = 30, message = "도착 장소는 최대 30자입니다.")
    private String endLocation;

    @NotNull(message = "출발 시간을 입력해주세요.")
    private LocalDateTime startDate;

    @NotNull(message = "도착 시간을 입력해주세요.")
    private LocalDateTime endDate;

    public TransportSaveRequest(String name, String transportation, String startLocation, String endLocation, LocalDateTime startDate, LocalDateTime endDate) {
        super(name);
        this.transportation = transportation;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Transport toEntity(Trip trip) {
        return Transport.of(super.getName(), trip, transportation, startLocation, endLocation, startDate, endDate);
    }

}
