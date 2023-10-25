package com.example.trip_itinerary.itinerary.domain;

import com.example.trip_itinerary.trip.domain.Trip;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    protected Itinerary(){
    }

    protected Itinerary(Long id, String name, Trip trip) {
        this.id = id;
        this.name = name;
        this.trip = trip;
    }

    public void updateItinerary(String name){
        if (name != null) {
            this.name = name;
        }
    }
}

