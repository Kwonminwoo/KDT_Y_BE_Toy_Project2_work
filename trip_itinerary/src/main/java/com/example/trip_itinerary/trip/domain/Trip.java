package com.example.trip_itinerary.trip.domain;

import com.example.trip_itinerary.itinerary.domain.Itinerary;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "is_domestic", nullable = false)
    private boolean isDomestic;

    @OneToMany(mappedBy = "trip")
    private List<Itinerary> itineraryList;

    protected Trip(){
    }

    private Trip(Long id, String name, LocalDate startDate, LocalDate endDate, boolean isDomestic) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isDomestic = isDomestic;
    }

    public static Trip of(Long id, String name, LocalDate startDate, LocalDate endDate, boolean isDomestic) {
        return new Trip(id, name, startDate, endDate, isDomestic);
    }

    public void updateTrip(String name, LocalDate startDate, LocalDate endDate, Boolean isDomestic){
        if(name != null){
            this.name = name;
        }
        if(startDate != null){
            this.startDate = startDate;
        }
        if (endDate != null) {
            this.endDate = endDate;
        }
        if (isDomestic != null) {
            this.isDomestic = isDomestic;
        }
    }
}
