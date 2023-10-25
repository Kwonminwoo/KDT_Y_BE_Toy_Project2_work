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

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    protected Transport() {}

    private Transport(String name, Trip trip, String transportation, String startLocation, String endLocation,
                      LocalDateTime startDate, LocalDateTime endDate) {
        super(null, name, trip);
        this.transportation = transportation;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Transport of(String name, Trip trip, String transportation, String startLocation, String endLocation,
                               LocalDateTime startDate, LocalDateTime endDate) {
        return new Transport(name, trip, transportation, startLocation, endLocation, startDate, endDate);
    }

    public void updateTransport(String name, String transportation, String startLocation,
                                String endLocation, LocalDateTime startDate, LocalDateTime endDate){

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

        if(startDate != null){
            this.startDate = startDate;
        }

        if(endDate != null){
            this.endDate = endDate;
        }
    }
}
