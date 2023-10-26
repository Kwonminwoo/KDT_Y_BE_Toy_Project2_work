package com.example.trip_itinerary.itinerary.domain;

import com.example.trip_itinerary.trip.domain.Trip;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@DiscriminatorValue("transport")
public class Transport extends Itinerary{
    @Column(nullable = false, length = 30)
    private String transportation;

    @Column(name = "start_location", nullable = false, length = 30)
    private String startLocation;

    @Column(name = "end_location", nullable = false, length = 30)
    private String endLocation;

    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;

    protected Transport() {}

    private Transport(String name, Trip trip, String transportation, String startLocation, String endLocation,
                      LocalDateTime startDate, LocalDateTime endDateTime) {
        super(null, name, trip);
        this.transportation = transportation;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDateTime = startDate;
        this.endDateTime = endDateTime;
    }

    public static Transport of(String name, Trip trip, String transportation, String startLocation, String endLocation,
                               LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return new Transport(name, trip, transportation, startLocation, endLocation, startDateTime, endDateTime);
    }

    public void updateTransport(String name, String transportation, String startLocation,
                                String endLocation, LocalDateTime startDateTime, LocalDateTime endDateTime){

        super.updateItinerary(name);

        if(transportation != null){
            this.transportation = transportation;
        }

        if(startLocation != null){
            this.startLocation = startLocation;
        }

        if(endLocation != null){
            this.endLocation = endLocation;
        }

        if(startDateTime != null){
            this.startDateTime = startDateTime;
        }

        if(endDateTime != null){
            this.endDateTime = endDateTime;
        }
    }
}
